package com.nacchofer31.domain.exception

sealed class CustomException(open val code: Int?, message: String) : Throwable(message),
    ResponseError,
    AuthError, RequestError

sealed interface RequestError {
    data class BadRequestException(
        override val message: String = "400-Internal Error",
        override val code: Int = 400
    ) : CustomException(code, message)

    data class NotAllowedException(
        override val message: String = "405-HTTP Method not supported",
        override val code: Int = 405
    ) : CustomException(code, message)

    data class NotFoundException(
        override val message: String = "404-Not Found",
        override val code: Int = 404
    ) : CustomException(code, message)

    data class TimeoutException(
        override val message: String = "Timeout",
        override val code: Int = 999
    ) : CustomException(code, message)
}

sealed interface ResponseError {

    data class UnknownException(val exception: Throwable, override val code: Int? = 999) :
        CustomException(code, exception.message ?: "UnknownException")

    data class ServerException(
        override val message: String = "500-503-Internal Server Error",
        override val code: Int = 500
    ) : CustomException(code, message)

    data class BusinessException(
        override val code: Int = 610,
        override val message: String = "Internal Error"
    ) : CustomException(code, message) {
        companion object {
            const val CHANGE_NAME_CODE = 3103
        }
    }

    data class NoConnectivityException(
        override val code: Int = 0,
        override val message: String = ""
    ) : CustomException(code, message)

}

sealed interface AuthError {
    data class ForbiddenException(
        override val message: String = "Forbidden",
        override val code: Int = 403
    ) : CustomException(code, message)

    data class NotAuthorizedException(
        override val message: String = "Auth needed",
        override val code: Int = 401
    ) : CustomException(code, message)
}

sealed interface InternalError {
    object DataStoreError : CustomException(
        null,
        message = "Internal Error"
    )

    data class MapperException(
        override val message: String = "Internal Error", override val code: Int = 600
    ) : CustomException(code, message)
}