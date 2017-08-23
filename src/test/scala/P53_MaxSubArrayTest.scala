import com.jichao.leetcode.P53_MaxSubArray
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/22/2017.
  */
class P53_MaxSubArrayTest extends FunSuite {
  test (" [-1] ") {
    assert(P53_MaxSubArray.Solution.maxSubArray(Array(-1)) == -1)
  }

  test("[-2,1,-3,4,-1,2,1,-5,4]") {
    assert(P53_MaxSubArray.Solution.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)) == 6)
  }
}
