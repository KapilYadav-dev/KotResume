package `in`.mrkaydev.portfolio.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import `in`.mrkaydev.portfolio.data.*
import `in`.mrkaydev.portfolio.networking.httpClient
import `in`.mrkaydev.portfolio.ui.components.EducationData
import `in`.mrkaydev.portfolio.ui.components.ExperienceData
import `in`.mrkaydev.portfolio.ui.components.ProjectData
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils
import `in`.mrkaydev.portfolio.writeToClipboard
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ViewModel : dev.icerock.moko.mvvm.viewmodel.ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState: StateFlow<UiState> get() = _uiState
    var name by mutableStateOf("")
    var githubUrl by mutableStateOf("")
    var resumeUrl by mutableStateOf("")
    var email by mutableStateOf("")
    var mobile by mutableStateOf("")
    var links by mutableStateOf("")
    var languages by mutableStateOf("")
    var tools by mutableStateOf("")
    var technologies by mutableStateOf("")


    var educationList by mutableStateOf(listOf(EducationData("", "", "", "")))
    var experienceList by mutableStateOf(listOf(ExperienceData("", "", "", "", listOf(""))))
    var projectList by mutableStateOf(listOf(ProjectData("", "", listOf(""))))

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
        viewModelScope.launch(Dispatchers.Default) {
            val widgetsList = mutableListOf<WidgetConfig>()
            var jsonString: String?=null
            async {
                widgetsList.add(
                    RowTextWidgetConfig(
                        firstTextWidgetConfig = BasicTextWidgetConfig(
                            text = name, textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "blue", fontWeight = "bold", textSize = 16
                            )
                        ), secondTextWidgetConfig = BasicTextWidgetConfig(
                            text = email, textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", fontWeight = "normal", textSize = 16
                            )
                        )
                    )

                )
                widgetsList.add(
                    RowTextWidgetConfig(
                        firstTextWidgetConfig = BasicTextWidgetConfig(
                            text = "All links here",
                            url = links,
                            textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", fontWeight = "normal", textSize = 16
                            )
                        ), secondTextWidgetConfig = BasicTextWidgetConfig(
                            text = "Mobile: +91-$mobile",
                            textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", fontWeight = "normal", textSize = 16
                            )
                        )
                    )
                )
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                widgetsList.add(
                    BasicTextWidgetConfig(
                        text = "Education", textConfig = BasicTextWidgetConfig.TextConfig(
                            color = "blue", fontWeight = "bold", textSize = 16
                        )
                    )
                )
                widgetsList.add(
                    DividerWidgetConfig(1)
                )
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                educationList.forEach {
                    widgetsList.add(
                        MiddleBulletinRowTextWidgetConfig(
                            "•",
                            BasicTextWidgetConfig(
                                text = it.schoolName,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "bold", textSize = 16
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.place,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "normal", textSize = 16
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.marks,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black",
                                    fontWeight = "normal",
                                    textSize = 14,
                                    fontStyle = "italics"
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.time,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black",
                                    fontWeight = "normal",
                                    textSize = 14,
                                    fontStyle = "italics"
                                )
                            )
                        ),
                    )
                    widgetsList.add(
                        SpacerWidgetConfig(12)
                    )
                }
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                widgetsList.add(
                    BasicTextWidgetConfig(
                        text = "Experience", textConfig = BasicTextWidgetConfig.TextConfig(
                            color = "blue", fontWeight = "bold", textSize = 16
                        )
                    )
                )
                widgetsList.add(
                    DividerWidgetConfig(1)
                )
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                experienceList.forEach {
                    widgetsList.add(
                        MiddleBulletinRowTextWidgetConfig(
                            "•",
                            BasicTextWidgetConfig(
                                text = it.companyName,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "bold", textSize = 16
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.location,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "normal", textSize = 16
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.position,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black",
                                    fontWeight = "normal",
                                    textSize = 14,
                                    fontStyle = "italics"
                                )
                            ),
                            BasicTextWidgetConfig(
                                text = it.time,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black",
                                    fontWeight = "normal",
                                    textSize = 14,
                                    fontStyle = "italics"
                                )
                            )
                        ),
                    )
                    val responsibilityList = mutableListOf<BasicTextWidgetConfig>()
                    it.responsibilities.forEach { responsibility ->
                        responsibilityList.add(
                            BasicTextWidgetConfig(
                                text = responsibility,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "normal", textSize = 14
                                )
                            )
                        )
                    }
                    widgetsList.add(
                        BulletinTextWidgetConfig(
                            textConfigsList = responsibilityList
                        )
                    )
                    widgetsList.add(
                        SpacerWidgetConfig(8)
                    )
                }
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                widgetsList.add(
                    BasicTextWidgetConfig(
                        text = "Projects", textConfig = BasicTextWidgetConfig.TextConfig(
                            color = "blue", fontWeight = "bold", textSize = 16
                        )
                    )
                )
                widgetsList.add(
                    DividerWidgetConfig(1)
                )
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                projectList.forEach {
                    widgetsList.add(
                        MiddleBulletinRowTextWidgetConfig(
                            "",
                            BasicTextWidgetConfig(
                                text = it.projectName,
                                url = it.projectUrl,
                                textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "bold", textSize = 16
                                )
                            )
                        ),
                    )
                    val projectList = mutableListOf<BasicTextWidgetConfig>()
                    it.projectDetails.forEach { detail ->
                        projectList.add(
                            BasicTextWidgetConfig(
                                text = detail, textConfig = BasicTextWidgetConfig.TextConfig(
                                    color = "black", fontWeight = "normal", textSize = 14
                                )
                            )
                        )
                    }
                    widgetsList.add(
                        BulletinTextWidgetConfig(
                            textConfigsList = projectList
                        )
                    )
                    widgetsList.add(
                        SpacerWidgetConfig(8)
                    )
                }
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                widgetsList.add(
                    BasicTextWidgetConfig(
                        text = "Skills", textConfig = BasicTextWidgetConfig.TextConfig(
                            color = "blue", fontWeight = "bold", textSize = 16
                        )
                    )
                )
                widgetsList.add(
                    DividerWidgetConfig(1)
                )
                widgetsList.add(
                    SpacerWidgetConfig(20)
                )
                widgetsList.add(
                    MiddleBulletinRowTextWidgetConfig(
                        firstTextWidgetConfig = BasicTextWidgetConfig(
                            text = languages,
                            textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", "normal", 14
                            )
                        ),
                        secondTextWidgetConfig = BasicTextWidgetConfig(
                            text = technologies,
                            textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", "normal", 14
                            )
                        )
                    )
                )
                widgetsList.add(
                    SpacerWidgetConfig(8)
                )
                widgetsList.add(
                    MiddleBulletinRowTextWidgetConfig(
                        firstTextWidgetConfig = BasicTextWidgetConfig(
                            text = tools,
                            textConfig = BasicTextWidgetConfig.TextConfig(
                                color = "black", "normal", 14
                            )
                        )
                    )
                )
                widgetsList.add(
                    SpacerWidgetConfig(8)
                )
                val data = WebsiteData(
                    resumeUrl = resumeUrl,
                    resumeName = name,
                    githubUrl = githubUrl,
                    resumeDataList = widgetsList
                )
                jsonString = Json.encodeToString(data)
            }.await()
            jsonString?.let {
                writeToClipboard(it)
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