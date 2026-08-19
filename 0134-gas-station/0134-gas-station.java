class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return gasStation(gas,cost);
    }
    public static int gasStation(int[] gas, int[] cost) {
        int gas1 = 0;
        int cost1 = 0;
        for (int i = 0; i < cost.length; i++) {
            gas1 += gas[i];
            cost1 += cost[i];
        }
        if (gas1 < cost1) {
            return -1;
        }
        int start = 0;
        int currgas = 0;
        for (int i = 0; i < gas.length; i++) {
            currgas = currgas + gas[i] - cost[i];
            if (currgas < 0) {
                start = i + 1;
                currgas = 0;
            }
        }
        return start;
    }
}