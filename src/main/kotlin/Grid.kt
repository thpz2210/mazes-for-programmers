class Grid(rows: Int, columns: Int) {

    private val grid = (0 until rows).map { row -> (0 until columns).map { column -> Cell(row, column) } }

    val cells = grid.flatten()
    val rows = grid

    private val width = grid[0].size

    init {
        configureCells()
    }

    private fun cell(row: Int, column: Int): Cell? {
        if (row !in grid.indices) return null
        if (column !in grid[row].indices) return null
        return grid[row][column]
    }

    private fun configureCells() = cells.forEach {
        val row = it.row
        val column = it.column
        it.north = cell(row - 1, column)
        it.east = cell(row, column + 1)
        it.south = cell(row + 1, column)
        it.west = cell(row, column - 1)
    }

    override fun toString(): String {
        return buildString {
            appendLine("+" + "---+".repeat(width))
            grid.forEach { row ->
                appendLine("|" + row.joinToString("") { cell ->
                    val body = "   "
                    body + if (cell.linked(cell.east)) " " else "|"
                })
                appendLine("+" + row.joinToString("") { cell ->
                    "${if (cell.linked(cell.south)) "   " else "---"}+"
                })
            }
        }
    }

}
