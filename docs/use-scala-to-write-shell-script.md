# Use Scala to write shell script
* 使用scala和命令行工具计算scala源文件的单词数量
```scala
import sys.process._
val wordSize = "find . -name *.scala".!!.split("\n").flatMap( x => s"cat $x".!!.split("""\s+|\n""")).length
```
