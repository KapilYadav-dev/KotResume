package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class BulletinTextWidgetConfig(
    val bulletinText: String = "•",
    @JsonNames("textList","list")val textConfigsList: List<BasicTextWidgetConfig>? = null,
    @EncodeDefault override val widgetId: String = Widgets.BulletinTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 32,
    override val endPadding: Int = 0
):WidgetConfig