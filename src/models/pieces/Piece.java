package models.pieces;

import java.awt.*;

public class Piece {
    private Tile head;
    private Tile tail;
    private int n_available;

    public Piece(Tile head, Tile tail){
        this.head = head;
        this.tail = tail;
        if(head.getColor() == tail.getColor()){
            this.n_available = 5;
        }
        else{
            this.n_available = 6;
        }
    }

    public Tile getHead(){
        return head;
    }

    public Tile getTail(){
        return tail;
    }

    public Color[] colorCombo(){
        Color [] color = {head.getColor(), tail.getColor()};
        return color;
    }

    public int n_available(){
        return n_available;
    }

    public String toString(){
        String head_color =" ";
        String tail_color=" ";
        if(head.getColor() == Color.red){
            head_color = "red";
        }
        else if(head.getColor() == Color.green){
            head_color = "green";
        }
        else if(head.getColor() == Color.blue){
            head_color = "blue";
        }
        else if(head.getColor()== Color.orange){
            head_color = "orange";
        }
        else if(head.getColor() == Color.yellow){
            head_color = "yellow";
        }
        else if(head.getColor() == Color.pink){
            head_color = "pink";
        }

        if(tail.getColor() == Color.red){
            tail_color = "red";
        }
        else if(tail.getColor() == Color.green){
            tail_color = "green";
        }
        else if(tail.getColor() == Color.blue){
            tail_color = "blue";
        }
        else if(tail.getColor()== Color.orange){
            tail_color = "orange";
        }
        else if(tail.getColor() == Color.yellow){
            tail_color = "yellow";
        }
        else if(tail.getColor() == Color.pink){
            tail_color = "pink";
        }
        String name = head_color +" "+ tail_color;
        return name;
    }
}
