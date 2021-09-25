package dev.rahugupt.polyline

package object common {

  /**
   * Set absolute precision using reciprocal precision usually pow(10, n) where n > 0, ~10x faster than f"$x%.7f".toDouble
   */
  def setAbsPrecision(x: Double, reciprocalPrecision: Double): Double = {
    val y = x * reciprocalPrecision
    if (Math.ulp(y) >= 1.0) x else Math.round(y) / reciprocalPrecision
  }

  /**
   * Calculate a^b, ~10x faster than Math.pow
   */
  def pow(a: Int, b: Int): Int = {
    var (re: Int, a1: Int, b1: Int) = (1, a, b)
    while (b1 > 0) {
      if ((b1 & 1) == 1) re *= a1
      b1 >>= 1
      a1 *= a1
    }
    re
  }
}
