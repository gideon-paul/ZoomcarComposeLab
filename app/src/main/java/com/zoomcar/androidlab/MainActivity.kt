package com.zoomcar.androidlab

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zoomcar.zuikit.dimensions.ZDimension
import com.zoomcar.zuikit.label.ZLabel
import com.zoomcar.zuikit.typography.ZTypography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hello()
        }
    }
}

@Composable
fun Hello() {
    Column(modifier = Modifier.fillMaxSize().padding(ZDimension.D16.dp)) {
        ZLabel(text = "Hello Zoomer", style = ZTypography.H3)
        ZLabel(text = "Experiment Away", style = ZTypography.BODY2)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHello() {
    Hello()
}
