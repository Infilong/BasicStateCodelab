package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
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
        /*
        Use rememberSaveable to restore your UI state after an Activity or process is recreated.
        Besides retaining state across recompositions,
        rememberSaveable also retains state across Activity and process recreation.
         */

        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

/*
StatefulCounter owns the state. That means that it holds the count state
and modifies it when calling the StatelessCounter function.
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}
