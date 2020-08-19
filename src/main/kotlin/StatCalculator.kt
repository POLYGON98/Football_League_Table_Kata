import result_scenarios.AwayWinScenario
import result_scenarios.DrawScenario
import result_scenarios.HomeWinScenario
import result_scenarios.ResultScenario

class StatCalculator {
    fun update(resultToAdd: FootballResult, stats: MutableMap<String, FootballStats>) : MutableMap<String, FootballStats> {
        val homeTeam = stats[resultToAdd.homeTeam] ?: FootballStats()
        val awayTeam = stats[resultToAdd.awayTeam] ?: FootballStats()
        var scenario: ResultScenario

        val scenarios = mapOf(
                "home" to HomeWinScenario(),
                "away" to AwayWinScenario()
        )

        var resultScenario = ""
        if (homeTeamHasWon(resultToAdd))
            resultScenario = "home"
        if (awayTeamHasWon(resultToAdd))
            resultScenario = "away"

        scenario = scenarios[resultScenario] ?: DrawScenario()

        stats[resultToAdd.homeTeam] = scenario.updateHomeStats(resultToAdd, homeTeam, awayTeam)
        stats[resultToAdd.awayTeam] = scenario.updateAwayStats(resultToAdd, homeTeam, awayTeam)

        return stats

    }

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore
}