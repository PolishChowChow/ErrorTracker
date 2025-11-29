package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.errortracker.data.ErrorCode
import java.util.UUID

@Composable
fun ListItem(
    errorRecord: ErrorCode,
    removeErrorCode: (id: UUID) -> Unit,
) {
    val defaultFontSize = 16.sp
    val fontWeight = FontWeight.Medium
    val descriptionFontSize = 10.sp
    Card(
        shape = MaterialTheme.shapes.medium, elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(.8f)
            ) {
                Row {
                    Box(
                        modifier = Modifier.weight(.1f)
                    ) {
                        Text(text = "3:12", fontSize = defaultFontSize, fontWeight = fontWeight)
                    }
                    Box(
                        modifier = Modifier.weight(.15f)
                    ) {
                        Text(
                            text = errorRecord.operation.uppercase(),
                            fontSize = defaultFontSize,
                            fontWeight = fontWeight
                        )
                    }
                    Box(
                        modifier = Modifier.weight(.4f)
                    ) {
                        Text(
                            text = errorRecord.structure.uppercase(),
                            fontSize = defaultFontSize,
                            fontWeight = fontWeight
                        )
                    }

                }
                Row {
                    Box(
                        modifier = Modifier.weight(.2f)
                    ) {
                        Text(text = errorRecord.errorValue, fontSize = descriptionFontSize)
                    }
                }
            }
            Column {
                FilledIconButton(
                    onClick = {
                        removeErrorCode(errorRecord.id)
                    }, shape = MaterialTheme.shapes.small, modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        modifier = Modifier,
                        contentDescription = "hol",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestListItem() {
    MaterialTheme {
        ListItem(
            errorRecord = ErrorCode("OP10.1", "Siłownik Z10.2", "Siłownik nie osiąga pozycji"),
            removeErrorCode = { }
        )
    }
}