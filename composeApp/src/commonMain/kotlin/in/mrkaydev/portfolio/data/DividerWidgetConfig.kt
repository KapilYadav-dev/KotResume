package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
data class DividerWidgetConfig(
    val thickness: Int? = null,
    val color: String? = null,
    val colorAlpha: Float = 1f,
    override val widgetId: String = Widgets.DividerWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
):WidgetConfig
