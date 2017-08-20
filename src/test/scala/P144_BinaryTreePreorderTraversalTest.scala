import org.scalatest.FunSuite
import com.jichao.leetcode.P144_BinaryTreePreorderTraversal

/**
  * Created by zhangj52 on 8/20/2017.
  */
class P144_BinaryTreePreorderTraversalTest extends FunSuite{
  test("Preorder ") {
    val root = new P144_BinaryTreePreorderTraversal.TreeNode(1)
    val left = new P144_BinaryTreePreorderTraversal.TreeNode(2)
    val right = new P144_BinaryTreePreorderTraversal.TreeNode(3)
    root.left = left
    root.right = right
    assert(P144_BinaryTreePreorderTraversal.Solution.preorderTraversal(root) == List(2,1,3))

  }

}
