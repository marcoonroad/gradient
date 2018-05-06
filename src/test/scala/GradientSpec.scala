import org.scalatest._
import Gradient._

class GradientSpec extends FlatSpec with Matchers {
  "A Dynamic value" should "be coercible from and to any value" in {
    val x: Dynamic = 5
    val y: Int = x

    5 should be(y)
  }

  it should "throw ClassCastException on invalid coercions" in {
    val x: Dynamic = 12

    a[ClassCastException] should be thrownBy {
      val y: String = x
    }
  }
}
