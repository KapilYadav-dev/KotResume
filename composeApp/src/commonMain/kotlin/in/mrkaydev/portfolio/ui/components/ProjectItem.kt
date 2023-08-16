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
fun ProjectItem(
    project: ProjectData,
    onProjectChange: (ProjectData) -> Unit
) {
    Column {
        OutlinedTextField(
            value = project.projectName,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onProjectChange(project.copy(projectName = it)) },
            label = { Text("Project Name", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        project.projectDetails.forEachIndexed { index, projectDetail ->
            OutlinedTextField(
                value = projectDetail,
                textStyle = fontStyle,
                modifier = Modifier.fillMaxSize(),
                onValueChange = { newDetail ->
                    onProjectChange(
                        project.copy(
                            projectDetails = project.projectDetails.toMutableList().also {
                                it[index] = newDetail
                            }
                        )
                    )
                },
                label = { Text("Project Detail", fontFamily = font) },
                colors = getOutlineTextFieldColors()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                onProjectChange(
                    project.copy(
                        projectDetails = project.projectDetails + ""
                    )
                )
            },
            enabled = project.projectDetails.lastOrNull()?.isNotEmpty() == true,
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            )
        ) {
            Text(
                "Add More Detail",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

data class ProjectData(
    val projectName: String,
    val projectDetails: List<String>
) {
    fun isFilled(): Boolean {
        return projectName.isNotEmpty()
    }
}