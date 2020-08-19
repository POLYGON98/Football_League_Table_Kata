package result_scenarios

class ResultScenarioFactory {
    private val scenarios = mapOf(
            "home" to HomeWinScenario(),
            "away" to AwayWinScenario()
    )

    fun create(scenario: String): ResultScenario {
        return scenarios[scenario] ?: DrawScenario()
    }
}