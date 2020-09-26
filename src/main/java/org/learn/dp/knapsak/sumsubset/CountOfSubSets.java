package org.learn.dp.knapsak.sumsubset;

public class CountOfSubSets {

    public int countOfSubSetsEqualToGivenSum(int[] data, int weight) {
        int[][] matrix = initializeMatrix(data.length, weight);

        for (int dataIndex =1; dataIndex<data.length+1; dataIndex++) {
            for (int weightIndex = 1; weightIndex<weight+1;weightIndex++) {
                if (data[dataIndex-1] <= weightIndex) {
                    matrix[dataIndex][weightIndex] = matrix[dataIndex-1][weightIndex-data[dataIndex-1]]
                            + matrix[dataIndex-1][weightIndex];
                } else {
                    matrix[dataIndex][weightIndex] = matrix[dataIndex-1][weightIndex];
                }
            }
        }
        return matrix[data.length][weight];
    }

    /**
     * Initializing the matrix, here rowIndex represents data elements size from 0 and columnIndex -> weights from 0
     *  if data size is 0, then we can not make the subsets from it -> so count is 0
     *  if weight is 0, we can form a subset of size 1 which is empty subset {} (which don't have any elements)
     * */
    private int[][] initializeMatrix(int rowSize, int columnSize) {
        int[][] initMatrix = new int[rowSize + 1][columnSize + 1];
        for (int rowIndex = 0; rowIndex < rowSize + 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnSize + 1; columnIndex++) {
                if (rowIndex == 0) {
                    initMatrix[rowIndex][columnIndex] = 0;
                }
                if (columnIndex == 0) {
                    initMatrix[rowIndex][columnIndex] = 1;
                }
            }
        }
        return initMatrix;
    }
}
