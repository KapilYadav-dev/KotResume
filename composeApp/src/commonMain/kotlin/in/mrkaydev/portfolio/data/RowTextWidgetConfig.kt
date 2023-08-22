package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
data class RowTextWidgetConfig(
    @JsonNames("firstText","firstTextWidgetConfig") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @JsonNames("secondText","secondTextWidgetConfig") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    override val widgetId: String = Widgets.RowTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig