package com.notepad96.apiholiday

import com.google.gson.reflect.TypeToken
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class DateInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // 기존의 요청을 확인합니다.
        val request = chain.request()

        try {
            val response = chain.proceed(request)
            if (!response.isSuccessful) {
                throw IOException("Network not successful")
            }

            val jsonString = response.body?.string() ?: ""
            val bodyFiltered = filteringData(jsonString)

            return response.newBuilder()
                .message(response.message)
                .body(bodyFiltered.toResponseBody())
                .build()
        } catch (ie: IOException) {
            // 네트워크가 실패하거나 타입이 일치하지 않아 변환에 실패한 경우
        }
    }

    private fun filteringData(input: String) : String {
        // 데이터를 필터링하여 반환합니다.
        // 1. 입력된 JsonString을 다시 객체화 시키는 과정
        val typeToken = object: TypeToken<GeneralResponse<*>>() {}.type
        val result: GeneralResponse<*> = gson.fromJson(input, typeToken)

        // 응답에서 header 값 확인하기
        val header = result.response.header

        if (header.resultCode != "00")
            throw IOException("Network Failed")
        
        // 2. 필요한 부분만 꺼내서 다시 JsonString으로 만드는 과정
        val body = result.response.body
        val contents = gson.toJson(body.items)    // Items만 꺼낸다.

        return contents
    }
}
