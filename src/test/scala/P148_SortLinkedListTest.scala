import com.jichao.leetcode.P148_SortLinkedList
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/19/2017.
  */
class P148_SortLinkedListTest extends FunSuite {

  test("Function merge") {
    var left, leftTail = new P148_SortLinkedList.ListNode(40)
    var right, rightTail = new P148_SortLinkedList.ListNode(30)
    var merged = P148_SortLinkedList.Solution.merge(left, right)
    assert(merged.x == 30)
    assert(merged.next.x == 40)

    assert(null == P148_SortLinkedList.Solution.merge(null, null))

    var leftCase3, leftTailCase3 = new P148_SortLinkedList.ListNode(40)
    merged = P148_SortLinkedList.Solution.merge(leftCase3, null)
    assert(merged.x == 40)
    assert(merged.next == null)

    var right4, rightTail4 = new P148_SortLinkedList.ListNode(30)
    merged = P148_SortLinkedList.Solution.merge(null, right4)
    assert(merged.x == 30)
    assert(merged.next == null)
  }

  test("Function split") {
    val node = new P148_SortLinkedList.ListNode(0)
    var head, tail = node
    for (i <- 1 to 10) {
      val node = new P148_SortLinkedList.ListNode(i)
      tail.next = node
      tail = node
    }

    var (left, right) = P148_SortLinkedList.Solution.split(head)
    for (i <- Range(0, 12, 2)) {
      assert(left.x == i)
      left = left.next
    }

    for (i <- Range(1, 10, 2)) {
      assert(right.x == i)
      right = right.next
    }


  }

  test("Test sortList") {
    val node = new P148_SortLinkedList.ListNode(0)
    var head, tail = node
    for (i <- Range(10, 0, -1)) {
      val node = new P148_SortLinkedList.ListNode(i)
      tail.next = node
      tail = node
    }
    var sorted = P148_SortLinkedList.Solution.sortList(head)
    for (i <- 0 to 10) {
      assert(sorted.x == i)
      sorted = sorted.next
    }

  }

}
