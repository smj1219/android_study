package com.example.kotlin_study

import com.example.kotlin_study.mypac.Ship
import com.example.kotlin_study.mypac.Ship2
import com.example.kotlin_study.mypac.Ship3

//클래스 정의하기
class MyCar

class YourCar{
    //멤버 함수
    fun  drive(){
        println("달려요!")
    }
}
class  Bus{
    fun drive(){

    }
}

fun main(){
    // MyCar 클래스로 객체를 생성해서 참조값을 c1 에 담기
    val c1:MyCar = MyCar()
    val c2:YourCar = YourCar()
    c2.drive()

    val s1 = Ship()
    val s2 = Ship2()
    val s3 = Ship3()

    val b:Bus=Bus();
    b.drive()
}