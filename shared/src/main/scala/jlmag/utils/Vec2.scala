package jlmag.utils

case class Vec2(x: Double, y: Double) {

  def +(b: Vec2): Vec2 = Vec2(x + b.x, y + b.y)
  def -(b: Vec2): Vec2 = Vec2(x - b.x, y - b.y)
  def *(s: Double): Vec2 = Vec2(x * s, y * s)
  def /(s: Double): Vec2 = this * (1 / s)

  def unary_- = Vec2(-x, -y)

  def lengthSq: Double = x*x + y*y
  def length: Double = math.sqrt(lengthSq)

}

object Vec2 {

  val Zero = Vec2(0, 0)

  val X = Vec2(1, 0)
  val Y = Vec2(0, 1)

}