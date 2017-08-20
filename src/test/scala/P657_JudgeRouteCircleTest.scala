import com.jichao.leetcode.P657_JudgeRouteCircle
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/14/2017.
  */

class P657_JudgeRouteCircleTest extends FunSuite {
  test("Judge Circle test") {
    var moves = "LL"
    assert(!P657_JudgeRouteCircle.judgeCircle(moves))

    moves = "LLRR"
    assert(P657_JudgeRouteCircle.judgeCircle(moves))
  }
}

