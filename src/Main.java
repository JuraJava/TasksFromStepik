//        Дана матрица A размером 6 х 6, заполненная целыми числами, не превосходящими по модулю 10^4 .
//        Требуется поменять местами максимальный элемент внешнего квадрата  матрицы А
//        с максимальным элементом внутреннего квадрата. Вывести измененную матрицу на экран.
//        Формат входных данных
//        Программа получает на вход 6 строк по 6 чисел в каждой.
//        Формат выходных данных
//        Выведите матрицу размером 6 x 6.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        // Ввод матрицы
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Инициализация переменных для хранения максимальных элементов и их индексов
        int maxInternal = Integer.MIN_VALUE;
        int maxExternal = Integer.MIN_VALUE;
        int internalRow = -1, internalCol = -1;
        int externalRow = -1, externalCol = -1;

        // Поиск максимального элемента внутреннего квадрата
        for (int i = 2; i < 4; i++) {
            for (int j = 2; j < 4; j++) {
                if (matrix[i][j] > maxInternal) {
                    maxInternal = matrix[i][j];
                    internalRow = i;
                    internalCol = j;
                }
            }
        }

        // Поиск максимального элемента внешнего квадрата
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Исключаем внутренний квадрат
                if (i >= 2 && i <= 3 && j >= 2 && j <= 3) {
                    continue;
                }
                if (matrix[i][j] > maxExternal) {
                    maxExternal = matrix[i][j];
                    externalRow = i;
                    externalCol = j;
                }
            }
        }

        // Проверка на случай, если внутренний или внешний максимумы не были найдены
        if (internalRow != -1 && externalRow != -1) {
            // Меняем местами найденные элементы
            matrix[internalRow][internalCol] = maxExternal;
            matrix[externalRow][externalCol] = maxInternal;
        }

        // Вывод измененной матрицы
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}