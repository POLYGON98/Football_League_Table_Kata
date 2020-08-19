package result_scenarios

import FootballResult
import FootballStats

interface ResultScenario {
    fun updateHomeStats(result: FootballResult, statsPair: Pair<FootballStats, FootballStats>) : FootballStats
    fun updateAwayStats(result: FootballResult, statsPair: Pair<FootballStats, FootballStats>) : FootballStats
}