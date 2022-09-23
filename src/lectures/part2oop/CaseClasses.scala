package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)
  // 1. Case class parameters are automatically promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. Case classes have a sensible toString method by default
  // syntactic sugar: println(instance) = println(instance.toString)
  println(jim.toString)
  println(jim)

  // 3. They have 'equals' and 'hashCode' implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true. If it was a regular class instead of a case class it would be false

  // 4. CCs have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable. Akka

  // 7. CCS have extrator patterns -> CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  TASK:
    Expand MyList - Use case classes and case objects
   */
}
