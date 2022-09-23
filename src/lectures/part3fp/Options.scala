package lectures.part3fp

object Options extends App {
  val myFirstOption: Option[Int] = Some(4) // should always have a VALID value inside
  val noOption: Option[Int] = None

  println(myFirstOption)

  // designed for unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // WRONG
  val result = Option(unsafeMethod()) // Some or none
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs

}
