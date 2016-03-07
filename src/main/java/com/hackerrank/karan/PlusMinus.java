package com.hackerrank.karan;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.DecimalFormat;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        DecimalFormat six = new DecimalFormat("##0.000000");
        int sum_pos = 0;
        int sum_neg = 0;
        int sum_zer = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            int temp = arr[arr_i];
            if(temp == 0){
                sum_zer++;
            }
            else if(temp > 0){
                sum_pos++;
            }
            else if(temp<0){
                sum_neg++;
            }            
        }
        double pos = ((double)sum_pos)/n;
        double neg = sum_neg/n;
        double zer = sum_zer/n;
        System.out.println(sum_pos);
        System.out.println(sum_neg);
        System.out.println(sum_zer);
        System.out.println(n);
        System.out.println(six.format(pos));
        System.out.println(six.format(neg));
        System.out.println(six.format(zer));
    }
}
