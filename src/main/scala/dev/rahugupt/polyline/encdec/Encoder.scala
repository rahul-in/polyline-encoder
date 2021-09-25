package dev.rahugupt.polyline.encdec

import dev.rahugupt.polyline.common.ScaleHelper._
import dev.rahugupt.polyline.context.PolylineContext
import dev.rahugupt.polyline.domain.Point

/**
 * @author rahugupt
 */
object Encoder {

  /**
   * Encode Seq[[[Point]]] to a PolylineString
   *
   * @param points Points to encode
   * @param context [[PolylineContext]]
   * @return
   */
  def encode(points: Seq[Point])(implicit context: PolylineContext): String = {
    var referencePoint = points.head.toFixed(context.numDigits)
    val encoded = new StringBuilder(encode(referencePoint))
    points.tail.map(_.toFixed(context.numDigits)).foreach(point => {
      encoded.append(encode(point - referencePoint))
      referencePoint = point
    })
    encoded.toString
  }

  private def encode(point: Point)(implicit context: PolylineContext): String = {
    encode(point.lat.asLong(context.numDigits))
      .concat(encode(point.lon.asLong(context.numDigits)))
      .concat(encode(point.zLevel))
  }

  private def encode(value: Long)(implicit context: PolylineContext): String = {
    val builder = new StringBuilder
    var temp = if (value < 0) ~(value << 1) else (value << 1)
    while (temp >= 0x20) {
      builder.append(context.encode(0x20 | (temp & 0x1f).toInt))
      temp >>= 5
    }
    builder.append(context.encode(temp.toInt)).toString
  }
}
