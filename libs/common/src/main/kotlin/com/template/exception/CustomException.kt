package com.template.exception

import com.template.enums.ReturnCode

class CustomException(
    private val returnCode: ReturnCode,
) : RuntimeException() {

    private val code
        get() = returnCode.code
    override val message: String
        get() = returnCode.message

    fun getReturnCode(): ReturnCode {
        return returnCode
    }
}
