import result_scenarios.*

class StatCalculator {
    fun update(resultToAdd: FootballResult, teamStatsPair: Pair<FootballStats, FootballStats>) : Pair<FootballStats, FootballStats> {
        val scenario = when {
            homeTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("home")
            awayTeamHasWon(resultToAdd) -> ResultScenarioFactory().create("away")
            else -> ResultScenarioFactory().create("draw")
        }

        val newHomeStats = scenario.updateHomeStats(resultToAdd, teamStatsPair)
        val newAwayStats = scenario.updateAwayStats(resultToAdd, teamStatsPair)

        return Pair(newHomeStats, newAwayStats)
    }

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore
}