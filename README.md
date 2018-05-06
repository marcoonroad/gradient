Gradient
========

Gradual Typing encoding for Scala.

This project provides a `Dynamic` "opaque" type with the following implicit
coercions (inside the `Gradient` namespace):
- `upcast:   [Type](value: Type)    Dynamic`
- `downcast: [Type](value: Dynamic) Type`

Once `Gradient` is imported, it would allow us to perform coercions from and
to such `Dynamic` type:

```scala
import Gradient._

val x : Dynamic = "Hello, World!"

// ... some stuff could be done here ...

val y : String = x
```

### Rationale

Why such encoding? Isn't Scala already "Gradual" due the mixing of static types,
subtyping and downcasts? Technically, no! The subtyping part introduces
_transitive_ "casts", which are **bad** if we try to encode Gradual Typing
through super types such as `AnyVal`, `AnyRef` or just `Any`. Take the following
example:

```scala
import scala.language.implicitConversions

implicit def cast[ Type ] (implicit value : Any) : Type =
  value.asInstanceOf[ Type ]

val b : Any = 7 // OK, Int <: Any

val c : Int = b // OK, implicit cast : Any => Type where Type := Int

// throws ClassCastException
val d : String = b // OK, implicit cast : Any => Type where Type := String

// throws ClassCastException
val e : String = c // NOT OK, implicit cast : (Int <: Any) => Type where
// Type := String, so Int => String
```

So, to avoid such gotchas, the implementation for such project uses a wrapper
class instead. A gradual/dynamic type **isn't a super type**. Instead, it is an
_abstract type_ (let's call that `?`) which provides the following coercion
relations (where `t` is an arbitrary type):
- ? ~ t
- t ~ ?

### Remarks

PRs and Issues are welcome! Have a happy hacking!
