package dev.rahugupt.polyline.context

import org.scalatest._
import flatspec._
import matchers._

class PolylineStrategySpec extends AnyFlatSpec with must.Matchers {

  it must "encode and decode using Standard algorithm" in {
    val value = 3

    Standard.encode(3) must be ('B')

    Standard.decode('B') must be (3)
  }

  it must "encode and decode using Default algorithm" in {
    val value = 3

    Default.encode(3) must be ('D')

    Default.decode('D') must be (3)
  }
}
