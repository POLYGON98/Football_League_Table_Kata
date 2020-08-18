class LeagueTable {

    val results = mutableListOf<FootballResult>()

    fun getPoints(team: String): Int {
        var totalPoints = 0
        for (result in results) {
            if (isHomeTeam(result, team)) {
                if (homeTeamHasWon(result))
                    totalPoints += 3
                if (thereWasDraw(result))
                    totalPoints++
            }
            if (isAwayTeam(result, team)) {
                if (awayTeamHasWon(result))
                    totalPoints += 3
                if (thereWasDraw(result))
                    totalPoints++
            }
        }
        return totalPoints
    }

    private fun awayTeamHasWon(result: FootballResult) = result.awayTeamScore > result.homeTeamScore

    private fun thereWasDraw(result: FootballResult) = result.homeTeamScore == result.awayTeamScore

    private fun homeTeamHasWon(result: FootballResult) = result.homeTeamScore > result.awayTeamScore

    private fun isAwayTeam(result: FootballResult, team: String) = result.awayTeam == team

    private fun isHomeTeam(result: FootballResult, team: String) = result.homeTeam == team

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
        var wins = 0
        for (result in results) {
            if (isHomeTeam(result, team)) {
                if (homeTeamHasWon(result))
                    wins++
            }
            if (isAwayTeam(result, team)) {
                if (awayTeamHasWon(result))
                    wins++
            }
        }
        return wins
    }

    fun getDraws(team: String): Int {
        return 0
    }

    fun getLosses(team: String): Int {
        return 0
    }

    fun push(matchResult: String) {
        results.add(FootballResult(matchResult))
    }

}
