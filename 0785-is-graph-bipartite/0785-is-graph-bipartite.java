class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<biPair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited.containsKey(i)) {
                continue;
            }
            q.add(new biPair(i, 0));
            while (!q.isEmpty()) {
                // remove
                biPair rp = q.poll();
                // ignore
                if (visited.containsKey(rp.vtx)) {
                    if (visited.get(rp.vtx) != rp.dis) {
                        return false;
                    }
                    continue;
                }
                // mark visited
                visited.put(rp.vtx, rp.dis);
                // self work
                // add unvisietd nbrs
                for (int nbrs : graph[rp.vtx]) {
                    if (!visited.containsKey(nbrs)) {
                        q.add(new biPair(nbrs, rp.dis + 1));
                    }
                }
            }
        }
        return true;
    }

    class biPair {

        int vtx, dis;

        public biPair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}