package Greedy;

import java.util.Scanner;
import java.io.File;
import java.util.Vector;
import java.util.Collections;


class Item implements Comparable<Item>{
    private int weight;
    private int value;
    private float ratio;

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    public float getRatio(){
        return this.ratio;
    }

    @Override
    public int compareTo(Item o) {
        if (this.ratio > o.getRatio()){
            return 1;
        }else if (this.ratio == o.getRatio()){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString(){
        return "(" + this.weight + ", " + this.value + ", " + this.ratio + ")";
    }
}

public class FractionalKnapsack {
    
    private Float calculateMaximumProfit(Vector<Item> Items, Integer MaxCapacity){
        Collections.sort(Items);
        Collections.reverse(Items);

        Float maxProfit = 0f;
        for (Item i: Items){
            if (MaxCapacity > i.getWeight()){
                MaxCapacity -= i.getWeight();
                maxProfit += i.getValue(); 
            }else {
                maxProfit += i.getRatio() * (float)MaxCapacity;
                MaxCapacity = 0;
                break;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) throws Exception{

        File file = new File("FractionalKnapsackInput.txt");
        Scanner sc = new Scanner(file);

        Vector<Item> Items = new Vector<Item>();
        int MaxCapacity = sc.nextInt();
        while(sc.hasNext()){
            int value = sc.nextInt();
            int weight = sc.nextInt();

            Item item = new Item(weight, value);
            Items.add(item);
        }

        FractionalKnapsack fk = new FractionalKnapsack();
        float maxProfit = fk.calculateMaximumProfit(Items, MaxCapacity);
        System.out.println(maxProfit);
        sc.close();

    }
}

