package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
   private List<Horse> horses;
    static Hippodrome game;
    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
      for (Horse horse : horses)
       horse.move();
    }
    public void run() throws InterruptedException {
     for(int i = 0; i < 100; i++){
      move();
      print();
      Thread.sleep(200);
     }
    }
    public void print() {
        for (Horse horse : horses)
         horse.print();

        for (int i = 0; i < 10; i++)
         System.out.println();
    }
    public Horse getWinner() {
     Horse winner = horses.get(0);
     for (Horse horse : horses){
      if (horse.getDistance() > winner.getDistance())
       winner = horse;
     }
     return winner;
    }
    public void printWinner() {
      System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public static void main(String[] args) throws InterruptedException {
     game = new Hippodrome(new ArrayList<>());
     game.getHorses().add(new Horse("Laka", 3, 0));
     game.getHorses().add(new Horse("Laga", 3, 0));
     game.getHorses().add(new Horse("Dada", 3, 0));
     game.run();
     game.printWinner();
    }
}
