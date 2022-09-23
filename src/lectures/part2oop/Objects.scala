package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factoring method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }

  // The class Person and the object Person are said to be COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // they point to the same instance in memory

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // Now they refer to different instances

  val bobbie = Person(mary, john) // We can create new instances by calling the singleton apply method instead of a constructor

  // Scala Application = Scala object with
  // def main(args: Array[String]): Unit
  // shortcut: extends App

  /*
  Scala objects are in their own class, are the only instance and implement the singleton pattern in one line!
   */
}
