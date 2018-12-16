import org.scalatest.FlatSpec
import org.scalatest.Matchers

class GridTest extends FlatSpec with Matchers {
    "A grid" should "be complete if it is empty" in {
        val grid = Grid(List.empty)

        grid.isComplete() should be(true)
    }

    it should "be complete if it contains only black squares" in {
        val grid = Grid(List(List(Square.black())))

        grid.isComplete() should be(true)
    }

    it should "not be complete if it contains white squares without lights" in {
        val grid = Grid(List(List(Square.white())))

        grid.isComplete() should be(false)
    }

    it should "be complete if it contains only white squares with lights" in {
        val grid = Grid(List(List(Square.white(true))))

        grid.isComplete() should be(true)
    }

    it should "be complete if all squares are lit" in {
        val grid = Grid(List(List(Square.white(), Square.white(true), Square.white())))

        grid.isComplete() should be(true)
    }

    it should "report a square as lit if it has a light" in {
        val grid = Grid(List(List(Square.white(true))))

        grid.isSquareLit(0, 0) should be(true)
    }

    it should "not report a square as lit if it does not have a light" in {
        val grid = Grid(List(List(Square.white())))

        grid.isSquareLit(0, 0) should be(false)
    }

    it should "report a square as lit if it does not have a light but a square in the same column does" in {
        val grid = Grid(List(List(Square.white(), Square.white(true))))

        grid.isSquareLit(0, 0) should be(true)
    }

    it should "report a square as lit if it does not have a light but a square in the same row does" in {
        val grid = Grid(List(List(Square.white()), List(Square.white(true))))

        grid.isSquareLit(0, 0) should be(true)
    }

    it should "not report a square as lit if it does not have a light but a square in the same column does but there is a black square between them" in {
        val grid = Grid(List(List(Square.white(), Square.black(), Square.white(true))))

        grid.isSquareLit(0, 0) should be(false)
    }

    it should "not report a square as lit if it does not have a light but a square in the same row does but there is a black square between them" in {
        val grid = Grid(List(List(Square.white()), List(Square.black()), List(Square.white(true))))

        grid.isSquareLit(0, 0) should be(false)
    }

    it should "not report a square as lit if it does not have a light but a square in a different row and column does" in {
        val grid = Grid(List(List(Square.white(), Square.white()), List(Square.white(), Square.white(true))))

        grid.isSquareLit(0, 0) should be(false)
    }

    it should "not report a square as lit if it is black without a value" in {
        val grid = Grid(List(List(Square.black())))

        grid.isSquareLit(0, 0) should be(false)
    }

    it should "not report a square as lit if it is black with a value" in {
        val grid = Grid(List(List(Square.black(1))))

        grid.isSquareLit(0, 0) should be(false)
    }
}
