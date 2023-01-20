package com.zoomcar.androidlab

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    val title = "My message"
    val message =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel magna vel erat tincidunt tincidunt at fringilla leo. Nam sit amet magna eget orci pellentesque rhoncus. Cras pellentesque, tellus vitae gravida sodales, dolor enim euismod sem, nec dignissim arcu nibh ac libero. Cras tincidunt magna nec arcu condimentum, ut vehicula diam feugiat. Integer ac maximus ante, vitae cursus velit. Praesent viverra faucibus dictum. Aliquam quis nisi tortor. Phasellus ut auctor leo, id aliquam odio. "

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
            text = "Facebook",
            fullWidth = true,
            onClick = {
                handleFacebook(context, message)
            }
        )

        ZButton(
            text = "Messenger",
            fullWidth = true,
            onClick = {
                handleMessenger(context, message)
            }
        )

        ZButton(
            text = "Viber",
            fullWidth = true,
            onClick = {
                handleViber(context, message)
            }
        )

        ZButton(
            text = "Twitter",
            fullWidth = true,
            onClick = {
                handleTwitter(context, message)
            }
        )

        ZButton(
            text = "Zelo",
            fullWidth = true,
            onClick = {

            }
        )
    }
}

fun handleFacebook(context: Context, message: String) {
    try {
        val intent = Intent()
        intent.apply {
            `package` = "com.facebook.katana"
            action = "android.intent.action.SEND"
            type = "text/plain"
            putExtra("android.intent.extra.TEXT", message)
            context.startActivity(intent)
        }
    } catch (e: Exception) {
        val sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=$message"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl))
        context.startActivity(intent)
    }
}

fun handleMessenger(context: Context, message: String) {
    val intent = Intent()
    intent.apply {
        `package` = "com.facebook.orca"
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, message)
        type = "text/plain"
    }

    try {
        context.startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // "Please Install Facebook Messenger"
    }
}

fun handleViber(context: Context, message: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.apply {
        setPackage("com.viber.voip")
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }

    try {
        context.startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // "Please Install Facebook Messenger"
    }
}

fun handleTwitter(context: Context, message: String) {
    val intent = Intent()
    intent.apply {
        `package` = "com.twitter.android"
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, message)
        type = "text/plain"
    }

    try {
        context.startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // TODO: Handle failure
    }
}

fun handleZelo(message: String) {

}

@Preview(showBackground = true)
@Composable
fun PreviewSocialMediaIntentsTester() {
    SocialMediaIntentsTester()
}
