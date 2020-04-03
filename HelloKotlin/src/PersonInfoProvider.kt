interface PersonInfoProvider {
    val providerInfo: String
    fun pInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId() : String
}

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic"

    protected open val sessionIdPrefix = "Session"

    override fun pInfo(person: Person) {
        super.pInfo(person)
        println("add")
    }

    override fun getSessionId(): String {
        println("session")

        return sessionIdPrefix
    }
}

fun main() {
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New info provider"

        fun getSessionId() = "id"
    }
    provider.pInfo(Person())
    provider.getSessionId()
    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider)  {
    if (infoProvider is SessionInfoProvider){
        println("is a session")
        infoProvider.getSessionId()
    }
    else {
        println("not a session")
    }
}