package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class BasicTextWidgetConfig(
    val text: String? = null,
    val url: String? = null,
    val shouldUnderLineUrl: Boolean? = true,
    @JsonNames("config","textConfig") val textConfig: TextConfig = TextConfig(),
    @EncodeDefault override val widgetId: String = Widgets.BasicTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig {
    @kotlinx.serialization.Serializable
    data class TextConfig(
        val color: String? = null,
        val fontWeight: String? = null,
        val textSize: Int? = 14,
        val fontStyle: String? = null
    )
}