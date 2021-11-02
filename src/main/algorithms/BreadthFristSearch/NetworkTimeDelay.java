package main.algorithms.BreadthFristSearch;

import java.util.*;

public class NetworkTimeDelay {
    class Edge {
        public int destination;
        public int weight;
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    class Pair {
        public int vertex;
        public int dist;

        Pair(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 0; i<N+1; i++) {
            graph[i]= new ArrayList<>();
        }
        for (int i =0; i<times.length; i++) {
            Edge newE = new Edge(times[i][1], times[i][2]);
            graph[times[i][0]].add(newE);
        }

        Pair src = new Pair(K, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {return a.dist - b.dist;});
        pq.add(src);
        int[] len = new int[N+1];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[K] = 0;
        int time = 0;
        while (!pq.isEmpty()) {
            Pair ver = pq.remove();
            for (Edge e: graph[ver.vertex]) {
                Pair tmp = new Pair(e.destination, e.weight + ver.dist);
                if (len[tmp.vertex] > tmp.dist) {
                    pq.add(tmp);
                    len[tmp.vertex] = e.weight + ver.dist;
                }
            }
        }
        for (int i =0; i <=N; ++i) {
            if(len[i] == Integer.MAX_VALUE) {
                return -1;
            }
            time = Math.max(time, len[i]);
        }
        return time;
    }

}
