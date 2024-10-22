package com.example.kotlin_study

// kotlin 에서 인터페이스 만들기
interface  Remocon{
    fun up()
    fun down()
}

//인터페이스를 구현한 클래스 만들기
class MyRemocon : Remocon{
    override fun up() {
        println("무언가를 올려요")
    }

    override fun down() {
        println("무언가를 내려요")
    }
    fun move(){
        println("움직여요!")
    }

}

fun main(){
    //Myremocon 객체를 생성해서 MyRemocon type 에 담기
    val r1:MyRemocon = MyRemocon()
    r1.up()
    r1.down()
    r1.move()

    //Myremocon 객체를 생성해서 Remocon type 에 담기
        val r2:Remocon = MyRemocon()
        r2.up()
        r2.down()
        //r2.move() // r2 는 Remocon type 이기 때문에 .move()는 호출 불가

    /*
        [type casting ]
        java -> (MyRemocon)r2
        kotlin -> r2 as Remocon
    */
    val r3:MyRemocon = r2 as MyRemocon
    r3.move() // casting 후에 .move() 호출 가능

    // r2 가 MyRemocon type 객체인지 확인해서 맞으면
    if (r2 is MyRemocon){
        // smart casting 형 변환없이 바로 MyRemocon 의 기능을 사용할 수 있다.
        r2.move() //move 를 호출한다.
    }


}