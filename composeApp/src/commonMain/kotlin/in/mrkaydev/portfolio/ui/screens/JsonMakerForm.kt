package `in`.mrkaydev.portfolio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import `in`.mrkaydev.portfolio.ui.ViewModel
import `in`.mrkaydev.portfolio.ui.components.*
import `in`.mrkaydev.portfolio.utils.FontLoader

val font = FontLoader.Montserrat
val fontStyle = TextStyle(fontFamily = font)

@Composable
fun getOutlineTextFieldColors() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color(0xff4169e1),
    unfocusedBorderColor = Color.Gray
)

@Composable
fun JsonMakerForm() {
    val viewModel = getViewModel(Unit, viewModelFactory { ViewModel() })
    val scrollState = rememberScrollState()

    viewModel.addProjectButtonEnabled = viewModel.projectList.lastOrNull()?.isFilled() == true
    viewModel.addEducationButtonEnabled = viewModel.educationList.lastOrNull()?.isFilled() == true
    viewModel.addExperienceButtonEnabled = viewModel.experienceList.lastOrNull()?.isFilled() == true
    viewModel.buttonSubmitEnabled = viewModel.name.isNotEmpty()
            && viewModel.email.isNotEmpty()
            && viewModel.languages.isNotEmpty()
            && viewModel.tools.isNotEmpty()
            && viewModel.technologies.isNotEmpty()
            && viewModel.educationList.isNotEmpty() && viewModel.educationList[0].isFilled()
            && viewModel.experienceList.isNotEmpty() && viewModel.experienceList[0].isFilled()
            && viewModel.projectList.isNotEmpty() && viewModel.projectList[0].isFilled()

    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .padding(24.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(
            "Basic Information:",
            fontFamily = font,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )
        OutlinedTextField(
            value = viewModel.name,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.name = it },
            label = { Text("Name", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.email,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.email = it },
            label = { Text("Email", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.mobile,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.mobile = it },
            label = { Text("Mobile", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.links,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.links = it },
            label = { Text("Links", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.resumeUrl,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.resumeUrl = it },
            label = { Text("Resume URL", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.githubUrl,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.githubUrl = it },
            label = { Text("Github Url", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.languages,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.languages = it },
            label = { Text("Programming languages (e.g Python, Java, C++)", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.technologies,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.technologies = it },
            label = { Text("Technologies (e.g. CI/CD, IOT etc)", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.tools,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { viewModel.tools = it },
            label = {
                Text(
                    "Frameworks and tools (e.g. KMP, Android, Android Studio)",
                    fontFamily = font
                )
            },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Education:", fontFamily = font, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        viewModel.educationList.forEachIndexed { index, education ->
            EducationItem(
                education = education,
                onEducationChange = { newEducation ->
                    viewModel.educationList = viewModel.educationList.toMutableList().also {
                        it[index] = newEducation
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(
            onClick = { viewModel.educationList = viewModel.educationList + EducationData("", "", "", "") },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = viewModel.addEducationButtonEnabled
        ) {
            Text(
                "Add More Education",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Experience:", fontFamily = font, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        viewModel.experienceList.forEachIndexed { index, experience ->
            ExperienceItem(
                experience = experience,
                onExperienceChange = { newExperience ->
                    viewModel.experienceList = viewModel.experienceList.toMutableList().also {
                        it[index] = newExperience
                    }
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(
            onClick = { viewModel.experienceList = viewModel.experienceList + ExperienceData("", "", "", "",listOf("")) },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = viewModel.addExperienceButtonEnabled
        ) {
            Text(
                "Add More Experience",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Text("Project:", fontFamily = font, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        viewModel.projectList.forEachIndexed { index, project ->
            ProjectItem(
                project = project,
                onProjectChange = { newProject ->
                    viewModel.projectList = viewModel.projectList.toMutableList().also {
                        it[index] = newProject
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = { viewModel.projectList = viewModel.projectList + ProjectData("", listOf()) },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = viewModel.addProjectButtonEnabled
        ) {
            Text(
                "Add More Project",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.height(40.dp))
        Button(
            onClick = {
                viewModel.makeJson()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(1f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = viewModel.buttonSubmitEnabled
        ) {
            Text(
                "Make Resume Json",
                fontFamily = font,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}