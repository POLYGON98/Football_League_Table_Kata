import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeagueTableShould {
    @Test
    internal fun `initialise with zero data for Manchester United`() {
        assertZeroData(LeagueTable(), "Manchester United")
    }

    @Test
    internal fun `push match result`() {
        val leagueTable = LeagueTable()
        leagueTable.push("Manchester United 3 - 0 Liverpool")

        assertEquals(leagueTable.results[0], "Manchester United 3 - 0 Liverpool")
    }

    private fun assertZeroData(leagueTable: LeagueTable, team: String) {
        assertEquals(leagueTable.getPoints(team), 0)
        assertEquals(leagueTable.getGoalsFor(team), 0)
        assertEquals(leagueTable.getGoalsAgainst(team), 0)
        assertEquals(leagueTable.getGoalDifference(team), 0)
        assertEquals(leagueTable.getWins(team), 0)
        assertEquals(leagueTable.getDraws(team), 0)
        assertEquals(leagueTable.getLosses(team), 0)
    }
}