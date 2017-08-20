package com.jichao.leetcode

import scala.collection.mutable

/**
  * Created by zhangj52 on 8/20/2017.
  */
object P144_BinaryTreePreorderTraversal {

  // Definition for a binary tree node.
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  object Solution {
    def preorderTraversal(root: TreeNode): List[Int] = {
      //TODO: wrong it is in order.
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
