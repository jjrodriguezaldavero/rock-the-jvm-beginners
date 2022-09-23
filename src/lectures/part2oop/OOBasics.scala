package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.writtenBy(author))
  println(novel.writtenBy(imposter)) // equality problem

  val counter = new Counter
  counter.inc.print
}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading is allowed as long as the methods have different signature
  def greet(): Unit = println(s"Hi, I am $name")

  // class parameters ARE NOT FIELDS
}

/*
Task: Implement a Novel and a Writer class
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
    - method authorAge
    - isWrittenBy(author)
    - copy(new year of release) = new instance of Novel
 */

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def writtenBy(author: Writer): Boolean =
    author == this.author

  def copy(newYear: Int): Novel =
    new Novel(name, newYear, author)
}

class Writer(first_name: String, last_name: String, val year: Int) {
  def fullName(): String =
    this.first_name + " " + this.last_name // variables are in camelCase and it is not needed to use 'this' if there is no ambiguity
}

/*
Task: Implement a Counter class
  - receives an int value
  - method current_count
  - method to increment / decrement => new Counter
  - overload inc/dec to receive an amount
 */

class Counter(val n: Int = 0) {
  def count() = n

  def inc = new Counter(count + 1) // immutability
  def dec = new Counter(count - 1)

  def inc(n: Int) = new Counter(count + n)
  def dec(n: Int) = new Counter(count - n)

  def print = println(count)
  /*
  Immutability is very important in functional programming: class instances
  should be immutable and to change them a new instance must be created.
   */
}


