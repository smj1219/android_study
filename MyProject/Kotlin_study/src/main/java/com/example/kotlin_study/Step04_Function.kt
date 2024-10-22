package com.example.kotlin_study

fun main(){
    var a = fun(){}
    /*
        Unit _ java 에서 void 와 비슷한 역활( 리턴 값이 없을 때 사용 ) 생략이 가능 하다.
     */
    var b:()->Unit = fun(){}
    var c:()->Unit = fun():Unit{ }
    var d:()->Int = fun():Int{ return 10 }
    var e:()->String = fun():String{ return "kim" }
    var f:(Int)->Unit = fun(num1:Int){ }
    var g:(String)->Unit = fun(msg:String){}
    var h:(Int, String)->Unit = fun(num:Int, mag:String){}
    var i:(Int)->String = fun(num:Int):String{ return "kim" }

    //d 는 변수이기 때문에 또 다른 함수도 모양만 일치하면 들어간다.
    d = fun():Int{
        return 10
    }


}