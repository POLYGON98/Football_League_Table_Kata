package result_scenarios

import FootballResult
import FootballStats

class AwayWinScenario : ResultScenario {
    override fun updateHomeStats(
            result: FootballResult,
            statsPair: Pair<FootballStats, FootballStats>
    ): FootballStats {
        val homeTeam = statsPair.first
        return FootballStats(
                homeTeam.points,
                homeTeam.goalsFor + result.homeTeamScore,
                homeTeam.goalsAgainst + result.awayTeamScore,
                homeTeam.goalDifference + result.homeTeamScore - result.awayTeamScore,
                homeTeam.wins,
                homeTeam.draws,
                homeTeam.losses + 1
        )
    }

    override fun updateAwayStats(
            result: FootballResult,
            statsPair: Pair<FootballStats, FootballStats>
    ): FootballStats {
        val awayTeam = statsPair.second
        return FootballStats(
                awayTeam.points + 3,
                awayTeam.goalsFor + result.awayTeamScore,
                awayTeam.goalsAgainst + result.homeTeamScore,
                awayTeam.goalDifference + result.awayTeamScore - result.homeTeamScore,
                awayTeam.wins + 1,
                awayTeam.draws,
                awayTeam.losses
        )
    }
}