class Square private (value: Int) {
    def getValue() : Option[Int] = value > 0 match {
        case true => Some(value)
        case false => Option.empty
    }

    def isWhite() : Boolean = value == Square.WHITE_SQUARE

    def isBlack() : Boolean = value >= Square.BLACK_SQUARE
}

object Square {
    private val BLACK_SQUARE = 0
    private val WHITE_SQUARE = -1

    def black(value: Int)= new Square(value)

    def black() = new Square(BLACK_SQUARE)

    def white() = new Square(WHITE_SQUARE)
}
