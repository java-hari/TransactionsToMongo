package com.app.mongo.util;
import java.util.*;

enum PotholeState {
    POTHOLE,
    CLEAN
}

public class RoadRepair {

    private static final Map<Character, PotholeState> STR_TO_STATE = Map.of(
        '.', PotholeState.CLEAN,
        'x', PotholeState.POTHOLE
    );

    public static List<List<PotholeState>> readLanes(String l1, String l2) {
        List<List<PotholeState>> road = new ArrayList<>();
        for (int i = 0; i < l1.length(); i++) {
            road.add(Arrays.asList(
                STR_TO_STATE.get(l1.charAt(i)),
                STR_TO_STATE.get(l2.charAt(i))
            ));
        }
        return road;
    }

    private static int maxRepairableHelper(List<PotholeState> lane1, List<PotholeState> lane2) {
        int n = lane1.size();
        int[] lane1Suffix = new int[n];
        int[] lane2Prefix = new int[n];

        // lane1 suffix potholes
        for (int i = n - 2; i >= 0; i--) {
            lane1Suffix[i] = lane1Suffix[i + 1];
            if (lane1.get(i + 1) == PotholeState.POTHOLE) {
                lane1Suffix[i]++;
            }
        }

        // lane2 prefix potholes
        for (int i = 1; i < n; i++) {
            lane2Prefix[i] = lane2Prefix[i - 1];
            if (lane2.get(i - 1) == PotholeState.POTHOLE) {
                lane2Prefix[i]++;
            }
        }

        int best = 0;
        for (int i = 0; i < n; i++) {
            best = Math.max(best, lane1Suffix[i] + lane2Prefix[i]);
        }
        return best;
    }

    public static int maxRepairableSegments(List<List<PotholeState>> road) {
        int n = road.size();
        List<PotholeState> lane1 = new ArrayList<>();
        List<PotholeState> lane2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lane1.add(road.get(i).get(0));
            lane2.add(road.get(i).get(1));
        }

        return Math.max(
            maxRepairableHelper(lane1, lane2),
            maxRepairableHelper(lane2, lane1)
        );
    }

    public static void main(String[] args) {
        String l1 = ".x..xx";
        String l2 = "xx..x.";

        List<List<PotholeState>> road = readLanes(l1, l2);
        System.out.println(maxRepairableSegments(road));
    }
}