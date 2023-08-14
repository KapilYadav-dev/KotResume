package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
data class DividerWidgetConfig(
    val thickness: Int? = null,
    val color: String? = null,
    val colorAlpha: Float = 1f,
    val widgetId: String = Widgets.DividerWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)
