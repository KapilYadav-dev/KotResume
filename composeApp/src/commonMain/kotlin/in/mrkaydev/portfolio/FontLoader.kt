package `in`.mrkaydev.portfolio

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

object FontLoader {
    private const val fontPath = "fonts"
    var Mons: FontFamily? = null
        private set

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadFonts() {
        Mons = FontFamily(
            Font(
                identity = "MonsBold",
                data = resource("$fontPath/font_bold.ttf").readBytes(),
                weight = FontWeight.Black
            ),
            Font(
                identity = "MonsRegular",
                data = resource("$fontPath/font_regular.ttf").readBytes(),
                weight = FontWeight.Normal
            )
        )
    }
}
