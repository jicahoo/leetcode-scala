package com.jichao.leetcode

/**
  * Created by zhangj52 on 8/19/2017.
  */
object P148_SortLinkedList {

  // Definition for singly-linked list.
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  /**
    * It is similar with my java solution. But it always failed by Time Exceed. Why?
    */
  object Solution {
    def append(tailNode: ListNode, node: ListNode) = {
      tailNode.next = node
      val nodeNext = node.next
      node.next = null
      (node, nodeNext)
    }

    def merge(left: ListNode, right: ListNode): ListNode = {
      if (left == null) {
        return right
      }
      if (right == null) {
        return left
      }

      var p = left
      var q = right
      val fakeNode = new ListNode()
      var head, tail = fakeNode

      while (p != null && q != null) {
        if (p.x < q.x) {
          tail.next = p
          tail = p
          p = p.next
          tail.next = null
        } else {
          tail.next = q
          tail = q
          q = q.next
          tail.next = null
        }
      }

      while (p != null) {
        tail.next = p
        tail = p
        p = p.next
        tail.next = null
      }

      while (q != null) {
        tail.next = q
        tail = q
        q = q.next
        tail.next = null
      }
      head.next
    }

    def split(head: ListNode) = {
      val leftNode = new ListNode()
      var left, leftTail = leftNode
      val rightNode = new ListNode()
      var right, rightTail = rightNode
      var curNode = head
      var i = 0
      while (curNode != null) {
        val nextNode = curNode.next
        if (i == 0) {
          leftTail.next = curNode
          curNode.next = null
          leftTail = curNode
          i = 1
        } else {
          rightTail.next = curNode
          curNode.next = null
          rightTail = curNode
          i = 0
        }
        curNode = nextNode
      }
      (left.next, right.next)
    }

    def sortList(head: ListNode): ListNode = {
      if (head == null) {
        return null
      }
      //First time, I missed it.
      if (head.next == null) {
        return head
      }
      val (left, right) = split(head)
      val sortedLeft = sortList(left)
      val sortedRight = sortList(right)
      val mergeHead = merge(sortedLeft, sortedRight)
      mergeHead
    }
  }

}
