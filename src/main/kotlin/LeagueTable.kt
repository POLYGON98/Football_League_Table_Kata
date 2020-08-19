class LeagueTable {

    var stats = mutableMapOf<String, FootballStats>()
    private val statCalculator = StatCalculator()

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
        stats = statCalculator.update(resultToAdd, stats)
    }
}
