package dev.rahugupt.polyline.domain

/**
 * @author rahugupt
 *
 * Point represented by lat, lon and zLevel
 * @param lat
 * @param lon
 * @param zLevel
 */
case class Point(lat: Double, lon: Double, zLevel: Int)

object Point {

  import dev.rahugupt.polyline.common.ScaleHelper._
  import dev.rahugupt.polyline.context.PolylineContext

  implicit class RichPoint(point: Point) {

    /**
     * Calculate delta of point for encoding
     *
     * @param point
     * @return
     */
    def -(previousPoint: Point): Point = {
      Point(
        lat = point.lat - previousPoint.lat,
        lon = point.lon - previousPoint.lon,
        zLevel = point.zLevel - previousPoint.zLevel)
    }

    def toFixed(numDigits: Int) = {
      point.copy(lat = point.lat.toFixed(numDigits), lon = point.lon.toFixed(numDigits), point.zLevel)
    }
  }
}
