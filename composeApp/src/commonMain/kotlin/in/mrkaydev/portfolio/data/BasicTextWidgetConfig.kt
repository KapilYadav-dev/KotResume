package `in`.mrkaydev.portfolio.data

import androidx.compose.ui.unit.TextUnit


data class BasicTextWidgetConfig(
    val text: String? = null,
    val url: String = "",
    val textConfig: TextConfig = TextConfig(),
    override val widgetId: String = Widgets.BasicTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
) : WidgetConfig {
    data class TextConfig(
        val color: String? = null,
        val fontWeight: String? = null,
        val textSize:TextUnit? = null
    )
}