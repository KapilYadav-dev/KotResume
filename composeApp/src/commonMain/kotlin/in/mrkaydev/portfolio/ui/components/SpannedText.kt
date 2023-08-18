package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import `in`.mrkaydev.portfolio.data.SpannedTextWidgetConfig

@Composable
fun SpannedText(config: SpannedTextWidgetConfig) {
    config.textList?.let {
        LazyRow {
            items(config.textList) {
                BasicText(it)
            }
        }
    }
}