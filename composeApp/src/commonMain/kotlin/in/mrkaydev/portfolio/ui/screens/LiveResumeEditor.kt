package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.ui.components.EditText
import kotlinx.serialization.json.Json

@Composable
fun LiveResumeEditor() {
    var jsonText by remember {
        mutableStateOf(
            TextFieldValue("""{
                      "resumeName": "KapilYadav-Resume.pdf",
                      "resumeUrl": "https://d1fdloi71mui9q.cloudfront.net/Pz93R8fISZm11vhLK3Qx_KapilResume.pdf",
                      "githubUrl": "https://github.com/KapilYadav-dev/KotResume",
                      "resumeDataList": []
                      }""")
        )
    }
    val data by remember(jsonText) {
        val parsedData = try {
            Json.decodeFromString(jsonText.text)
        } catch (e: Exception) {
            WebsiteData()
        }
        derivedStateOf {
            parsedData
        }
    }
    Box(modifier = Modifier.background(Color(0xff535659)).fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(0.35f)) {
                EditText(
                    value = jsonText,
                    onValueChange = {
                        jsonText=it
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier.weight(0.65f)) {
                Resume(data, isInEditor = { true })
            }
        }
    }
}