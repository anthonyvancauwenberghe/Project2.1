import com.ingenious.models.tiles.Tile;
import com.ingenious.providers.impl.GameServiceProvider;
import tests.Tests;
import tests.impl.BoardTesting;

public class Main {
    public static void main(String[] args) {
        GameServiceProvider.boot();
        Tests.getInstance().execute();
    }
}
