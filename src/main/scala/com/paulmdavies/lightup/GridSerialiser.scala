package com.paulmdavies.lightup

object GridSerialiser {
    def deserialise(gridText: String): Grid = {
        new Grid(gridText.trim().split("\n").map(_.trim.split("").map {
            case "W" => Square.white()
            case "B" => Square.black()
            case other => Square.black(other.toInt)
        }.toList).toList)
    }

    def serialise(grid: Grid): String = {
        grid.squares.map(_.map(square => {
            if (square.isWhite()) {
                square.hasLight() match {
                    case true => "*"
                    case false => "W"
                }
            } else if (square.isBlack()) {
                square.getValue() match {
                    case Some(value) => value.toString()
                    case None => "B"
                }
            }
        }).mkString("")).mkString("\n")
    }
}
