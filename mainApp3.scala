


import scala.swing.{Dimension, _}
import scala.swing.BorderPanel.Position._
import event._
import java.awt.{Color, Graphics2D}

import scala.util.Random
import java.awt.Dimension
import java.awt.image.BufferedImage
import java.io.File

import Board.BoardGame
import SimpleGUI.reactions
import javax.imageio.ImageIO
import javax.swing.{ImageIcon, KeyStroke}



object SimpleGUI extends SimpleSwingApplication {
  def top = new MainFrame { // top is a required method
    title = "Jeu de dames"

    /* val button1 = new Button {
      text = "Throw!"
      foreground = Color.blue
      background = Color.red
      borderPainted = true
      enabled = true
      tooltip = "Click to throw a dart"
    }*/
///////////////////MENUBAR
    size = new Dimension(300, 200)
    menuBar = new MenuBar {
      contents += new Menu("File") {

        contents += new MenuItem(new Action("Save") //sauvegarder la partie en cours
        {
          accelerator = Some(KeyStroke.getKeyStroke("ctrl S"))

          def apply {
            // Code pour sauver la partie?
          }
        })
        contents += new MenuItem(Action("Exit") { //quit the game
          sys.exit(0)
        })
        contents += new Separator
        val facile = new RadioMenuItem("Facile")
        val moyen = new RadioMenuItem("Moyen")
        val difficile = new RadioMenuItem("Difficile")
        val mutex = new ButtonGroup(facile, moyen, difficile)
        contents ++= mutex.buttons
        listenTo(facile)
        listenTo(moyen)
        listenTo(difficile)
      }
    }


    //IMAGE
    val blackpawn = new Label {
      icon = new ImageIcon("C:\\Users\\Administrator\\OneDrive - CY Cergy Paris Université\\Images\\black_pawn.png")
    }



    var B = new BoardGame
    B.PlacePawns
    //B.gridPanel



    //DISPOSITION DES ELEMENTS DE LA FENETRE
    contents = new BorderPanel {
      layout(B.gridPanel) = Center
      //layout(afficher) = East
    }


    B.buttonMap.values.foreach({ elem => listenTo(elem)})   //Listen to each button to associate events

    //case class ButtonClicked(source)
    reactions += {
      case ButtonClicked(component)  =>
        //println("ouch")
        component.background=Color.GRAY
        //println("Ouch tou m'as cliqué dessous")
        println(B.buttonMap.find(_._2 == component).map(_._1))    //get the key value associated to the button "component"
        val x = B.buttonMap.find(_._2 == component).map(_._1).unzip
        println(x._1.head)
        println(x._2.head)
        //println(B.buttonMap(t._1,t._2))
    }



    val result = B.buttonMap.keySet.toSeq.sorted
    // Displays output
    //println(result)

  }




}
