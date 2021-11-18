package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    //anytime you need what would have been a "static" variable in Java, use companion object
    //in kotlin. Access with ClassName.VARIABLE_NAME like Math.PI
    companion object{
        //keys for the key-value pairs for the intent extras
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginNewAccount.setOnClickListener{
            //launches the registration activity
            //pass the values of username and password to the new activity
            //1. extract any info you might need from editTexts
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()

            //2. create the intent and packages the extras
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }

            //3. launch the activity
            startActivity(registrationIntent)
        }
    }
}