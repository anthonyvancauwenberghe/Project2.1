package com.ingenious.algorithms.impl.Q_Learning;

/**
 * Created by carolley on 01-Dec-17.
 */
public class QTable {

    /**
     * Q-values for each action possible (placing: RED, BLUE, GREEN, ORANGE, YELLOW PURPLE)
     */

    private double [] q_values;

    public QTable(double [] q_values){
        this.q_values = q_values;
    }

    public QTable(){
        double q_values [] = {0.0,0.0,0.0,0.0,0.0,0.0};
        this.q_values = q_values;
    }

    public double [] getQ_table(){
        return q_values;
    }

    public void editQ_table(double [] q_values){
        this.q_values = q_values;
    }

    public double get_RedQ(){
        return this.q_values[0];
    }

    public void set_RedQ(double redQ){
        this.q_values[0]= redQ;
    }

    public double get_BlueQ(){
        return this.q_values[1];
    }

    public void set_BlueQ(double blueQ){
        this.q_values[1]= blueQ;
    }

    public double get_GreenQ(){
        return this.q_values[2];
    }

    public void set_GreenQ(double greenQ){
        this.q_values[2]= greenQ;
    }

    public double get_OrangeQ(){
        return this.q_values[3];
    }

    public void set_OrangeQ(double orangeQ){
        this.q_values[3]= orangeQ;
    }

    public double get_YellowQ(){
        return this.q_values[4];
    }

    public void set_YellowQ(double yellowQ){
        this.q_values[4]= yellowQ;
    }

    public double get_PurpleQ(){
        return this.q_values[5];
    }

    public void set_PurpleQ(double purpleQ){
        this.q_values[5]= purpleQ;
    }

    public int index_argmaxQ(){
        int index = 0;
        for(int i=1; i<6; i++){
            if(this.q_values[i] > this.q_values[index]){
                index = i;
            }
        }
        return index;
    }

}
