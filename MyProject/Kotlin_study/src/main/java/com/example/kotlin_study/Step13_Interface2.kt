package com.example.kotlin_study

fun main(){
    /*
        in java

        final Remocon r1 = new Remocon(){
            void up(){}
            void down(){}
        }
     */

    // 익명 클래스를 이용해서 Remocom type 의 참조값 얻어내기
    // 익명 클래스를 정희함과 동시에 객체를 생성하느 것외 object 키워드이다
    val r1:Remocon = object : Remocon{
        override fun up() {
            println("채널을 올려요!")
        }

        override fun down() {
            println("채널을 내려요!")
        }
    }
    r1.up()
    r1.down()
}