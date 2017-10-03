package providers.impl;

import models.pieces.Bag;
import models.pieces.Pieces;
import providers.Provider;

public class BagProvider extends Provider {
    private Bag bag;

    @Override
    protected void initialize() {
        this.bag = new Bag();
        this.fillInitialBag();
    }

    public Bag getBag() {
        return bag;
    }

    private void fillInitialBag() {

        /* FILL THE BAG WITH 6 PIECES OF A DIFFERENT COLOR */
        for (int i = 0; i < 6; i++) {
            this.bag.addPiece(Pieces.REDBLUE.getPiece());
            this.bag.addPiece(Pieces.REDGREEN.getPiece());
            this.bag.addPiece(Pieces.REDORANGE.getPiece());
            this.bag.addPiece(Pieces.REDYELLOW.getPiece());
            this.bag.addPiece(Pieces.REDPURPLE.getPiece());

            this.bag.addPiece(Pieces.BLUEGREEN.getPiece());
            this.bag.addPiece(Pieces.BLUEORANGE.getPiece());
            this.bag.addPiece(Pieces.BLUEYELLOW.getPiece());
            this.bag.addPiece(Pieces.BLUEPURPLE.getPiece());

            this.bag.addPiece(Pieces.GREENORANGE.getPiece());
            this.bag.addPiece(Pieces.GREENYELLOW.getPiece());
            this.bag.addPiece(Pieces.GREENPURPLE.getPiece());

            this.bag.addPiece(Pieces.ORANGEYELLOW.getPiece());
            this.bag.addPiece(Pieces.ORANGEPURPLE.getPiece());

            this.bag.addPiece(Pieces.YELLOWPURPLE.getPiece());
        }

        /* FILL THE BAG WITH 5 PIECES OF THE SAME COLOR */
        for (int i = 0; i < 5; i++) {
            this.bag.addPiece(Pieces.REDRED.getPiece());
            this.bag.addPiece(Pieces.BLUEBLUE.getPiece());
            this.bag.addPiece(Pieces.GREENGREEN.getPiece());
            this.bag.addPiece(Pieces.ORANGEORANGE.getPiece());
            this.bag.addPiece(Pieces.YELLOWYELLOW.getPiece());
            this.bag.addPiece(Pieces.PURPLEPURPLE.getPiece());
        }
    }
}
