package com.furkanmulayim.birikio.feature.screen_profile.ui.screen

import CustomIconButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.feature.screen_profile.ui.component.AccessibilityContent
import com.furkanmulayim.birikio.feature.screen_profile.ui.component.DeleteContent
import com.furkanmulayim.birikio.feature.screen_profile.ui.component.GeneralCard
import com.furkanmulayim.birikio.feature.screen_profile.ui.component.HelpContent
import com.furkanmulayim.birikio.feature.screen_profile.ui.component.ProfileCard

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(top = Appsize.padding64)
    ) {

        AppBarSection(
            onBackClick = { navController.popBackStack() })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(colorScheme.surface)
                .padding(vertical = Appsize.padding12, horizontal = Appsize.padding20)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    focusManager.clearFocus()
                }) {
            ProfileSection()
            AccessibilitySection(onClickLanguage = {}, onClickPassword = {})
            HelpSection(onClickDeveloper = {}, onClickShareApp = {}, onClickPrivacy = {})
            DeleteSection(onClickDeleteData = {}, onClickForgotPass = {})
            CopyrightSection()
        }
    }
}

@Composable
private fun AppBarSection(onBackClick: () -> Unit) {
    CustomSpacerHeight(Appsize.padding8)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding20),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        CustomIconButton(
            R.drawable.back_button,
            color = colorScheme.surface,
            onClick = onBackClick
        )

        Text(
            modifier = Modifier.padding(top = Appsize.size3, start = Appsize.padding8),
            text = stringResource(R.string.nameProfie), style = Typo.font_30_w700
        )
    }
    CustomSpacerHeight(Appsize.padding12)
}

@Composable // Profile
private fun ProfileSection() {
    ProfileCard(
        title = "Furkan Mülayim",
        subtitle = "Katılım Tarihi 01.01.1111",
        iconResId = R.drawable.profile,
        onProfileClick = { })
}

@Composable // Password - Language
private fun AccessibilitySection(
    onClickPassword: () -> Unit,
    onClickLanguage: () -> Unit,
) {
    GeneralCard(
        view = {
            AccessibilityContent(onClickPassword, onClickLanguage)
        })
}

@Composable // Developer - Share App - Privacy
private fun HelpSection(
    onClickDeveloper: () -> Unit,
    onClickShareApp: () -> Unit,
    onClickPrivacy: () -> Unit,
) {
    GeneralCard(view = {
        HelpContent(onClickDeveloper, onClickShareApp, onClickPrivacy)
    })
}

@Composable // Forgot Password - Delete Data
private fun DeleteSection(
    onClickForgotPass: () -> Unit,
    onClickDeleteData: () -> Unit,
) {
    GeneralCard(view = {
        DeleteContent(onClickForgotPass, onClickDeleteData)
    })
}

@Composable
private fun CopyrightSection(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Appsize.padding20),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Copyright",
            style = Typo.font_12_w500.copy(
                textAlign = TextAlign.Center
            ),
        )
    }
}
