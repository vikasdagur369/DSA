class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int[] maxProfit = new int[amount.length];
        Arrays.fill(maxProfit, -1);
        maxProfit[0] = amount[0];
        int[] degree = new int[amount.length];
        int[] parent = new int[amount.length];
        Arrays.fill(parent, -1);
        parent[0] = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[v]++;
            degree[u]++;
            queue.addLast(edge);
        }
        while (!queue.isEmpty()) {
            int[] edge = queue.pollFirst();
            int u = edge[0], v = edge[1];
            if (parent[u] != -1 && parent[v] != -1) {
                continue;
            }
            if (parent[u] == -1 && parent[v] == -1) {
                queue.addLast(edge);
                continue;
            }
            if (parent[u] == -1) {
                parent[u] = v;
            } else {
                parent[v] = u;
            }
        }
        int bobStep = 0;
        int bobCurrent = bob;
        while (bobCurrent != 0) {
            bobStep++;
            bobCurrent = parent[bobCurrent];
        }
        int aliceStep = bobStep / 2;
        bobCurrent = bob;
        while (bobCurrent != 0 && aliceStep-- >= 0) {
            if (aliceStep == -1 && bobStep % 2 == 0) {
                amount[bobCurrent] = amount[bobCurrent] / 2;
                break;
            }
            amount[bobCurrent] = 0;
            bobCurrent = parent[bobCurrent];
        }
        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1 && i > 0) {
                leafNodes.add(i);
            }
        }
        Stack<Integer> pathStack = new Stack<>();
        for (Integer idx : leafNodes) {
            int i = idx;
            while (maxProfit[parent[i]] == -1) {
                pathStack.add(i);
                i = parent[i];
            }
            maxProfit[i] = maxProfit[parent[i]] + amount[i];
            while (!pathStack.isEmpty()) {
                i = pathStack.pop();
                maxProfit[i] = maxProfit[parent[i]] + amount[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer idx : leafNodes) {
            max = Math.max(max, maxProfit[idx]);
        }
        return max;
    }
}
