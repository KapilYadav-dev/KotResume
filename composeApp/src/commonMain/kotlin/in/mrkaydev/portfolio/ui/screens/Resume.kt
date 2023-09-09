package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import app.softwork.routingcompose.Router
import compose.icons.FeatherIcons
import compose.icons.feathericons.Code
import compose.icons.feathericons.Download
import compose.icons.feathericons.Edit
import compose.icons.feathericons.Github
import compose.icons.feathericons.Menu
import `in`.mrkaydev.portfolio.data.BasicTextWidgetConfig
import `in`.mrkaydev.portfolio.data.BulletinTextWidgetConfig
import `in`.mrkaydev.portfolio.data.DividerWidgetConfig
import `in`.mrkaydev.portfolio.data.MiddleBulletinRowTextWidgetConfig
import `in`.mrkaydev.portfolio.data.RowTextWidgetConfig
import `in`.mrkaydev.portfolio.data.SpacerWidgetConfig
import `in`.mrkaydev.portfolio.data.SpannedTextWidgetConfig
import `in`.mrkaydev.portfolio.data.WebsiteData
import `in`.mrkaydev.portfolio.data.Widgets
import `in`.mrkaydev.portfolio.getWindowDimen
import `in`.mrkaydev.portfolio.openUrl
import `in`.mrkaydev.portfolio.ui.components.BasicText
import `in`.mrkaydev.portfolio.ui.components.BulletinText
import `in`.mrkaydev.portfolio.ui.components.DividerWidget
import `in`.mrkaydev.portfolio.ui.components.MiddleBulletinRowText
import `in`.mrkaydev.portfolio.ui.components.RowText
import `in`.mrkaydev.portfolio.ui.components.SpannedText
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils.toDp

@Composable
fun Resume(data: WebsiteData, isInEditor: () -> Boolean = { false }) {
    val router = Router.current
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
                if(!isInEditor()) {
                    Icon(
                        imageVector = FeatherIcons.Edit,
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 32.dp).size(24.dp)
                            .clickable { router.navigate("liveJson") },
                        tint = Color.White
                    )
                    Icon(
                        imageVector = FeatherIcons.Code,
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 32.dp).size(24.dp)
                            .clickable { router.navigate("json") },
                        tint = Color.White
                    )
                }
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
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(if (isInEditor()) 1.0f else ratio ).fillMaxHeight().background(Color.White)
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