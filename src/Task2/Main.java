/*
Дан массив NxN.
Напишите программу на Java которая находит минимальный элемент диагонали на картинке,
без учёта элемента пересечения диагоналей.

Пример:
1 2 3 4 *5*
5 6 9 !2! 1
0 9 1 8 7
6 *3* 6 6 6
*99* 100 -2 3 1
 */

package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array;
        int n;

        n = inputArraySize(sc);

        array = new int[n][n];
        fillArray(sc, array);

        System.out.println("Минимальный элемент на диагонали, без учёта пересечения: " + findMinDiagonalElement(array));
        sc.close();
    }

    private static int inputArraySize(Scanner sc) {
        int size = 0;
        while (size <= 0) {
            System.out.println("Введите размер массива NxN больше 0: ");
            while (!sc.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число для размера массива:");
                sc.next();
            }
            size = sc.nextInt();

        }
        return size;
    }

    private static void fillArray(Scanner sc, int[][] array) {
        System.out.println("Заполните массив произвольными числами: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                while (true) {
                    if (sc.hasNextInt()) {
                        array[i][j] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка! Введите целое число для элемента массива:");
                        sc.next();
                    }
                }
            }
        }
    }

    private static int findMinDiagonalElement(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int j = 0, i = array.length - 1; j < array.length && i >= 0; i--, j++) {
            if (i == j) {
                continue;
            }
            if (min > array[j][i]) {
                min = array[j][i];
            }
        }
        return min;
    }
}

