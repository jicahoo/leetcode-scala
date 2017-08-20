package com.jichao.leetcode

object P657_JudgeRouteCircle {
    def judgeCircle(moves: String): Boolean = {
      val charCount = moves.groupBy(identity).mapValues(_.length)
      def extractSome(some : Option[Int]): Int = {
        some match {
          case Some(v) => v
          case _ => 0
        }
      }

      def countMove(move: Char):Int = {
        extractSome(charCount.get(move))
      }
      val leftMoves = countMove('L')
      val rightMoves = countMove('R')
      val upMoves = countMove('U')
      val downMove = countMove('D')
      leftMoves == rightMoves && upMoves == downMove
    }
  }
