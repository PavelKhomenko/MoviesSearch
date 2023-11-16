package com.example.imdbapimvvm.data.dto.search

import com.example.imdbapimvvm.data.dto.Response

class MoviesSearchResponse(val searchType: String,
                           val expression: String,
                           val results: List<MovieDto>) : Response()