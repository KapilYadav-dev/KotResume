package `in`.mrkaydev.portfolio.data

import kotlinx.serialization.json.JsonObject

@kotlinx.serialization.Serializable
data class WebsiteData(
    val resumeName: String?=null,
    val resumeUrl: String?=null,
    val resumeDataList: List<JsonObject>?=null
)
