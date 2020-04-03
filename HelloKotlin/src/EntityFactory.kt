import java.util.*

interface IdProvider {
    fun getId(): String
}

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}
object EntityFactory {
    fun create(type:EntityType) :Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help

        }

        //return Entity(id, name)
    }
}

sealed class Entity  () {
    object Help: Entity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()

}
fun main() {
    val entity:Entity = EntityFactory.create(EntityType.EASY)
    val entity1 = Entity.Easy("id","name")
    val entity2 = entity1.copy(name = "new name")


    if (entity1 == entity2) {
        println("equal")
    }
    else
        println("not equal")


    val msg = when (entity){
        Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Medium -> "med class"
        is Entity.Hard -> "hard class"
    }
    println(msg)
    /*
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val medEntity = EntityFactory.create(EntityType.MEDIUM)
    println(medEntity)
     */

}