package providers;

import providers.impl.*;

public class GameServiceProvider extends Provider {

    private static GameServiceProvider instance;

    private BoardProvider boardProvider;
    private PlayerProvider playerProvider;
    private BagProvider bagProvider;
    private GuiProvider guiProvider;

    protected void initialize() {
        boardProvider = new BoardProvider();
        bagProvider = new BagProvider();
        playerProvider = new PlayerProvider(bagProvider.getBag());
        guiProvider = new GuiProvider();
    }

    public static void boot() {
        try {
            if (instance == null)
                instance = new GameServiceProvider();
            else
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            System.out.println("Error application is already booted.");
        }
    }

    private static void verifyInitialization() {
        try {
            if (instance == null)
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            exception.printStackTrace();
            System.out.println("Critical error application was not booted.");
            System.exit(1);
        }
    }

    public static GuiProvider getGuiProvider() {
          verifyInitialization();
        return instance.guiProvider;
    }

    public static BoardProvider getBoardProvider() {
           verifyInitialization();
        return instance.boardProvider;
    }

    public static PlayerProvider getPlayerProvider() {
         verifyInitialization();
        return instance.playerProvider;
    }

    public static BagProvider getBagProvider() {
           verifyInitialization();
        return instance.bagProvider;
    }

    public static void restart() {
        GameServiceProvider.getGuiProvider().getGui().dispose();
        instance = new GameServiceProvider();
    }

}
