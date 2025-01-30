class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // ALgo :
        // 1. Check  Bipertite graph & make component
        // 2 If true the do bfs form each component nodes and cnt the depth else if not bipertite return -1;
        // 3. take max of all bfs
        // 4. return max -- TC   V*(V+E) -- 500 *(10500)  ~ 10^6 -- should work ::

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge :edges){
            int u = edge[0] , v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        List<List<Integer>> components = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            if(color[i]==-1){
                List<Integer> component = new ArrayList<>();
                if (!checkBipartite(i, adj, color, component)) {
                    return -1; 
                }
                components.add(component);
            }
        }
        int maxGrp = 0;
        for (List<Integer> component : components) {
            maxGrp += getMaxBFS(component, adj,n);
        }
        return maxGrp;

    }  
    private int getMaxBFS(List<Integer> component, List<List<Integer>> adj,int n) {
        int maxDepth = 0;
        for (int node : component) {
            int[] vis =new int[n+1];
            maxDepth = Math.max(maxDepth, bfs(adj,vis,node));
        }
        return maxDepth;
    }
    public int bfs(List<List<Integer>> adj , int[] vis, int node){
        vis[node]=1;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{node,1});
        int level =0;
        while(!que.isEmpty()){
            int [] temp = que.poll();
            level =Math.max(temp[1],level);

            for(int ngbr : adj.get(temp[0])){
                if(vis[ngbr]!=1){
                    vis[ngbr]=1;
                    que.offer(new int[]{ngbr,temp[1]+1});
                }
            }
        }
        return level;
    }
    private boolean checkBipartite(int node, List<List<Integer>> adj, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 0;
        component.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adj.get(curr)) {
                if (color[neighbor] == color[curr]) {
                    return false; // Not bipartite
                }
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[curr];
                    queue.offer(neighbor);
                    component.add(neighbor);
                }
            }
        }
        return true;
    }
    
}
