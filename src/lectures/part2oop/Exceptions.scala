package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) // This will crash with a NullPointerException (NPE)

  // 1. Throwing exceptions

  // val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class (Exception and Error are the major Throwable subtypes)
  // Exception: something wrong with the code
  // Error: something wrong with the system (eg. stack overflow)

  // 2. Catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a runtime exception")
  } finally {
    // Optional. code that will get executed NO MATTER WHAT.
    // does not influence the return type. Use finally only for side effects.
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions.
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
       - add(x,y)
       - subtract(x,y)
       - multiply(x,y)
       - divide(x,y)

       Throw
         - OverflowException if add(x,y) exceeds Int.MAX_VALUE
         - UnderflowException if add(x,y) exceeds Int.MIN_VALUE
         - MathCalculationException for division by 0
   */

  // val array = Array.ofDim(Int.MaxValue) //OutOfMemoryError (OOM)

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else n * factorial(n-1)
  }
  //println(factorial(50000)) //StackOverflows

/*
  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int =
      if(x + y < Int.MaxValue) x + y
      else throw new OverflowException
    def subtract(x: Int, y: Int): Int =
      if(x - y > Int.MinValue) x - y
      else throw new UnderflowException
    def multiply(x: Int, y: Int): Int = x * y
    def divide(x: Int, y: Int): Int =
      if(y != 0) x / y
      else throw new MathCalculationException
  }
*/

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
