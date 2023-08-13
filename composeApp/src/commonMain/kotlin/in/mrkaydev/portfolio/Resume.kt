package `in`.mrkaydev.portfolio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Resume() {
    Column(
        modifier = Modifier.fillMaxSize().padding(
            horizontal = 32.dp, vertical = 24.dp
        )
    ) {
        Text("hello", fontSize = 25.sp, fontFamily = FontLoader.Mons, fontWeight = FontWeight.Normal)

    }
}