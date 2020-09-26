package org.learn.dp.knapsak.sumsubset;

/**
 * Checking if sum of subsets exists or not with the given sum in the data
 * */
public class SumOfSubSet {

    public boolean checkIfSumOfSubsetsExists(int[] data, int sum) {
        Boolean[][] matrix = initMatrix(data.length, sum);
        for (int rowIndex = 1; rowIndex < data.length+1; rowIndex++) {
            for (int weightIndex=1; weightIndex < sum+1; weightIndex++) {
                if (data[rowIndex-1] <= weightIndex) {
                    matrix[rowIndex][weightIndex] = matrix[rowIndex-1][weightIndex-data[rowIndex-1]] || matrix[rowIndex-1][weightIndex];
                } else {
                    matrix[rowIndex][weightIndex] = matrix[rowIndex-1][weightIndex];
                }
            }
        }
        //printMatrixData(matrix);
        return matrix[data.length][sum];
    }

    private void printMatrixData(Boolean[][] matrix) {
        for (Boolean[] rowData : matrix) {
            for (Boolean elementInRow : rowData) {
                System.out.print(elementInRow + "   ");
            }
            System.out.println();
        }
    }

    private Boolean[][] initMatrix(int rowSize, int columnSize) {
        Boolean[][] t = new Boolean[rowSize + 1][columnSize + 1];
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex <columnSize+1; columnIndex++) {
                if (rowIndex == 0) {
                    t[rowIndex][columnIndex] = false;
                }
                if (columnIndex == 0) {
                    t[rowIndex][columnIndex] = true;
                }
            }
        }
        return t;
    }
}
