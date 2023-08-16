package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.ui.screens.font
import `in`.mrkaydev.portfolio.ui.screens.fontStyle
import `in`.mrkaydev.portfolio.ui.screens.getOutlineTextFieldColors


@Composable
fun ExperienceItem(
    experience: ExperienceData,
    onExperienceChange: (ExperienceData) -> Unit
) {
    Column {
        OutlinedTextField(
            value = experience.companyName,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onExperienceChange(experience.copy(companyName = it)) },
            label = { Text("Company Name", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = experience.position,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onExperienceChange(experience.copy(position = it)) },
            label = { Text("Position", fontFamily = font) }, colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = experience.time,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onExperienceChange(experience.copy(time = it)) },
            label = { Text("Time", fontFamily = font) }, colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        experience.responsibilities.forEachIndexed { index, responsibility ->
            OutlinedTextField(
                value = responsibility,
                textStyle = fontStyle,
                modifier = Modifier.fillMaxSize(),
                onValueChange = { newResponsibility ->
                    onExperienceChange(
                        experience.copy(
                            responsibilities = experience.responsibilities.toMutableList().also {
                                it[index] = newResponsibility
                            }
                        )
                    )
                },
                label = { Text("Responsibility", fontFamily = font) },
                colors = getOutlineTextFieldColors()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                onExperienceChange(
                    experience.copy(
                        responsibilities = experience.responsibilities + ""
                    )
                )
            },
            enabled = experience.responsibilities.lastOrNull()?.isNotEmpty() == true,
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            )
        ) {
            Text(
                "Add More Responsibility",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

data class ExperienceData(
    val companyName: String,
    val position: String,
    val time: String,
    val responsibilities: List<String>
) {
    fun isFilled(): Boolean {
        return companyName.isNotEmpty() && position.isNotEmpty() && time.isNotEmpty()
    }
}
