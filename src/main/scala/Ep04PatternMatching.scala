package com.elixirin

object Ep04PatternMatching extends App {

  //Switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // PM is an Expression that is equivalent of a switch expression
  println(order)

  // PM takes it to whole another level :
  // Can deconstruct case classes
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) //Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and my age is $a"
    case _ => "Something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the $genre"
    case _ => "I don't know what you're talking about"
  }
  println(bandDescription)

  // Decomposing List
  val aList = List(1,2,3,4)
  val listDescrription = aList match {
    case List(_, 2, _) => "List containing 2 as its second parameter"
    case _ => "unknown list"
  }
  // If PM doesn't match anything, it will throw a match error
  // PM will try all cases in sequence
}
