class LeagueTable {

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
        val result = FootballResult(matchResult)
        val teamStatsPair = Pair(
                stats[result.homeTeam] ?: FootballStats(),
                stats[result.awayTeam] ?: FootballStats()
        )
        updateHomeStats(result, matchResult, teamStatsPair)
        updateAwayStats(result, matchResult, teamStatsPair)
    }

    private fun updateHomeStats(result: FootballResult, matchResult: String, teamStatsPair: Pair<FootballStats, FootballStats>) {
        stats[result.homeTeam] = StatCalculator().update(FootballResult(matchResult), teamStatsPair).first
    }

    private fun updateAwayStats(result: FootballResult, matchResult: String, teamStatsPair: Pair<FootballStats, FootballStats>) {
        stats[result.awayTeam] = StatCalculator().update(FootballResult(matchResult), teamStatsPair).second
    }
}
