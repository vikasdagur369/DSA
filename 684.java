class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        for(int i = 1; i < par.length; i++){
            par[i] = i;
        }
        int[] res = new int[2];
        for(int[] edge : edges){
            int pa = find(edge[0], par);
            int pb = find(edge[1], par);
            if(pa == pb){
                res = edge;
            }else{
                par[pb] = pa;
            }
        }
        return res;
    }

    public int find(int x, int[] par){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x], par);
    }
}
