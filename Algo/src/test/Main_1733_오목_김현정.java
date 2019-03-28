package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1733_오목_김현정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean isWin = false;

		b: for (int i = 0; i < 19; i++) {
		 	for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) {
					boolean isSame = true;
					// 가로(오른쪽)
					for (int k = j + 1; k < j + 5; k++) {
						if (k > 18) {
							isSame = false;
							break;
						}
						if (board[i][k] != board[i][j]) {
							isSame = false;
							break;
						}
					}
					if (isSame) {
						if (j - 1 >= 0 && board[i][j - 1] == board[i][j]) {
							continue;
						}
						if (j + 5 > 18) {
							System.out.println(board[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							isWin = true;
							break b;
						} else {
							if (board[i][j + 5] != board[i][j]) {
								System.out.println(board[i][j]);
								System.out.println((i + 1) + " " + (j + 1));
								isWin = true;
								break b;
							}
						}
					}
					// 세로(아래쪽)
					isSame = true;
					for (int k = i + 1; k < i + 5; k++) {
						if (k > 18) {
							isSame = false;
							break;
						}
						if (board[k][j] != board[i][j]) {
							isSame = false;
							break;
						}
					}
					if (isSame) {
						if (i - 1 >= 0 && board[i - 1][j] == board[i][j]) {
							continue;
						}
						if (i + 5 > 18) {
							System.out.println(board[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							isWin = true;
							break b;
						} else {
							if (board[i + 5][j] != board[i][j]) {
								System.out.println(board[i][j]);
								System.out.println((i + 1) + " " + (j + 1));
								isWin = true;
								break b;
							}
						}
					}
					// 대각선 오른쪽 아래
					isSame = true;
					for (int k = 1; k < 5; k++) {
						if (i + k > 18 || j + k > 18) {
							isSame = false;
							break;
						}
						if (board[i + k][j + k] != board[i][j]) {
							isSame = false;
							break;
						}
					}
					if (isSame) {
						if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == board[i][j]) {
							continue;
						}
						if (i + 5 > 18 || j + 5 > 18) {
							System.out.println(board[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							isWin = true;
							break b;
						} else {
							if (board[i + 5][j + 5] != board[i][j]) {
								System.out.println(board[i][j]);
								System.out.println((i + 1) + " " + (j + 1));
								isWin = true;
								break b;
							}
						}
					}
					// 대각선 왼쪽 아래
					isSame = true;
					for (int k = 1; k < 5; k++) {
						if (i + k > 18 || j - k < 0) {
							isSame = false;
							break;
						}
						if (board[i + k][j - k] != board[i][j]) {
							isSame = false;
							break;
						}
					}
					if (isSame) {
						if (i - 1 >= 0 && j + 1 < 19 && board[i - 1][j + 1] == board[i][j]) {
							continue;
						}
						if (i + 5 > 18 || j - 5 < 0) {
							System.out.println(board[i][j]);
							System.out.println((i + 4 + 1) + " " + (j - 4 + 1));
							isWin = true;
							break b;
						} else {
							if (board[i + 5][j - 5] != board[i][j]) {
								System.out.println(board[i][j]);
								System.out.println((i + 4 + 1) + " " + (j - 4 + 1));
								isWin = true;
								break b;
							}
						}
					}
				}
			}
		}

		if (!isWin) {
			System.out.println(0);
		}

	}// end main
}// end class
