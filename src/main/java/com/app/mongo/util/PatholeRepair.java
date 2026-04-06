package com.app.mongo.util;

public class PatholeRepair {

    public static int maxRepairedPotholes(String L1, String L2) {
        int n = L1.length();
        int totalPotholes = 0;
        for (char c : L1.toCharArray()) {
            if (c == 'x') totalPotholes++;
        }
        for (char c : L2.toCharArray()) {
            if (c == 'x') totalPotholes++;
        }

        // dp[i][0] = min potholes in path from index 0 to i ending in L1
        // dp[i][1] = min potholes in path from index 0 to i ending in L2
        int[][] dp = new int[n][2];
        dp[0][0] = (L1.charAt(0) == 'x' ? 1 : 0);
        dp[0][1] = (L2.charAt(0) == 'x' ? 1 : 0);

        for (int i = 1; i < n; i++) {
            // To reach L1[i], we can come from L1[i-1] or L2[i-1]
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + (L1.charAt(i) == 'x' ? 1 : 0);
            // To reach L2[i], we can come from L2[i-1] or L1[i-1]
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (L2.charAt(i) == 'x' ? 1 : 0);
        }

        int minPotholesInPath = Math.min(dp[n-1][0], dp[n-1][1]);
        return totalPotholes - minPotholesInPath;
    }
    
    public static void main(String[] args) {
    	PatholeRepair pr = new PatholeRepair();
    	System.out.println( pr.maxRepairedPotholes("XXX.X","X...X"));
	}
}
