package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import compose.icons.FeatherIcons
import compose.icons.feathericons.Download
import compose.icons.feathericons.Github
import compose.icons.feathericons.Menu
import `in`.mrkaydev.portfolio.data.*
import `in`.mrkaydev.portfolio.getWindowDimen
import `in`.mrkaydev.portfolio.openUrl
import `in`.mrkaydev.portfolio.ui.components.*
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils.toDp
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun Resume(data: WebsiteData) {
    val width = getWindowDimen().first
    val height = getWindowDimen().second

    val ratio= if(width<height) 0.8f else 0.45f
    Box(modifier = Modifier.background(Color(0xff535659)).fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().zIndex(1f).height(64.dp).background(Color(0xff333639)), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                Icon(imageVector = FeatherIcons.Menu, contentDescription = "", modifier = Modifier.padding(horizontal = 32.dp).size(24.dp), tint = Color.White)
                Text(data.resumeName.toString(), fontWeight = FontWeight.SemiBold, fontFamily = FontLoader.Montserrat, fontSize = 16.sp, color = Color.White)
            }
            Row {
                Icon(imageVector = FeatherIcons.Github, contentDescription = "", modifier = Modifier.padding(horizontal = 32.dp).size(24.dp).clickable { openUrl(data.githubUrl) }, tint = Color.White)
                Icon(imageVector = FeatherIcons.Download, contentDescription = "", modifier = Modifier.padding(horizontal = 32.dp).size(24.dp).clickable { openUrl(data.resumeUrl) }, tint = Color.White)
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(ratio).fillMaxHeight().background(Color.White)
                .padding(start = 32.dp, end = 32.dp, top = 80.dp, bottom = 32.dp).align(
                    Alignment.Center
                )
        ) {
            items(data.resumeDataList?: emptyList()) {
                val id = it["widgetId"]?.jsonPrimitive?.contentOrNull
                when (id.toString()) {
                    Widgets.BasicTextWidgetId.widgetName -> {
                        val data = Json.decodeFromJsonElement(BasicTextWidgetConfig.serializer(), it)
                        BasicText(data)
                    }
                    Widgets.RowTextWidgetId.widgetName -> {
                        val data = Json.decodeFromJsonElement(RowTextWidgetConfig.serializer(), it)
                        RowText(data)
                    }
                    Widgets.DividerWidgetId.widgetName -> {
                        val data = Json.decodeFromJsonElement(DividerWidgetConfig.serializer(), it)
                        DividerWidget(data)
                    }
                    Widgets.MiddleBulletinRowTextWidgetId.widgetName -> {
                        val data = Json.decodeFromJsonElement(MiddleBulletinRowTextWidgetConfig.serializer(), it)
                        MiddleBulletinRowText(data)
                    }
                    Widgets.BulletinTextWidgetId.widgetName -> {
                        val data = Json.decodeFromJsonElement(BulletinTextWidgetConfig.serializer(), it)
                        BulletinText(data)
                    }
                    Widgets.SpacerWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(SpacerWidgetConfig.serializer(), it)
                        config.space?.toDp()?.let { dp ->
                            Spacer(Modifier.height(dp))
                        }
                    }
                }
            }
        }
    }
}


fun getResumeItemList() = listOf(
    RowTextWidgetConfig(
        BasicTextWidgetConfig(
            text = "Kapil Yadav",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "blue",
                fontWeight = "bold"
            )
        ),
        BasicTextWidgetConfig(
            text = "Email: infokaydev@gmail.com",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        )
    ),
    RowTextWidgetConfig(
        BasicTextWidgetConfig(
            text = "All links here",
            url = "https://linktr.ee/mrkaydev",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal",
            )
        ),
        BasicTextWidgetConfig(
            text = "Mobile: +91-8920701834",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        )
    ),
    SpacerWidgetConfig(
        space = 20
    ),
    BasicTextWidgetConfig(
        text = "Education",
        textConfig = BasicTextWidgetConfig.TextConfig(
            textSize = 16,
            color = "blue",
            fontWeight = "bold"
        )
    ),
    DividerWidgetConfig(
        thickness = 1,
        color = "black",
        topPadding = 4
    ),
    SpacerWidgetConfig(
        space = 20
    ),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "Ajay Kumar Garg Engineering College",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Ghaziabad",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Bachelor of Technology in Computer Science Engineering; CGPA: 7.4",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "Aug. 2019 – May. 2023",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
    SpacerWidgetConfig(
        space = 12
    ),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "Rajkiya pratibha vikas vidyalaya",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Surajmal vihar, New Delhi",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Class 12th; PERCENTAGE: 93.7%",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "April. 2018 – May. 2019",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal"
            )
        )
    ),
    SpacerWidgetConfig(
        space = 20
    ),
    BasicTextWidgetConfig(
        text = "Experience",
        textConfig = BasicTextWidgetConfig.TextConfig(
            textSize = 16,
            color = "blue",
            fontWeight = "bold"
        )
    ),
    DividerWidgetConfig(
        thickness = 1,
        color = "black",
        topPadding = 4
    ),
    SpacerWidgetConfig(
        space = 20
    ),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "Mobile Premier League (MPL)",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Bangalore, IN (Remote)",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Android Intern",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "April 2023 - Present",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
    BulletinTextWidgetConfig(
        textConfigsList = listOf(
            BasicTextWidgetConfig(
                text = "improved app startup time from <b>400 ms to 20 ms.</b>",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "refactored their codebase from java to kotlin and reduced tech burden.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "worked with <b>MPL internal SDK’s</b> which are being used in multiple products.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
        )
    ),
    SpacerWidgetConfig(8),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "INDMoney",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Gurugram, IN (Remote)",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Android Intern",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "Sept 2022 - March 2023",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
    BulletinTextWidgetConfig(
        textConfigsList = listOf(
            BasicTextWidgetConfig(
                text = "was responsible for the whole <b>Mutual funds vertical.</b>",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "was the DRI for implementation of <b>Sentry SDK.</b>",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "worked on platform task for improving <b>Janky frames.</b>",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
        )
    ),
    SpacerWidgetConfig(8),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "Atom EI",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Gurugram, IN (Remote)",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Android Intern",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "June 2022 - Sept 2022",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
    BulletinTextWidgetConfig(
        textConfigsList = listOf(
            BasicTextWidgetConfig(
                text = "<b>Led Personalized Time feature :</b> Added a feature in prod release for Personalized meditation time for making flexible meditation for the user. Bug-free in 1st e2e testing itself.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "<b>Image similarity algorithm :</b> Worked upon Phash algorithm which converted to a library in kotlin for internal use so that we can achieve Image similarity stable way with more than 85% accuracy.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "<b>Fixed bug on the production line :</b> Fixed a critical bug which leads to crashing, thus Firebase crashlytics events dropped by 90%.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
        )
    ),
    SpacerWidgetConfig(8),
    MiddleBulletinRowTextWidgetConfig(
        bulletinText = "•",
        firstTextWidgetConfig = BasicTextWidgetConfig(
            text = "Atom EI",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "bold"
            )
        ),
        secondTextWidgetConfig = BasicTextWidgetConfig(
            text = "Gurugram, IN (Remote)",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 16,
                color = "black",
                fontWeight = "normal"
            )
        ),
        thirdTextWidgetConfig = BasicTextWidgetConfig(
            text = "Android Intern",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "June 2022 - Sept 2022",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 14,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
    BulletinTextWidgetConfig(
        textConfigsList = listOf(
            BasicTextWidgetConfig(
                text = "<b>Led Personalized Time feature :</b> Added a feature in prod release for Personalized meditation time for making flexible meditation for the user. Bug-free in 1st e2e testing itself.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "<b>Image similarity algorithm :</b> Worked upon Phash algorithm which converted to a library in kotlin for internal use so that we can achieve Image similarity stable way with more than 85% accuracy.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
            BasicTextWidgetConfig(
                text = "<b>Fixed bug on the production line :</b> Fixed a critical bug which leads to crashing, thus Firebase crashlytics events dropped by 90%.",
                textConfig = BasicTextWidgetConfig.TextConfig(
                    textSize = 14,
                    color = "black",
                    fontWeight = "normal"
                )
            ),
        )
    )
)