package tests.impl;

import com.ingenious.providers.impl.GameServiceProvider;

public class ScoreTesting {
    public void moveFirstPlayerScore() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setRedScore(i);

        }

        for (int i = 1; i < 7; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setGreenScore(i);

        }

        for (int i = 1; i < 8; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setBlueScore(i);

        }

        for (int i = 1; i < 9; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setOrangeScore(i);

        }

        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setYellowScore(i);

        }

        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).score().setPurpleScore(i);

        }
    }

    public void changeSecondPlayerScore() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setRedScore(i);

        }

        for (int i = 1; i < 7; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setGreenScore(i);

        }

        for (int i = 1; i < 8; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setBlueScore(i);

        }

        for (int i = 1; i < 9; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setOrangeScore(i);

        }

        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setYellowScore(i);

        }

        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).score().setPurpleScore(i);

        }
    }
}
