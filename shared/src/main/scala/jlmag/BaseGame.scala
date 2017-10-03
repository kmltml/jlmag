package jlmag

import scala.collection.mutable
import org.scalajs.dom

abstract class BaseGame {

  type Game <: BaseGame

  type Entity = jlmag.Entity[Game]
  val Entity = jlmag.Entity

  type Component = jlmag.Component[Game]


  var running = true

  val entities: mutable.Set[Entity] = mutable.Set.empty

  def init(): Unit

  def preDraw(): Unit = ()

  def _update(): Unit = update()
  def update(): Unit = ()

  private def step(): Unit = {
    entities.foreach(_.update())
    preDraw()
    entities.foreach(_.draw())
    if(running) {
      dom.window.requestAnimationFrame(_ => step())
    }
  }

  def run(): Unit = {
    init()
    step()
  }

}
