package dev.rahugupt.polyline.context

import org.scalatest._
import flatspec._
import matchers._

class PolylineConverterSpec extends AnyFlatSpec with must.Matchers {

  it must "correctly convert default polyline string to standard polyline string" in {
    val standard = "}qdR}dje@Aoj|@}uyBAoj|@_vyB@"
    val default = "-ylT-lrmBCwr9B-26DCwr9Bg36DB"

    PolylineConverter.convert(standard, Standard) must be (default)

    PolylineConverter.convert(default, Default) must be (standard)
  }

  it must "correctly convert standard polyline string to default polyline string" in {
    val standard = "mfn|z@ym}yvBAo|v~Dazn~JAq|v~Dczn~J@"
    val default = "unv97B6u-63DCw93_Fi7v_LCy93_Fk7v_LB"

    PolylineConverter.convert(standard, Standard) must be (default)

    PolylineConverter.convert(default, Default) must be (standard)
  }
}
