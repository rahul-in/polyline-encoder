package dev.rahugupt.polyline.encdec

import dev.rahugupt.polyline.common.ScaleHelper._
import dev.rahugupt.polyline.context.PolylineContext
import dev.rahugupt.polyline.domain.Point

import scala.collection.mutable.ListBuffer

/**
 * @author rahugupt
 */
object Decoder {

  /**
   * Decode an encoded polyline string to Seq[[[Point]]]
   *
   * @param encoded polyline encoded string
   * @param context [[PolylineContext]]
   * @return
   */
  def decode(encoded: String)(implicit context: PolylineContext): Seq[Point] = {
    val (len, counter) = (encoded.length, new Counter)
    var (latitude, longitude, zLevel) = (0L, 0L, 0)
    val points = ListBuffer[Point]()
    while (counter.get < len) {
      latitude += decode(encoded, counter)
      longitude += decode(encoded, counter)
      zLevel += decode(encoded, counter).intValue
      points += Point(lat = latitude.asDouble(context.numDigits), lon = longitude.asDouble(context.numDigits), zLevel = zLevel)
    }
    points
  }

  private def decode(encoded: String, counter: Counter)(implicit context: PolylineContext): Long = {
    var (b, result, shift) = (0L, 1L, 0)
    do {
      b = context.decode(encoded.charAt(counter.getAndIncrement)) - 1
      result += b << shift
      shift += 5
    } while (b >= 0x1f)
    if ((result & 1) != 0) ~(result >> 1) else result >> 1
  }
}
