package jlmag

class Tag[A] private () {

  override def equals(that: Any): Boolean = that match {
    case that: Tag[_] => this eq that
    case _ => false
  }

}

object Tag {

  def apply[A](implicit tag: Tag[A]): Tag[A] = tag

  def create[A]: Tag[A] = new Tag[A]

}

class TaggedComponent[C](val component: C, val tag: Tag[C])
object TaggedComponent {
  implicit def create[C](component: C)(implicit tag: Tag[C]) =
    new TaggedComponent(component, tag)
}