package dev.rahugupt.polyline.context

/**
 * @author rahugupt
 *
 * Convert polyline encoded string from one format to another without converting them to objects.
 */
object PolylineConverter {

  def convert(encoded: String, sourceStrategy: PolylineStrategy): String = {
    def targetStrategy: PolylineStrategy = sourceStrategy match {
      case Standard => Default
      case Default => Standard
    }
    convert(encoded, sourceStrategy, targetStrategy)
  }

  def convert(encoded: String, sourceStrategy: PolylineStrategy, targetStrategy: PolylineStrategy): String = {
    if (sourceStrategy == targetStrategy) {
      encoded
    } else {
      encoded.map(c => targetStrategy.encode(sourceStrategy.decode(c)))
    }
  }
}
