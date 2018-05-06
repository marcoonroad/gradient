import scala.language.implicitConversions

object Gradient {
  class Dynamic (value: Any) {
    def coercion[Type] ( ) : Type =
      value.asInstanceOf[Type]
  }

  implicit def upcast[Type] (value: Type) : Dynamic =
    new Dynamic (value)

  implicit def downcast[Type] (value: Dynamic) : Type =
    value.coercion[Type] ( )
}

// end
