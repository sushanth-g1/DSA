package com.dsa.learning.arrays;

public class PrefixSum {
    public static int[] sum(int[] arr){
        int n = arr.length;
        int[] Pf = new int[n];
        Pf[0] = arr[0];
        for(int i=1;i<n;i++){
            Pf[i]=Pf[i-1]+arr[i];                    // TC : O(N)
        }

        // Print Prefix Sum
        for(int j=0; j<n;j++){
            System.out.println(Pf[j]);
        }
        return Pf;
    }

    // Equilibrium Index
    public static void equilibriumIndex(int[] arr,int[] prefixSum){
        int c = 0;
        int n = prefixSum.length, left = 0, right = 0;
        for (int i=0; i<n; i++){
            if(i==0){
                left = 0;
            }
            else {
                left = prefixSum[i-1];
            }
            right = prefixSum[n-1] - prefixSum[i];
            if (left == right){
                System.out.println(" ********** "+arr[i]);
                System.out.println(" ********** "+left+"  ********** "+right);
                c++;
            }
        }
    }

    public static int[] prefixEven(int[] arr){
        int n = arr.length;
        int[] prefixEven = new int[n];
        prefixEven[0] = arr[0];
        for(int i=1;i<n;i++){
            if(i%2 == 0){
                prefixEven[i] = prefixEven[i-1]+arr[i];
            }
            else{
                prefixEven[i] = prefixEven[i-1];
            }
        }
        return prefixEven;
    }
    public static int[] prefixOdd(int[] arr){
        int n = arr.length;
        int[] prefixOdd = new int[n];
        prefixOdd[0] = 0;
        for(int i=1;i<n;i++){
            if(i%2 != 0){
                prefixOdd[i] = prefixOdd[i-1]+arr[i];
            }
            else{
                prefixOdd[i] = prefixOdd[i-1];
            }
        }
        return prefixOdd;
    }
    public static void specialIndex(int[] arr, int[] prefixEven, int[] prefixOdd){
        int c = 0,n = arr.length,sumEven=0,sumOdd=0;
        for(int i=0;i<n;i++){
            if(i==0){
                sumEven = prefixOdd[n-1]-prefixOdd[i];
                sumOdd  = prefixEven[n-1]-prefixEven[i];
            }else {
                sumEven = prefixEven[i-1]+(prefixOdd[n-1]-prefixOdd[i]);
                sumOdd = prefixOdd[i-1]+(prefixEven[n-1]-prefixEven[i]);
            }
            if(sumEven == sumOdd){
                System.out.println("*** index : "+i+", element : "+arr[i]+", sumEven = "+sumEven+", sumOdd = "+sumOdd);
                c++;
            }
        }
        System.out.println(c);
    }



    public static void main(String[] args) {
        int[] arr ={4,3,2,7,6,-2};
//        sum(arr);
//        equilibriumIndex(arr,sum(arr));
        specialIndex(arr,prefixEven(arr),prefixOdd(arr));

    }
}
