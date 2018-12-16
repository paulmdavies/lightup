case class Grid(squares: List[List[Square]]) {
    def isComplete(): Boolean = {
        squares.zipWithIndex.forall {
            case (column: List[Square], columnIndex: Int) => column.zipWithIndex.forall {
                case (square: Square, rowIndex: Int) => square.isBlack() || isSquareLit(columnIndex, rowIndex)
            }
        }
    }

    def isSquareLit(columnIndex: Int, rowIndex: Int): Boolean = {
        val squareHasLight = getSquare(columnIndex, rowIndex).hasLight()

        squareHasLight || unblockedLightInLine(getColumn(columnIndex), rowIndex) || unblockedLightInLine(getRow(rowIndex), columnIndex)
    }

    private def unblockedLightInLine(line: List[Square], index: Int) = {
        val lightIndices = line.zipWithIndex.filter(_._1.hasLight()).map(_._2)
        val lowerLightOption = lightIndices.find(_ < index)

        val lightLowerInLine = lowerLightOption match {
            case None => false
            case Some(lightIndex) => {
                val intermediateSquares = line.slice(lightIndex, index)
                intermediateSquares.nonEmpty && !intermediateSquares.exists(_.isBlack())
            }
        }

        val higherLightOption = lightIndices.find(_ > index)

        val lightHigherInLine = higherLightOption match {
            case None => false
            case Some(lightIndex) => {
                val intermediateSquares = line.slice(index, lightIndex)
                intermediateSquares.nonEmpty && !intermediateSquares.exists(_.isBlack())
            }
        }

        lightLowerInLine || lightHigherInLine
    }

    private def getSquare(columnIndex: Int, rowIndex: Int) = {
        getColumn(columnIndex)(rowIndex)
    }

    private def getRow(rowIndex: Int) = {
        squares.map(_ (rowIndex))
    }

    private def getColumn(column: Int) = {
        squares(column)
    }
}
