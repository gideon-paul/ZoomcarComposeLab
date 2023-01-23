package com.zoomcar.androidlab

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri

/**
 * SocialMediaHelper
 *
 * @param application [Application] object.
 *
 * @author Gideon Paul
 */
class SocialMediaHelper(
    private val application: Application
) {
    /**
     * Send message to a phone number on Whatsapp. It appears that the phone number need not be saved
     * in the user contacts for this to work.  If no phone number is specified, this function will open
     * Whatsapp with list of contacts and the user should choose whom to send the message. For invalid
     * or incomplete phone numbers, Whatsapp will display error dialogs accordingly.
     *
     * @param message Message to be sent to the user.
     * @param phoneNumber Must be a valid phone number with country code. The number can be preceded by
     * a plus sign. though that's not a requirement.
     */
    fun sendMessageViaWhatsapp(
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
        application.startActivity(intent)
    }

    /**
     * Looks like Facebook allows only sharing an url, not text. The user has to manually type in the
     * text to be posted.
     *
     * See https://stackoverflow.com/a/14496338/3376001
     *
     * @param url Url to be posted.
     */
    fun postToFacebook(url: String) {
        val intent = Intent()
        intent.apply {
            `package` = "com.facebook.katana"
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, url)
            application.startActivity(intent)
        }
    }

    /**
     * This will open the facebook messenger with list of all user contacts. The user has to manually
     * choose the contacts to send message.
     *
     * @param message Message to be sent.
     */
    fun sendMessageViaFacebookMessenger(
        message: String
    ) {
        val intent = Intent()
        intent.apply {
            `package` = "com.facebook.orca"
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        application.startActivity(intent)
    }

    fun handleViber(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.apply {
            setPackage("com.viber.voip")
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, message)
        }

        try {
            application.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            // "Please Install Facebook Messenger"
        }
    }

    /**
     * Tweets a given message via twitter app.
     *
     * @param tweet Tweet to be sent out. Be mindful of the character limit.
     */
    fun tweetToTwitter(tweet: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data =
            Uri.parse("https://twitter.com/intent/tweet?text=$tweet")
        application.startActivity(intent)
    }

    fun handleZalo(message: String) {
        val intent = Intent()
        intent.apply {
            `package` = "com.twitter.android"
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }

        try {
            application.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            // TODO: Handle failure
        }
    }
}
