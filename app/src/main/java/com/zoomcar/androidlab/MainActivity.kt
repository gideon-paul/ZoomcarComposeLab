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
                handleWhatsapp(context, "917483785428", message)
            }
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
            text = "Zalo",
            fullWidth = true,
            onClick = {
                handleZello(context, message)
            }
        )
    }
}

/**
 * Send message to a phone number on Whatsapp. It appears that the phone number need not be saved
 * in the user contacts for this to work.
 *
 * @param context Context object.
 * @param phoneNumber Must be a valid phone number with country code. The number can be preceded by
 * a plus sign. though that's not a requirement.
 * @param message Message to be sent to the user.
 */
fun handleWhatsapp(context: Context, phoneNumber: String, message: String) {
    val uri = Uri.parse("whatsapp://send?phone=$phoneNumber&text=$message")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.putExtra(Intent.EXTRA_TEXT, message)
    context.startActivity(intent)
}

/**
 * Looks like Facebook allows only sharing an url, not text.
 *
 * See https://stackoverflow.com/a/14496338/3376001
 *
 */
fun handleFacebook(context: Context, message: String) {
    try {
        val intent = Intent()
        intent.apply {
            `package` = "com.facebook.katana"
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, message)
            context.startActivity(intent)
        }
    } catch (e: Exception) {
//        val sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=$message"
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl))
//        context.startActivity(intent)
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

fun handleZello(context: Context, message: String) {
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

@Preview(showBackground = true)
@Composable
fun PreviewSocialMediaIntentsTester() {
    SocialMediaIntentsTester()
}
