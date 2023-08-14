package `in`.mrkaydev.portfolio

import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    url?.let { window.open(it) }
}

internal actual fun showAlert(msg:String?) {
    msg?.let { window.alert(it)}
}

internal actual fun String.logger() {
    console.log(this)
}

internal actual fun getWindowDimen(): Pair<Int, Int> {
    return Pair(window.outerWidth, window.outerHeight)
}