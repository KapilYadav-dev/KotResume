package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import `in`.mrkaydev.portfolio.data.DividerWidgetConfig
import `in`.mrkaydev.portfolio.utils.Utils
import `in`.mrkaydev.portfolio.utils.Utils.toDp

@Composable
fun DividerWidget(config: DividerWidgetConfig) {
    config.apply {
        thickness?.let {
            Divider(
                modifier = Modifier
                    .padding(startPadding.toDp(),topPadding.toDp(),endPadding.toDp(), bottomPadding.toDp())
                    .fillMaxWidth(),
                color = Utils.getColorElseBlack(color).copy(alpha = colorAlpha),
                thickness = it.toDp()
            )

        }
    }
}