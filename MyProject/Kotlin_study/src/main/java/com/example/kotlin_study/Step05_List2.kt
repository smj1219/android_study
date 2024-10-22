package com.example.kotlin_study

fun main(){
    //읽기 전용 List
    val nums:List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)

    // List 를 이용해서 새로운 List 얻어내기
    val result = nums.map(fun(item):Int{
        return item*2
    })
    println(result)

    val result2 = nums.map {
        //여기를 람다함수 내부이기 때문에 return  이라는 예약어는 사용하지 않는다.
        it*2
    }
    println(result2)

    // List 에서 5 이상인 아이템만 남신다음 해당 아이템에 2를 곱한 새로운 List 얻어내기
    val result3 = nums.filter { it>=5 }.map { it*2 }
    println(result3)

    val nums2 = listOf(10, -5, -6, 1, 4, -7, -8, 20, 30, -15, -13)
    val nums3 = nums2.filter { it>=0 }
    println(nums3)
}