class LeagueTable {

    val results = mutableListOf<FootballResult>()
    var stats = mutableMapOf<String, FootballStats>()

    fun getPoints(team: String): Int {
        return stats[team]?.points ?: 0
    }

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore

    private fun thereWasDraw(result: FootballResult) = result.homeTeamScore == result.awayTeamScore

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    fun getGoalsFor(team: String): Int {
        return 0
    }

    fun getGoalsAgainst(team: String): Int {
        return 0
    }

    fun getGoalDifference(team: String): Int {
        return 0
    }

    fun getWins(team: String): Int {
        return stats[team]?.wins ?: 0
    }

    fun getDraws(team: String): Int {
        return 0
    }

    fun getLosses(team: String): Int {
        return 0
    }

    fun push(matchResult: String) {
        val resultToAdd = FootballResult(matchResult)
        results.add(resultToAdd)
        updateStats(resultToAdd)
    }

    private fun updateStats(resultToAdd: FootballResult) {
        if (!stats.keys.contains(resultToAdd.homeTeam)) {
            stats[resultToAdd.homeTeam] = FootballStats()
        }
        if (!stats.keys.contains(resultToAdd.awayTeam)) {
            stats[resultToAdd.awayTeam] = FootballStats()
        }
        val homeTeam = stats[resultToAdd.homeTeam] ?: FootballStats()
        val awayTeam = stats[resultToAdd.awayTeam] ?: FootballStats()

        if (homeTeamHasWon(resultToAdd))
            stats[resultToAdd.homeTeam] = FootballStats(homeTeam.points + 3, 0, 0, 0, homeTeam.wins + 1, homeTeam.draws, 0)
        if (awayTeamHasWon(resultToAdd))
            stats[resultToAdd.awayTeam] = FootballStats(awayTeam.points + 3, 0, 0, 0, awayTeam.wins + 1, awayTeam.draws, 0)
        if (thereWasDraw(resultToAdd)) {
            stats[resultToAdd.homeTeam] = FootballStats(homeTeam.points + 1, 0, 0, 0, homeTeam.wins, homeTeam.draws + 1, 0)
            stats[resultToAdd.awayTeam] = FootballStats(awayTeam.points + 1, 0, 0, 0, awayTeam.wins, awayTeam.draws + 1, 0)
        }
    }

}
