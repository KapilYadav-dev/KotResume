package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.ui.components.EditText
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.writeToClipboard
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
        Row(
            modifier = Modifier.fillMaxWidth().zIndex(0f).height(64.dp)
                .background(Color(0xff333639)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Button(
                    {
                    // TODO add paste fun...
                    },
                    modifier = Modifier.weight(0.5f),
                    colors = ButtonDefaults.buttonColors(Color(0xff4169e1))
                ) {
                    Text(
                        "Paste JSON",
                        color = Color.White,
                        fontFamily = FontLoader.Montserrat,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.width(24.dp))
                Button(
                    {
                        writeToClipboard(jsonText.text)
                    },
                    modifier = Modifier.weight(0.5f),
                    colors = ButtonDefaults.buttonColors(Color(0xff4169e1))
                ) {
                    Text(
                        "Copy JSON",
                        color = Color.White,
                        fontFamily = FontLoader.Montserrat,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxSize().padding(top = 64.dp)) {
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
                Resume(data, shouldTakeFullScreen = { true })
            }
        }
    }
}