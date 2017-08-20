package com.jichao.leetcode

import scala.collection.mutable

/**
  * Created by zhangj52 on 8/20/2017.
  */
object P215_KthLargestElement {

  object Solution {

    def findKthLargest(nums: Array[Int], k: Int): Int = {
      var lo = 0
      var hi = nums.length - 1
      val t = nums.length - k
      var j = -1
      while(lo < hi && (j != t)) {
        j = partition(nums, lo, hi)
        if (j < t) {
            lo = j + 1
        } else if (j > t) {
          hi = j - 1
        }
      }
      nums(t)
    }
    def partition(nums: Array[Int], lo: Int, hi: Int): Int = {
      var i = lo
      var j = hi + 1
      while(i < j) {
        while(i < hi && (nums({i+=1;i}) < nums(lo))) {}
        while(j > lo && (nums({j-=1;j}) > nums(lo))) {}
        if(i < j) {
          exchange(nums, i, j)
        }
      }
      exchange(nums, lo, j)
      j
    }

    def exchange(nums: Array[Int], i:Int, j:Int): Unit = {
      val temp = nums(i)
      nums(i) = nums(j)
      nums(j) = temp
    }


      //Solution 2:
    implicit object Ord extends Ordering[Int] {
      def compare(x: Int, y: Int) = y.compare(x)
    }

    def findKthLargestSolution2(nums: Array[Int], k: Int): Int = {
      var q = new mutable.PriorityQueue[Int]( )
      for ( i <- nums ) {
        q += i
        if (q.size > k) {
          q.dequeue()
        }
      }
      q.head
    }

    //Solution One: No need to build heap for all elements
    def findKthLargestSolution1(nums: Array[Int], k: Int): Int = {
      val q = new mutable.PriorityQueue[Int]()
      nums.foreach(q += _)
      var result:Int = 0
      for( i <- 0 until k) {
        result = q.dequeue()
      }
      result
    }
  }

}
