import org.scalatest.FlatSpec
import org.scalatest.Matchers

class SquareTest extends FlatSpec with Matchers {
    private val ANY_SQUARE_VALUE = 1

    "A black square" should "be black" in {
        val square = Square.black()

        square.isBlack() should be (true)
    }

    it should "not be white" in {
        val square = Square.black()

        square.isWhite() should be (false)
    }

    it should "not have a value" in {
        val square = Square.black()

        square.getValue() should be (Option.empty)
    }

    "A white square" should "not be black" in {
        val square = Square.white()

        square.isBlack() should be (false)
    }

    it should "be white" in {
        val square = Square.white()

        square.isWhite() should be (true)
    }

    it should "not have a value" in {
        val square = Square.white()

        square.getValue() should be (Option.empty)
    }

    "A black square with a value" should "be black" in {
        val square = Square.black(ANY_SQUARE_VALUE)

        square.isBlack() should be (true)
    }

    it should "not be white" in {
        val square = Square.black(ANY_SQUARE_VALUE)

        square.isWhite() should be (false)
    }

    it should "not have a value" in {
        val square = Square.black(ANY_SQUARE_VALUE)

        square.getValue() should be (Option(1))
    }
}
