import java.io.*;

public class MatricesABC {
    public static void main(String[] args) throws IOException {

        DataInputStream readMatrixA = new DataInputStream(new FileInputStream("a.mat"));
        int rowsA = readMatrixA.readByte();
        int colsA = readMatrixA.readByte();
        Double[][] matrixA = readMatrix(readMatrixA, rowsA, colsA);

        DataInputStream readMatrixB = new DataInputStream(new FileInputStream("b.mat"));
        int rowsB = readMatrixB.readByte();
        int colsB = readMatrixB.readByte();
        Double[][] matrixB = readMatrix(readMatrixB, rowsB, colsB);

        Double[][] matrixC = new Double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                matrixC[i][j] = sum;
            }
        }

        //a
        System.out.println("Matriz a.mat:");
        printMatrix(matrixA);
        System.out.println();

        //b
        System.out.println("Matriz b.mat:");
        printMatrix(matrixB);
        System.out.println();

        //c
        System.out.println("Matriz c.mat:");
        printMatrix(matrixC);

        DataOutputStream writeMatrixC = new DataOutputStream(new FileOutputStream("c.mat"));
        writeMatrix(writeMatrixC, matrixC);

    }//Fin Main

    //leerM
    public static Double[][] readMatrix(DataInputStream input, int rows, int cols) throws IOException {
        Double[][] matrix = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.readDouble();
            }
        }
        return matrix;
    }

    //EscribirM
    public static void writeMatrix(DataOutputStream output, Double[][] matrix) throws IOException {
        for (Double[] row : matrix) {
            for (Double value : row) {
                output.writeDouble(value);
            }
        }
    }

    //PrintM
    public static void printMatrix(Double[][] matrix) {
        for (Double[] row : matrix) {
            for (Double value : row) {
                System.out.printf("%8.2f ", value);
            }
            System.out.println();
        }
    }
}//fin clase

/*
Los archivos a.mat y b.mat son archivos binarios que contienen los datos matrices con valores numéricos reales.
El primer byte en el archivo indica el número de renglones en la matriz.
El segundo byte indica el número de columnas en la matriz.
Los datos restantes en el archivo corresponden a los valores de tipo double almacenados en la matriz.

Elaborar un programa que lea los archivos a.mat y b.mat y calcule el producto de las matrices.
Almacenar el resultado en un archivo c.mat con el mismo formato de los archivos de entrada.

//JDSD

 */