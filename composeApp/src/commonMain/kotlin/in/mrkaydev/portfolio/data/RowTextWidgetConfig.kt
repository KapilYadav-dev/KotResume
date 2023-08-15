package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class RowTextWidgetConfig(
    @JsonNames("firstText","firstTextWidgetConfig") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("secondText","secondTextWidgetConfig") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    val widgetId: String = Widgets.RowTextWidgetId.widgetName,
    val topPadding: Int = 0,
    val bottomPadding: Int = 0,
    val startPadding: Int = 0,
    val endPadding: Int = 0
)