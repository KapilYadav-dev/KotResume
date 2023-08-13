package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class MiddleBulletinRowTextWidgetConfig(
    @SerialName("bulletinText") val bulletinText: String = "•",
    @SerialName("firstText") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @SerialName("secondText") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    @SerialName("thirdText") val thirdTextWidgetConfig: BasicTextWidgetConfig? = null,
    @SerialName("fourthText") val fourthTextWidgetConfig: BasicTextWidgetConfig? = null,
    override val widgetId: String = Widgets.MiddleBulletinRowTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig