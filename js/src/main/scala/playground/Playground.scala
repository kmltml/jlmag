package playground

import jlmag.{BaseGame, CommonComponents, InputHandling, RenderComponents}
import jlmag.render.{CanvasRenderer, HasRenderer}
import jlmag.utils.Vec2
import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode

import scala.util.Random

class Playground extends BaseGame
  with HasRenderer
  with CommonComponents
  with RenderComponents
  with Components
  with InputHandling {

  override type Renderer = CanvasRenderer
  override type Game = this.type

  override val renderer = CanvasRenderer(dom.document.getElementById("main-canvas").asInstanceOf[dom.html.Canvas])

  object input extends Input {
    val x = axis(button(KeyCode.Left), button(KeyCode.Right))
    val y = axis(button(KeyCode.Up), button(KeyCode.Down))
    val reset = button(KeyCode.Space)
  }

  def newEntity() = {
    val e = new Entity(this)
    e += new Position(Vec2(Random.nextInt(800), Random.nextInt(600)))
    e += new Sprite(renderer.loadTexture("tex/test.png"), Vec2(50, 50))
    e += new Controlled
    entities += e
    e
  }

  def init(): Unit = {
    for(_ <- 0 until 500) {
      newEntity()
    }
  }

  override def preDraw(): Unit = {
    renderer.clean(255, 255, 230)
  }

}

object Playground {

  def main(args: Array[String]): Unit = {
    new Playground().run()
  }

}
