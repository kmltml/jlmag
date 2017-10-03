package jlmag

class Component[Game <: BaseGame] {

  private var _parent: Option[Entity[Game]] = None
  def parent: Entity[Game] = _parent.get
  def parent_=(newParent: Option[Entity[Game]]): Unit = {
    if(_parent != newParent) {
      _parent.foreach(detach)
      _parent = newParent
      _parent.foreach(attach)
    }
  }
  def parentOpt: Option[Entity[Game]] = _parent

  def draw(): Unit = ()
  def update(): Unit = ()

  protected def detach(entity: Entity[Game]): Unit = ()
  protected def attach(entity: Entity[Game]): Unit = ()

}
