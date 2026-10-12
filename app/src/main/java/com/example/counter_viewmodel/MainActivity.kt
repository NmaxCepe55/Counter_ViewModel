package com.example.counter_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counter_viewmodel.ui.theme.Counter_ViewModelTheme
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CounterScreen(viewModel)
        }
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel) {

    val counter by viewModel.counter.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Andhika Gusti Al-Fahrezi"
        )

        Text(
            text = "NIM: 245150400111061"
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = counter.toString()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Button(
                onClick = {
                    viewModel.decrement()
                }
            ) {
                Text("Down")
            }

            Button(
                onClick = {
                    viewModel.reset()
                }
            ) {
                Text("Reset")
            }

            Button(
                onClick = {
                    viewModel.increment()
                }
            ) {
                Text("Up")
            }
        }
    }
}