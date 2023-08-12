import `in`.mrkaydev.portfolio.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        BrowserViewportWindow("Portfolio") {
            App()
        }
    }
}
