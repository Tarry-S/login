package com.example.login

//object keyword makes it so all the functions are static functions
object RegistrationUtil {

    //isn't empty
    //isn't already used
    //correct format
    fun validateEmail(email: String) : Boolean {
        return true
    }

    fun validateName(name: String) : Boolean {
        return true
    }

    //forbidden words
    //already taken
    //can't haven real name
    //min of characters
    //other requirements: capital letters, etc
    fun validateUsername(username: String) : Boolean {
        return true
    }

    //not empty
    //meets security requirements: at least 8 chars, 1 digit, 1 cap letters
    //passwords match
    fun validatePassword(password: String, confirmPassword : String) : Boolean {
        if(password == "" || confirmPassword == ""){
            return false
        }else if(password.length < 8 || password. )
    }

}