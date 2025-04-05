package com.elixirin

import scala.List

object Ep03FunctionalProgrammingInScala extends App {
  // Scala is OOL
  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged $age Years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) //INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    in Functional Programming: ( We want to work with functions as first class citizens of the Language
     - compose function
     - pass functions as arguments
     - return function as results

     Conclusion: FunctionX = Function1, Function2, ...., Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcatenator("I Love", "Scala") // "I Love Scala"


  // Syntax Sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  /*
    equivalent to
    val doubler = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */
  doubler(4) // 8

  // more shortHand Notation
  val halfer: Int => Int = (x: Int) => x / 2
  /*
    equivalent to
    val halfer = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */
  halfer(8) // 4

  // can also shorten the above syntax
  val adder = (x: Int) => x + x
  adder(2)


  // Higher Order Functions : take fns as arguments and/or return fns as result
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x * x) //Higher order function
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap( x => List(x, 2 * x))
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,4,5).filter( x => x <= 3)
  println(aFilteredList)

  //shorter syntax for above
  val anotherFilteredList = List(1,2,3,4,5,6,7,8,9).filter(_ >= 6) // equivalent to x => x >=6
  println(anotherFilteredList)

  //chaining HOFs
  // all pairs between the numbers  1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map( letter => s"$number-$letter"))
  println(allPairs)

  // for Comprehension for equivalent above code
  val anotherAllPair = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"

  println(anotherAllPair)


  //Collections
  //List
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail

  val aPrependedList = 0 :: aList // 0,1,2,3,4,5
  val anExtendedList =  0 +: aList :+ 6 // 0,1,2,3,4,5,6


  //Sequences
  val aSequence: Seq[Int] = Seq(1,2,3)  // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) //aSequence.apply(1) - element at index 1 i.e. 2

  // Vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5,6)

  //Sets = No duplicates
  val aSet = Set(1,2,2,3,4,5,3,7) // Set(1,2,3,4,7)
  println(aSet.contains(6))

  val addedSet = aSet + 6
  println(addedSet.contains(6))

  val removeSet = aSet - 3
  println(removeSet)


  // Ranges
  val aRange = 1 to 100
  val twoByTwo = aRange.map(_ * 2).toList
  println(twoByTwo)


  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Piyush", 47856345),
    "Jane" -> 28397890 // equivalent to ("Jane" , 28397890)
  )

}



