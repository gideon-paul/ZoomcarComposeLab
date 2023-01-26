package com.zoomcar.androidlab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.zoomcar.zuikit.ZColor
import com.zoomcar.zuikit.appbar.ZAppBar
import com.zoomcar.zuikit.button.ZButton
import com.zoomcar.zuikit.dimensions.ZDimension
import com.zoomcar.zuikit.label.ZLabel
import com.zoomcar.zuikit.label.ZLabelColor
import com.zoomcar.zuikit.typography.ZTypography

@Composable
fun ReferAndEarnScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ZAppBar(
                title = "Refer and Earn",
                onNavigationIconClicked = {
                    // TODO: Handle this
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                item {
                    ZLabel(
                        modifier = Modifier
                            .padding(horizontal = ZDimension.D16.dp)
                            .padding(top = ZDimension.D24.dp),
                        text = "Refer your friends to Zoomcar and earn benefits and discounts!",
                        style = ZTypography.TITLE1
                    )
                }

                item {
                    ZLabel(
                        modifier = Modifier
                            .padding(horizontal = ZDimension.D16.dp)
                            .padding(top = ZDimension.D12.dp),
                        text = "How it works?",
                        style = ZTypography.TITLE1
                    )
                }

                item {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = ZDimension.D16.dp)
                            .padding(top = ZDimension.D20.dp)
                    ) {
                        Step(
                            text = "Refer your friends to zoomcar",
                            modifier = Modifier
                        )

                        Step(
                            text = "Your friend downloads the app & logs in using your link",
                            modifier = Modifier
                        )

                        Step(
                            text = "You both get paid when your friend books a ride!",
                            modifier = Modifier
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = ZDimension.D16.dp)
                            .padding(top = ZDimension.D44.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ZLabel(
                            text = "Referral Benefits",
                            style = ZTypography.TITLE1
                        )

                        ZLabel(
                            text = "Learn More",
                            style = ZTypography.CAPTION,
                            color = ZLabelColor.ACCENT
                        )
                    }
                }
            }

            ZButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(ZDimension.D16.dp),
                text = "log in now to refer!".toUpperCase(Locale.current),
                fullWidth = true,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview
@Composable
fun PreviewReferAndEarnScreen() {
    ReferAndEarnScreen()
}

@Composable
fun Step(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(end = ZDimension.D8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(ZDimension.D1.dp)
                    .height(ZDimension.D8.dp)
                    .background(ZColor.EVER_GREEN_06.color)
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(ZDimension.D8.dp)
                    .background(ZColor.EVER_GREEN_06.color)
            )

            Box(
                modifier = Modifier
                    .width(ZDimension.D1.dp)
                    .fillMaxHeight()
                    .background(ZColor.EVER_GREEN_06.color)
            )
        }


        ZLabel(
            text = text,
            style = ZTypography.BODY2,
            modifier = Modifier.padding(bottom = ZDimension.D20.dp)
        )
    }
}

@Composable
fun ReferralBenefitComponent() {

}