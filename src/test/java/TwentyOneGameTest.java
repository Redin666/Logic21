import org.example.Card;
import org.example.TwentyOneGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwentyOneGameTest {


    @Test
    void testPlayerHit() {
        TwentyOneGame game = new TwentyOneGame();
        game.playerHit();
        assertEquals(3, game.getPlayerScore());
    }

    @Test
    public void testComputerPlay() {
        TwentyOneGame game = new TwentyOneGame();
        game.getComputerHand().addAll(Arrays.asList(Card.TEN, Card.SIX));


        game.computerPlay();
        assertTrue(game.isGameOver());
        assertTrue(game.getComputerScore() >= 17);
    }
}
