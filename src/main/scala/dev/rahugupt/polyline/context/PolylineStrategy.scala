package dev.rahugupt.polyline.context

/**
 * @author rahugupt
 *
 * Polyline Encoding Algorithm
 */
sealed trait PolylineStrategy {
  def encode(value: Int): Char

  def decode(value: Char): Int
}

/**
 * Standard PolyLine Encoder (specified by Google)
 */
case object Standard extends PolylineStrategy {

  override def encode(value: Int): Char = (value + 63).toChar

  override def decode(value: Char): Int = (value - 63)
}

/**
 * URL-safe Polyline Encoder
 */
case object Default extends PolylineStrategy {

  override def encode(value: Int): Char = Encode(value)

  override def decode(value: Char): Int = Decode(value - 45)
}

