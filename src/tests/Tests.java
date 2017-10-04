package tests;

import providers.impl.GameServiceProvider;

public class Tests {

    public void moveFirstPlayerScore(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1; i<6; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(0,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<7; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(1,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<8; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(2,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<9; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(3,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(4,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<11; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(0).setScore(5,i);
            GameServiceProvider.gui().repaintAll();

        }
    }

    public void changeSecondPlayerScore(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1; i<6; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(0,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<7; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(1,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<8; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(2,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<9; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(3,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(4,i);
            GameServiceProvider.gui().repaintAll();

        }

        for(int i=1; i<11; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameServiceProvider.players().getPlayer(1).setScore(5,i);
            GameServiceProvider.gui().repaintAll();

        }
    }
}
