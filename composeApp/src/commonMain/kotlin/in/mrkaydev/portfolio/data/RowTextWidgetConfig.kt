package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class RowTextWidgetConfig(
    @SerialName("firstText") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @SerialName("secondText") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
    override val widgetId: String = Widgets.RowTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig