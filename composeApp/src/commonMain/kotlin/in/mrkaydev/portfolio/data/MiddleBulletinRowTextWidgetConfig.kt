package `in`.mrkaydev.portfolio.data


@kotlinx.serialization.Serializable
data class MiddleBulletinRowTextWidgetConfig(
    val bulletinText: String = "•",
    val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    val thirdTextWidgetConfig: BasicTextWidgetConfig? = null,
    val fourthTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.MiddleBulletinRowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)