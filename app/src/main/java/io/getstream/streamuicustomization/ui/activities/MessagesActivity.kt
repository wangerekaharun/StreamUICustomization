package io.getstream.streamuicustomization.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import io.getstream.chat.android.compose.ui.messages.MessagesScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.compose.ui.theme.StreamColors
import io.getstream.streamuicustomization.ui.theme.CustomLightStreamColors
import io.getstream.streamuicustomization.ui.theme.CustomStreamShapes
import io.getstream.streamuicustomization.ui.theme.StreamCustomTypography

class MessagesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val channelId = intent.getStringExtra(KEY_CHANNEL_ID) ?: return
        setContent {
            ChatTheme(
                shapes = CustomStreamShapes,
                colors = if (isSystemInDarkTheme()) StreamColors.defaultDarkColors() else CustomLightStreamColors,
                typography = StreamCustomTypography
            ) {
                MessagesScreen(
                    channelId = channelId,
                    messageLimit = 30,
                    onBackPressed = { finish() },
                    onHeaderActionClick = {}
                )
            }
        }
    }

    companion object {
        private const val KEY_CHANNEL_ID = "channelId"

        fun getIntent(context: Context, channelId: String): Intent {
            return Intent(context, MessagesActivity::class.java).apply {
                putExtra(KEY_CHANNEL_ID, channelId)
            }
        }
    }
}