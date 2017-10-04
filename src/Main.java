import com.ingenious.providers.impl.GameServiceProvider;
import tests.Tests;

public class Main {
    public static void main(String[] args) {
        GameServiceProvider.boot();
        Tests.getInstance().execute();
    }
}
