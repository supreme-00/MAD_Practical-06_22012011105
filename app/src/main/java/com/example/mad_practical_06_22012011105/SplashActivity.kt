package com.example.mad_practical_06_22012011105

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var GuniAnimation:AnimationDrawable
    lateinit var tweenAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val uvpce_imageView = findViewById<ImageView>(R.id.uvpce_imageView)
        uvpce_imageView.setBackgroundResource(R.drawable.uvpce_animation_list)
        GuniAnimation = uvpce_imageView.background as AnimationDrawable
        tweenAnimation = AnimationUtils.loadAnimation(this ,R.anim.tween)
        tweenAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            GuniAnimation.start()
            findViewById<ImageView>(R.id.uvpce_imageView).startAnimation(tweenAnimation)
        }
        else{
            GuniAnimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also{startActivity(it)}

    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}