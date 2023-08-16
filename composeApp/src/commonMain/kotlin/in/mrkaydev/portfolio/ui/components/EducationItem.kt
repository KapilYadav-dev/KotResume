package `in`.mrkaydev.portfolio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.mrkaydev.portfolio.ui.screens.font
import `in`.mrkaydev.portfolio.ui.screens.fontStyle
import `in`.mrkaydev.portfolio.ui.screens.getOutlineTextFieldColors

@Composable
fun EducationItem(
    education: EducationData,
    onEducationChange: (EducationData) -> Unit
) {
    Column {
        OutlinedTextField(
            value = education.schoolName,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onEducationChange(education.copy(schoolName = it)) },
            label = { Text("School/College Name", fontFamily = font) },
            colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = education.place,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onEducationChange(education.copy(place = it)) },
            label = { Text("Place", fontFamily = font) }, colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = education.marks,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onEducationChange(education.copy(marks = it)) },
            label = { Text("Marks", fontFamily = font) }, colors = getOutlineTextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = education.time,
            textStyle = fontStyle,
            modifier = Modifier.fillMaxSize(),
            onValueChange = { onEducationChange(education.copy(time = it)) },
            label = { Text("Time", fontFamily = font) }, colors = getOutlineTextFieldColors()
        )
    }
}

data class EducationData(
    val schoolName: String,
    val place: String,
    val marks: String,
    val time: String
) {
    fun isFilled(): Boolean {
        return schoolName.isNotEmpty() && marks.isNotEmpty()
    }
}