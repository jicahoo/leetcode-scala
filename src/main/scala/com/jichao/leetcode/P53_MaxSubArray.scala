package com.jichao.leetcode

/**
  * Created by zhangj52 on 8/22/2017.
  */
object P53_MaxSubArray {
  object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
      var result = Int.MinValue
      var maxSumToIndex = Int.MinValue

      for (i <- nums) {
        maxSumToIndex = (if(maxSumToIndex < 0) Int.MinValue else (maxSumToIndex + i)) max i
        if (result < maxSumToIndex) {
          result = maxSumToIndex
        }
      }
      result
    }
  }

}
