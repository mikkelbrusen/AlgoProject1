package afl1;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	// The number of vertices
	private final int V;
   
	// Contains edges represented as adjacency lists
	private LinkedList<Node>[] edges;
	
	// Marked vertices
	private int[] markedAndDist;
	
	public int[] getMarkedAndDist() {
		return markedAndDist;
	}

	// Queue for vertices
	private Queue<Integer> queue;
   
	// Adds an edge between v1 and v2
	public void addEdge(int v1, int v2, int i) {
		edges[v1].add(new Node(v2, i));
		edges[v2].add(new Node(v1, i));
	}
	
	public int size() {
		return V;
	}

	// Finds the length from start node to all other nodes. 
	public void bfs(int start) {
		// Implement this
		markedAndDist[start] = 0;
		queue.add(start);
		while (queue.size() != 0){
			int v = queue.remove();
			for (int j = 0; j < edges[v].size(); j++){
				if (!isMarked(edges[v].get(j).getKey())){
					markedAndDist[edges[v].get(j).getKey()] = markedAndDist[v]+1;
					queue.add(edges[v].get(j).getKey());
				}
			}
		}
	}
	
	public boolean isMarked(int v) {
		return markedAndDist[v] != -1;
	}
   
	// Creates a graph with V vertices and no edges.
	public Graph(int V) {
		this.V = V;
		edges = (LinkedList<Node>[]) new LinkedList[V];
		markedAndDist = new int[V];
		queue = new LinkedList<Integer>();
		
		for (int i = 0; i < V; i++) {
			edges[i] = new LinkedList<Node>();
			markedAndDist[i] = -1;
		}
	}
	
	public LinkedList<Node>[] getEdges() {
		return edges;
	}
	
	public boolean contains(int i, int j) {
		for (Node vertex: edges[i]) {
			if (vertex.equals(j)) {
				return true;
			}
		}
		return false;
	}
}
