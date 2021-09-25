# Packed Geometry

Packed Geometry implementation based on [HereMaps flexible-polyline ("Default")](https://github.com/heremaps/flexible-polyline) and [Encoded Polyline Algorithm Format ("Standard")](https://developers.google.com/maps/documentation/utilities/polylinealgorithm)

Two formats defined above are [interchangeable](#conversion) and does not require converting to `Object`.

This is a loss-less implementation, i.e., no loss in precision during encoding or decoding.

#### Initialize context
###### Import predefined context (Encoded Polyline Algorithm Format support 5 decimal places)
```scala
import dev.rahugupt.polyline.context.PolylineContext

import PolylineContext.DEFAULT
import PolylineContext.STANDARD
```
###### For PolylineContext with custom decimal places, use:
```scala
import dev.rahugupt.polyline.context.PolylineContext

implicit val context = new PolylineContext(7, Default) // with Default encoder
implicit val standardContext = new PolylineContext(7, Standard) // with Standard encoder
```

#### Encoding

```scala
import dev.rahugupt.polyline.encdec.Encoder

val encoded = Encoder.encode(polyline)(context);
```

#### Decoding

```scala
import dev.rahugupt.polyline.encdec.Decoder

val points = Decoder.decode(encoded)(context);
```

#### Conversion
PolylineConverter provides efficient way to convert encoded string from one format to another.

```scala
import dev.rahugupt.polyline.context.PolylineConverter

val standard = PolylineConverter.convert(encoded, Default)
val default = PolylineConverter.convert(encoded, Standard)
```