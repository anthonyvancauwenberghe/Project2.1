package board; /**
 * Created by alexisguillot on 14/09/2017.
 */

import java.util.ArrayList;

public class Board {

    private static ArrayList<Node> nodes = new ArrayList<Node>(); //This is the list containing the nodes

    public static void initBoard() {
        int cnt = 0; //This counter keeps track of the number of nodes that were created
        int board_width = 6; // this is the radius of nodes from the center to the end of the board (incl. center)
        int tmp_top = -(board_width - 1);//reference to keep track of the decrease in the number of hexes to be created
        for (int i = 0; i < board_width; i++) //loop as many times as there are columns on the sides of the central one (* 2)
        {
            for (int j = board_width - 1; j >= tmp_top; j--) {
                if (i == 0) {
                    nodes.add(new Node(i, -j)); //Create nodes only once for the case when i is 0 because it is the center
                    ++cnt;
                } else {
                    nodes.add(new Node(i, -j));
                    nodes.add(new Node(-i, j)); // then creates 2 version of the node, its regular and mirrored version.
                    cnt += 2;
                }
            }
            ++tmp_top; //update the size of the colum to be generated and loop again
        }
        System.out.println(cnt + " nodes have been created");
    }

    public static ArrayList<Node> getNodes() {
        if (Board.nodes.isEmpty()) {
            Board.initBoard();
        }
        return nodes;
    }

}
