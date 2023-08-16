package `in`.mrkaydev.portfolio

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.networking.httpClient
import `in`.mrkaydev.portfolio.theme.AppTheme
import `in`.mrkaydev.portfolio.ui.screens.JsonMakerForm
import `in`.mrkaydev.portfolio.ui.screens.Resume
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

@Composable
internal fun App() {
    var isFontLoaded by rememberSaveable { mutableStateOf(false) }
    var showResume by rememberSaveable { mutableStateOf(false) }
    var data by rememberSaveable { mutableStateOf(WebsiteData()) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            FontLoader.loadFonts()
            isFontLoaded = true
        }
        delay(2.seconds)
        data = httpClient.get(Utils.RESUME_JSON_URL).body()
    }
    AppTheme {
        if (isFontLoaded && showResume) JsonMakerForm() else if (isFontLoaded) {
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
            LaunchedEffect(Unit) {
                delay(2.seconds)
                showResume = true
            }
        }
    }
}

internal expect fun openUrl(url: String?)
internal expect fun showAlert(msg: String?)
internal expect fun String.logger()
internal expect fun getWindowDimen(): Pair<Int, Int>