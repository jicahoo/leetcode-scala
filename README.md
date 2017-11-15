# leetcode-scala
Leetcode scala

## Scala的世界观
* Scala是如何看待编程和其中的问题的。Scala的目标，Scala的手段，Scala的效果。
* 能在编译期做的约束和检查，就不要延迟到运行时。例如，ADT

## 自己一点练习，总结理论，是不是有些效率低下，还是找一本书（无论线上和线下）通读一遍，效率更高，做练习，搜索，通读，做练习，搜索，通读，不断演进，学得更快。

# Scala warm-up:
* https://jaxenter.com/cheat-sheet-complete-guide-scala-136558.html
* http://rea.tech/java-to-scala-cheatsheet/
* https://alvinalexander.com/downloads/scala/Scala-Cheat-Sheet-devdaily.pdf
* https://github.com/lampepfl/progfun-wiki/blob/gh-pages/CheatSheet.md
* https://mbonaci.github.io/scala/
* https://docs.scala-lang.org/cheatsheets/
## Keywords or tags
* 列表解析式
* 函数一等公民
* 鸭子类型
* 尾递归
* 代数类型
* 模式匹配
* 伴生对象
* Non-Strict (lazy), Strict, WithFilter. 
* 不可变性
* 闭包
* Monad
* 类型系统

## Scala 最佳实践
* https://github.com/alexandru/scala-best-practices

## Scala异步编程
* https://alexn.org/blog/2017/01/30/asynchronous-programming-scala.html
* https://github.com/scala/scala-async


## 代数数据类型
* https://scalerablog.wordpress.com/2016/10/03/algrebraic-data-types-in-scala/
* https://wiki.haskell.org/Algebraic_data_type
* https://pawelwlodarski.gitbooks.io/functional-programming/content/

## Scala的坑
* http://docs.scala-lang.org/tutorials/FAQ/yield.html 的最后部分，Range(1,10).xxx 和 List(1,10).xxx 会返回不同的结果。
* 对于FP的批判：http://queue.acm.org/detail.cfm?ref=rss&id=2611829&utm_content=bufferb88da 貌似作者挑一个奇怪的例子，不一定站得住脚。

## 非常有用的资料
* http://docs.scala-lang.org/tutorials/FAQ/index.html
* http://docs.scala-lang.org/overviews/core/architecture-of-scala-collections.html 对于Scala Collection 架构的官方介绍。
* https://twitter.github.io/scala_school

## 闭包
* 闭包没什么，闭包可以做的事情，你创建个类一样，可以做。闭包，有些时候，你的函数依赖于外部变量，你就学要他。如果，不支持，写程序就比较麻烦。
* https://www.artima.com/pins1ed/functions-and-closures.html
* 持续理解
* 我造个例子,  你有账户的钱用一个变量表示。有人不停的给你转账，1万，2万，3万...,你的加到你的账户里。
```scala
scala> var myMoney = 100
myMoney: Int = 100

scala> def addMoney(more:Int) = {myMoney += more }     //这就是个闭包，负责给我加钱的逻辑
addMoney: (more: Int)Unit

scala> Range(1,10).foreach{  addMoney(_) }

scala> myMoney  //钱到帐了，哈哈
res27: Int = 145
```
× 如果闭包抓到的是val, 是没有多大意思的，和普通函数没区别。
* 关键的问题，为什么不把这个变量以参数的形式传进去。上面的例子是，我传进去是达不到效果的。
* 程序的本质就是如何组织数据和计算逻辑，而计算逻辑和数据是要交互，计算逻辑是要依据数据做计算，并改变数据。所以，闭包就是和数据联系起来的计算逻辑，类也是将数据和计算联系起来了，只是出发点不同，类的角度是带有计算逻辑的数据，从数据出发，所以，类先有变量成员，再有方法成员；而闭包是带有数据的计算逻辑，从函数出发。JavaScript就可以用闭包来模拟面向对象的特性。会JavaScript的人更能深刻理解闭包。(找JavaScript的人求证？)
* 闭包能做的事情，用其他工具或者概念也能做，只是会比较麻烦。期待举个例子？

## 模式匹配与ADT，偏函数，函数组合
* Refer: https://pawelwlodarski.gitbooks.io/functional-programming/content/workshop_-_adt.html
* 可以做模式匹配的类型：原始类型，case class, ADT. apply & unapply?
* https://twitter.github.io/scala_school/pattern-matching-and-functional-composition.html CASE语句的本质是偏函数和函数组合(function compose). 因为是偏函数，所以，case语句的语法是 case <sub_set_value_pattern> => <return_value>，符合函数的定义方式。(Int) => String
```scala
//一个函数定义的例子。
val addOne:(Int) => Int = (e:Int) => e + 1
```

```scala
//Twitter scala school的例子
scala> val one: PartialFunction[Int, String] = { case 1 => "one" }
one: PartialFunction[Int,String] = <function1>

scala> one.isDefinedAt(1)
res0: Boolean = true

scala> one.isDefinedAt(2)
res1: Boolean = false
```
## 概括Scala的资料
* 前言: http://scala-lang.org/files/archive/spec/2.12/

## 列表解析式是如何工作的
* http://docs.scala-lang.org/tutorials/FAQ/yield.html

## 概念定义或体系
* 把函数理解为一个计算逻辑。或者就理解为数学上的函数定义。集合->映射->函数. 不管，你具体怎么做的，只要映射一致，你们就是相同的函数。所以，函数更关心结果不关心过程。

* 函数可以认为是一个计算逻辑。特例，表达式

## 编程语言研究方法论
* 静态分析。
 * 直接看DevelopmentKit的源代码。
 * 看背后思想，发展历史。
 * 搞清楚语言内核
 * 和其他相关语言，对比分析
 * 编译后指令的查看
 
* 动态分析
 * Debug.
 * **println/log. println 是利器。能比较快捷和清除地搞清楚我们所关系的执行顺序，某个执行点的上下文（相关变量的值）** 例如,https://alvinalexander.com/scala/examples-shows-differences-between-strict-lazy-evaluation-in-scala
 * Performance
 * 练习体会
 * 实际项目

## Scala编译成了什么指令？
* scalac -print
* javap 


## 思想或者目标
* 减少程序的复杂度，让编译器做更多工作。
* 函数式编程的一些概念和设计，譬如说，不变量，无副作用的函数，这是对函数和值引用的一些约束，有了这些约束，一方面，人就更容易推理或者预测程序的行为；另一方面，这些约束也可以为机器所利用，有了这些约束，某些计算是不是可以并行计算。
* 函数作为一等公民也可以减少复杂度？

## Scala
* http://exercism.io/exercises/scala/sieve/readme
* http://exercism.io/submissions/0edc95b2e4a84d61a02942b52914d20c
* 在做sieve这道题的时候，学习到了一些简单的东西。我的解决方案还是老式的思想，脑子有个数组，然后，循环访问这个标记数组；虽然用到的takeWhile, 但总觉得别扭。
* 不用老式的for/while循环思想，Scala中，就是以流或者序列(Seq)为起点，做各种变换和计算。在序列上，可以有各种各样的操作模式
  * 序列的模式匹配，x::xs. 序列的分解
  * 取序列的某些部分
    * head,tail,init
    * takeWhile
  * 略过序列的前面某些部分：
    * drop(n)
    * dropWhile()
  * 与index相关的操作
    * indexWhile
  * fold操作, 遍历的过程中，计算并记住一些与已扫描元素的结果，与reduce有何区别？至少，reduceLeft是foldLeft的特例。foldLeft是要提供初始元素的。
  * slibing. 固定窗口大小滑动，依次计算。
  * groupBy. Like SQL group by.
  * 产生无限序列：Stream.from(1)
  
* Scala的视角不一样，更多地是从数学角度，而不是计算机（CPU, 内存操作）角度。Scala的Seq就被建模为一种自然数到元素类型集合的PartialFunction(部分函数, 标准的译法是偏函数）。题外话，很多时候，你都要去看一样英文的数学概念，才能更好的理解Scala, 中文的数学概念翻译都不准确，偏函数，偏序关系，都很难从字面理解，而英文中，就是partial function, total function, partial order, total order，从字面意思上就能很好的理解，不是所有的元素又有对应的函数或者序关系，就是部分函数或者部分序关系，所以，花精力看英文的数学概念解释是有必要的。 回归正题，将Seq建模为部分函数PartialFunction[Int, B], 你就比较容易理解Seq数据结构怎样通过下标访问：seq(n).而在C及类似语言中，我们的思想都类似数组，数组的访问其实是数组的内存地址加上index * sizeof(lementType)。所以，C语言的开发者，一开始还是很难适应的。
* 不要mutable，用了mutable，就会倾向于老式的思想。
* 不用Break, 用takeWhile可以替代。
* 递归的思想，函数编程更喜欢递归，正常情况下，C语言的递归也无副作用。递归的这种特征和函数编程很一致。是吗？

## exercism scala
### 2017/11/01 心得
* 今天，我又刷了题目http://exercism.io/tracks/scala/exercises/meetup, 记一下刷后感。
* 在Debug的时候，发现IntelliJ IDEA可以在匿名函数处设置断点，譬如说，list.find(\_ > 0)，那么，就可以在 \_ > 0处设置断点。
* Range.slice 和 List.slice 是不一样的，前者是lazy的，后者是eager的
* List.withFilter是lazy的，返回值具有FilterMondadic trait. withFilter就可以组合了: https://alvinalexander.com/scala/examples-shows-differences-between-strict-lazy-evaluation-in-scala
```scala
object Test1WithFilterLazy extends App {

    def lessThan30(i: Int): Boolean = {
        println(s"\n$i less than 30?")
        i < 30
    } 

    def moreThan20(i: Int): Boolean = {
        println(s"$i more than 20?")
        i > 20
    } 

    val a = List(1, 25, 40, 5, 23)
    val q0 = a.withFilter(lessThan30)
    val q1 = q0.withFilter(moreThan20)
    for (r <- q1) println(s"$r")

}
```
### lunh
* http://exercism.io/exercises/scala/luhn/readme
* Scala如何比较简单地实现这个功能：在一个List[Char]中，如果第一个元素的值为'0', 就去掉它？

## Scala中常用的缩写
* x 单个元素，可能与数学有关。y=f(x)
* xs 多个元素, 一般是list.tail的部分
* p: predicate 常做参数名称。
* c: collection

## Scala的类型系统
* Scala AnyRef == Java Object ( In Scala, Any <- AnyRef, Any <- AnyVal)
* http://chariotsolutions.com/wp-content/uploads/2016/04/HeatherMiller.pdf
* 顺便复习了一下，Java的super和extends. 举例说明，  <? entends Number> 代表是**某个**继承自Number的类，<? super NaturalNumber>代表的是Number的某个祖先类，可能是父类，也可能是父类的父类。两者的区别
 * <? extends Number>你可以想象成树结构，以Number为子节点的树结构。 ? 是集合 {Number, Number的子节点}中的某个元素，?的取值空间就是一个树形结构。List<? extends Number>存放的一定是Number某个子类，你不能往里存新的元素，因为从<? extends Number>这个说明中，你无从得知它里面具体是什么类。但你取出的元素满足约束：它一定是Number的子类，你可以按照Number的方式操作其中的元素，消费其中的元素。读出的东西有保证，有约束；无法确定什么类型的可以写入。
 * <? super NaturalNumber>你可以想象成线性结构或者说一条直线, 是由NaturalNumber祖先构成的直线。?是集合{NaturalNumber, NaturalNumber的祖先节点}中的某个元素。?的取值空间就在一条直线上。所以,?的取值一定是自身或者祖先，那么， NaturalNumber一定是?的子类。所以说，NaturalNumber类型的对象一定能放入到List<? super NaturalNumber>中。 读出的东西没有保证和约束，可能是任意的祖先节点；但是，写入NaturalNumber的时候，能够保证可以，因为具体类型是其某个祖先。
 
 * 一个经典例子
 ```java
 //https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
 public class Collections { 
  public static <T> void copy(List<? super T> dest, List<? extends T> src) {
      for (int i = 0; i < src.size(); i++) 
        dest.set(i, src.get(i)); 
  } 
}
 ```
 * twitter scala school 列举了类型系统的相关主题：递归类型，结构类型（其实就是鸭子类型，用到了反射，注意性能）
 ```text
Type & polymorphism basics
Basic Types and type polymorphism, type inference, variance, bounds, quantification
Advanced types
Advanced Types, view bounds, higher-kinded types, recursive types, structural types
 ```

## Map
* map.getOrElse() 解决在构建Map时的常见痛点。

## 请问函数作为一等公民有那些体现？
* 函数可以作为参数。
* compose 函数和函数间的运算。
* curry. 函数可以按参数分解或者说降维，编程某些参数固定的函数。
* 偏函数。可以和currying类比， currying是去掉一个维度，偏函数是减去一些参数类型值的集合的子集。case语句的本质就是偏函数。
* 举个例子，
```scala
object TryScala {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val x = (1 to 10).map(add(1)).map(square)
    val y = (1 to 10).map(square _ compose add(1))
    println(x)
    println(y)
    println(s"x == y? ${x==y}")
  }

  def add(x: Int)(y: Int): Int = {
    println(s"$x + $y")
    x + y
  }

  def square(x: Int): Int = {
   println(s"$x*$x")
    x * x
  }
}
```


## for-comprehension
* TODO

## 刷了个难题
* http://exercism.io/tracks/scala/exercises/simple-linked-list
* Nothing的作用:
    * Nothing在构造一些零元的时候非常重要。没有Nothing你是无法构造零元。最好的例子就是Nil就是List[T]的零元。Nil是一个object，类型是List[Nothing]. 而List是协变的, 所以，Nil可以看作是任何类型T对应的List[T]的子类的实例。所以，你做操作, 1::Nil, "AA"::Nil都是合理。这就是零元，他要和相关的任何类型都能兼容。在这个设计中，如果没有Nohting，你是不可以构造出零元的。而零元是什么，为什么需要这个元，请看下一节的解释。
    * 之所以需要零元，因为函数式编程语言常常用递归来构造数据结构，而递归的终点就是零元。上面说的List[T]就是一个例子, List[T]的定义就是递归的。但任何递归总有结束的时候，List的递归就是要到一个空的List.而空的List就是递归的终点，就是我的Nil.

## 类型系统，面向对象
### 鸭子类型
* https://dzone.com/articles/duck-typing-scala-structural
### 协变
* https://en.wikipedia.org/wiki/Covariance_and_contravariance_(computer_science)
* 协变，逆变的意义:
    * 类型兼容（安全），代码重用。
    * 什么叫类型兼容？ 从某个视角看，你就是这个类型。比如说，有个方法的签名是 int cacluateWeight(Animal a).如果Cat extends Animal. 那么方法的调用cacluateWeight(new Cat())是能够运行的。 A<:B的内涵就是 如果在某些计算逻辑中，使用了B的引用，如果把这些B的引用换成A的引用，也是合理的。在讨论协变或者逆变的时候，当你被眼花缭乱的解释或者理论说明绕晕时，你就可以使用这个基本原则。
   * 此处，我们就是用这个基本原则，去看一下函数的参数的逆变和返回值的协变。在下面的例子中，childFunc是可以赋值给parentFunc, childFunct可以从parentFunc的类型的视角看待，也就是Function1[Animal, Rectangle] <: Function1[Cat, Shape]. 根据上面的原则，我们可以人为，在某些计算逻辑中，使用了parentFunc的引用，我们把它换成childFunc的引用也是合理的。为什么合理呢？ 先从入参看，在替换之前，入参传入的肯定都是Cat类或者Cat子类的实例。如果替换成了childFunc, childFunc是以Animal这个视角来处理传入的实例的，而Cat或者Cat子类肯定能够以Animal的视角来处理，因为Cat的子类<:Cat <: Animal。所以，说函数类型的入参是逆变的。为什么不是协变的？协变是行不通的。假如是协变的，那么,就有结论Function1[Cat, Rectangle] <: Function1[Animal, Shape], 再套用上面的方法，如果某段逻辑使用了类型为Function1[Animal, Shape]的引用，我们尝试把这些引用替换为Function1[Cat,Rectangle]，那么，在替换之前，传入的参数是Animal的类型，替换之后是入参是Cat的类型，是按照Cat的视角去处理的，因为Cat是Animal的子类，Cat可能具有一些Animal并没有的方法，而Function[Cat,Rectangle]类新的函数正好调用这些Animal不具有的方法，那么，实际传入的可能是Animal类的实例，也可能是Cat的实例，也可能是Animal其他的子类的实例，如果传入的是非Cat的实例，那么，Function1[Cat,Rectangle]会调用入参类型所不具有而Cat具有的方法，这肯定是不安全的，所以说，函数的入参不可能是协变的，入参必须是逆变的。返回值的协变，可以用同样的方法分析出来。

```scala
private class Animal

private class Cat extends Animal

private class Shape

private class Rectangle extends Shape

object App {

  def main(args: Array[String]):Unit = {
    var parentFunc: Cat => Shape = (c: Cat) => new Shape
    var childFunc: Animal => Rectangle = (a: Animal) => new Rectangle
    parentFunc = childFunc
  }
}
```
### 继承trait
* trait与抽象类? (https://stackoverflow.com/questions/32958972/trait-vs-abstract-class-in-scala) Try scalac -print
 * extends trait  == extends object with trait
 * extends abstract clss == extends abstatract class extends object
 
## 并发
* synchronized.this 
* https://twitter.github.io/scala_school/concurrency.html

## 处理错误，Exception, == null, Not found.
## Class object-oriented.
* case class
* implicit class

## meta programming
* reflection
* metaprogramming
* quasi-quotation
* macro宏

## 工程性
* 适合多人合作
* 招人成本
* 社区成熟度，问题解决的成本，主流语言的问题，很容易从网上找到答案。

## 性能相关
* CPS 或 continuation 类似GOTO, 复杂易错，但是可以提高性能。我认为，非框架或者语言开发者，不应该使用，以为易错和复杂。
 * http://blog.bruchez.name/2011/09/continuations-in-scala.html 有益于基于事件的编程。 Contiunation 利用到了Closure.
 * CPS, continuation,好像已经过时(2017/11/13)，或者说没人维护，也没什么人使用。已被scala.async所替代，https://github.com/scala/scala-async。
 注意方向，**不要花在过时技术上**， 浪费时间。Akka用过CPS，但是已经被废弃。
* 宏是编译期行为，也可以通过宏提高性能

## scalaz
* 纯函数式扩展lib

## 单元测试
* scalatest
* scalacheck

## 基于Scala构建的产品
* Apache Spark让Scala名声大噪。Akka，用Actor Model构造高并发，容错，可伸缩的，自愈的，高性能的系统。
* Twitter和Linkin用Scala构造出一些很不错了产品。 LinkedIn的消息系统Kafka （据说代码写的漂亮, 主要还是Java,30%是Scala, 不过，core是scala写的）, Twitter的RPC调用框架Finagle.
* https://www.zhihu.com/question/28809372
* https://github.com/lauris/awesome-scala

## Scala与Python对比
没有买卖就没有杀害，没有对比就没有伤害。有对比，才能以批判的角度看待Scala。
* List按下标获取元素。 Python更方便。list.head vs list[0], list.tail vs list[1:], list.last vs list[-1], list.init vs list[:-1].

## Effective Scala (from twitter)
* http://twitter.github.io/effectivescala/
* http://twitter.github.io/scala_school/ 
