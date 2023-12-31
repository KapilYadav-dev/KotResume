package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.HtmlParser.parseHtml
import `in`.mrkaydev.portfolio.utils.Utils
import `in`.mrkaydev.portfolio.utils.Utils.getFontStyleElseNormal
import `in`.mrkaydev.portfolio.utils.Utils.toSp

@Composable
fun BasicText(config: BasicTextWidgetConfig) {
    val clipBoard = LocalClipboardManager.current
    config.apply {
        text?.let {
            if(it.isNotBlank() || it.isNotEmpty()) {
                Row {
                    var textLayoutResult: TextLayoutResult? = null
                    Text(
                        text = it.parseHtml(),
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
                            openUrl(url)
                        }
                    )
                }
            }
        }
    }
}