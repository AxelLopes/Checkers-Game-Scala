package Board

import java.awt.{Color, Dimension}

import scala.swing.{Button, Component, GridPanel, Label, ToggleButton}

class BoardGame {

  var buttonMap = collection.mutable.Map[(Int,Int), Button]() //Map pour récupérer tous les boutons et les associer à une position (x,y)




  //CREATION DU PLATEAU DE JEU
  var gridPanel = new GridPanel(10, 10) {
    val s = new Dimension(600, 600)
    background = Color.white
    preferredSize = s
    minimumSize = s
    maximumSize = s
    var i = 1
    var j = 1

    while (i <= 10) {
      while (j <= 10) {
        if (i % 2 == 0) {
          val bouton = new Button{
            background = Color.black
            enabled = true
            tooltip = "Click to choose this pawn"
          }
          buttonMap += ((i, j) -> bouton)
          contents += buttonMap(i,j)
          //listenTo(buttonMap(i,j))
          j += 1
          contents += new Label("     ")
          j += 1
        } else {
          contents += new Label("     ")
          j += 1
          val bouton = new Button {
            background = Color.black
            enabled = true
            tooltip = "Click to choose this pawn"
          }
          buttonMap += ((i, j) -> bouton)
          contents += buttonMap(i,j)
          //listenTo(buttonMap(i,j))
          j += 1
        }
      }
      i += 1
      j = 1
    }
  }





  ////PLACEMENT DES PIONS
  def PlacePawns {
    var i = 1
    var j = 1
    while (i <= 4) {
      j = 1
      if (i % 2 == 1) {
        j += 1
      }
      while (j <= 10) {
        buttonMap((i, j)).background = Color.magenta
        j += 2
      }
      i += 1
    }
    j = 1
    i = 7
    while (i <= 10) {
      j = 1
      if (i % 2 == 1) {
        j += 1
      }
      while (j <= 10) {
        buttonMap((i, j)).background = Color.cyan
        j += 2
      }
      i += 1
    }
  }

}