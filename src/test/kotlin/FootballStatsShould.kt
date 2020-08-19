import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FootballStatsShould {
    @Test
    internal fun `initialise to zero`() {
        val footballStats = FootballStats()
        assertEquals(0, footballStats.points)
        assertEquals(0, footballStats.goalsFor)
        assertEquals(0, footballStats.goalsAgainst)
        assertEquals(0, footballStats.goalDifference)
        assertEquals(0, footballStats.wins)
        assertEquals(0, footballStats.draws)
        assertEquals(0, footballStats.losses)
    }
}