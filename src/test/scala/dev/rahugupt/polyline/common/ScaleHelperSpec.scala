package dev.rahugupt.polyline.common

import org.scalatest._
import flatspec._
import matchers._

class ScaleHelperSpec extends AnyFlatSpec with must.Matchers {
  import ScaleHelper._

  it must "round number to correct decimal digits" in {
    val pi = Math.PI // 3.141592653589793

    pi.toFixed(0) must be (3.0)

    pi.toFixed(2) must be (3.14)

    pi.toFixed(4) must be (3.1416)

    pi.toFixed(5) must be (3.14159)

    pi.toFixed(7) must be (3.1415927)
  }

  it must "scale number correctly" in {
    val pi = Math.PI // 3.141592653589793

    pi.asLong(0) must be (3)

    pi.asLong(2) must be (314)

    pi.asLong(4) must be (31416)

    pi.asLong(5) must be (314159)

    pi.asLong(7) must be (31415927)
  }

  it must "retrieve double value from scaled value correctly" in {
    3L.asDouble(0) must be (3.0)

    314.asDouble(2) must be (3.14)

    31416.asDouble(4) must be (3.1416)

    314159.asDouble(5) must be (3.14159)

    31415927.asDouble(7) must be (3.1415927)
  }
}
