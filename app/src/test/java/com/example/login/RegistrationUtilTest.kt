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
        val result = RegistrationUtil.validatePassword("123", "132")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordContains8Char_returnTrue(){
        val result = RegistrationUtil.validatePassword("12345678", "12345678")
        assertThat(result).isTrue()
    }

    @Test
    fun validatePassword_passwordsContainsDigit_returnTrue(){
        val result = RegistrationUtil.validatePassword("abcdefg1", "abcdefg1")
        assertThat(result).isTrue()
    }

    @Test
    fun validatePassword_passwordContainsCap_returnsFalse(){
        val result = RegistrationUtil.validatePassword("asdf1234", "asdf1234")
        assertThat(result).isFalse()
    }
}