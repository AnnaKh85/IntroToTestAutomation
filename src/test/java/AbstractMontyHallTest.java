import org.gb.MontyHallGame;
import org.junit.jupiter.api.BeforeEach;

public class AbstractMontyHallTest {
    protected MontyHallGame game;

    @BeforeEach
    public void setUp() {
        game = new MontyHallGame(1000); // Initialize with 1000 games for testing
    }
}
