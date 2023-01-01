import kotlin.random.Random.Default.nextBoolean

object Sidewinder {

    fun on(grid: Grid) = grid.rows.forEach { row ->
        val run = mutableListOf<Cell>()
        row.forEach { cell ->
            run.add(cell)
            val isAtEastBoundary = cell.east == null
            val isAtNorthBoundary = cell.north == null
            if (isAtEastBoundary || (!isAtNorthBoundary && nextBoolean())) {
                val member = run.random()
                if (member.north != null) member.link(member.north!!)
                run.clear()
            } else {
                cell.link(cell.east!!)
            }
        }
    }

}
