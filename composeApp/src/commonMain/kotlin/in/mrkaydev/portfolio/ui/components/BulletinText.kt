package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.data.BulletinTextWidgetConfig

@Composable
fun BulletinText(config: BulletinTextWidgetConfig) {
    config.textConfigsList?.let {
        Column {
            it.forEach { item->
                if(item.text?.isNotBlank() ==true || item.text?.isNotEmpty()==true) {
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 32.dp)) {
                        Text(config.bulletinText)
                        Spacer(modifier = Modifier.width(16.dp))
                        BasicText(item)
                    }
                }
            }
        }
    }
}