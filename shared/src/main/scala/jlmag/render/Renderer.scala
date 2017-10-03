package jlmag.render

import jlmag.BaseGame
import jlmag.utils.Vec2

trait Renderer {

  type Texture

  def drawTexture(tex: Texture, pos: Vec2, size: Vec2): Unit

  def clean(r: Int, g: Int, b: Int): Unit

}

trait HasRenderer { this: BaseGame =>

  type Renderer <: jlmag.render.Renderer

  val renderer: Renderer

}