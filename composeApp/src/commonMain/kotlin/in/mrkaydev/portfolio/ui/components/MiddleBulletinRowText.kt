package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.data.MiddleBulletinRowTextWidgetConfig

@Composable
fun MiddleBulletinRowText(config: MiddleBulletinRowTextWidgetConfig) {
    config.apply {
        Row(modifier = Modifier.fillMaxWidth()) {
            if(config.firstTextWidgetConfig?.text?.isNotBlank()==true || config.firstTextWidgetConfig?.text?.isNotEmpty()==true) {
                Text(bulletinText)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        config.firstTextWidgetConfig?.let { BasicText(it) }
                        config.secondTextWidgetConfig?.let { BasicText(it) }
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        config.thirdTextWidgetConfig?.let { BasicText(it) }
                        config.fourthTextWidgetConfig?.let { BasicText(it) }
                    }
                }
            }
        }
    }
}