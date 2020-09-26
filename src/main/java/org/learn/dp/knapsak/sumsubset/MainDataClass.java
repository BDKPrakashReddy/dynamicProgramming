package org.learn.dp.knapsak.sumsubset;

public class MainDataClass {
    public static void main(String[] args) {
        int[] data = {2, 3, 5, 8, 10};
        int sum = 10;
        /*System.out.println("Checking if sum of subsets exists or not with the given sum in the data, result : "
                + new SumOfSubSet().checkIfSumOfSubsetsExists(data, sum));

        System.out.println("Checking if the given data can be divided into 2 half with sum of elements in the halves are equal, result : "
                + new SumOfSubSet().checkIfSumOfSubsetsExists(data, sum));

        System.out.println("Checking the number of subsets exists with the sum equal to given weight in the given data, result : "
                + new CountOfSubSets().countOfSubSetsEqualToGivenSum(data, sum));*/

        System.out.println("Minimum Subset sum is : "+ new MinimumSubsetSum().getMinimumSubsetSum(data));
    }
}
