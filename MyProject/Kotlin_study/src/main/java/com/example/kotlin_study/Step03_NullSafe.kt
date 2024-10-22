package com.example.kotlin_study

fun main(){
    //변수를 선언만 미리 한다
    var a:String
    //선언과 동시에 값을 대입 한다
    var b:String="kim"
    //선언과 동시에 null 값을 대입 하려고 하는데 type 이 맞지 않아서 안 들어 간다
    //var c:String=null
    //null 값을 허용 하려면 data type 뒤에 suffix(접미어) 로 ? 를 붙여야 한다
    // String type 과 String? type 은 엄연히 다른 type
    var c:String? = null
    c = "lee"
    println("$b 의 길이는 ${b.length}")
    /*
        c?.length 의 의미는 "c가 null 이 아닌 경우에만 length 를 참조해라" 라는 의미
        만일 c 가 null 이라면 c?.length 위치에는 null 이 리턴된다. (null 이 남는다)
     */
    println("$c 의 길이는 ${c?.length}")


}