class Square private (value: Int) {
    def getValue() : Option[Int] = value > 0 match {
        case true => Some(value)
        case false => Option.empty
    }

    def isWhite() : Boolean = value <= Square.WHITE_SQUARE

    def isBlack() : Boolean = value >= Square.BLACK_SQUARE

    def isLit() : Boolean = value == Square.LIT_WHITE_SQUARE
}

object Square {
    private val BLACK_SQUARE = 0
    private val WHITE_SQUARE = -1
    private val LIT_WHITE_SQUARE = -2

    def black(value: Int)= new Square(value)

    def black() = new Square(BLACK_SQUARE)

    def white() = new Square(WHITE_SQUARE)

    def white(lit: Boolean = false) = new Square(lit match {
        case true => LIT_WHITE_SQUARE
        case false => WHITE_SQUARE
    })
}
