package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.data.*
import `in`.mrkaydev.portfolio.ui.components.BasicText
import `in`.mrkaydev.portfolio.ui.components.DividerWidget
import `in`.mrkaydev.portfolio.ui.components.MiddleBulletinRowText
import `in`.mrkaydev.portfolio.ui.components.RowText
import `in`.mrkaydev.portfolio.utils.Utils.toDp

@Composable
fun Resume() {
    Box(modifier = Modifier.background(Color(0xff535659)).fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight().background(Color.White)
                .padding(horizontal = 32.dp, vertical = 24.dp).align(
                    Alignment.Center
                )
        ) {
            items(getResumeItemList()) {
                when (it.widgetId) {
                    Widgets.BasicTextWidgetId.widgetName -> BasicText(it as BasicTextWidgetConfig)
                    Widgets.RowTextWidgetId.widgetName -> RowText(it as RowTextWidgetConfig)
                    Widgets.DividerWidgetId.widgetName -> DividerWidget(it as DividerWidgetConfig)
                    Widgets.MiddleBulletinRowTextWidgetId.widgetName -> MiddleBulletinRowText(it as MiddleBulletinRowTextWidgetConfig)
                    Widgets.SpacerWidgetId.widgetName -> {
                        val config = it as SpacerWidgetConfig
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
                textSize = 12,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "Aug. 2019 – May. 2023",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 12,
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
                textSize = 12,
                color = "black",
                fontWeight = "normal"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "April. 2016 – May. 2019",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 12,
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
                textSize = 12,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        ),
        fourthTextWidgetConfig = BasicTextWidgetConfig(
            text = "April 2023 - Present",
            textConfig = BasicTextWidgetConfig.TextConfig(
                textSize = 12,
                color = "black",
                fontWeight = "normal",
                fontStyle = "italics"
            )
        )
    ),
)