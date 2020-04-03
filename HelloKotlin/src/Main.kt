fun sayHello(greeting:String, vararg itemsToGreet:String) {
    itemsToGreet.forEach {itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun greetPerson(greeting: String ="Hello", name: String = "Kotlin") = println("$greeting $name")

fun main() {
/*
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    //sayHello(greeting="Hi", itemsToGreet = interestingThings)
    //sayHello("hi", interestingThings)
    sayHello("hi", "Kotlin", "P:","c")
    sayHello("Hi", *interestingThings)
    sayHello(itemsToGreet = *interestingThings, greeting = "Sup")
    greetPerson(name = "Name")
    greetPerson()
*/


    //val person = Person( "Kevin", "Huang")
    val person = Person()
    person.printInfo()


}