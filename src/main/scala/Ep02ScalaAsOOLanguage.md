# Scala at Lightspeed - Object-Oriented Programming

## 📽️ Summary

In this video, Daniel continues the **“Scala at Lightspeed”** course from **Rock the JVM** by diving into **object-oriented programming** (OOP) in Scala. The session starts with the creation of a Scala project where Daniel defines a class named `Animal`, laying the foundation for discussing OOP principles like **class instantiation**, **inheritance**, and **polymorphism**.

Daniel covers essential OOP constructs in Scala, including **constructor arguments**, **abstract classes**, and **traits**—Scala’s alternative to interfaces and mixins. The tutorial also touches upon **method overloading**, **infix notation**, and the flexibility of method naming and syntax in Scala.

Further, the video explores advanced OOP features such as **singleton objects**, the **singleton pattern**, **case classes**, **exception handling**, and **generics**. Throughout, Daniel reinforces the importance of **immutability** in Scala and demonstrates how OOP is expressed in a more **concise and expressive** way compared to many traditional languages. He wraps up by showcasing how to make Scala applications executable via the `App` trait and encourages viewers to continue learning via Rock the JVM.

---

## 🌟 Highlights

- 🐾 **Introduction to Class Definitions**: Demonstrates how to define and instantiate classes like `Animal` in Scala.
- 🔄 **Inheritance Explained**: Shows how subclasses extend parent classes, reusing and extending functionality.
- ⚙️ **Constructor Arguments**: Differentiates between temporary arguments and persistent class fields.
- 📏 **Subtype Polymorphism**: Covers how overridden methods are resolved at runtime, promoting flexible code design.
- 🌱 **Traits and Mixins**: Introduces traits as reusable components that enable multiple inheritance.
- 🧩 **Case Classes and Pattern Matching**: Explains concise data classes that simplify immutability and pattern matching.
- ⏳ **Immutability in Scala**: Advocates for immutable structures to promote safer and more understandable code.

---

## 💡 Key Insights

### 🎓 Advanced Class Structures
Classes like `Animal` provide a familiar starting point for OOP in Scala, allowing traditional object-oriented principles to be practiced with more expressive syntax and features.

### 🔄 Effective Code Reuse via Inheritance
Scala’s **inheritance** model reduces code duplication and promotes **DRY** principles by letting child classes reuse parent behaviors.

### 🛠️ Constructor Arguments vs. Fields
Constructor parameters do not become class fields unless declared with `val` or `var`. This separation ensures better memory usage and enforces encapsulation.

### ⚡ Dynamic Method Resolution
Scala’s **runtime polymorphism** means the most specific method in the class hierarchy is chosen, making behavior adaptable and modular.

### 💡 Traits for Flexibility
Unlike Java’s single inheritance limitation, Scala supports mixing **multiple traits**, enabling more flexible and maintainable code composition.

### 🌟 Ease of Pattern Matching with Case Classes
Case classes in Scala come with out-of-the-box features like `equals`, `hashCode`, and pattern matching support, reducing boilerplate and simplifying data modeling.

### ⚖️ Immutability Enhances Robustness
Scala encourages using immutable structures (`val`), which makes code easier to reason about, particularly in **multi-threaded** and **functional** contexts.

---

# Scala: Companion Objects Explained (Rock the JVM Style)

This guide breaks down the concept of **companion objects** in Scala using a clear and beginner-friendly approach, inspired by the teaching style of Daniel Ciocîrlan and Rock the JVM.

---

## 💡 What Is a Singleton Object?

In Scala, a singleton object is an object with only **one instance**. You define it using the `object` keyword.

```scala
object Animal {
  val canLiveIndefinitely: Boolean = false
}
```

- This is similar to a **static object** in Java.
- You don't need `new` to access it—just call it directly.

---

## 💡 What Is a Class?

A `class` is a **blueprint** to create multiple objects (instances).

```scala
class Animal(val name: String)
```

You can create instances like this:

```scala
val cat = new Animal("Whiskers")
val dog = new Animal("Buddy")
```

Each `new` call creates a **different animal**.

---

## 💡 What Is a Companion Object?

A **companion object** in Scala is:

- An `object` that has the **same name** as a `class` or `trait`.
- Defined in the **same file** as the class or trait.

Example:

```scala
class Animal(val name: String)

object Animal {
  val canLiveIndefinitely: Boolean = false
}
```

In this case:
- `object Animal` is the **companion** of `class Animal`.

---

## ✅ Key Rule

A **companion object** and its `class` can **access each other’s private fields and methods**.

> This is **not possible in Java**, but it's allowed in Scala.

---

## ❗ Important Distinction

Even though the `class` and `object` share the same name, they are **not the same**.

| `class Animal` | `object Animal` |
|----------------|------------------|
| Used to create individual animals | Used to store shared logic or constants |
| Has instance-specific data (e.g., `name`) | Has static-like fields (e.g., `canLiveIndefinitely`) |

---

## 🔍 Usage Example

```scala
class Animal(val name: String)

object Animal {
  val canLiveIndefinitely: Boolean = false
}
```

```scala
val dog = new Animal("Rex")
println(dog.name) // Output: Rex

println(Animal.canLiveIndefinitely) // Output: false
```

---

## 🧠 Analogy

- The **object Animal** is like a **head office** for animals.
- Each `new Animal("Fluffy")` is like an **individual animal**.

**Object (Singleton)**:
> "No animal can live forever."

**Class (Instance)**:
> "My name is Fluffy."

---

## ✅ Key Takeaways

- `class Animal` and `object Animal` are **companions**.
- They can access each other’s **private** members.
- The `object` is a **singleton**—only one instance.
- The `class` is used to create **individual objects**.
- Use the companion `object` to:
    - Define constants
    - Define utility methods
    - Write factory methods (like `apply`)
    - Hold shared logic that does not depend on specific instances

---

## 🔍 Object extends App

In Scala, when you write:

```scala
object MyApp extends App
```

You are saying:

> “Hey Scala, I want this object to **run as a complete application**.”

### ✅ Why?
Because by writing `extends App`, you're inheriting a **main method** behind the scenes. That’s the same `main` method you’d write manually in Java:

```java
public static void main(String[] args) {
    // do something
}
```

But in Scala, it’s **built-in** thanks to `App`.

---

## 💥 The Magic Behind `extends App`

The `App` trait already includes a `main` method that **automatically runs the code inside your object**.

So this:

```scala
object MyApp extends App {
  println("Hello, Scala!")
}
```

Is secretly doing this:

```scala
object MyApp {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
  }
}
```

But **you don't have to write `main` yourself**. Scala does it for you with `extends App`.

---

## 📍 Why It Matters in IntelliJ

In IntelliJ:

- If your object **doesn't** have a `main` method (or doesn’t extend `App`), you **can’t run it**.
- If it **does** (either by writing `main` or using `extends App`), IntelliJ shows the green ▶️ button so you can run it.

Try this:

```scala
// Not runnable
object Demo {
  println("Not runnable directly")
}
```

vs.

```scala
// Runnable
object Demo extends App {
  println("Now it runs!")
}
```

---

## ✅ Final Takeaways

| Concept                        | Scala                             | Java Equivalent                            |
|-------------------------------|------------------------------------|--------------------------------------------|
| Define an application         | `object MyApp extends App`         | `public static void main(...)`             |
| Automatically runnable        | ✅ Yes, with `extends App`         | ❌ No, must define `main` manually         |
| Static-like method            | `object` body code is run once     | `static` method called on class            |

---

## 🧠 Quick Analogy

- **Java:** You need a `main()` method and declare it static.
- **Scala:** You just say `extends App`, and Scala takes care of the rest. Less code, same result.

---

Would you like a visual mind map or diagram for this too? Or want to learn how `App` is implemented under the hood in Scala source code?

## 🔮 What's Next?

This lesson sets the stage for deeper concepts in Scala's functional programming model. The next video in the series transitions from OOP into **purely functional paradigms**, further evolving the developer's perspective and capabilities in the Scala ecosystem.

---

🔗 **Explore More**:  
Visit [Rock the JVM](https://rockthejvm.com/) to access full courses, tutorials, and hands-on exercises to master Scala and functional programming.
