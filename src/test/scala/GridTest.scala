import org.scalatest.FlatSpec
import org.scalatest.Matchers

class GridTest extends FlatSpec with Matchers {
    "A board" should "be complete if it is empty" in {
        Grid(List.empty).isComplete() should be (true)
    }

    it should "be complete if it contains only black squares" in {
        Grid(List(List(Square.black()))).isComplete() should be (true)
    }

    it should "not be complete if it contains unlit white squares" in {
        Grid(List(List(Square.white()))).isComplete() should be (false)
    }

    it should "be complete if it contains only lit white squares" in {
        Grid(List(List(Square.white(true)))).isComplete() should be (true)
    }
}
