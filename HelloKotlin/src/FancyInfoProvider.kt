class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "Fancy"

    override fun pInfo(person: Person) {
        super.pInfo(person)
        println("fancy info")
    }

    override val sessionIdPrefix: String
        get() = "Fancy Session"
}