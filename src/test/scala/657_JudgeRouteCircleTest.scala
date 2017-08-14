import P657_JudgeRouteCircle.Solution
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/14/2017.
  */

class HelloTests extends FunSuite {
  test("Judge Circle test") {
    var moves = "LL"
    assert(!Solution.judgeCircle(moves))

    moves = "LLRR"
    assert(Solution.judgeCircle(moves))
  }
}

