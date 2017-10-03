package jlmag

import scala.collection.mutable

trait InputHandling extends BaseGame { this: InputData =>

  abstract override def _update(): Unit = {
    input.update()
    super._update()
  }

  val input: Input

  class Input {

    class Axis private[Input](left: Button, right: Button) {

      private[Input] var _value: Double = 0
      def value = _value

      private[Input] def update(): Unit = {
        _value =
          if(left.down) -1
          else if(right.down) 1
          else 0
      }

    }

    class Button private[Input](code: Int) {
      private var _down = false
      def down = _down

      private[Input] def install(): Unit = {
        onDown { i =>
          if(i == code) {
            _down = true
          }
        }
        onUp { i =>
          if(i == code) {
            _down = false
          }
        }
      }
    }

    private val axes: mutable.Buffer[Axis] = mutable.Buffer.empty

    def button(code: Int): Button = {
      val btn = new Button(code)
      btn.install()
      btn
    }

    def axis(l: Button, r: Button): Axis = {
      val ax = new Axis(l, r)
      axes += ax
      ax
    }

    private[InputHandling] def update(): Unit = axes.foreach(_.update())

  }

}

trait InputData {
  def onDown(f: Int => Unit): Unit
  def onUp(f: Int => Unit): Unit
}