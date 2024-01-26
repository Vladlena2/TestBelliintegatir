/*
Создать алгоритм заполнения матрицы согласно схемам, приведенным ниже:

1 1 1 1
1 0 0 1
1 0 0 1
1 1 1 1

2 2 2 2 2 2
2 1 1 1 1 2
2 1 0 0 1 2
2 1 0 0 1 2
2 1 1 1 1 2
2 2 2 2 2 2

3 3 3 3 3 3 3 3
3 2 2 2 2 2 2 3
3 2 1 1 1 1 2 3
3 2 1 0 0 1 2 3
3 2 1 0 0 1 2 3
3 2 1 1 1 1 2 3
3 2 2 2 2 2 2 3
3 3 3 3 3 3 3 3

 */

package Task3;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array;
        int n = 0;

        while (n <= 0) {
            System.out.println("Введите длину массива больше 0: ");
            while (!sc.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число для размера массива:");
                sc.next();
            }
            n = sc.nextInt();
        }

        array = new int[n][n];

        makeSnake(array, n);
        printSnake(array);
    }

    private static void makeSnake(int[][] array, int length) {
        int number = length / 2 - 1;

        for (int delta = 0; delta < length - 2; delta++) {
            for (int i = 0 + delta; i < length - delta; i++) {
                array[i][length - 1 - delta] = number;
            }
            for (int i = length - 1 - delta; i >= 0 + delta; i--) {
                array[length - 1 - delta][i] = number;
            }
            for (int i = length - 1 - delta; i >= 1 + delta; i--) {
                array[i][0 + delta] = number;
            }
            for (int i = 0 + delta; i < length - delta - 1; i++) {
                array[0 + delta][i] = number;
            }

            // Если length нечетное
            if (number > 0) {
                number--;
            }
        }
    }

    private static void printSnake(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
    }
}
