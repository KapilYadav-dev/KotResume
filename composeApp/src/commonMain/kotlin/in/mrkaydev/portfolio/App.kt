package `in`.mrkaydev.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import `in`.mrkaydev.portfolio.theme.AppTheme
import `in`.mrkaydev.portfolio.ui.UiState
import `in`.mrkaydev.portfolio.ui.ViewModel
import `in`.mrkaydev.portfolio.ui.screens.Resume
import `in`.mrkaydev.portfolio.utils.FontLoader
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun App() {
    val viewModel = getViewModel(Unit, viewModelFactory { ViewModel() })
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            AppTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp).align(Alignment.Center),
                        color = Color.Black
                    )
                    Text(
                        "made by mrkaydev and powered by Compose multiplatform <3",
                        fontSize = 16.sp,
                        fontFamily = FontLoader.Montserrat,
                        modifier = Modifier.padding(32.dp).align(Alignment.BottomCenter)
                    )
                }
            }
        }
        is UiState.Error -> {
            val data = (uiState as UiState.Error).message
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource("error.png"),
                    modifier = Modifier.fillMaxSize(0.6f).align(Alignment.Center),
                    contentDescription = ""
                )
                Text(
                    "Error occurred : ( \n$data",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontLoader.Montserrat,
                    modifier = Modifier.padding(32.dp).align(Alignment.BottomCenter)
                )
            }
        }
        is UiState.JsonDataSuccess -> {
            val data = (uiState as UiState.JsonDataSuccess).data
            AppTheme {
                Resume(data)
            }
        }
        UiState.Initial -> {

        }
    }
}

internal expect fun enterFullScreen()
internal expect fun exitFullScreen()
internal expect fun openUrl(url: String?)
internal expect fun showAlert(msg: String?)
internal expect fun writeToClipboard(text: String?)
internal expect fun log(msg: String?)
internal expect fun getWindowDimen(): Pair<Int, Int>