package `in`.mrkaydev.portfolio.data

@kotlinx.serialization.Serializable
data class WebsiteData(
    val resumeName: String?=null,
    val resumeUrl: String?=null,
    val githubUrl: String?=null,
    val resumeDataList: List<WidgetConfig>?=null
)
