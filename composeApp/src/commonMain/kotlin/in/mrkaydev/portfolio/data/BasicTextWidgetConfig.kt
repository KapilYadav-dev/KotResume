package `in`.mrkaydev.portfolio.data

import androidx.compose.ui.unit.TextUnit


@kotlinx.serialization.Serializable
data class BasicTextWidgetConfig(
    val text: String? = null,
    val url: String? = null,
    val shouldUnderLineUrl:Boolean?=true,
    val textConfig: TextConfig = TextConfig(),
    override val widgetId: String = Widgets.BasicTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
) : WidgetConfig {
    @kotlinx.serialization.Serializable
    data class TextConfig(
        val color: String? = null,
        val fontWeight: String? = null,
        val fontStyle:String?=null,
        val textSize:Int? = null
    )
}