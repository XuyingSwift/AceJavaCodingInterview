package main.DataStructure.Arrays;

public class MinimumJumpsToReachTheEndOfArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumNumberOfJump(a, 0, a.length-1));
        System.out.println(minimumNumberOfJumpDP(a));
    }

    public static int minimumNumberOfJump(int[] a, int start, int end){
        //If start == end, we reached the end, return 0.
        if(start == end) return 0;

        //if current element is 0, you cannot jump to end at all
        if(a[start] == 0) return Integer.MAX_VALUE;

        int minimumJumps = Integer.MAX_VALUE;

        for(int k=start+1; k<=start+a[start] && k<=end; k++){
            /*
            For each K from start+1 to end, find the minimum jumps.
             */
            int jumps = minimumNumberOfJump(a,k,end);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < minimumJumps){
                minimumJumps  = jumps + 1;
            }
        }
        return minimumJumps;

    }

    public static int minimumNumberOfJumpDP(int[] a){

        if(a == null || a.length == 0) return 0;

        if(a[0] == 0) return Integer.MAX_VALUE;

        int[] jump = new int[a.length];

        //no jumps required for first element
        jump[0] = 0;

        for(int i=1; i<a.length;i++){
            jump[i] = Integer.MAX_VALUE;

            for(int j=0; j<i; j++){
                if(j+a[j]>=i && jump[j] != Integer.MAX_VALUE ){
                    jump[i] = Integer.min(jump[i], 1 + jump[j]);
                }
            }
        }
        return jump[a.length-1];
    }
}
