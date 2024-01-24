package com.dsa.learning.primenumber;

public class PrimeNumbers {
    //Prime Numbers
    public static boolean checkPrime(int n){
        if(n<=1){
            return false;
        }
        int noOfFactor = 0;
        for(int i=1; i<=n;i++){
            if(n%i == 0){
                noOfFactor++;
            }
            System.out.println(" **** i : "+i);
        }
        if(noOfFactor == 2){
            return true;
        }
        return false;
    }
    public static boolean checkPrime2(int n){
        if(n<=1){
            return false;
        }
        int noOfFactor = 0;
        for(int i=1; i<=Math.sqrt(n);i++){
            if(n%i == 0){
                noOfFactor++;
            }
            System.out.println(" **** i : "+i);
        }
        if(noOfFactor == 2){
            return true;
        }
        return false;
    }

    // Sieve of Eratosthenes
    public static void seivePrime(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=2;i<=n;i++){                      //for(int i=2;i<=Math.sqrt(n);i++)  i<=Math.sqrt(n) -----> 2nd Optimisation
            if(prime[i] == false){
                for (int j=i*2;j<=n;j=j+i){         //for (int j=i*i;j<=n;j=j+i)  j=i*i -----> 1st Optimisation
                    prime[j] = true;
                }
            }
        }
        for (int i=2;i<=n;i++){
            if (prime[i] == false){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        System.out.println(checkPrime(24));
//        System.out.println(checkPrime2(24));

        seivePrime(24);

        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        System.out.println("Runtime: " + runtime + " milliseconds");

    }
}
