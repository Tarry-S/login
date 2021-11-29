package com.example.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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

    //starting an activity for a result
    //1. register the activity with a contract
    private val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
        //decides what to do if the result is ok(if it was successful)
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            //note: editText are different from textViews so you have to call setText
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        } else {
            Toast.makeText(this, "registration canceled", Toast.LENGTH_SHORT).show()
        }
        //decide what to do if unsuccessful
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
            //startActivity(registrationIntent)
            startRegistrationForResult.launch(registrationIntent)
        }
    }
}