package lectures.part2oop

import playground.{PrinceCharming, Cinderella => Princess}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package membres are accesible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  // val princess = new playground.Cinderella // fully qualified name
  val princess = new Princess

  // packages are in hierarchy matching folder structure

  // package objects
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // In case of class naming conflicts:
  // 1. Use fully qualified names
  val date = new Date
  //val sqlDate = new SqlDate(2018, 5, 4)
  // 2. Use name aliasing
  // val sqlDate = SqlDate

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
