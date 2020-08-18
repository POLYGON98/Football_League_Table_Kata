import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LeagueTableShould {
    lateinit var leagueTable: LeagueTable

    @BeforeEach
    internal fun setUp() {
        leagueTable = LeagueTable()
    }

    @Test
    internal fun `initialise with zero data for Manchester United`() {
        assertZeroData(LeagueTable(), "Manchester United")
    }

    @Test
    internal fun `push match result`() {
        leagueTable.push("Manchester United 3 - 0 Liverpool")

        assertEquals("Manchester United 3 - 0 Liverpool", leagueTable.results[0].toString())
    }

    @Test
    internal fun `update points after result pushed`() {
        leagueTable.push("Manchester United 3 - 0 Liverpool")

        assertEquals(3, leagueTable.getPoints("Manchester United"))
    }

    @Test
    internal fun `update points after 2 results pushed`() {
        pushHomeWinAndDraw()

        assertEquals(4, leagueTable.getPoints("Manchester United"))
        assertEquals(1, leagueTable.getPoints("Liverpool"))
    }

    @Test
    internal fun `update wins after results pushed`() {
        pushHomeWinAndDraw()

        assertEquals(1, leagueTable.getWins("Manchester United"))
        assertEquals(0, leagueTable.getWins("Liverpool"))
    }

    @Test
    internal fun `update draws after results pushed`() {
        pushHomeWinAndDraw()

        assertEquals(1, leagueTable.getDraws("Manchester United"))
        assertEquals(1, leagueTable.getDraws("Liverpool"))
    }



    private fun pushHomeWinAndDraw() {
        leagueTable.push("Manchester United 3 - 0 Liverpool")
        leagueTable.push("Manchester United 1 - 1 Liverpool")
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