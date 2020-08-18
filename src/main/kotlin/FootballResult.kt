class FootballResult(private val matchResult: String) {
    private val resultParts = matchResult.split(" - ")
    private val firstHalf = resultParts[0]
    private val secondHalf = resultParts[1]
    val homeTeamScore = firstHalf.last().toString().toInt()
    val awayTeamScore = secondHalf.first().toString().toInt()
    val homeTeam = firstHalf.substring(0, firstHalf.length - 1).trim()
    val awayTeam = secondHalf.substring(1).trim()

    override fun toString(): String {
        return matchResult
    }

}
