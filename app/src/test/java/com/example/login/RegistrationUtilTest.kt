package com.example.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    //methodName_someCCondition_expectedResult
    @Test
    fun validatePassword_emptyPassword_returnsFalse(){
        val result = RegistrationUtil.validatePassword("", "")
        //assertThat(actualValue).isEqual(desiredValue)
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnFalse(){
        val result = RegistrationUtil.validatePassword("123dfsdf", "132asdfa")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordContains8Char_returnFalse(){
        val result = RegistrationUtil.validatePassword("1345678", "1345678")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsContainsDigit_returnFalse(){
        val result = RegistrationUtil.validatePassword("abcdefge", "abcdefge")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordContainsCap_returnsFalse(){
        val result = RegistrationUtil.validatePassword("asdf1234", "asdf1234")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_goodPassword_returnTrue(){
        val result = RegistrationUtil.validatePassword("Abcd1234", "Abcd1234")
        assertThat(result).isTrue()
    }


    @Test
    fun validateEmail_emptyEmail_returnFalse(){
        val result = RegistrationUtil.validateEmail("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_repeatedEmail_returnFalse(){
        val result = RegistrationUtil.validateEmail("connersmith1254@gmail.com")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_notAEmail_returnFalse(){
        val result = RegistrationUtil.validateEmail("sad.comfiab@ds")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_goodEmail_returnTrue(){
        val result = RegistrationUtil.validateEmail("ahhhhh@gmail.com")
        assertThat(result).isTrue()
    }


    @Test
    fun validateName_weirdName_returnFalse(){
        val result = RegistrationUtil.validateName("wa938746wer9f")
        assertThat(result).isFalse()
    }

    @Test
    fun validateName_goodName_returnTrue() {
        val result = RegistrationUtil.validateName("conner")
        assertThat(result).isTrue()
    }

    @Test
    fun validateUsername_emptyUsername_returnFalse(){
        val result = RegistrationUtil.validateUsername("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_tooLongUsername_returnFalse(){
        val result = RegistrationUtil.validateUsername("asdygfuhaw8e7rt8qw49yerfqiweyfriqwefgiqwaefitwqei7tfiqwetgfiqtwefuqweitfiaweufgi")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_takenUsername_returnFalse(){
        val result = RegistrationUtil.validateUsername("bigboi")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_forbiddenUsername_returnFalse(){
        val result = RegistrationUtil.validateUsername("mushrooman")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_usernameHasName_returnFalse(){
        val result = RegistrationUtil.validateUsername("connersmith")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_goodUsername_returnTrue(){
        val result = RegistrationUtil.validateUsername("bingus")
        assertThat(result).isTrue()
    }
}