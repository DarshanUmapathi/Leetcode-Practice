package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class validPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Question number - 1971 - ValidPath
//		There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
//		You want to determine if there is a valid path that exists from vertex source to vertex destination.
//      Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

		int n = 6;
		int [][] edges = new int[5][5];
		edges[0][0] = 0;
		edges[0][1] = 1;
		edges[1][0] = 0;
		edges[1][1] = 2;
		edges[2][0] = 0;
		edges[2][1] = 3;
		edges[3][0] = 3;
		edges[3][1] = 4;
		edges[4][0] = 4;
		edges[4][1] = 5;
		
		int source = 0;
		int dest = 5;
		
		// Lesson 1 : ArrayList<ArrayList> reading and writing 
		
		/*ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(10);
		a2.add(20);
		a2.add(30);
		a2.add(40);
		
			
		// Adding the arraylist to the main arraylist
		al.add(a1);
		al.add(a2);
		
		for (int i=0;i<al.size();i++) {
			for(int j=0;j<al.get(i).size();j++) {
				System.out.println(al.get(i).get(j));
			}
		}*/
		
		// Lesson 2 : Creating a Map<Integer,ArrayList<Integer>>
		/*	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		map.put(1, a1);
		map.put(2, a2);
		System.out.println(map.get(1));
		System.out.println(map.get(2).get(2));*/
		
		
		// Solution - DFS
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(i, new ArrayList<Integer>());
		}
		
		boolean[] visted = new boolean[n];
		
		//System.out.println(edges.length);
		
		for(int j=0;j<edges.length;j++) {
			int a = edges[j][0];
			int b = edges[j][1];
			map.get(a).add(b);
			map.get(b).add(a);
		}
		boolean returnedVal = dfs(map,visted,source,dest);
		System.out.println(returnedVal);
	}

	private static boolean dfs(Map<Integer, ArrayList<Integer>> map, boolean[] visted, int source, int dest) {
		
		// if revisit the same element return false;
		if (visted[source]==true) return false;
		if(source==dest) return true;
		visted[source] = true;
		
		for (Integer neighbour:map.get(source)) {
			if(dfs(map,visted,neighbour,dest)) return true;
		}
		return false;
	}

	

}
