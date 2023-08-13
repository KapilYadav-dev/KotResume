package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import `in`.mrkaydev.portfolio.data.BasicTextWidgetConfig
import `in`.mrkaydev.portfolio.data.RowTextWidgetConfig
import `in`.mrkaydev.portfolio.utils.FontLoader
import `in`.mrkaydev.portfolio.utils.Utils

@Composable
fun RowText(config: RowTextWidgetConfig) {
    config.apply {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            config.firstTextWidgetConfig?.let { BasicText(it) }
            config.secondTextWidgetConfig?.let { BasicText(it) }
        }
    }
}