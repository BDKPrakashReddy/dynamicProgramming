package org.learn.dp.knapsak.sumsubset;

public class MinimumSubsetSum {

    public int getMinimumSubsetSum(int[] data) {
        int maxSum = getMaxSum(data);
        int matrixRowLength = data.length;
        int[][] matrixData = initMatrix(matrixRowLength, maxSum);

        doMatrixWeightCalculation(data, maxSum, matrixData);
        int[] allElementsWeights = matrixData[matrixRowLength];
        int halfWeightIndex = 0;
        for (int index = 0; index <= maxSum / 2; index++) {
            if (allElementsWeights[index] > 0) {
                halfWeightIndex = index;
            }
        }
        return maxSum - 2 * halfWeightIndex;
    }

    private void doMatrixWeightCalculation(int[] data, int maxSum, int[][] matrixData) {
        //This will form weighed matrix data
        for (int dataIndex = 1; dataIndex < data.length + 1; dataIndex++) {
            for (int weightIndex = 1; weightIndex < maxSum + 1; weightIndex++) {
                if (data[dataIndex - 1] <= weightIndex) {
                    matrixData[dataIndex][weightIndex] = matrixData[dataIndex - 1][weightIndex - data[dataIndex - 1]]
                            + matrixData[dataIndex - 1][weightIndex];
                } else {
                    matrixData[dataIndex][weightIndex] = matrixData[dataIndex - 1][weightIndex];
                }
            }
        }
    }

    private int[][] initMatrix(int rowLength, int columnLength) {
        int[][] initMatrix = new int[rowLength + 1][columnLength + 1];
        for (int rowIndex = 0; rowIndex < rowLength + 1; rowIndex++) {
            for (int colIndex = 0; colIndex < columnLength + 1; colIndex++) {
                if (rowIndex == 0) {
                    initMatrix[rowIndex][colIndex] = 0;
                }
                if (colIndex == 0) {
                    initMatrix[rowIndex][colIndex] = 1;
                }
            }
        }
        return initMatrix;
    }

    private int getMaxSum(int[] data) {
        int maxSum = 0;
        for (int val : data) {
            maxSum += val;
        }
        return maxSum;
    }
}
