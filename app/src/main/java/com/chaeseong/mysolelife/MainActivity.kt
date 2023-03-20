package com.chaeseong.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.chaeseong.mysolelife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

	private lateinit var auth: FirebaseAuth

	override fun onCreate(savedInstanceState: Bundle?) {

		auth = FirebaseAuth.getInstance()

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		findViewById<Button>(R.id.logoutBtn).setOnClickListener {
			auth.signOut()

			val intent = Intent(this, IntroActivity::class.java)
			intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
			startActivity(intent)

		}

	}
}