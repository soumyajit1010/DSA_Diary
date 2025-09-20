package DSA_Diary.daily.d_2025_09_20;

import java.util.*;
//https://takeuforward.org/plus/dsa/problems/m-coloring-problem
/*
M Coloring Problem

Difficulty: Hard

Given an integer M and an undirected graph with N vertices and E edges.
The goal is to determine whether the graph can be coloured with a maximum of M colors
so that no two of its adjacent vertices have the same colour applied to them.

Input:
- N: Number of vertices
- M: Maximum number of colors
- E: Number of edges
- edges: List of edges where each edge is represented as (u, v)

Output:
- Return true if it is possible to color the graph using at most M colors such that
  no two adjacent vertices have the same color.
- Return false otherwise.

Example 1:
Input: N = 4, M = 3, E = 5, Edges = [(0,1), (1,2), (2,3), (3,0), (0,2)]
Output: true
Explanation:
We can color the vertices as: 0->Red, 1->Blue, 2->Green, 3->Blue.

Example 2:
Input: N = 3, M = 2, E = 3, Edges = [(0,1), (1,2), (0,2)]
Output: false
Explanation:
Vertex 2 is adjacent to both 0 and 1. With only 2 colors, it is not possible
to color all vertices without conflicts.
*/

public class TakeUForward_GFG_M_Coloring_Problem {
    boolean graphColoring(int[][] edges, int m, int n) {

        int[] node = new int[n];
        for (int i = 0; i < n; i++) {
            node[i] = 0;
        }
        return function(node, edges, m, n, 0);

    }

    boolean function(int[] nodes, int[][] edges, int m, int n, int c) {
        if (c == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (possibleColor(nodes, edges, c, i)) {
                nodes[c] = i;
                if (function(nodes, edges, m, n, c + 1) == true) {
                    return true;
                }
                nodes[c] = 0;
            }
        }
        return false;
    }

    boolean possibleColor(int[] nodes, int[][] edges, int c, int color) {
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u == c && nodes[v] == color) return false;
            if (v == c && nodes[u] == color) return false;
        }
        return true;
    }


    // Check if current color assignment is safe for this node
    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int col) {
        for (int it : G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }

    // Recursive function to try coloring nodes
    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) return true; // all nodes colored

        for (int col = 1; col <= m; col++) {
            if (isSafe(node, G, color, col)) {
                color[node] = col;
                if (solve(node + 1, G, color, n, m)) return true;
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    // Main function
    public static boolean graphColoring(List<Integer>[] G, int m) {
        int n = G.length;
        int[] color = new int[n];
        Arrays.fill(color, 0);

        return solve(0, G, color, n, m);
    }

    // Driver for testing
    public static void main(String[] args) {
        int N = 4, M = 3;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) G[i] = new ArrayList<>();

        // Example edges: [(0,1), (1,2), (2,3), (3,0), (0,2)]
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        System.out.println(graphColoring(G, M)); // true
    }

}
