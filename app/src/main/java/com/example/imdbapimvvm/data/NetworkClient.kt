package com.example.imdbapimvvm.data

import com.example.imdbapimvvm.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response

}