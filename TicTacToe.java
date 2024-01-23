/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THEKISO MTSHANYELO
 */
public class TicTacToe {

    static ArrayList<Integer> playerposition = new ArrayList<>();
    static ArrayList<Integer> cpuposition = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random rand = new Random();

        char[][] grid = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

        boardgame(grid);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();

            while (playerposition.contains(playerPos) || cpuposition.contains(playerPos)) {

                System.out.println("Position occupied! Enter a correct Position");
                playerPos = scan.nextInt();

            }

            placepiece(grid, playerPos, "player");
            playerposition.add(playerPos);

            String winner = verifyWin();

            if (winner.length() > 0) {

                System.out.println(winner);
                break;
            }

            int secondPos = rand.nextInt(9) + 1;

            while (playerposition.contains(secondPos) || cpuposition.contains(secondPos) || secondPos == playerPos) {

                System.out.println("Position occupied! Enter a correct Position");
                secondPos = rand.nextInt(9) + 1;

            }
            placepiece(grid, secondPos, "cpu");
            cpuposition.add(secondPos);

            boardgame(grid);
            winner = verifyWin();

            if (winner.length() > 0) {

                System.out.println(winner);
                break;
            }

        }

    }

    public static String verifyWin() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> diagonalRight = Arrays.asList(1, 5, 9);
        List<Integer> diagonalLeft = Arrays.asList(3, 5, 7);

        List<List<Integer>> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diagonalRight);
        winning.add(diagonalLeft);

        for (List<Integer> list : winning) {
            if (playerposition.containsAll(list)) {
                return "Congratulations, you won!";
            } else if (cpuposition.containsAll(list)) {
                return "Sorry, you lost. Try again.";
            }
        }

        if (playerposition.size() + cpuposition.size() == 9) {
            return "Draw";
        }

        return "";
    }

    public static void placepiece(char[][] grid, int pos, String user) {

        char symbol = ' ';

        if (user.equals("player")) {

            symbol = 'X';
            playerposition.add(pos);

        } else if (user.equals("cpu")) {

            symbol = 'O';
            cpuposition.add(pos);

        }

        switch (pos) {

            case 1:
                grid[0][0] = symbol;
                break;
            case 2:
                grid[0][2] = symbol;
                break;
            case 3:
                grid[0][4] = symbol;
                break;
            case 4:
                grid[2][0] = symbol;
                break;
            case 5:
                grid[2][2] = symbol;
                break;
            case 6:
                grid[2][4] = symbol;
                break;
            case 7:
                grid[4][0] = symbol;
                break;
            case 8:
                grid[4][2] = symbol;
                break;
            case 9:
                grid[4][4] = symbol;
                break;

            default:
                System.out.println("Invalid");

        }
    }

    public static void boardgame(char[][] grid) {

        for (char[] x : grid) {
            for (char i : x) {
                System.out.print(i);

            }
            System.out.println();
        }

    }
}
