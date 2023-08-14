package `in`.mrkaydev.portfolio.data


@kotlinx.serialization.Serializable
data class BulletinTextWidgetConfig(
    val bulletinText: String = "•",
    val textConfigsList: List<BasicTextWidgetConfig>? = null,
    val widgetId: String = Widgets.BulletinTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 32,
    val endPadding: Int = 0
)