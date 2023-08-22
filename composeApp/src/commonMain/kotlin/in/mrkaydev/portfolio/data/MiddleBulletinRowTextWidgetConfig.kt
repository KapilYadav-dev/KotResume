package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class MiddleBulletinRowTextWidgetConfig(
    val bulletinText: String = "•",
    @JsonNames("firstText","firstTextWidgetConfig") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("secondText","secondTextWidgetConfig") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("thirdText","thirdTextWidgetConfig") val thirdTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("fourthText","fourthTextWidgetConfig") val fourthTextWidgetConfig: BasicTextWidgetConfig? = null,
    @EncodeDefault override val widgetId: String = Widgets.MiddleBulletinRowTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig