package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1) // RECURSIVE
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))
  // println(factorial(50000)) StackOverflows

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1) // TAIL RECURSION: use recursive call as the LAST expression
  }

  // println(anotherFactorial(20000))

  /*
  The difference between both functions is that the second one does not need to
  store intermediate values to compute the factorial because it calls factHelper() directly,
  while the first one needs to keep the values of n to call n * factorial().
  This is the difference between recursive and tail-recursive functions.

  WHEN YOU NEED LOOPS, USE **TAIL** RECURSION

  Any recursive function can be transformed into a tail recursive function.
   */

  /*
  TASKS. Using tail recursion, do:
  1. Concatenate a string n times
  2. IsPrime function
  3. Fibonacci function
   */

  def concatenate(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenate(aString, n - 1, aString + accumulator)

  println(concatenate("hola", 5, ""))

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
