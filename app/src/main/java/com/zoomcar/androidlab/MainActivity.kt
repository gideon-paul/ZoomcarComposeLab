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
                sendMessageViaWhatsapp(context, null, message)
            }
        )

        ZButton(
            text = "Facebook",
            fullWidth = true,
            onClick = {
                postToFacebook(context, message)
            }
        )

        ZButton(
            text = "Messenger",
            fullWidth = true,
            onClick = {
                sendMessageViaFacebookMessenger(context, message)
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
                tweetToTwitter(context, message)
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
 * in the user contacts for this to work.  If no phone number is specified, this function will open
 * Whatsapp with list of contacts and the user should choose whom to send the message. For invalid
 * or incomplete phone numbers, Whatsapp will display error dialogs accordingly.
 *
 * @param context Context object.
 * @param message Message to be sent to the user.
 * @param phoneNumber Must be a valid phone number with country code. The number can be preceded by
 * a plus sign. though that's not a requirement.
 */
fun sendMessageViaWhatsapp(
    context: Context,
    phoneNumber: String?,
    message: String
) {
    val uri = Uri.parse(
        if (phoneNumber == null) {
            "whatsapp://send?text=$message"
        } else {
            "whatsapp://send?phone=$phoneNumber&text=$message"
        }
    )

    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.putExtra(Intent.EXTRA_TEXT, message)
    context.startActivity(intent)
}

/**
 * Looks like Facebook allows only sharing an url, not text. The user has to manually type in the
 * text to be posted.
 *
 * See https://stackoverflow.com/a/14496338/3376001
 *
 * @param context Context
 * @param url Url to be posted.
 */
fun postToFacebook(context: Context, url: String) {
    val intent = Intent()
    intent.apply {
        `package` = "com.facebook.katana"
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, url)
        context.startActivity(intent)
    }
}

/**
 * This will open the facebook messenger with list of all user contacts. The user has to manually
 * choose the contacts to send message.
 *
 * @param context Context
 * @param message Message to be sent.
 */
fun sendMessageViaFacebookMessenger(
    context: Context,
    message: String
) {
    val intent = Intent()
    intent.apply {
        `package` = "com.facebook.orca"
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, message)
        type = "text/plain"
    }
    context.startActivity(intent)
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

/**
 * Tweets a given message via twitter app.
 *
 * @param context Context
 * @param tweet Tweet to be sent out. Be mindful of the character limit.
 */
fun tweetToTwitter(context: Context, tweet: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data =
        Uri.parse("https://twitter.com/intent/tweet?text=$tweet")
    context.startActivity(intent)
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
