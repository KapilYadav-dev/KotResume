package `in`.mrkaydev.portfolio

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.theme.AppTheme
import `in`.mrkaydev.portfolio.ui.screens.Resume
import `in`.mrkaydev.portfolio.utils.FontLoader
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
internal fun App() {
    var darkTheme by rememberSaveable { mutableStateOf(false) }
    var isFontLoaded by rememberSaveable { mutableStateOf(false) }
    var showResume by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        FontLoader.loadFonts()
        isFontLoaded = true
    }
    AppTheme(useDarkTheme = darkTheme) {
        if (isFontLoaded && showResume) Resume() else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(64.dp))
            }
            LaunchedEffect(Unit) {
                delay(3.seconds)
                showResume = true
            }
        }
    }
}

internal expect fun openUrl(url: String?)
internal expect fun showAlert(msg: String?)