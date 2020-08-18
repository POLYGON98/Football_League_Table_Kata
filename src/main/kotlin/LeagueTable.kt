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
        return (stats[team] ?: FootballStats()).goalsFor
    }

    fun getGoalsAgainst(team: String): Int {
        return (stats[team] ?: FootballStats()).goalsAgainst
    }

    fun getGoalDifference(team: String): Int {
        return 0
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

        if (homeTeamHasWon(resultToAdd)){
            stats[resultToAdd.homeTeam] = FootballStats(
                homeTeam.points + 3,
                homeTeam.goalsFor + resultToAdd.homeTeamScore,
                homeTeam.goalsAgainst + resultToAdd.awayTeamScore,
                0,
                homeTeam.wins + 1,
                homeTeam.draws,
                homeTeam.losses
            )
            stats[resultToAdd.awayTeam] = FootballStats(
                awayTeam.points,
                awayTeam.goalsFor + resultToAdd.awayTeamScore,
                awayTeam.goalsAgainst + resultToAdd.homeTeamScore,
                0,
                awayTeam.wins,
                awayTeam.draws,
                awayTeam.losses + 1
            )
        }
        if (awayTeamHasWon(resultToAdd)) {
            stats[resultToAdd.homeTeam] = FootballStats(
                homeTeam.points,
                homeTeam.goalsFor + resultToAdd.homeTeamScore,
                homeTeam.goalsAgainst + resultToAdd.awayTeamScore,
                0,
                homeTeam.wins,
                homeTeam.draws,
                homeTeam.losses + 1
            )
            stats[resultToAdd.awayTeam] = FootballStats(
                awayTeam.points + 3,
                awayTeam.goalsFor + resultToAdd.awayTeamScore,
                awayTeam.goalsAgainst + resultToAdd.homeTeamScore,
                0,
                awayTeam.wins + 1,
                awayTeam.draws,
                awayTeam.losses
            )
        }
        if (thereWasDraw(resultToAdd)) {
            stats[resultToAdd.homeTeam] = FootballStats(
                homeTeam.points + 1,
                homeTeam.goalsFor + resultToAdd.homeTeamScore,
                homeTeam.goalsAgainst + resultToAdd.awayTeamScore,
                0,
                homeTeam.wins,
                homeTeam.draws + 1,
                homeTeam.losses
            )
            stats[resultToAdd.awayTeam] = FootballStats(
                awayTeam.points + 1,
                awayTeam.goalsFor + resultToAdd.awayTeamScore,
                awayTeam.goalsAgainst + resultToAdd.homeTeamScore,
                0,
                awayTeam.wins,
                awayTeam.draws + 1,
                awayTeam.losses
            )
        }

    }

}
