interface ResultScenario {
    fun updateHomeStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats) : FootballStats
    fun updateAwayStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats) : FootballStats
}