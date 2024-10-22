package com.example.kotlin_study

//수정 가능한 (Mutable) 목록 (List)
fun main(){
    //val foods:MutableList<String> = mutableListOf("라면", "김밥")
    val foods = mutableListOf("라면", "김밥")
    // mutable 이기 때문에 아이템 추가 가능
    foods.add("쫄면")
    foods.add("떡볶이")
    foods.add("오뎅")
    // 아이템 수정 가능
    foods.set(0, "신라면")
    foods[1] = "참치김밥"
    // 아이템 삭제 가능
    foods.removeAt(index= 2) //2번 인덱스의 아이템 삭제
    foods.removeLast()//마지막 인덱스 삭제
}