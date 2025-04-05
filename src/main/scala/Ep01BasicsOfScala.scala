package com.elixirin

object Ep01BasicsOfScala extends App {
  println("I Love Scala!")

  //defining a val
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42;
  //reassignment of val is illegal and will throw a compile time error

  val aBoolean = false //type mentioning is optional
  println(aBoolean)
  //Regular Data Types are Int, Boolean, Char, Double, Float, String

  val aString = "I Love Scala!"
  val aComposedString = "I" + " " + "Love" + " " + "Scala"
  val anInterPolatedString = s"The meaning of life is $meaningOfLife"
  println(aString, aComposedString, anInterPolatedString)

  // expressions are structures that can be reduced to a value
  val anExpression = 2 + 3
  println(anExpression)

  // if-expression
  val ifExpression = if (meaningOfLife > 43 ) 56 else 999
  println(ifExpression)

  val chainedIfExpression =
    if (meaningOfLife> 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  println(chainedIfExpression)

  //code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    //value of a block is the value of the last expression
    aLocalValue + 3
  }

  println(aCodeBlock)


  // define a function
  def myFunction(x: Int, y: String) : String = {
    y + " " + x
  }

  println(myFunction(5, "Thirteen"))

  // recursive Function
  private def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n -1)

  // In Scala we don't use loops or iteration, we use RECURSION!
  println(factorial(5))

  //the Unit type =  no meaningful value === void in other Languages


  def myUnitReturningFunction(): Unit = {
    println("I don't like returning Unit")
    println(theUnit)
  }
  //will return theUnit

  val theUnit = ()

  print(myUnitReturningFunction())

}
