package com.example.kotlin_study

class Person constructor(name:String){
    //필드 선언
    var name:String
    init {
        // 생성자에 전달된 값을 필드에 저장
        this.name=name
    }
}

//위의 코드를 줄이면 아래와 같다
class Person2 constructor(var name:String)
class Person3 (var name:String)


fun main(){
    val p1 = Person("김구라")
    val p2 = Person("해골")
    val p3 = Person("원숭이")
    val p4 = Person("주뎅이")
}