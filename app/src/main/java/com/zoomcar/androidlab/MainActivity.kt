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
import com.zoomcar.zuikit.button.ZButton
import com.zoomcar.zuikit.dimensions.ZDimension
import com.zoomcar.zuikit.label.ZLabel
import com.zoomcar.zuikit.typography.ZTypography

class MainActivity : AppCompatActivity() {
    private val socialMediaHelper = SocialMediaHelper(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialMediaIntentsTester(socialMediaHelper)
        }
    }
}

@Composable
fun SocialMediaIntentsTester(socialMediaHelper: SocialMediaHelper) {
    val message =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel magna vel erat tincidunt tincidunt at fringilla leo. Nam sit amet magna eget orci pellentesque rhoncus. Cras pellentesque, tellus vitae gravida sodales, dolor enim euismod sem, nec dignissim arcu nibh ac libero. Cras tincidunt magna nec arcu condimentum, ut vehicula diam feugiat. Integer ac maximus ante, vitae cursus velit. Praesent viverra faucibus dictum. Aliquam quis nisi tortor. Phasellus ut auctor leo, id aliquam odio. https://www.zoomcar.com/"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = ZDimension.D16.dp),
        verticalArrangement = Arrangement.spacedBy(ZDimension.D16.dp)
    ) {
        ZLabel(
            text = "Social Media Links",
            style = ZTypography.H3
        )

        ZButton(
            text = "Whatsapp",
            fullWidth = true,
            onClick = {
                socialMediaHelper.sendMessageViaWhatsapp(null, message)
            }
        )

        ZButton(
            text = "Facebook",
            fullWidth = true,
            onClick = {
                socialMediaHelper.postToFacebook(message)
            }
        )

        ZButton(
            text = "Messenger",
            fullWidth = true,
            onClick = {
                socialMediaHelper.sendMessageViaFacebookMessenger(message)
            }
        )

        ZButton(
            text = "Viber",
            fullWidth = true,
            onClick = {
                socialMediaHelper.handleViber(message)
            }
        )

        ZButton(
            text = "Twitter",
            fullWidth = true,
            onClick = {
                socialMediaHelper.tweetToTwitter(message)
            }
        )

        ZButton(
            text = "Zalo",
            fullWidth = true,
            onClick = {
                socialMediaHelper.handleZalo(message)
            }
        )
    }
}
