package com.jichao.leetcode

/**
  * Created by zhangj52 on 8/20/2017.
  */
object P94_BinaryTreeInorderTraversal {

  // Definition for a binary tree node.
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  import scala.collection.mutable

  object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {

      val list = new mutable.ListBuffer[Int]()
      var stack = List[TreeNode]()
      var curRoot = root
      while (curRoot != null || stack.nonEmpty) {
        while (curRoot != null) {
          stack = curRoot :: stack
          curRoot = curRoot.left
        }
        if (stack.nonEmpty) {
          val topNode = stack.head
          list += topNode.value
          curRoot = topNode.right
          stack = stack.tail
        }
      }
      list.toList
    }
  }


}
