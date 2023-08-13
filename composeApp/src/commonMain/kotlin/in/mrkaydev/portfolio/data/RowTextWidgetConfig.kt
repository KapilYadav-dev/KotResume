package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class RowTextWidgetConfig(
    @SerialName("firstText") val firstTextWidgetConfig: BasicTextWidgetConfig? = null,
    @SerialName("secondText") val secondTextWidgetConfig: BasicTextWidgetConfig? = null,
)