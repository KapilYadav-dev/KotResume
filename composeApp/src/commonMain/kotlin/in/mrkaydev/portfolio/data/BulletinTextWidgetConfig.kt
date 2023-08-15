package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class BulletinTextWidgetConfig(
    val bulletinText: String = "•",
    @JsonNames("textList","list")val textConfigsList: List<BasicTextWidgetConfig>? = null,
    val widgetId: String = Widgets.BulletinTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 32,
    val endPadding: Int = 0
)