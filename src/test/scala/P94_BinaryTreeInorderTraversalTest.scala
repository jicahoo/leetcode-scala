import com.jichao.leetcode.P94_BinaryTreeInorderTraversal
import org.scalatest.FunSuite

/**
  * Created by zhangj52 on 8/20/2017.
  */
class P94_BinaryTreeInorderTraversalTest extends FunSuite {
  test("Preorder ") {
    val root = new P94_BinaryTreeInorderTraversal.TreeNode(1)
    val left = new P94_BinaryTreeInorderTraversal.TreeNode(2)
    val right = new P94_BinaryTreeInorderTraversal.TreeNode(3)
    root.left = left
    root.right = right
    assert(P94_BinaryTreeInorderTraversal.Solution.inorderTraversal(root) == List(2,1,3))

  }
}
