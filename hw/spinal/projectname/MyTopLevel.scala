package projectname

import spinal.core._
import spinal.lib._

case class P() extends Bundle with IMasterSlave {
  val a = Bool()
  override def asMaster(): Unit = {
    in(a)
  }
}

case class MyTopLevel() extends Component {
  val p = slave(P())
  p.a := True
}

object MyTopLevelVerilog extends App {
  Config.spinal.generateVerilog(MyTopLevel())
}

object MyTopLevelVhdl extends App {
  Config.spinal.generateVhdl(MyTopLevel())
}
