import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FootballResultShould {

    @Test
    internal fun `print out as string`() {
        val actual = FootballResult("Manchester United 3 - 0 Liverpool").toString()
        val expected = "Manchester United 3 - 0 Liverpool"
        Assertions.assertEquals(expected, actual)
    }
}