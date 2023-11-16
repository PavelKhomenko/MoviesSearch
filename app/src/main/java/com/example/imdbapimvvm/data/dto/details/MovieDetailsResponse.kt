package com.example.imdbapimvvm.data.dto.details

import com.example.imdbapimvvm.data.dto.Response

class MovieDetailsResponse(val id: String,
                           val title: String,
                           val imDbRating: String?,
                           val year: String,
                           val countries: String,
                           val genres: String,
                           val directors: String,
                           val writers: String,
                           val stars: String,
                           val plot: String) : Response()