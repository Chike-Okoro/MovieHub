package com.example.starmoviehub.model.response

data class GetPopularMoviesResponse(
    val page: Int,
    val results: List<Result>?,
    val total_pages: Int,
    val total_results: Int,
    val status_message: String?,
    val status_code: Int?
)