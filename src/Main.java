import providers.impl.GameServiceProvider;

public class Main {

    public static void main(String[] args) {
        GameServiceProvider.boot();
        //GameServiceProvider.test().moveFirstPlayerScore();
        //GameServiceProvider.test().changeSecondPlayerScore();
        //GameServiceProvider.test().lightUpAllTiles();
    }
}
