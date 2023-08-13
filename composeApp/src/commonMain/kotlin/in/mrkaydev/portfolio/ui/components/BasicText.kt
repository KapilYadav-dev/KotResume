package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import `in`.mrkaydev.portfolio.data.BasicTextWidgetConfig
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils

@Composable
fun BasicText(config: BasicTextWidgetConfig) {
    config.apply {
        text?.let {
            Text(
                text = it,
                fontWeight = Utils.getFontWeightElseNormal(textConfig.fontWeight),
                color =  Utils.getColorElseBlack(textConfig.color),
                fontSize = textConfig.textSize?:14.sp,
                fontFamily = FontLoader.Montserrat
            )
        }
    }
}