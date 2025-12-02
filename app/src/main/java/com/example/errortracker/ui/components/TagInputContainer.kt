package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.errortracker.ui.theme.AppTheme

@Preview(showBackground = true)
@Composable
fun TagInputContainerPreview(){
    val tags = listOf<String>("Op30.3","Op30.1","Op30.2","Op30.4","R06","R05")
    var actualTags = remember { mutableStateListOf<String>() }
    AppTheme {
        TagInputContainerContent(
            tags = tags,
            actualTags = actualTags,
            onPressOutside = { }
        )
    }
}


@Composable
fun TagInputContainer(
    tags: List<String>,
    actualTags: MutableList<String>,
    onPress: () -> Unit
) {
    TagInputContainerContent(
        tags = tags,
        actualTags = actualTags,
        onPressOutside = onPress
    )
}

@Composable
fun TagInputContainerContent(
    tags: List<String>,
    actualTags: MutableList<String>,
    onPressOutside: () -> Unit
) {
    fun onPress(tag: String){
        if(actualTags.indexOf(tag) >=0){
            actualTags.remove(tag)
        }
        else{
            actualTags.add(tag)
        }
        onPressOutside()
    }
    FlowRow(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        for(tag in tags){
            val isSelected = actualTags.indexOf(tag) >= 0
            Column() {
                FilterChip(
                    selected = isSelected,
                    onClick = { onPress(tag) },
                    label = { Text(text=tag)},
                    leadingIcon = if (isSelected) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
        }
    }
}