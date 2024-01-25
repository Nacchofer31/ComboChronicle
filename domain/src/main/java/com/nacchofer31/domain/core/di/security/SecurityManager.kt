package com.nacchofer31.domain.core.di.security

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SecurityManager @Inject constructor(
    private val cipher: Cipher,
    private val secretKey: SecretKey,
) {
    private val split = "@"
    private val tLen = 128

    fun encryptData(value: String): String {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val ivString = Base64.encodeToString(cipher.iv, Base64.DEFAULT)
        val encryptData =  cipher.doFinal(value.toByteArray())
        return ivString.plus(split).plus(Base64.encodeToString(encryptData, Base64.DEFAULT))
    }

    fun decryptData(encryptedData: String): String {
        return runCatching {
            val split = encryptedData.split(split.toRegex())
            val iv = Base64.decode(split[0], Base64.DEFAULT)
            val dataEncrypted = Base64.decode(split[1], Base64.DEFAULT)
            cipher.init(Cipher.DECRYPT_MODE, secretKey, GCMParameterSpec(tLen, iv))
            val result =  cipher.doFinal(dataEncrypted)
            String(result)
        }.getOrElse { "" }
    }
}