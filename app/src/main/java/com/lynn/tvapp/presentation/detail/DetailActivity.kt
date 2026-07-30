package com.lynn.tvapp.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lynn.tvapp.presentation.detail.ui.theme.TVAppTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("id", 0)
        setContent {
            TVAppTheme {
                DetailScreen(id = id)
            }
        }
    }
}
