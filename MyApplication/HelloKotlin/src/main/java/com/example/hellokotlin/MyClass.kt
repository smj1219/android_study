package com.example.hellokotlin

// java 에서 main() 메소드 역활을 한다.
// run 했을 때 실행의 흐름이 시작 되는 도입점
fun main(){
    println("Hello World!")
    // var _변수를 만들 때, val _상수를 만들 때 사용
    // type 추론(infer) 가 가능하다면 data type 은 생략가능
    // ㄴ 변수나 상수 선언과 동시에 값을 대입하는 경우

    // 정수를 담을 수 있는 num 이라는 변수를 만들어서 10 대입하기
    // int num = 10; => java
    var num:Int = 10 //kotlin

    // 실수를 담을 수 있는 num2 라는 이름의 변수를 만들어서 10.1 대입하기
    //double num2 = 10.1 => java
    var num2:Double = 10.1

    // 문자열을 담을 수 있는 myName 이라는 이름의 변수를 만들어서  "김구라" 대입하기
    var myName:String = "김구라"

    //myName 은 변수(var) 이기 때문에 변경 가능
    myName="에이콘"

    //num 도 변수(var)이기 때문에 type 만 같으면 변경 가능
    num=99

    //num3 를 정수를 저장할 수 있는 상수로 지정
    val num3:Int = 8888
    //num3 = 9999 // 상수로 지정하여 값 변경 불가




}