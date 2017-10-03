package jlmag
package render

import jlmag.utils.Vec2
import org.scalajs.dom

class CanvasRenderer(ctxt: dom.CanvasRenderingContext2D) extends Renderer {

  override type Texture = dom.html.Element

  override def drawTexture(tex: Texture, pos: Vec2, size: Vec2): Unit = {
    ctxt.drawImage(tex, pos.x, pos.y, size.x, size.y)
  }

  override def clean(r: Int, g: Int, b: Int): Unit = {
    ctxt.save()
    ctxt.fillStyle = s"rgb($r, $g, $b)"
    ctxt.fillRect(0, 0, 90000, 90000) // TODO make this sane
  }

  def loadTexture(path: String): Texture = {
    val img = dom.document.createElement("img").asInstanceOf[dom.html.Image]
    img.src = path
    img
  }

}

object CanvasRenderer {

  def apply(canvas: dom.html.Canvas): CanvasRenderer =
    new CanvasRenderer(canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D])

}