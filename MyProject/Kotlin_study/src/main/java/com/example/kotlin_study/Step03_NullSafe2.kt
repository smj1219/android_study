package com.example.kotlin_study

fun main(){
    var str:String = "abcde1234"
    var str2:String? = "abcde1234"

    //문자열의 길이를 참조해서 변수에 담기
    var length:Int=str.length
    //str2가 null 일 가능성이 있기 때문에 변수 type 또한 ? 로 받아주어야 한다.
    var length2:Int?= str2?.length
    //type 추론이 가능하기 때문에 생략가능
    var length3= str2?.length

    //Elvis 연산자 ?: _만일 str2?.length 가 null 이면 0이라는 기본 값을 이 위치에 남긴다는 의미
    /*
        Elvis 연산자 ?: 는 null 일경우에 기본값을 남기는 연산자이다
        str2?.length 가 만일 null 이면 0 을 남기기 때문에 대입연산자의 우측이 null 일 가능성은 없다
        따라서 length3 는 Int? 이 아닌 Int type 으로 선언할수 있는 것이다
     */
    var length4:Int = str2?.length ?: 0

}