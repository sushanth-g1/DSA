package com.dsa.learning.arrays;

public class CarryForward {
    public static int subArray(char[] s){
        int c = 0,n=s.length;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(s[i] == 'g')
                c++;
            else if(s[i] == 'a')
                ans += c;
        }
        return ans;
    }
    public static int maxMin(int[] arr){
        int max = arr[0];
        for(int maximum : arr){
            max = Math.max(max,maximum);
        }
        int min = arr[0];
        for(int minimum : arr){
            min = Math.min(min,minimum);
        }



        int n=arr.length,len=0, ans = n, minIndex = -1, maxIndex = -1;
        for(int i=n-1;i>0;i--){
            if(min == max)
                return 1;
            if(arr[i]==min){
                minIndex = i;
                if(maxIndex != -1){
                    len = maxIndex-minIndex;
                    ans = Math.min(len,ans);
                }
            }else if(arr[i]==max){
                maxIndex = i;
                if(minIndex != -1){
                    len = minIndex-maxIndex;
                    ans = Math.min(len,ans);
                }
            }
        }
        System.out.println("ans");
        return ans;

    }

    public static void main(String[] args) {
//        char[] s = {'a','d','g','a','g','a','g','f','g'};
//        System.out.println(subArray(s));
        int[] ints = {1,6,4,6,5,1,5,2,6,4,4};
        System.out.println(maxMin(ints));
    }
}
