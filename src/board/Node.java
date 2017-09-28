package board;

public class Node {
    public int x;
    public int y;

    public boolean fixed;
    public boolean occupied;

    public Node() {
        this.x = 0;
        this.y = 0;
        System.out.println("New node created at " + 0 + " " + 0);
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("New node created at " + x + " " + y);
    }


}
