package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.writeToClipboard
import kotlinx.serialization.json.Json

@Composable
fun LiveResumeEditor() {
    var jsonText by remember {
        mutableStateOf(
            """{
                      "resumeName": "KapilYadav-Resume.pdf",
                      "resumeUrl": "https://d1fdloi71mui9q.cloudfront.net/Pz93R8fISZm11vhLK3Qx_KapilResume.pdf",
                      "githubUrl": "https://github.com/KapilYadav-dev/KotResume",
                      "resumeDataList": []
                      }"""
        )
    }
    val data by remember(jsonText) {
        val parsedData = try {
            Json.decodeFromString(jsonText)
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
                        writeToClipboard(jsonText)
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
                OutlinedTextField(
                    value = jsonText,
                    textStyle = fontStyle,
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxSize(),
                    onValueChange = { jsonText = it },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.Black,
                        backgroundColor = Color.White.copy(alpha = 0.8f),
                        focusedIndicatorColor = Color.Black
                    ),
                )
            }
            Column(modifier = Modifier.weight(0.65f)) {
                Resume(data, shouldTakeFullScreen = { true })
            }
        }
    }
}