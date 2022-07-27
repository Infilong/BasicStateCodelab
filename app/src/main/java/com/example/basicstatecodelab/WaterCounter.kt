package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        //UI won't recompose
//        var count = 0
//        Text(text = "You've had $count glasses.")
//        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
//            Text("Add One")
//        }

        //For this we can use the remember composable inline function.
        // A value calculated by remember is stored in the Composition during the initial composition,
        // and the stored value is kept across recompositions.
//        val count: MutableState<Int> = remember {
//            mutableStateOf(0)
//        }
//        Text("You've had ${count.value} glasses")
//        Button(onClick = { count.value++ }, Modifier.padding(8.dp)) {
//            Text(text = "Add one")
//        }

        /*
        You can use the by keyword to define count as a var.
        Adding the delegate's getter and setter imports lets us read and mutate count indirectly
        without explicitly referring to the MutableState's value property every time.
         */
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            var showTask by remember {
                mutableStateOf(true)
            }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false })
            }
            Text("You've had $count glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }
        }


    }
}