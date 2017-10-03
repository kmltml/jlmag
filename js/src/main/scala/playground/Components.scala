package playground

import jlmag.Tag
import jlmag.utils.Vec2

import scala.util.Random

trait Components { this: Playground =>

  class Brownian extends Component {
    override def update(): Unit = {
      parent.component[Position].position += Vec2(Random.nextInt(3) - 1, Random.nextInt(3) - 1)
    }
  }
  object Brownian {
    implicit val tag: Tag[Brownian] = Tag.create
  }

  class Controlled extends Component {
    override def update(): Unit = {
      parent.component[Position].position += Vec2(input.x.value, input.y.value)
    }
  }

}
