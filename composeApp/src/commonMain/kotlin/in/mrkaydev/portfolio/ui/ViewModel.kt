package `in`.mrkaydev.portfolio.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.networking.httpClient
import `in`.mrkaydev.portfolio.ui.components.EducationData
import `in`.mrkaydev.portfolio.ui.components.ExperienceData
import `in`.mrkaydev.portfolio.ui.components.ProjectData
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
    var name by mutableStateOf("")
    var githubUrl by mutableStateOf("")
    var email by mutableStateOf("")
    var mobile by mutableStateOf("")
    var links by mutableStateOf("")
    var languages by mutableStateOf("")
    var tools by mutableStateOf("")
    var technologies by mutableStateOf("")


    var educationList by mutableStateOf(listOf(EducationData("", "", "", "")))
    var experienceList by mutableStateOf(listOf(ExperienceData("", "", "", listOf(""))))
    var projectList by mutableStateOf(listOf(ProjectData("", listOf(""))))

    var addEducationButtonEnabled by mutableStateOf(false)
    var addExperienceButtonEnabled by mutableStateOf(false)
    var addProjectButtonEnabled by mutableStateOf(false)
    var buttonSubmitEnabled by mutableStateOf(false)


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

    fun makeJson() {
        val json = ""
    }
}

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    data class JsonDataSuccess(val data: WebsiteData) : UiState()
    data class Error(val message: String) : UiState()
}