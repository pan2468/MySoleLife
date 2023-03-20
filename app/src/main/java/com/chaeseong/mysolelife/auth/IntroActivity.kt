package com.chaeseong.mysolelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.chaeseong.mysolelife.MainActivity
import com.chaeseong.mysolelife.R
import com.chaeseong.mysolelife.databinding.ActivityIntroBinding
import com.google.firebase.auth.FirebaseAuth

class IntroActivity : AppCompatActivity() {

	private lateinit var auth: FirebaseAuth

	private lateinit var binding: ActivityIntroBinding

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)

		auth = FirebaseAuth.getInstance()
		binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

		binding.loginBtn.setOnClickListener {
			val intent = Intent(this, LoginActivity::class.java)
			startActivity(intent)
		}

		binding.joinBtn.setOnClickListener {
			val intent = Intent(this, JoinActivity::class.java)
			startActivity(intent)
		}

		binding.noAccountBtn.setOnClickListener {
			auth.signInAnonymously()
				.addOnCompleteListener(this) { task ->
					if (task.isSuccessful) {

						Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

						val intent = Intent(this, MainActivity::class.java)
						intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
						startActivity(intent)

					} else {

						Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

					}
				}
		}
	}
}