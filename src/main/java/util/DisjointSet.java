package util;

public class DisjointSet {
        private final int[] parent;
        private final int[] size;

        public DisjointSet(int maxNode) {
            this.parent = new int[maxNode + 1];
            this.size = new int[maxNode + 1];
            for (int i = 1; i <= maxNode; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
                return;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        public boolean isRepresentative(int node) {
            return find(node) == node;
    }
}
