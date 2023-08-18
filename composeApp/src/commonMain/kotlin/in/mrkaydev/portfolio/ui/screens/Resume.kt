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
    val state = rememberLazyListState()

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
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(ratio).fillMaxHeight().background(Color.White)
                .padding(start = 32.dp, end = 32.dp, top = 80.dp, bottom = 32.dp).align(
                    Alignment.Center
                )
        ) {
            items(data.resumeDataList?: emptyList()) {
                when (it["widgetId"]?.jsonPrimitive?.contentOrNull) {
                    Widgets.BasicTextWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(BasicTextWidgetConfig.serializer(), it)
                        BasicText(config)
                    }
                    Widgets.SpannedTextWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(SpannedTextWidgetConfig.serializer(), it)
                        SpannedText(config)
                    }
                    Widgets.RowTextWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(RowTextWidgetConfig.serializer(), it)
                        RowText(config)
                    }
                    Widgets.DividerWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(DividerWidgetConfig.serializer(), it)
                        DividerWidget(config)
                    }
                    Widgets.MiddleBulletinRowTextWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(MiddleBulletinRowTextWidgetConfig.serializer(), it)
                        MiddleBulletinRowText(config)
                    }
                    Widgets.BulletinTextWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(BulletinTextWidgetConfig.serializer(), it)
                        BulletinText(config)
                    }
                    Widgets.SpacerWidgetId.widgetName -> {
                        val config = Json.decodeFromJsonElement(SpacerWidgetConfig.serializer(), it)
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