package jlmag

import scala.collection.mutable

class Entity[Game <: BaseGame](val game: Game) {

  private val components = mutable.Map.empty[Tag[_], Component[Game]]

  def +=[C <: Component[Game] : Tag](component: C) = {
    val previous = components.put(implicitly[Tag[C]], component)
    previous.foreach(_.parent = None)
    component.parent = Some(this)
  }

  def component[C <: Component[Game] : Tag]: C =
    components(implicitly[Tag[C]]).asInstanceOf[C]

  def update(): Unit = {
    components.valuesIterator.foreach(_.update())
  }

  def draw(): Unit = {
    components.valuesIterator.foreach(_.draw())
  }

}

object Entity