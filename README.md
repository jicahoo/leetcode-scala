# leetcode-scala
Leetcode scala

# Scala warm-up:
* https://jaxenter.com/cheat-sheet-complete-guide-scala-136558.html
* http://rea.tech/java-to-scala-cheatsheet/
* https://alvinalexander.com/downloads/scala/Scala-Cheat-Sheet-devdaily.pdf
* https://github.com/lampepfl/progfun-wiki/blob/gh-pages/CheatSheet.md
* https://mbonaci.github.io/scala/
* https://docs.scala-lang.org/cheatsheets/

## 概念定义或体系
* 把函数理解为一个计算逻辑。或者就理解为数学上的函数定义。集合->映射->函数. 不管，你具体怎么做的，只要映射一致，你们就是相同的函数。所以，函数更关心结果不关心过程。

* 函数可以认为是一个计算逻辑。特例，表达式

## 编程语言研究方法论
* 静态分析。
 * 直接看DevelopmentKit的源代码。
 * 看背后思想，发展历史。
 * 搞清楚语言内核
 * 和其他相关语言，对比分析
 
* 动态分析
 * Debug.
 * **println/log. println 是利器。能比较快捷和清除地搞清楚我们所关系的执行顺序，某个执行点的上下文（相关变量的值）** 例如,https://alvinalexander.com/scala/examples-shows-differences-between-strict-lazy-evaluation-in-scala
 * Performance
 * 练习体会
 * 实际项目

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

## 2017/11/01 心得
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


## Scala中常用的缩写
* x 单个元素，可能与数学有关。y=f(x)
* xs 多个元素, 一般是list.tail的部分
* p: predicate 常做参数名称。
* c: collection

## Scala的类型系统
* Scala AnyRef == Java Object ( In Scala, Any <- AnyRef, Any <- AnyVal)
* http://chariotsolutions.com/wp-content/uploads/2016/04/HeatherMiller.pdf
* 顺便复习了一下，Java的super和extends. 举例说明，  <? entends Number> 代表是**某个**继承自Number的类，<? super NaturalNumber>代表的是Number的某个祖先类，可能是父类，也可能是父类的父类。两者的区别
 * <? extends Number>你可以想象成树结构，以Number为子节点的树结构。 ? 是集合 {Number, Number的子节点}中的某个元素，?的取值空间就是一个树形结构。List<? extends Number>存放的一定是Number某个子类，你不能往里存新的元素，因为从<? extends Number>这个说明中，你无从得知它里面具体是什么类。但你取出的元素满足约束：它一定是Number的子类，你可以按照Number的方式操作其中的元素，消费其中的元素。
 * <? super NaturalNumber>你可以想象成线性结构或者说一条直线, 是由NaturalNumber祖先构成的直线。?是集合{NaturalNumber, NaturalNumber的祖先节点}中的某个元素。?的取值空间就在一条直线上。所以,?的取值一定是自身或者祖先，那么， NaturalNumber一定是?的子类。所以说，NaturalNumber类型的对象一定能放入到List<? super NaturalNumber>中。 

## Map
* map.getOrElse() 解决在构建Map时的常见痛点。

## 请问函数作为一等公民有那些体现？
* 函数可以作为参数。
* compose 函数和函数间的运算。
* curry. 函数可以按参数分解或者说降维，编程某些参数固定的函数。
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

## 处理错误，Exception, == null, Not found.
## Class object-oriented.
* case class
* implicit class

## meta programming
* reflection
* metaprogramming
* quasi-quotation

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
