class Person(val firstName:String = "Henry", val lastName:String ="Cavil") {

    var nickName: String? = null
        set(value) {
            field = value
            println("the nickname is $value")
        }

    get() {
        println("The returned value is $field")
        return field
    }
/*
    init {
        println("init 1")
    }
    constructor(): this("Peter","Parker") {
        println("secondary constructor")
    }

    init {
        println("init 2")
    }
    */

    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"
        //val nickNameToPrint = if (nickName != null) nickName else "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }

}