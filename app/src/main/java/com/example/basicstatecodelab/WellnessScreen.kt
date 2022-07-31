package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/*
ViewModels are recommended to be used at screen-level composables,
that is, close to a root composable called from an activity, fragment, or destination of a Navigation graph.
ViewModels should never be passed down to other composables,
instead you should pass only the data they need and functions that perform the required logic as parameters.
 */
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            //onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) })
            onCheckedTask = {index -> wellnessViewModel.changeTest(index)})
    }
}


@Preview
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}