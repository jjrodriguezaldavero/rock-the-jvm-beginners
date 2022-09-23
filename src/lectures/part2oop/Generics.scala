package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // Generic class: uses the generic type A
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
  If Cat extends Animal, does List[Cat] extends List[Animal]? Three possibilities:
    1. yes, List[Cat] extends List[Animal] -> COVARIANCE
   */
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) - is it possible?? HARD QUESTION -> we return a list of animals

  /*
    2. NO, List[Cat] and List[Animal] are separate things -> INVARIANCE
   */
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // not possible, the compiler will throw errors

  /*
    3. HELL NO! -> CONTRAVARIANCE
   */
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types ( <: , >: )
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car) // throws error

  // expand MyList to be generic

}
