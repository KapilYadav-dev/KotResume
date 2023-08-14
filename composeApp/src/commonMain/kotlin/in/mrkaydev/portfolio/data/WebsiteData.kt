package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
data class WebsiteData(
    val resumeName:String,
    val resumeUrl:String,
    val resumeDataList:List<WidgetConfig>
)
