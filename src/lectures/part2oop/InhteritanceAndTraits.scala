package lectures.part2oop

object InheritanceAndTraits extends App {

  // Scala implements single class inheritance
  sealed class Animal {
    def eat = println("nomnomnom")
    private def drink = println("slurpp")
    val creatureType = "wild"
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  //cat.eat
  //cat.drink
  cat.crunch

  /*
  protected methods can only be used by a class and its subclasses
  private methods can only be used by its class
  */

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic" // can be overriden directly on the constructor
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad sense: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // even though it is specified as animal class, it calls the dog class method

  // overRIDING is not the same as overLOADING

  // super: allows to call a method from a parent class

  /*
  Preventing overrides:
    1. Use final keyword on class member
    2. Use final keyword on the class itself
    3. Seal the class with the sealed keyword = extend classes IN THIS FILE, prevent extensions IN OTHER FILES
   */

}
