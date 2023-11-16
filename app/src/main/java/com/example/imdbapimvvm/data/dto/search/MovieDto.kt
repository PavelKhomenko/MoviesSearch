package com.example.imdbapimvvm.data.dto.search

data class MovieDto(val id: String,
                    val resultType: String,
                    val image: String,
                    val title: String,
                    val description: String)