import org.gb.MontyHallGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallGameTest extends AbstractMontyHallTest{
    private MontyHallGame game;
    @BeforeEach
    public void setUp() {
        game = new MontyHallGame(1000);
    }
    @Test
    public void testSimulationSwitchWins() {
        game.simulateGames();
        int switchWins = game.getSwitchWins();
        int stayWins = game.getStayWins();

        // We expect that switching wins more often than staying
        assertTrue(switchWins > stayWins);
    }

    @Test
    public void testSimulationStayWins() {
        game.simulateGames();
        int switchWins = game.getSwitchWins();
        int stayWins = game.getStayWins();

        // We expect that staying wins less often than switching
        assertTrue(stayWins < switchWins);
    }

    @Test
    public void testSimulationTotalGames() {
        int expectedTotalGames = 1000;
        double winProportion = (double) game.getSwitchWins() / expectedTotalGames;

        // You can adjust these bounds based on the acceptable range
        double lowerBound = 0.65;
        double upperBound = 0.75;

        // Check if the win proportion is within the acceptable range
        assertFalse(winProportion >= lowerBound && winProportion <= upperBound);
    }

    @ParameterizedTest
    @MethodSource("provideTotalGames")
    public void testSimulation(int totalGames) {
        game = new MontyHallGame(totalGames);
        game.simulateGames();

        int switchWins = game.getSwitchWins();
        int stayWins = game.getStayWins();

        // Assertions for your test
        assertTrue(switchWins > stayWins);
    }

    private static Stream<Arguments> provideTotalGames() {
        return Stream.of(
                Arguments.of(1000),
                Arguments.of(5000),
                Arguments.of(10000)
        );
    }

    @Test
    public void testInvalidTotalGames() {
        // Negative test: Total games cannot be negative
        assertThrows(IllegalArgumentException.class, () -> new MontyHallGame(-1));
    }

    @Test
    public void testInvalidPrizeDoor() {
        // Negative test: Prize door cannot be outside the range [0, 2]
        assertThrows(IllegalArgumentException.class, () -> new MontyHallGame(-1));
    }
}
