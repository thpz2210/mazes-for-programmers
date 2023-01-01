data class Cell(val row: Int, val column: Int) {

    var north: Cell? = null
    var east: Cell? = null
    var south: Cell? = null
    var west: Cell? = null

    val neighbors = setOfNotNull(north, east, south, west)

    private val links = mutableSetOf<Cell>()

    fun linked(cell: Cell?) = cell != null && links.contains(cell)

    fun link(cell: Cell, bidirectional: Boolean = true) {
        links.add(cell)
        if (bidirectional) cell.link(this, bidirectional = false)
    }

    fun unlink(cell: Cell, bidirectional: Boolean = true) {
        links.remove(cell)
        if (bidirectional) cell.unlink(this, bidirectional = false)
    }

}
