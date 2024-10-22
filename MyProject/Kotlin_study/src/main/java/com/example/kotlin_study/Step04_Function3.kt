package com.example.kotlin_study

//함수 type 을 매개변수로 전달 받는 함수를 만들어보자
fun useFunc(f:()->Unit){
    //매개 변수 f 에 전달된 함수 call
    f()
}

//메인 메소드
fun main(){
    //위에서 선언한 useFunc 함수 호출해보기
    useFunc(fun(){
        println("실행됨!")
    })

    useFunc({
        println("실행됨")
    })

    useFunc { println("실행됨!") }
}