package `in`.mrkaydev.portfolio.data


@kotlinx.serialization.Serializable
data class RowTextWidgetConfig(
    val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.RowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)