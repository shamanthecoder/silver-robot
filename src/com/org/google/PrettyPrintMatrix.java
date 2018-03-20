package com.org.google;

import java.util.ArrayList;
import java.util.Scanner;


public class PrettyPrintMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = Integer.parseInt(scan.next());
		ArrayList<ArrayList<Integer>> result = printArray(A);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.size(); j++) {
				System.out.print(result.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> printArray(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A <= 0)
			return result;

		int n = 2 * A - 1;
		int[][] matrix = new int[n][n];
		int i = 0;
		int j = 0;
		int dir = 0;

		for (int num = A; num > 0; num--) {
			int size = num == 1 ? 1 : (2 * num - 1) * (2 * num - 1) - (2 * num - 3) * (2 * num - 3);
			int count = 0;
			while (count < size) {
				count++;
				matrix[i][j] = num;
				if (dir == 0) {
					j++;
					if (j == n || matrix[i][j] != 0) {
						j--;
						dir = 1;
						i++;
					}
				} else if (dir == 1) {
					i++;
					if (i == n || matrix[i][j] != 0) {
						i--;
						dir = 2;
						j--;
					}
				} else if (dir == 2) {
					j--;
					if (j < 0 || matrix[i][j] != 0) {
						j++;
						i--;
						dir = 3;
					}
				} else {
					i--;
					if (i < 0 || matrix[i][j] != 0) {
						i++;
						j++;
						dir = 0;
					}
				}
			}
		}

		for (int p = 0; p < n; p++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int q = 0; q < n; q++) {
				list.add(matrix[p][q]);
			}
			result.add(list);
		}
		return result;
	}

}
