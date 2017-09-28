package providers;

import providers.impl.BoardProvider;
import providers.impl.GuiProvider;
import providers.impl.PlayerProvider;
import providers.impl.RackProvider;

public class GameServiceProvider extends Provider {

    private static GameServiceProvider singleton;
    private BoardProvider boardProvider;
    private PlayerProvider playerProvider;
    private RackProvider rackProvider;
    private GuiProvider guiProvider;

    protected void initialize() {
        boardProvider = new BoardProvider();
        playerProvider = new PlayerProvider();
        rackProvider = new RackProvider();
        guiProvider = new GuiProvider();
    }

    public static void boot() {
        try {
            if (singleton == null)
                singleton = new GameServiceProvider();
            else
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            System.out.println("Error application is already booted.");
        }
    }

    private static void verifyInitialization() {
        try {
            if (singleton == null)
                throw new IllegalStateException();
        } catch (IllegalStateException exception) {
            System.out.println("Critical error application was not booted.");
            System.exit(1);
        }
    }

    public static GuiProvider getGuiProvider() {
        verifyInitialization();
        return singleton.guiProvider;
    }

    public static BoardProvider getBoardProvider() {
        verifyInitialization();
        return singleton.boardProvider;
    }

    public static PlayerProvider getPlayerProvider() {
        verifyInitialization();
        return singleton.playerProvider;
    }

    public static RackProvider getRackProvider() {
        verifyInitialization();
        return singleton.rackProvider;
    }

    public static void restart() {
        GameServiceProvider.getGuiProvider().getGui().dispose();
        singleton = new GameServiceProvider();
    }

}
