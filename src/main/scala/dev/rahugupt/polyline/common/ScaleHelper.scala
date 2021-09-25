package dev.rahugupt.polyline.common

/**
 * @author rahugupt
 */
object ScaleHelper {
  object Scale {
    val TWO = scale(2)
    val FIVE = scale(5)
    val SEVEN = scale(7)

    private def scale(numDigits: Int): Int = pow(10, numDigits)

    def valueOf(numDigits: Int): Int = numDigits match {
      case 0 => 1
      case 2 => Scale.TWO
      case 5 => Scale.FIVE
      case 7 => Scale.SEVEN
      case _ => scale(numDigits)
    }
  }

  implicit class RichDouble(double: Double) {

    /**
     * Rounding the number to keep only [[numDigits]] decimals
     *
     * @param numDigits
     * @return
     */
    def toFixed(numDigits: Int): Double = {
      setAbsPrecision(double, Scale.valueOf(if (numDigits < 0) -numDigits else numDigits))
    }

    /**
     * Used to scale a double to power of 10.
     *
     * @param scale power of 10 to scale double value
     * @return
     */
    def asLong(scale: Int): Long = {
      Math.round(double * Scale.valueOf(scale))
    }
  }

  implicit class RichLong(long: Long) {

    /**
     * Use to retrieve double value from scaled long value
     *
     * @param scale power of 10 that is used to scale double
     * @return
     */
    def asDouble(scale: Int): Double = {
      long.toDouble / Scale.valueOf(scale)
    }
  }
}
