package tests;

import tests.impl.BoardTesting;

public class Tests {
    private static Tests instance = null;

    protected Tests() {

    }

    public static Tests getInstance() {
        if (instance == null) {
            instance = new Tests();
        }
        return instance;
    }

    /* ALL TESTS YOU WANT TO EXECUTE GO IN HERE */
    public void execute() {
        BoardTesting test = new BoardTesting();
        test.lightUpAllNodes();
    }


}
