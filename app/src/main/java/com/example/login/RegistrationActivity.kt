package com.example.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //access any values that were sent to us from the intent that launched this activity
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)

        binding.editTextRegistrationUsername.setText(username)
        binding.editTextRegistrationPassword.setText(password)
//        Toast.makeText(this, "user:$username ps:$password", Toast.LENGTH_SHORT).show()

        binding.buttonRegistrationRegister.setOnClickListener {
            //TODO: verify that the information they enter is valid

            //in real app, we'd talk to a database and save the new user

            //return to the login screen ans send back the user and pass to prefill
            var returnToLoginIntent = Intent().apply {
                putExtra(LoginActivity.EXTRA_USERNAME,
                    binding.editTextRegistrationUsername.text.toString()
                )
                putExtra(LoginActivity.EXTRA_PASSWORD,
                binding.editTextRegistrationPassword.text.toString())
            }

            if(binding.editTextRegistrationUsername.text.toString() != "" || binding.editTextRegistrationPassword.text.toString() != "" ) {
                setResult(Activity.RESULT_OK, returnToLoginIntent)
            }else{
                setResult(Activity.RESULT_CANCELED, returnToLoginIntent)
            }
            finish()
        }
    }
}