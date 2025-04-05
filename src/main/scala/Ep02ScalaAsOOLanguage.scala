package com.elixirin

object Ep02ScalaAsOOLanguage extends App {
  // class and instance
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat(): Unit = println("I'm eating as Animal")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal  //constructor Definition
  val aDog = new Dog("KoKo")

  // constructor arguments are NOT fields: need to put a val before the constructor argument
  println(aDog.name)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Simba")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime


  // abstract class
  abstract class WalkingAnimal {
    protected val hasLegs = true //all fields and methods are default by public, there's no keyword as public, we can restrict it by using protected and private
    def walk(): Unit //not implemented
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philospher {
    def ?!(thought: String): Unit //?! is a Valid Method Name -> used in Akka for Actor Communication
  }

  // single class inheritance and multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philospher {
    override def eat(animal: Animal): Unit = println(s"I am eating you animal")

    override def ?!(thought: String): Unit = println(s"I was thinking a $thought!")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //method that has a single argument can use the infix Notation => object method argument
  aCroc ?! "What if we could fly?" //such a method looks like an operator

  // therefore operators in Scala are actually methods
  val basicMath = 1 + 2 //+ here is a method belonging to the Int type
  val anotherBasicMath = 1.+(2) // equivalent to 1 + 2

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println(s"I am a dinosaur so I can eat all animals")
  }

  // What is happening above
  /*
    class Carnivore_Anonymous_3434 extends Carnivore {
      override def eat(animal: Animal): Unit = println(s"I am a dinosaur so I can eat all animals")
    }

    val dinosaur = new Carnivore_Anonymous_3434
   */

  //Singleton Object
  object MySingleton { // this is the only instance of the type MySingleton
    val mySingletonValue = 34534
    def mySingletonMehtod(): Int = 78367

    def apply(x: Int): Int = x + 1 //apply can be present in any class or any object of Scala
    // the presence of the apply method in class allows the instances of that class to call the applied method in the following way
    // MySingleton.apply(65) or that is equivalent to MySingleton(65) this automatically interprets a call to the apply method
  }

  println(MySingleton.mySingletonMehtod())

  MySingleton.apply(65)
  MySingleton(65)
  println(MySingleton(65))


  // in the same file we can define a class/trait and a singleton object this is called class Animal and object Animal is called companions
  // companion object
  object Animal {
    //companions has a special property to access each others private fields/methods
    //singleton Animal and instances of Animal class are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods
  println(animalsCanLiveForever)


  /*
    Case classes =  lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
   */

  case class Person(name: String, age: Int)

  // may be constructed without the keyword new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)


  // Exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some Faulty error message"
  } finally {
    // will always execute no matter what with or without error
  }


  // Generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
  val first = aList.head //int
  val rest = aList.tail
  val aStringList = List("Hello", "Scala")
  val firstString = aStringList.head //string



  // Point #1: In Scala we operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
      1). Works miracles in multithreaded/distributed envs
      2). Helps make sense of the code ("reasoning about")
   */
  val reverseList = aList.reverse // this will return a NEW List

  // Point #2: Scala is closest to the OO Language ideal (True OOL)

}