package com.example.kotlin_study.mypac

// 대표 생성자는 클래스명 다음에 작성한다.
class Ship constructor() {
    //init 블럭은 대표생성자의 일부이다
    init {
        //객체를 생성하는 시점에 초기화 하고 싶은 작ㅇ업이 있으면 여기서 한다
        println("primary 생성자 호출됨")


    }
}