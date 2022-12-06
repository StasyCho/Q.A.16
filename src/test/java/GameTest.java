import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 500);
        Player player2 = new Player(2, "Vova", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Dima", "Vova");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenSecondPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 50);
        Player player2 = new Player(2, "Vova", 500);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Dima", "Vova");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenNoPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 500);
        Player player2 = new Player(2, "Vova", 500);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Dima", "Vova");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void playerNotFound1() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 500);
        Player player2 = new Player(2, "Vova", 500);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petiy", "Vova"));
    }
    @Test
    public void playerNotFound2() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 500);
        Player player2 = new Player(2, "Vova", 500);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Dima", "Petiy"));
    }

    @Test
    public void playerNotFound3() {
        Game game = new Game();
        Player player1 = new Player(1, "Dima", 500);
        Player player2 = new Player(2, "Vova", 500);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Vitia", "Petiy"));
    }
}
