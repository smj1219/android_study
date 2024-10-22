package com.example.kotlin_study

class MyTool{
    //같은 메소드 명으로 메소드를 여러개 정의할 수 있다.(메개변수의 모양이 다르면)
    fun make(){}
    fun make(amount:Int){}
    fun make(amount:Int, name:String){}
}

class YourTool{
    //메소드 오버로딩 느낌을 낼 수 있다.
    fun make(amount: Int=0, name: String=""){}
}

class OurTool{
    //java 에서도 다양한 모양의 메소드를 호출할 수 있게 하려면 @JvmOverloads 어노테이션이 필요하다.
    @JvmOverloads fun make(amount: Int=0, name: String=""){}
}

fun main(){
    MyTool().apply {
        make()
        make(10)
        make(10,"망치")
    }

    YourTool().apply {
        make()
        make(1)
        make(1, "망치")
    }



}