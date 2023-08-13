package `in`.mrkaydev.portfolio.utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

object FontLoader {
    private const val fontPath = "fonts"
    var Montserrat: FontFamily? = null
        private set

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadFonts() {
        Montserrat = FontFamily(
            Font(
                identity = "bold",
                data = resource("$fontPath/font_bold.ttf").readBytes(),
                weight = FontWeight.Bold
            ),
            Font(
                identity = "semibold",
                data = resource("$fontPath/font_semibold.ttf").readBytes(),
                weight = FontWeight.SemiBold
            ),
            Font(
                identity = "medium",
                data = resource("$fontPath/font_medium.ttf").readBytes(),
                weight = FontWeight.Medium
            ),
            Font(
                identity = "normal",
                data = resource("$fontPath/font_regular.ttf").readBytes(),
                weight = FontWeight.Normal
            ),
            Font(
                identity = "light",
                data = resource("$fontPath/font_light.ttf").readBytes(),
                weight = FontWeight.Light
            )
        )
    }
}
