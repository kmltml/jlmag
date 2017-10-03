package jlmag

import jlmag.render.HasRenderer
import jlmag.utils.Vec2

trait RenderComponents { this: BaseGame with CommonComponents with HasRenderer =>

  class Sprite(texture: renderer.Texture, size: Vec2) extends Component {

    override def draw(): Unit =
      renderer.drawTexture(texture, parent.component[Position].position, size)

  }
  object Sprite {
    implicit val tag: Tag[Sprite] = Tag.create
  }

}
