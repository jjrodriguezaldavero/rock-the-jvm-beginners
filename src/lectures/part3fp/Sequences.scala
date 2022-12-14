package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 until 10).foreach(x => println("Hello"))

  // Lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList // prepending, as well as +:
  val appended = aList :+ 42
  println(prepended)
  println(appended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println) // Initializes primitive types (like ints) to 0 and reference types (like strings) to null

  // Mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  // connection between arrays and sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion of an array to a sequence
  println(numbersSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // performance test: vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      // operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // advantage of list: keeps reference to tail
  // disadvantage: updating an element in the middle is long
  println(getWriteTime(numbersList))
  // advantage of vector: depth of the tree is small
  // disadvantage: needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
}
