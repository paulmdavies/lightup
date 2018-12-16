case class Grid(squares: List[List[Square]]) {
    def isComplete() : Boolean = {
        squares.forall(_.forall(square => square.isBlack() || square.isLit()))
    }
}
