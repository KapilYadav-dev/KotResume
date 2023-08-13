package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.mrkaydev.portfolio.data.BasicTextWidgetConfig
import `in`.mrkaydev.portfolio.openUrl
import `in`.mrkaydev.portfolio.showAlert
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils
import `in`.mrkaydev.portfolio.utils.Utils.Toast
import `in`.mrkaydev.portfolio.utils.Utils.getFontStyleElseNormal
import `in`.mrkaydev.portfolio.utils.Utils.toSp
import kotlinx.coroutines.delay

@Composable
fun BasicText(config: BasicTextWidgetConfig) {
    val clipBoard = LocalClipboardManager.current

    config.apply {
        text?.let {
            Column {
                var textLayoutResult: TextLayoutResult? = null
                Text(
                    text = it,
                    fontWeight = Utils.getFontWeightElseNormal(textConfig.fontWeight),
                    color = Utils.getColorElseBlack(textConfig.color),
                    fontSize = textConfig.textSize?.toSp() ?: 14.sp,
                    fontFamily = FontLoader.Montserrat,
                    fontStyle = getFontStyleElseNormal(textConfig.fontStyle),
                    onTextLayout = {
                        textLayoutResult = it
                    },
                    modifier = Modifier.drawBehind {
                        if (shouldUnderLineUrl == true && url != null) {
                            textLayoutResult?.size?.width?.toFloat()?.let { it1 ->
                                Offset(
                                    it1,
                                    size.height - 1.dp.toPx()
                                )
                            }?.let { it2 ->
                                drawLine(
                                    color = Color.Black.copy(alpha = 0.3f),
                                    start = Offset(0f, size.height - 1.dp.toPx()),
                                    end = it2,
                                    strokeWidth = 1.dp.toPx()
                                )
                            }
                        }
                    }.clickable {
                        clipBoard.setText(AnnotatedString(it))
                        //showAlert("Copied to clipboard")
                        openUrl(url)
                    }
                )
            }

        }
    }
}