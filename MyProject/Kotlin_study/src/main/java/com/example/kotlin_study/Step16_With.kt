package com.example.kotlin_study

fun main(){
    class Member{
        var num:Int? = null
        var name:String? = null
        var isMan:Boolean? =  null

        fun showInfo(){
            println("${this.num}, ${this.name}, ${this.isMan}")
        }
    }

    val m1 = Member()
    m1.num =1
    m1.name = "김구라"
    m1.isMan= true
    m1.showInfo()

    val m2 = Member()
    //특정 객체와 함께할 작업을 { } 안에 모아 놓고 일괄 실행할 수 있다.
    with(m2) {
        num=2
        name="해골"
        isMan=false
        showInfo()
    }

}