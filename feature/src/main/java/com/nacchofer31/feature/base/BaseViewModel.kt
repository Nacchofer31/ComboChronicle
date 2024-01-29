package com.nacchofer31.feature.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nacchofer31.domain.exception.CustomException
import com.nacchofer31.feature.extension.tryOffer
import com.nacchofer31.feature.routes.NavEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseViewModel : ViewModel() {

    private val eventChannelNav = Channel<NavEvent>(Channel.BUFFERED)
    val navEventsFlow = eventChannelNav.receiveAsFlow()

    protected val _error = MutableStateFlow<CustomException?>(null)
    val error: StateFlow<CustomException?> get() = _error

    fun navigateTo(route: NavEvent) {
        viewModelScope.launch {
            eventChannelNav.tryOffer(route)
        }
    }

    fun <T, K> StateFlow<T>.mapState(
        scope: CoroutineScope = viewModelScope,
        transform: (data: T) -> K
    ): StateFlow<K> {
        return mapLatest {
            transform(it)
        }.stateIn(scope, SharingStarted.Eagerly, transform(value))
    }
}