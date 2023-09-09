import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import app.softwork.routingcompose.HashRouter
import `in`.mrkaydev.portfolio.App
import `in`.mrkaydev.portfolio.ui.screens.JsonMakerForm
import `in`.mrkaydev.portfolio.ui.screens.LiveResumeEditor
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("Portfolio") {
            HashRouter(initPath = "/") {
                route("/") {
                    App()
                }
                route("/home") {
                    App()
                }
                route("/json") {
                    JsonMakerForm()
                }
                route("/liveJson") {
                    LiveResumeEditor()
                }
                route("/livejson") {
                    LiveResumeEditor()
                }
            }
        }
    }
}
