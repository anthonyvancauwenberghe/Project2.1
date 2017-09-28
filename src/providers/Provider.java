package providers;

abstract public class Provider {

    public Provider() {
        this.initialize();
    }

    protected abstract void initialize();
}
