package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class BasicTextWidgetConfig(
    val text: String? = null,
    val url: String? = null,
    val shouldUnderLineUrl: Boolean? = true,
    @JsonNames("config","textConfig") val textConfig: TextConfig = TextConfig(),
    val widgetId: String = Widgets.BasicTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
) {
    @kotlinx.serialization.Serializable
    data class TextConfig(
        val color: String? = null,
        val fontWeight: String? = null,
        val textSize: Int? = null,
        val fontStyle: String? = null
    )
}