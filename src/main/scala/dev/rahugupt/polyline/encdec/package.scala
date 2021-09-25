package dev.rahugupt.polyline

/**
 * @author rahugupt
 */
package object encdec {

  /**
   * Store count for encoding and decoding purpose. It's not thread-safe.
   * For multi-threaded environment consider using [[java.util.concurrent.atomic.AtomicInteger]]
   */
  class Counter {
    private var value: Int = 0
    def getAndIncrement: Int = {
      value += 1
      value - 1
    }
    def get: Int = value
  }
}
