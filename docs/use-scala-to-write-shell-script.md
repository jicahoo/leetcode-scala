# Use Scala to write shell script
* 使用scala和命令行工具计算scala源文件的单词数量
```scala
import sys.process._
val wordSize = "find . -name *.scala".!!.split("\n").flatMap( x => s"cat $x".!!.split("""\s+|\n""")).length
```

* 将scala的字符串通过标准输入的形式传给命令。
```scala
import sys.process._
val x = Process("xargs").#<(new ByteArrayInputStream("xxx".getBytes))
println(x !!)
```

* 使用管道
```scala
("cat README.md" #| "grep 1" #| "wc -l").!!.trim
```

* 同时获取返回码和输出
```scala
import sys.process._
var output = ""
val logger = ProcessLogger(x => output += x)
val status = Process("ls -l").!(logger)
(status, output)
```

* 异常处理
* TODO
