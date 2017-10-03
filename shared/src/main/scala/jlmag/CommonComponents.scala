package jlmag

import jlmag.utils.Vec2

trait CommonComponents { this: BaseGame =>

  class Position(var position: Vec2 = Vec2.Zero) extends Component
  object Position {
    implicit val tag: Tag[Position] = Tag.create
  }

}
