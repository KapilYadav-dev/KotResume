package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames

@kotlinx.serialization.Serializable
data class SpacerWidgetConfig(
 val space:Int?=null,
 @JsonNames("widgetId") val widgetId: String = Widgets.SpacerWidgetId.widgetName,
 val topPadding: Int = 0,
 val bottomPadding: Int = 0,
 val startPadding: Int = 0,
 val endPadding: Int = 0
)
