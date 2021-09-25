package dev.rahugupt.polyline.encdec

import dev.rahugupt.polyline.context._
import org.scalatest._
import flatspec._
import matchers._

class EncoderSpec extends AnyFlatSpec with must.Matchers {
  import Fixture._

  it must "encode polyline using standard algorithm with 5 decimal places" in {
    import PolylineContext.STANDARD
    Encoder.encode(points) must be ("}qdR}dje@Aoj|@}uyBAoj|@_vyB@")
  }

  it must "encode polyline using default algorithm with 5 decimal places" in {
    import PolylineContext.DEFAULT
    Encoder.encode(points) must be ("-ylT-lrmBCwr9B-26DCwr9Bg36DB")
  }

  it must "encode polyline using standard algorithm with 7 decimal places" in {
    implicit val context = PolylineContext(7, Standard)
    Encoder.encode(points) must be ("mfn|z@ym}yvBAo|v~Dazn~JAq|v~Dczn~J@")
  }

  it must "encode polyline using default algorithm with 7 decimal places" in {
    implicit val context = PolylineContext(7, Default)
    Encoder.encode(points) must be ("unv97B6u-63DCw93_Fi7v_LCy93_Fk7v_LB")
  }
}
