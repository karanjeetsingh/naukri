package com.hackerrank.karan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CutTheSticks {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        List<Integer> sticks = new ArrayList<Integer>();
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            sticks.add(arr[arr_i]);
        }
        
        while(sticks.size()>0){
            System.out.println(sticks.size());
            Collections.sort(sticks);
            int minLength = sticks.get(0);
            for(ListIterator<Integer> iterator = sticks.listIterator(); iterator.hasNext(); ){
                Integer stick = iterator.next();
                stick-=minLength;
                if(stick <= 0){
                    iterator.remove();
                } else {
                    iterator.set(stick);
                }
            }
        }        
    }
}
