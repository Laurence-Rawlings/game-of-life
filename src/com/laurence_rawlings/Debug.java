package com.laurence_rawlings;

public class Debug {

    public static void main(String[] args) {
	    Board b = new Board(50, 10);
	    System.out.println(b);

	    b.createCell(10, 5);
        b.createCell(10, 6);
        b.createCell(10, 7);
	    System.out.println(b);

	    b.updateBoard();
	    System.out.println(b);

        b.updateBoard();
        System.out.println(b);
    }
}
