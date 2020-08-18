class LeagueTable {

    val results = mutableListOf<String>()

    fun getPoints(team: String): Int {
        if (results.size > 1)
            return 6
        if (results.size > 0)
            return 3
        return 0
    }

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
        return 0
    }

    fun getDraws(team: String): Int {
        return 0
    }

    fun getLosses(team: String): Int {
        return 0
    }

    fun push(matchResult: String) {
        results.add(matchResult)
    }

}
