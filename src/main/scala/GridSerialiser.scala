object GridSerialiser {
    def deserialise(gridText: String) : Grid = {
        new Grid(gridText.trim().split("\n").map(_.trim.split("").map{
            case "W" => Square.white()
            case "B" => Square.black()
            case other => Square.black(other.toInt)
        }.toList).toList)
    }
}
