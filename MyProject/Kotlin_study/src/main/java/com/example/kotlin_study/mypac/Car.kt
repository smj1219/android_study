package com.example.kotlin_study.mypac

//생성자 여러개 정의하기
class Car {
    //필드
    var name:String?=null

    //인자로 아무것도 전달받지 않는 생성자
    constructor(){
        println("constructor()")
    }

    //인자로 String type 을 전달받는 생성자
    constructor(name:String){
        println("constructor(name:String)")
        this.name=name
    }

    fun drive(){
        println("${this.name} 이 달려요!")
    }
}