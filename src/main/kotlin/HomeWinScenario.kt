class HomeWinScenario : ResultScenario {
    override fun updateHomeStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats): FootballStats {
        return FootballStats(
            homeTeam.points + 3,
            homeTeam.goalsFor + result.homeTeamScore,
            homeTeam.goalsAgainst + result.awayTeamScore,
            homeTeam.goalDifference + result.homeTeamScore - result.awayTeamScore,
            homeTeam.wins + 1,
            homeTeam.draws,
            homeTeam.losses
        )
    }

    override fun updateAwayStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats): FootballStats {
        return FootballStats(
            awayTeam.points,
            awayTeam.goalsFor + result.awayTeamScore,
            awayTeam.goalsAgainst + result.homeTeamScore,
            awayTeam.goalDifference + result.awayTeamScore - result.homeTeamScore,
            awayTeam.wins,
            awayTeam.draws,
            awayTeam.losses + 1
        )
    }
}