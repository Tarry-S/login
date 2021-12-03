package com.example.login

//object keyword makes it so all the functions are static functions
object RegistrationUtil {
    var existingUsers = listOf("bigboi", "asdf", ": ^)")
    var existingEmails = listOf("connersmith1254@gmail.com", "therock@byahoo.com")
    var forbiddenWords = listOf("mushroom")
    var name = ""

    //isn't empty
    //isn't already used
    //correct format
    fun validateEmail(email: String) : Boolean {
        if(email != "" && !existingEmails.contains(email)){
            if (email.substring(email.length - 4) == ".com" && email.contains("@"))
                return true
        }
        return false
    }

    //only letters
    fun validateName(name: String) : Boolean {
        val chars = name.toCharArray()

        for (c in chars) {
            if (!Character.isLetter(c)) {
                return false
            }
        }
        this.name = name
        return true
    }

    //forbidden words
    //already taken
    //can't haven real name
    //maximum 30 Min 1
    fun validateUsername(username: String) : Boolean {
        if(!existingUsers.contains(username) && !username.contains(name) && username.isNotEmpty() && username.length <= 32){
            if(username.indexOfAny(forbiddenWords) == -1)
                return true
        }
        return false
    }

    //not empty
    //meets security requirements: at least 8 chars, 1 digit, 1 cap letters
    //passwords match
    fun validatePassword(password: String, confirmPassword : String) : Boolean {
        if (password != "" && password.length >= 8) {
            if (password.indexOfAny(
                    charArrayOf(
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                        'Y', 'Z'
                    )
                ) >= 0
            ) {
                if (password.indexOfAny(
                        charArrayOf(
                            '0', '1', '2', '3', '4', '5', '6', '7', '8',
                            '9'
                        )
                    ) >= 0
                ){
                    if(password == confirmPassword)
                        return true
                }
            }
        }
        return false
    }
}