package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import compose.icons.feathericons.Square
import `in`.mrkaydev.portfolio.data.*
import `in`.mrkaydev.portfolio.enterFullScreen
import `in`.mrkaydev.portfolio.exitFullScreen
import `in`.mrkaydev.portfolio.getWindowDimen
import `in`.mrkaydev.portfolio.openUrl
import `in`.mrkaydev.portfolio.ui.components.*
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils.toDp

@Composable
fun Resume(data: WebsiteData, shouldTakeFullScreen: () -> Boolean = { false }) {

    val width = getWindowDimen().first
    val height = getWindowDimen().second
    val state = rememberLazyListState()
    var isFullScreen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        state.scrollToItem(0)
    }

    val ratio = if (width < height) 0.8f else 0.55f
    Box(modifier = Modifier.background(Color(0xff535659)).fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().zIndex(1f).height(64.dp)
                .background(Color(0xff333639)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                data.resumeName?.let {
                    Icon(
                        imageVector = FeatherIcons.Menu,
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 32.dp).size(24.dp),
                        tint = Color.White
                    )
                    Text(
                        data.resumeName.toString(),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontLoader.Montserrat,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
            Row {
                data.githubUrl?.let {
                    Icon(
                        imageVector = FeatherIcons.Github,
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 32.dp).size(24.dp)
                            .clickable { openUrl(data.githubUrl) },
                        tint = Color.White
                    )
                }
                data.resumeUrl?.let {
                    Icon(
                        imageVector = FeatherIcons.Download,
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 32.dp).size(24.dp)
                            .clickable { openUrl(data.resumeUrl) },
                        tint = Color.White
                    )
                }
                Icon(
                    imageVector = FeatherIcons.Square,
                    contentDescription = "",
                    modifier = Modifier.padding(horizontal = 32.dp).size(if (isFullScreen) 16.dp else 28.dp)
                        .clickable {
                            isFullScreen = !isFullScreen
                            if (isFullScreen) enterFullScreen() else exitFullScreen()
                        },
                    tint = Color.White
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(if (shouldTakeFullScreen()) 1.0f else ratio).fillMaxHeight().background(Color.White)
                .padding(start = 32.dp, end = 32.dp, top = 80.dp, bottom = 32.dp).align(
                    Alignment.Center
                )
        ) {
            items(data.resumeDataList ?: emptyList()) {
                when (it.widgetId) {
                    Widgets.BasicTextWidgetId.widgetName -> {
                        val config = it as BasicTextWidgetConfig
                        BasicText(config)
                    }

                    Widgets.SpannedTextWidgetId.widgetName -> {
                        val config = it as SpannedTextWidgetConfig
                        SpannedText(config)
                    }

                    Widgets.RowTextWidgetId.widgetName -> {
                        val config = it as RowTextWidgetConfig
                        RowText(config)
                    }

                    Widgets.DividerWidgetId.widgetName -> {
                        val config = it as DividerWidgetConfig
                        DividerWidget(config)
                    }

                    Widgets.MiddleBulletinRowTextWidgetId.widgetName -> {
                        val config = it as MiddleBulletinRowTextWidgetConfig
                        MiddleBulletinRowText(config)
                    }

                    Widgets.BulletinTextWidgetId.widgetName -> {
                        val config = it as BulletinTextWidgetConfig
                        BulletinText(config)
                    }

                    Widgets.SpacerWidgetId.widgetName -> {
                        val config = it as SpacerWidgetConfig
                        config.space?.toDp()?.let { dp ->
                            Spacer(Modifier.height(dp))
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}