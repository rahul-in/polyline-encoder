package dev.rahugupt.polyline.context

/**
 * @author rahugupt
 *
 * Context of Polyline Encoding
 */
case class PolylineContext(numDigits: Int, strategy: PolylineStrategy) {

  def encode(value: Int): Char = strategy.encode(value)

  def decode(value: Char): Int = strategy.decode(value)
}

object PolylineContext {
  implicit val DEFAULT = PolylineContext(5, Default)
  implicit val STANDARD = PolylineContext(5, Standard)
}

