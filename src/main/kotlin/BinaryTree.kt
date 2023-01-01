object BinaryTree {

    fun on(grid: Grid) = grid.cells.forEach { cell ->
        val neighbors = listOfNotNull(cell.north, cell.east)
        if (neighbors.isNotEmpty()) cell.link(neighbors.random())
    }

}
