package com.zoomcar.androidlab

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val contactsListFlow = MutableStateFlow<List<Contact>>(mutableListOf())

    private val contactsPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { permissionGranted ->
            if (permissionGranted) {
                fetchAndUpdateWhatsappContactsList()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val contacts = contactsListFlow.collectAsState()
            ContactsListScreen(
                modifier = Modifier,
                contacts = contacts.value,
                finish = {
                    finish()
                }
            )
        }

        if (!hasPermissionToReadContacts()) {
            contactsPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
        } else {
            fetchAndUpdateWhatsappContactsList()
        }
    }

    /**
     * A simple wrapper function to hide the complexity fo checking contacts permission.
     */
    private fun hasPermissionToReadContacts(): Boolean {
        return this.applicationContext.checkSelfPermission(Manifest.permission.READ_CONTACTS) ==
                PackageManager.PERMISSION_GRANTED
    }

    /**
     * Queries the content resolver for contacts list and the updates the state flow of contacts.
     */
    private fun fetchAndUpdateWhatsappContactsList() {
        lifecycleScope.launch(Dispatchers.IO) {
            val contacts = getWhatsappContacts()
            contactsListFlow.emit(contacts)
            Log.e("MainActivity", contacts.toString())
        }
    }

    /**
     * In this code snippet, we are using the contentResolver to query the phone's contacts,
     * passing in the URI for the WhatsApp content, and a selection criteria that filters only
     * contacts that have WhatsApp profile.
     *
     * The query() method takes 5 parameters :
     * 1. URI of the content provider
     * 2. array of columns that you want to retrieve
     * 3. selection criteria
     * 4. selection arguments
     * 5. sort order
     *
     * We use the column ContactsContract.Data.DISPLAY_NAME to get the contact name
     * and ContactsContract.Data.DISPLAY_NAME to get the WhatsApp number.
     */
    private fun getWhatsappContacts(): List<Contact> {
        val contentResolver = this.contentResolver
        val cursor = contentResolver.query(
            ContactsContract.Data.CONTENT_URI,
            arrayOf(ContactsContract.Data.DISPLAY_NAME, ContactsContract.Data.DATA1),
            "mimetype=?",
            arrayOf("vnd.android.cursor.item/vnd.com.whatsapp.profile"),
            null
        )
        val contacts = mutableListOf<Contact>()

        if (cursor != null && cursor.count > 0) {
            while (cursor.moveToNext()) {
                val name = cursor.getString(0)
                val number = cursor.getString(1)
                contacts.add(Contact(name, number))
            }
        }

        cursor?.close()
        return contacts
    }
}
