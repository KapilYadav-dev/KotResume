package `in`.mrkaydev.portfolio.data

import `in`.mrkaydev.portfolio.utils.Utils
import kotlinx.serialization.Serializable

@Serializable(with = Utils.BaseItemSerializer::class)
sealed interface WidgetConfig {
    val topPadding: Int?
    val bottomPadding: Int?
    val startPadding: Int?
    val endPadding: Int?
    val widgetId: String?
}