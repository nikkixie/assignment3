package com.example.cse438.trivia.data

data class Track(
    val id : String,
    val readable : Boolean,
    val title : String,
    val artist : Artist,
    val album : Album,
    val type : String

)

//    val title_short : String,
//    val title_version : String,
//    val isrc : String,
//    val link : String,
//    val share : String,
//    val duration : String,
//    val track_position : Int,
//    val disk_number : Int,
//    val rank : Int,
//    val release_date : String,
//    val explicit_lyrics : Boolean,
//    val explicit_content_lyrics : Int,
//    val explicit_content_cover : Int,
//    val preview : String,
//    val bpm : Double,
//    val gain : Double,
//    val available_countries : List<String>,
