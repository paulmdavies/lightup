package com.paulmdavies.lightup

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class GridSerialiserTest extends FlatSpec with Matchers {
    "A grid serializer" should "handle white squares" in {
        val grid = GridSerialiser.deserialise("W")

        grid should equal(Grid(List(List(Square.white()))))
    }

    it should "handle black squares" in {
        val grid = GridSerialiser.deserialise("B")

        grid should equal(Grid(List(List(Square.black()))))
    }

    it should "handle numbered squares" in {
        val grid = GridSerialiser.deserialise("4")

        grid should equal(Grid(List(List(Square.black(4)))))
    }

    it should "handle grid in one dimension" in {
        val grid = GridSerialiser.deserialise("1WB2")

        grid should equal(Grid(List(List(Square.black(1), Square.white(), Square.black(), Square.black(2)))))
    }

    it should "handle grid in two dimensions" in {
        val grid = GridSerialiser.deserialise(
            """
                1W
                B2
            """
        )

        grid should equal(Grid(List(List(Square.black(1), Square.white()), List(Square.black(), Square.black(2)))))
    }
}
