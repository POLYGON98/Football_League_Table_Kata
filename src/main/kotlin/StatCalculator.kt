import result_scenarios.*

class StatCalculator {
    fun update(resultToAdd: FootballResult, stats: MutableMap<String, FootballStats>) : MutableMap<String, FootballStats> {
        val homeTeam = stats[resultToAdd.homeTeam] ?: FootballStats()
        val awayTeam = stats[resultToAdd.awayTeam] ?: FootballStats()

        val scenario = when {
            homeTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("home")
            awayTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("away")
            else -> ResultScenarioFactory().create("draw")
        }

        stats[resultToAdd.homeTeam] = scenario.updateHomeStats(resultToAdd, homeTeam, awayTeam)
        stats[resultToAdd.awayTeam] = scenario.updateAwayStats(resultToAdd, homeTeam, awayTeam)

        return stats

    }

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore
}