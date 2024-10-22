package com.example.kotlin_study

fun main(){
    //수정 가능한 Map
    //val mem:MutableMap<String, Any> = mutableMapOf<String, Any>()
    //val mem:MutableMap<String, Any> = mutableMapOf()
    val mem = mutableMapOf<String, Any>()
    mem.put("num", 1)
    mem.put("name", "김구라")
    mem.put("isMan", true)

    //참조, return type 이 Any? type 이므로 casting 이 가능하다
    val num:Int = mem.get("num") as Int
    val name:String = mem.get("name") as String
    val isMan:Boolean = mem.get("isMan") as Boolean

    val post = mutableMapOf<String, Any>()
    //데이터 추가
    post["id"] = 1
    post["title"] = "제목입니다"
    post["content"] = "내용입니다"
    //참조
    val id = post["id"] as Int
    val title = post["title"] as String
    val content = post["content"] as String



}