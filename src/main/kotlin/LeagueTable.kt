class LeagueTable {

    val results = mutableListOf<FootballResult>()
    var stats = mutableMapOf<String, FootballStats>()

    fun getPoints(team: String): Int {
        return stats[team]?.points ?: 0
    }

    fun getGoalsFor(team: String): Int {
        return (stats[team] ?: FootballStats()).goalsFor
    }

    fun getGoalsAgainst(team: String): Int {
        return (stats[team] ?: FootballStats()).goalsAgainst
    }

    fun getGoalDifference(team: String): Int {
        return (stats[team] ?: FootballStats()).goalDifference
    }

    fun getWins(team: String): Int {
        return (stats[team] ?: FootballStats()).wins
    }

    fun getDraws(team: String): Int {
        return (stats[team] ?: FootballStats()).draws
    }

    fun getLosses(team: String): Int {
        return (stats[team] ?: FootballStats()).losses
    }

    fun push(matchResult: String) {
        val resultToAdd = FootballResult(matchResult)
        results.add(resultToAdd)
        updateStats(resultToAdd)
    }

    private fun updateStats(resultToAdd: FootballResult) {
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

    }

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore

}
