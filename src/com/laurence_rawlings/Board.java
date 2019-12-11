package com.laurence_rawlings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private int width;
    private int height;
    private boolean[][] board;

    public Board() {
        this(50, 50);
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new boolean[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCell(int x, int y) {
        try {
            return board[y][x];
        } catch (IndexOutOfBoundsException ignored) {
            return false;
        }
    }

    public void createCell(int x, int y) {
        try {
            board[y][x] = true;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void killCell(int x, int y) {
        try {
            board[y][x] = false;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void setCell(int x, int y, boolean state) {
        try {
            board[y][x] = state;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public boolean checkCell(int x, int y) {
        boolean cell = isCell(x, y);
        int neighbours = 0;

        for (int nX = x - 1; nX <= x + 1; nX++) {
            for (int nY = y - 1; nY <= y + 1; nY++) {
                if (isCell(nX, nY)) {
                    if (!(x == nX && y == nY)) {
                        neighbours++;
                    }
                }
            }
        }

        if (cell) {
            return neighbours == 2 || neighbours == 3;
        } else {
            return neighbours == 3;
        }
    }

    public void updateBoard() {
        boolean[][] tempBoard = new boolean[height][width];
        copy(board, tempBoard);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tempBoard[y][x] = checkCell(x, y);
            }
        }

        copy(tempBoard, board);
    }

    public void copy(boolean[][] board, boolean[][] boardCopy) {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                boardCopy[x][y] = board[x][y];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("┌" + IntStream.range(0, width).mapToObj(i -> "─")
                .collect(Collectors.joining("")) + "┐\n");
        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder();
            row.append("│");
            for (int x = 0; x < width; x++) {
                row.append(isCell(x, y) ? "x" : " ");
            }
            row.append("│\n");
            out.append(row);
        }
        out.append("└" + IntStream.range(0, width).mapToObj(i -> "─")
                .collect(Collectors.joining("")) + "┘");

        return out.toString();
    }
}
