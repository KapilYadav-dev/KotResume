package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.EncodeDefault


@kotlinx.serialization.Serializable
data class SpannedTextWidgetConfig(
    val textList: List<BasicTextWidgetConfig>? = null,
    @EncodeDefault override val widgetId: String = Widgets.SpannedTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig
