package com.hackerrank.karan;

import java.util.Scanner;

public class GridSearch {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            boolean isValid = false;
            int a = 0;
            for(int i = 0; i<R;i++){
            	char[] chArray = G[i].toCharArray();
            	for(int j = 0; j<C; j++){
            		char ch = chArray[j];
            		if(ch == P[a].charAt(0)){
            			if(isRestStringMatch(chArray, P[a], j, c)){
            				if(isGridMatch(G,P,i,j)){
            					isValid = true;
            				}
            			}
            		}
            	}
            }
            
            System.out.println(isValid?"YES":"NO");
        }
    }
	
	public static boolean isRestStringMatch(char[] gChArray, String p, int j, int c){
		char[] pChArray = p.toCharArray();
		int match=0;
		for(int k = 1; k<c;k++){
			if(j+k<gChArray.length){
				if(gChArray[j+k] == pChArray[k]){
					match++;
				}
			}
		}
		if(match == c-1){
			return true;
		}
		return false;
	}
	
	public static boolean isGridMatch(String G[], String P[], int i, int j){
		int match = 0;
		for(int a = 1; a < P.length ; a++){
			if(i+a<G.length){
				if(isRestStringMatch(G[i+a].toCharArray(), P[a], j, P[a].length())){
					match++;
				}
			}
		}
		if(match == P.length-1){
			return true;
		}
		return false;
	}

}
