package com.zakdroid.candysuharnica.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zakdroid.candysuharnica.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.imgViewLogo.alpha = 0f
        binding.imgViewLogo.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }*/
    }
}