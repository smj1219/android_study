package com.example.kotlin_study

fun main(){
    val num=10
    //변수나 상수 선언을 미리하고
    val result:String
    //조건부로 다른 값을 대입
    if (num%2 == 1){
        result="$num 은 홀수입니다"
    }else{
        result="$num 은 짝수입니다"
    }

    //kotlin 은 3항 연산자가 없다
    //val result2 = num%2 == 1  ? "$num 은 홀수입니다" : result="$num 은 짝수입니다"

    //kotlin 에서는 if else 문을 3항 연산자 처럼 변수에 대입할 수 있다.
   val result2 = if (num%2==1)"$num 은 홀수입니다." else "$num 은 짝수입니다"

}