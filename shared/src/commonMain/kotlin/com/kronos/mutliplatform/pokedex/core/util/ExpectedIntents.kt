package com.kronos.mutliplatform.pokedex.core.util

interface IExpectedIntents {
    fun openBrowser(url:String)
    fun makeCall(phone:String)
    fun sendEmail(email:String)
}

expect class ExpectedIntents : IExpectedIntents