package com.zoomcar.androidlab

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zoomcar.zuikit.button.ZButton
import com.zoomcar.zuikit.dimensions.ZDimension
import com.zoomcar.zuikit.label.ZLabel
import com.zoomcar.zuikit.typography.ZTypography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialMediaIntentsTester()
        }
    }
}

@Composable
fun SocialMediaIntentsTester() {
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(all = ZDimension.D16.dp),
        verticalArrangement = Arrangement.spacedBy(ZDimension.D16.dp)
    ) {
        ZLabel(
            text = "Social Media Intents",
            style = ZTypography.H3
        )

        ZButton(
            text= "Facebook",
            fullWidth = true,
            onClick = {

            }
        )

        ZButton(
            text= "Messenger",
            fullWidth = true,
            onClick = {

            }
        )

        ZButton(
            text= "Viber",
            fullWidth = true,
            onClick = {

            }
        )

        ZButton(
            text= "Twitter",
            fullWidth = true,
            onClick = {

            }
        )

        ZButton(
            text= "Zelo",
            fullWidth = true,
            onClick = {

            }
        )
    }
}

fun handleFacebook(message: String) {

}

fun handleMessenger(message: String) {

}

fun handleViber(message: String) {

}

fun handleTwitter(message: String) {

}

fun handleZelo(message: String) {

}

@Preview(showBackground = true)
@Composable
fun PreviewSocialMediaIntentsTester() {
    SocialMediaIntentsTester()
}
