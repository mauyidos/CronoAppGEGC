package com.mexiti.cronoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mexiti.cronoapp.navigation.NavManager
import com.mexiti.cronoapp.ui.theme.CronoAppTheme
import com.mexiti.cronoapp.viewModel.CronometroViewModel
import com.mexiti.cronoapp.viewModel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cronometroViewModel: CronometroViewModel by viewModels()
        val dataViewModel: DataViewModel by viewModels()
        setContent {
                NavManager(cronometroViewModel, dataViewModel)
        }
    }
}

