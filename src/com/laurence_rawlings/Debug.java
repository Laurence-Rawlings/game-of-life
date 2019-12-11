package com.laurence_rawlings;

import java.io.IOException;

public class Debug {

    public static void main(String[] args) {
	    Board b = new Board(50, 10);

	    //Glider
	    b.createCell(10, 5);
        b.createCell(10, 6);
        b.createCell(10, 7);
        b.createCell(9, 7);
        b.createCell(8, 6);

        //Draw Loop
        while (true) {
            System.out.println(b);
            b.updateBoard();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
