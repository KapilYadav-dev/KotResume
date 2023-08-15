package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class MiddleBulletinRowTextWidgetConfig(
    val bulletinText: String = "•",
    @JsonNames("firstText","firstTextWidgetConfig") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("secondText","secondTextWidgetConfig") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("thirdText","thirdTextWidgetConfig") val thirdTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("fourthText","fourthTextWidgetConfig") val fourthTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.MiddleBulletinRowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)