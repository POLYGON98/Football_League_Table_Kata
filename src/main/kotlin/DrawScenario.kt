class DrawScenario : ResultScenario {
    override fun updateHomeStats(
        result: FootballResult,
        homeTeam: FootballStats,
        awayTeam: FootballStats
    ): FootballStats {
        return FootballStats(
            homeTeam.points + 1,
            homeTeam.goalsFor + result.homeTeamScore,
            homeTeam.goalsAgainst + result.awayTeamScore,
            homeTeam.goalDifference + result.homeTeamScore - result.awayTeamScore,
            homeTeam.wins,
            homeTeam.draws + 1,
            homeTeam.losses
        )
    }

    override fun updateAwayStats(
        result: FootballResult,
        homeTeam: FootballStats,
        awayTeam: FootballStats
    ): FootballStats {
        return FootballStats(
            awayTeam.points + 1,
            awayTeam.goalsFor + result.awayTeamScore,
            awayTeam.goalsAgainst + result.homeTeamScore,
            awayTeam.goalDifference + result.awayTeamScore - result.homeTeamScore,
            awayTeam.wins,
            awayTeam.draws + 1,
            awayTeam.losses
        )
    }

}
