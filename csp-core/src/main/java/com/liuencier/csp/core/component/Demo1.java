package com.liuencier.csp.core.component;

import java.util.Scanner;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-04 17:37
 **/
public class Demo1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[j][i] + " ");
            }
            System.out.println();
        }

    }
}
