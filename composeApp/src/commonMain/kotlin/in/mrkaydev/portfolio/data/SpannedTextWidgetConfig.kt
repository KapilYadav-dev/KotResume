package `in`.mrkaydev.portfolio.data


@kotlinx.serialization.Serializable
data class SpannedTextWidgetConfig(
    val textList: List<BasicTextWidgetConfig>? = null,
    val widgetId: String = Widgets.SpannedTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)
