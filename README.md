# leetcode-scala
Leetcode scala

# Scala warm-up:
* https://jaxenter.com/cheat-sheet-complete-guide-scala-136558.html
* http://rea.tech/java-to-scala-cheatsheet/
* https://alvinalexander.com/downloads/scala/Scala-Cheat-Sheet-devdaily.pdf
* https://github.com/lampepfl/progfun-wiki/blob/gh-pages/CheatSheet.md
* https://mbonaci.github.io/scala/
* https://docs.scala-lang.org/cheatsheets/


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
* Scala的视角不一样，更多地是从数学角度，而不是计算机（CPU, 内存操作）角度。Scala的Seq就被建模为一种自然数到元素类型集合的PartialFunction(部分函数, 标准的译法是偏函数）。题外话，很多时候，你都要去看一样英文的数学概念，才能更好的理解Scala, 中文的数学概念翻译都不准确，偏函数，偏序关系，都很难从字面理解，而英文中，就是partial function, total function, partial order, total order，从字面意思上就能很好的理解，不是所有的元素又有对应的函数或者序关系，就是部分函数或者部分序关系，所以，花精力看英文的数学概念解释是有必要的。 回归正题，将Seq建模为部分函数PartialFunction[Int, B], 你就比较容易理解Seq数据结构怎样通过下标访问：seq(n).而在C及类似语言中，我们的思想都类似数组，数组的访问其实是数组的内存地址加上index * sizeof(lementType)。所以，C语言的开发者，一开始还是很难适应的。
* 不要mutable，用了mutable，就会倾向于老式的思想。
* 不用Break, 用takeWhile可以替代。
