import com.jichao.leetcode.P215_KthLargestElement
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/20/2017.
  */
class P215_KthLargestElementTest extends FunSuite{
  test("k largest") {
    var nums = Array(6,5,4,3,2,1)
    assert( P215_KthLargestElement.Solution.findKthLargest(nums, 1) == 6 )
    assert( P215_KthLargestElement.Solution.findKthLargest(nums, 2) == 5 )

    nums = Array(-1, 2, 0)
    assert( P215_KthLargestElement.Solution.findKthLargest(nums, 2) == 0 )




  }

}
