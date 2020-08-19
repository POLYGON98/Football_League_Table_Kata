import result_scenarios.*

class StatCalculator {
    fun update(resultToAdd: FootballResult, stats: MutableMap<String, FootballStats>) : MutableMap<String, FootballStats> {
        val homeTeamStats = stats[resultToAdd.homeTeam] ?: FootballStats()
        val awayTeamStats = stats[resultToAdd.awayTeam] ?: FootballStats()
        val teamStatsPair = Pair(homeTeamStats, awayTeamStats)

        val scenario = when {
            homeTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("home")
            awayTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("away")
            else -> ResultScenarioFactory().create("draw")
        }

        stats[resultToAdd.homeTeam] = scenario.updateHomeStats(resultToAdd, teamStatsPair)
        stats[resultToAdd.awayTeam] = scenario.updateAwayStats(resultToAdd, teamStatsPair)

        return stats

    }

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore
}