package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.errortracker.data.Record
import java.util.UUID

@Composable
fun ListItem(
    errorRecord: Record,
    removeErrorCode: (id: UUID) -> Unit,
) {
    val defaultFontSize = 16.sp
    val fontWeight = FontWeight.Medium
    val descriptionFontSize = 10.sp
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(3.dp),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row {
                Column(
                    modifier = Modifier.fillMaxWidth(.75f)
                ) {
                    Text(
                        text = errorRecord.content,
                        fontSize = defaultFontSize,
                        fontWeight = fontWeight
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = errorRecord.date.toLocalTime().toString().substring(0, 8),
                        fontSize = defaultFontSize,
                        fontWeight = fontWeight,
                    )
                }
            }



            Row {
                Box(
                    modifier = Modifier.weight(.25f)
                ) {
                    Text(text = errorRecord.description, fontSize = descriptionFontSize)
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Column (
                    modifier = Modifier.weight(.75f)
                ) {
                    FlowRow(
                        modifier = Modifier.wrapContentSize(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        for (tag in errorRecord.tags) {
                            Column {
                                AssistChip(
                                    modifier = Modifier.height(32.dp),
                                    onClick = { },
                                    label = { Text(text = "#${tag}") },


                                    )
                            }
                        }
                    }
                }
                Column (
                    modifier = Modifier.weight(.25f)
                ){
                    FilledIconButton(
                        onClick = {
                            removeErrorCode(errorRecord.id)
                        },
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Delete")
                    }
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
                errorRecord = Record(
                    "OP10.1", "Siłownik Z10.2", listOf("OP30.3", "OP10.1")
                ), removeErrorCode = { })
        }
    }