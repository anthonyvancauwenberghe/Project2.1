package providers.impl;

import models.rack.Rack;
import providers.Provider;

public class RackProvider extends Provider {
    private Rack rack;

    @Override
    protected void initialize() {
        this.rack = new Rack();
    }

    public Rack getRack() {
        return rack;
    }
}
