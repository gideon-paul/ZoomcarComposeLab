package com.zoomcar.androidlab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zoomcar.zuikit.appbar.ZAppBar
import com.zoomcar.zuikit.appbar.base.ZAppBarNavigationIcon
import com.zoomcar.zuikit.dimensions.ZDimension
import com.zoomcar.zuikit.label.ZLabel
import com.zoomcar.zuikit.typography.ZTypography

/**
 * ContactsListScreen.
 *
 * @param modifier [Modifier] object.
 * @param finish Function to call when navigation icon is pressed.
 * @param contacts List of contacts to be displayed.
 *
 * @author Gideon Paul
 */
@Composable
fun ContactsListScreen(
    modifier: Modifier = Modifier,
    finish: () -> Unit = {},
    contacts: List<Contact>,
) {
    Scaffold(
        topBar = {
            ZAppBar(
                title = "Whatsapp Contacts",
                navigationIcon = ZAppBarNavigationIcon.CLOSE,
                onNavigationIconClicked = {
                    finish()
                }
            )
        }
    ) {
        LazyColumn(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            contacts.forEach { contact ->
                item {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = ZDimension.D8.dp,
                                horizontal = ZDimension.D8.dp
                            ),
                        elevation = ZDimension.D2.dp
                    ) {
                        Column(modifier = Modifier.padding(all = ZDimension.D8.dp)) {
                            ZLabel(
                                text = contact.name,
                                style = ZTypography.BODY2
                            )

                            ZLabel(
                                text = contact.number,
                                style = ZTypography.CAPTION
                            )
                        }
                    }
                }
            }
        }
    }
}
