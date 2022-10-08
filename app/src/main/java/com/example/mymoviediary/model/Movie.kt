package com.example.mymoviediary.model

/* coder: 상준
 */

// 영화 진흥위원회 API에서 받아오는 값
data class ResultGetMovieChart(
    var boxOfficeResult: BoxOfficeResult?
)

data class BoxOfficeResult(
    var boxofficeType: String? = null,
    var showRange: String? = null,
    var dailyBoxOfficeList: List<DailyBoxOfficeMovie>
)

data class DailyBoxOfficeMovie(
    var rank: String? = null,
    var movieNm: String? = null,
    var openDt: String? = null
)

// 네이버 API에서 받아오는 값
data class ResultGetNaverMovie(
    var items: List<Items>
)

data class Items(
    var title: String? = null,
    var link: String? = null,
    var image: String? = null,
    var subtitle: String? = null,
    var director: String? = null,
    var actor: String? = null,
    var userRating: Double? = null
)

class Movie(

)