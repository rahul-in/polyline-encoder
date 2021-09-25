package dev.rahugupt.polyline.encdec

import dev.rahugupt.polyline.context._
import dev.rahugupt.polyline.domain.Point
import org.scalatest._
import flatspec._
import matchers._

class DecoderSpec extends AnyFlatSpec with must.Matchers {

  it must "decode polyline using standard algorithm with 5 decimal places" in {
    import PolylineContext.STANDARD
    Decoder.decode("}qdR}dje@Aoj|@}uyBAoj|@_vyB@") must be (Fixture.points.map(_.toFixed(5)))
  }

  it must "decode polyline using default algorithm with 5 decimal places" in {
    import PolylineContext.DEFAULT
    Decoder.decode("-ylT-lrmBCwr9B-26DCwr9Bg36DB") must be (Fixture.points.map(_.toFixed(5)))
  }

  it must "encode polyline using standard algorithm with 7 decimal places" in {
    implicit val context = PolylineContext(7, Standard)
    Decoder.decode("mfn|z@ym}yvBAo|v~Dazn~JAq|v~Dczn~J@") must be (Fixture.points.map(_.toFixed(7)))
  }

  it must "encode polyline using default algorithm with 7 decimal places" in {
    implicit val context = PolylineContext(7, Default)
    Decoder.decode("unv97B6u-63DCw93_Fi7v_LCy93_Fk7v_LB") must be (Fixture.points.map(_.toFixed(7)))
  }
}
