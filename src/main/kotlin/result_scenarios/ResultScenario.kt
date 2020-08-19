package result_scenarios

import FootballResult
import FootballStats

interface ResultScenario {
    fun updateHomeStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats) : FootballStats
    fun updateAwayStats(result: FootballResult, homeTeam: FootballStats, awayTeam: FootballStats) : FootballStats
}