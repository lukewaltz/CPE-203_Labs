import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Tests {

    @Test
    public void test_winSet(){
        Player luke = new Player(PlayerKind.WELL_PAID, 10);
        //luke.playRandom();

        Game test = new Game();
        test.winningLotNumber();

        //test.numMatch(luke.playRandom());

        //test.winnings(luke);
    }

    @Test
    public void testWINNER(){
        Player luke = new Player(PlayerKind.WELL_PAID, 10);
        Game test = new Game();


    }
}
