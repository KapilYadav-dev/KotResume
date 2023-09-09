package `in`.mrkaydev.portfolio

import kotlinx.browser.document
import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    url?.let { window.open(it) }
}

internal actual fun showAlert(msg: String?) {
    msg?.let { window.alert(it) }
}

internal actual fun log(msg: String?) {
    console.log(msg)
}

internal actual fun getWindowDimen(): Pair<Int, Int> {
    return Pair(window.outerWidth, window.outerHeight)
}

internal actual fun writeToClipboard(text: String?) {
    text?.let {
        window.navigator.clipboard.writeText(it).then {
            showAlert("Copied to clipboard")
        }
    }
}

internal actual fun enterFullScreen() {
    val element = document.getElementById("ComposeTarget")
    element?.requestFullscreen()
}

internal actual fun exitFullScreen() {
    document.exitFullscreen()
}