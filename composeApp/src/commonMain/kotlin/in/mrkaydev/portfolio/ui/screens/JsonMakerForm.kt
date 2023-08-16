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
    var name by remember { mutableStateOf("") }
    var githubUrl by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var links by remember { mutableStateOf("") }
    var languages by remember { mutableStateOf("") }
    var tools by remember { mutableStateOf("") }
    var technologies by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    var educationList by remember { mutableStateOf(listOf(EducationData("", "", "", ""))) }
    var experienceList by remember {
        mutableStateOf(
            listOf(
                ExperienceData(
                    "",
                    "",
                    "",
                    listOf("")
                )
            )
        )
    }

    var projectList by remember { mutableStateOf(listOf(ProjectData("", listOf("")))) }

    var addEducationButtonEnabled by remember { mutableStateOf(false) }
    var addExperienceButtonEnabled by remember { mutableStateOf(false) }
    var addProjectButtonEnabled by remember { mutableStateOf(false) }
    var buttonSubmitEnabled by remember { mutableStateOf(false) }

    addProjectButtonEnabled = projectList.lastOrNull()?.isFilled() == true
    addEducationButtonEnabled = educationList.lastOrNull()?.isFilled() == true
    addExperienceButtonEnabled = experienceList.lastOrNull()?.isFilled() == true
    buttonSubmitEnabled = name.isNotEmpty()
            && email.isNotEmpty()
            && languages.isNotEmpty()
            && tools.isNotEmpty()
            && technologies.isNotEmpty()
            && educationList.isNotEmpty() && educationList[0].isFilled()
            && experienceList.isNotEmpty() && experienceList[0].isFilled()
            && projectList.isNotEmpty() && projectList[0].isFilled()


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
            value = name,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { name = it },
            label = { Text("Name", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { email = it },
            label = { Text("Email", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = mobile,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { mobile = it },
            label = { Text("Mobile", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = links,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { links = it },
            label = { Text("Links", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = githubUrl,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { githubUrl = it },
            label = { Text("Github Url", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = languages,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { languages = it },
            label = { Text("Programming languages (e.g Python, Java, C++)", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = technologies,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { technologies = it },
            label = { Text("Technologies (e.g. CI/CD, IOT etc)", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = tools,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { tools = it },
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
        educationList.forEachIndexed { index, education ->
            EducationItem(
                education = education,
                onEducationChange = { newEducation ->
                    educationList = educationList.toMutableList().also {
                        it[index] = newEducation
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(
            onClick = { educationList = educationList + EducationData("", "", "", "") },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = addEducationButtonEnabled
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
        experienceList.forEachIndexed { index, experience ->
            ExperienceItem(
                experience = experience,
                onExperienceChange = { newExperience ->
                    experienceList = experienceList.toMutableList().also {
                        it[index] = newExperience
                    }
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(
            onClick = { experienceList = experienceList + ExperienceData("", "", "", listOf("")) },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = addExperienceButtonEnabled
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
        projectList.forEachIndexed { index, project ->
            ProjectItem(
                project = project,
                onProjectChange = { newProject ->
                    projectList = projectList.toMutableList().also {
                        it[index] = newProject
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = { projectList = projectList + ProjectData("", listOf()) },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.5f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = addProjectButtonEnabled
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
                makeJson()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(1f)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xff4169e1)
            ),
            enabled = buttonSubmitEnabled
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

fun makeJson() {

}