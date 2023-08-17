package `in`.mrkaydev.portfolio.ui

import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.networking.httpClient
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : dev.icerock.moko.mvvm.viewmodel.ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState: StateFlow<UiState> get() = _uiState

    init {
        loadFonts()
    }

    private fun loadFonts() {
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                viewModelScope.launch {
                    async { FontLoader.loadFonts() }.await()
                    fetchJson()
                }
            }
        }
    }

    private fun fetchJson() {
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                _uiState.emit(UiState.Loading)
                val data = httpClient.get(Utils.RESUME_JSON_URL).body<WebsiteData>()
                _uiState.emit(UiState.JsonDataSuccess(data))
            }.onFailure {
                _uiState.emit(UiState.Error("Error occurred : ${it.message}"))
            }
        }
    }
}

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    data class JsonDataSuccess(val data: WebsiteData) : UiState()
    data class Error(val message: String) : UiState()
}