package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val age: Int, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"$name is hanging out with ${person.name}"
    def +(alias: String): Person = new Person(s"$name $alias", age, favoriteMovie)
    def unary_+ : Person = new Person(name, age + 1, favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def learns(topic: String) = s"$name learns $topic"
    def learnsScala = this learns "Scala"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", 26, "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (only for methods with a single parameter) (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", 12, "Fight Club")
  println(mary + tom) // Scala has an incredibly loose naming convention which allows for this

  println(1 + 2)
  println(1.+(2))
  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1
  val y = 1.unary_- //equivalent. unary_ prefix only works with - + ~ !

  println(!mary)

  // postfix notation
  println(mary.isAlive)
  // println(mary isAlive) doesn't work in this version of Scala

  // apply
  println(mary.apply())
  println(mary()) // equivalent. The apply() method defines the behaviour of calling the class!

  /*
  EXERCISES
  1. Overload the + operator
     mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class
     Add a unary + operator => new person with the age + 1
     +mary => mary with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala"
     Add a learnsScala method, calls learns method with "Scala"
     Use it in postfix notation

  4. Overload the apply method
     mary.apply(2) => "Mary watched Inception 2 times"
   */

  println("TESTING EXERCISE \n")

  val mary_rockstar = mary + "the Rockstar"
  println(mary_rockstar.name)

  val mary_old = +mary
  println(s"${mary_old.name} is ${mary_old.age} years old")

  println(mary learns "Scala")
  println(mary learnsScala)

  println(mary(2))
}
