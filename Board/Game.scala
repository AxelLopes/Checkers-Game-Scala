package Board

import java.awt.Color

import scala.swing
import scala.swing.Button

class Game {
/*
  def IsLegal(start : (Int,Int) , destination : (Int,Int)):Boolean =  {
    match destination {
      case (((destination._1  || destination._2)<1)||((destination._1  || destination._2)>10)) => false
    }

  }
*/
  def IsTaken(square : Button): Boolean = {
    return (square.background!= Color.black)
  }

//Out of board nécessaire?

  def IsAlly(square : Button): Boolean = {
    return(square.background==Color.cyan)
  }
  /*
    def legalPawnMove(start: (Int, Int), destination : (Int,Int)): Boolean = {
      return (destination._1 == start._1+1 && (destination._2 == start._2-1 || destination._2 == start._2+1))
    }


  def legalPawnMoves(jeu : BoardGame) : List[(Int,Int)] = {
  val cases = (1 to 10).toList.map(i => (1 to 10).toList.map(x => (i,x))).foldRight(List[(Int,Int)]()) {(xs,ys) => xs ::: ys}
  cases.filter({x => legalPawnMove(x)}).toList
}
*/



}
