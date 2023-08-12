package `in`.mrkaydev.portfolio

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import `in`.mrkaydev.portfolio.theme.AppTheme

@Composable
internal fun App() {
    var darkTheme by rememberSaveable { mutableStateOf(false) }
    AppTheme(useDarkTheme = darkTheme) {
        Resume()
    }
}

internal expect fun openUrl(url: String?)