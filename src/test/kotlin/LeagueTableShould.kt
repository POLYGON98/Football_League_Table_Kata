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
        assertZeroData("Manchester United")
    }

    @Test
    internal fun `update points after result pushed`() {
        leagueTable.push("Manchester United 3 - 0 Liverpool")

        assertEquals(3, leagueTable.getPoints("Manchester United"))
    }

    @Test
    internal fun `update points after 2 results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(4, leagueTable.getPoints("Manchester United"))
        assertEquals(4, leagueTable.getPoints("Liverpool"))
    }

    @Test
    internal fun `update wins after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(1, leagueTable.getWins("Manchester United"))
        assertEquals(1, leagueTable.getWins("Liverpool"))
    }

    @Test
    internal fun `update draws after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(1, leagueTable.getDraws("Manchester United"))
        assertEquals(1, leagueTable.getDraws("Liverpool"))
    }

    @Test
    internal fun `update losses after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(1, leagueTable.getLosses("Manchester United"))
        assertEquals(1, leagueTable.getLosses("Liverpool"))
    }

    @Test
    internal fun `update goals for after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(5, leagueTable.getGoalsFor("Manchester United"))
        assertEquals(3, leagueTable.getGoalsFor("Liverpool"))
    }

    @Test
    internal fun `update goals against after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(3, leagueTable.getGoalsAgainst("Manchester United"))
        assertEquals(5, leagueTable.getGoalsAgainst("Liverpool"))
    }

    @Test
    internal fun `update goal difference after results pushed`() {
        pushHomeWinAndDrawAndLoss()

        assertEquals(2, leagueTable.getGoalDifference("Manchester United"))
        assertEquals(-2, leagueTable.getGoalDifference("Liverpool"))
    }

    @Test
    internal fun `return zero data after results pushed and non-existent team entered`() {
        pushHomeWinAndDrawAndLoss()

        assertZeroData("Tottenham Hotspur")
    }

    private fun pushHomeWinAndDrawAndLoss() {
        leagueTable.push("Manchester United 3 - 0 Liverpool")
        leagueTable.push("Manchester United 1 - 1 Liverpool")
        leagueTable.push("Manchester United 1 - 2 Liverpool")
    }

    private fun assertZeroData(team: String) {
        assertEquals(0, leagueTable.getPoints(team))
        assertEquals(0, leagueTable.getGoalsFor(team))
        assertEquals(0, leagueTable.getGoalsAgainst(team))
        assertEquals(0, leagueTable.getGoalDifference(team))
        assertEquals(0, leagueTable.getWins(team))
        assertEquals(0, leagueTable.getDraws(team))
        assertEquals(0, leagueTable.getLosses(team))
    }
}