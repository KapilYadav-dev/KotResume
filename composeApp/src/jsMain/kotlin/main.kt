import app.softwork.routingcompose.HashRouter
import `in`.mrkaydev.portfolio.App
import `in`.mrkaydev.portfolio.ui.screens.JsonMakerForm
import `in`.mrkaydev.portfolio.ui.screens.LiveResumeEditor
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        BrowserViewportWindow("Portfolio") {
            HashRouter(initPath = "/") { // or BrowserRouter(initPath = "/hello") {
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
