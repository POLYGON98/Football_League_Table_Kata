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

        assertEquals("Manchester United 3 - 0 Liverpool", leagueTable.results[0].toString())
    }

    @Test
    internal fun `update points after result pushed`() {
        val leagueTable = LeagueTable()

        leagueTable.push("Manchester United 3 - 0 Liverpool")

        assertEquals(3, leagueTable.getPoints("Manchester United"))
    }

    @Test
    internal fun `update points after 2 results pushed`() {
        val leagueTable = LeagueTable()

        leagueTable.push("Manchester United 3 - 0 Liverpool")
        leagueTable.push("Manchester United 1 - 1 Liverpool")

        assertEquals(4, leagueTable.getPoints("Manchester United"))
        assertEquals(1, leagueTable.getPoints("Liverpool"))
    }

    @Test
    internal fun `update wins after results pushed`() {
        val leagueTable = LeagueTable()

        leagueTable.push("Manchester United 3 - 0 Liverpool")
        leagueTable.push("Manchester United 1 - 1 Liverpool")

        assertEquals(1, leagueTable.getWins("Manchester United"))
        assertEquals(0, leagueTable.getWins("Liverpool"))
    }

    private fun assertZeroData(leagueTable: LeagueTable, team: String) {
        assertEquals(0, leagueTable.getPoints(team))
        assertEquals(0, leagueTable.getGoalsFor(team))
        assertEquals(0, leagueTable.getGoalsAgainst(team))
        assertEquals(0, leagueTable.getGoalDifference(team))
        assertEquals(0, leagueTable.getWins(team))
        assertEquals(0, leagueTable.getDraws(team))
        assertEquals(0, leagueTable.getLosses(team))
    }
}