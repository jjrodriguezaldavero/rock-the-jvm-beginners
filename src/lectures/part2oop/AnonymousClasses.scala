package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class: we haven't implemented the class yet
  // Under the hood, Scala defines: class AnonymousClasses$$anon$a extends Animal

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }
  println(funnyAnimal.getClass)

  /*
  equivalent with:

  class AnonymousClasses$$anon$a extends Animal {
    override def eat: Unit = println("ahahahahah")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }


}
