package com.chaeseong.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.chaeseong.mysolelife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

	private lateinit var auth: FirebaseAuth

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

		auth = FirebaseAuth.getInstance()

		if(auth.currentUser?.uid == null){
			Log.d("SplashActivity","null")

			Handler().postDelayed({
				startActivity(Intent(this, IntroActivity::class.java))
				finish()
			},3000)
		}else{
			Log.d("SplashActivity","not null")

			Handler().postDelayed({
				startActivity(Intent(this, MainActivity::class.java))
				finish()
			},3000)
		}

//		Handler().postDelayed({
//			startActivity(Intent(this, IntroActivity::class.java))
//			finish()
//		},3000)
	}
}