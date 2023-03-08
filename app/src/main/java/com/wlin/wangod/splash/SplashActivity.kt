package com.wlin.wangod.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.wlin.wangod.HomeActivity
import com.wlin.wangod.R
import com.wlin.wangod.ui.theme.WanGodTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    private var mainHandler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanGodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Welcome()
                }
            }
        }
        mainHandler = Handler(mainLooper)
        enterHomeScreen()
    }

    private fun enterHomeScreen() {
        mainHandler?.postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, 3000L)
    }

    @Preview(name = "Dark Mode")
    @Composable
    private fun Welcome() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "welcome to wan god",
                modifier = Modifier
                    .size(Dp(45f))
                    .clip(CircleShape)
                    .border(Dp(1f), Color.Red, CircleShape)
            )
            Spacer(modifier = Modifier.size(Dp(12f)))
            Text(text = "Welcome to wan god", modifier = Modifier.clickable {
                Toast.makeText(this@SplashActivity, "Enter home screen", Toast.LENGTH_SHORT).show()
                enterHomeScreen()
            })
        }
    }
}