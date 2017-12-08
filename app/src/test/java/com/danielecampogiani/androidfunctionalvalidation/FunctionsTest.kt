package com.danielecampogiani.androidfunctionalvalidation

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FunctionsTest {


    @Test
    fun testValidMail() {
        assertTrue(validMail("name.surname@gmail.com"))
    }

    @Test
    fun testMissingProvider() {
        assertFalse(validMail("name.surname"))
    }

    @Test
    fun testMissingDomain() {
        assertFalse(validMail("name.surname@gmail"))
    }

    @Test
    fun testValidPhoneNumber() {
        assertTrue(validNumber("1234567898"))
    }

    @Test
    fun testShortPhoneNumber() {
        assertFalse(validNumber("123456789"))
    }


}