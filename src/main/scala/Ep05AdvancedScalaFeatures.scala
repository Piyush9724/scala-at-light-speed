package com.elixirin

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Ep05AdvancedScalaFeatures extends App {
   /***
    * LAZY EVALUATION
    */
   //Useful in infinite collections
   lazy val aLazyValue = 2
   lazy val lazyValueWithSideEffect = {
      println("I am so very lazy")
      43
   }
   val eagerValue = lazyValueWithSideEffect + 1
   //it will now print "I am so very lazy" on the console because the lazyValueWithSideEffect is being used in the above statement

   /**
    * "pseudo-collections" : Option, Try
    */
   def methodWhichCanReturnNull(): String = "Hello, Scala"
   //We don't have to do the below if we have Option type as a return typ
   /*if (methodWhichCanReturnNull() == null ) {
      //defensive code against null
   }*/

   val anOption = Option(methodWhichCanReturnNull()) //Some("Hello. Scala")
   // option = "collection" which contains at most one element: Some(value) or None

   val stringProcessing = anOption match {
      case Some(string) => s"Obtained a Valid String: $string"
      case None => "Obtained Nothing"
   }
   //can map, flatMap, filter

   //another pseudo-collection Try
   def methodWhichCanThrowException(): String = throw new RuntimeException

   /*
   We can catch exceptions like these, but adding many layers for this will lead to add complexities and make code unreadable
   try {
      methodWhichCanThrowException()
   } catch {
      case e: Exception => "defend against an exception"
   }*/
   // We can do this way in scala
   val aTry = Try(methodWhichCanThrowException())
   // a try = "collection" with either a value if the code went well, or an exception if the code threw one

   val anotherStringProcessing = aTry match {
      case Success(value) => s"I have obtained a Valid String $value"
      case Failure(exception) => s"I have obtained an exception : $exception"
   }



   /**
    * Evaluate something on another thread
    * (asynchronous programming)
    */
   //FUTURE
   val aFuture = Future{ //Future.apply()
      println("Loading...")
      Thread.sleep(1000)
      println("I have computed a value")
      67
   }
   // Future is a "collection" which contains a value when it's evaluated
   // Future is composable with map, flatMap, filter
   // monads <- Future, Try, Option


   /**
    * Implicits basics
    * (one of the most powerful features of Scala : they allow some magic that we didn't have thought was possible
    */
   // #1. implicit arguments
   def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
   implicit val myImplicitInt = 46
   println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt) will return 47

   // #2. implicit Conversions
   implicit class MyRichInteger(n: Int) {
      def isEven() = n % 2 == 0
   }

   println(23.isEven()) // new MyRichInteger(23).isEven()
   // use this carefully

}
