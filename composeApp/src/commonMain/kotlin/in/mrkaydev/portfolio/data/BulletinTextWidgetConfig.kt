package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class BulletinTextWidgetConfig(
    @SerialName("bulletinText") val bulletinText: String = "•",
    @SerialName("textList") val textConfigsList: List<BasicTextWidgetConfig>? = null,
    override val widgetId: String = Widgets.BulletinTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 32,
    override val endPadding: Int = 0
):WidgetConfig