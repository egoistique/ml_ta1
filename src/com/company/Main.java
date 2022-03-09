package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void input(int[][] arr, int size) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.println("Enter a[%d][%d]: "+ r + " " + c);
                 arr[r][c] = sc.nextInt();
            }
        }
    }

    public static void output(int [][] arr, int size) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.println(arr[r][c]);
                System.out.println(" ");
            }
            System.out.println("\n");
        }
    }

    // Получение матрицы без i-й строки и j-го столбца
    public static void getMatrix(int [][] arr, int [][] p, int i, int j, int m) {
        int ki, kj, di, dj;
        di = 0;
        for (ki = 0; ki < m - 1; ki++) { // проверка индекса строки
            if (ki == i) di = 1;
            dj = 0;
            for (kj = 0; kj < m - 1; kj++) { // проверка индекса столбца
                if (kj == j) dj = 1;
                p[ki][kj] = arr[ki + di][kj + dj];
            }
        }
    }

    public static int determinant(int[][] arr, int m) {
        int i, j, d, k, n;
        int [][] p = new int[m][m];
        j = 0; d = 0;
        k = 1; //(-1) в степени i
        n = m - 1;
        if (m < 1) {
            System.out.println("Определитель вычислить невозможно!");
        }
        if (m == 1) {
            return  arr[0][0];
        }
        if (m == 2) {
            return arr[0][0] * arr[1][1] - (arr[1][0] * arr[0][1]);
        }
        if (m > 2) {
            for (i = 0; i < m; i++) {
                getMatrix(arr, p, i, 0, m);
                d = d + k * arr[i][0] * determinant(p, n);
                k = -k;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        int size = 3;
        int [][] arr = new int [size][size];
        input(arr, size);
        System.out.println(determinant(arr, size));
    }
}
