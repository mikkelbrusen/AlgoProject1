package afl1;

import java.io.*;
import java.util.*;

public class Svageste {

	public static void main(String[] args) throws IOException {
		new Svageste().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String current = in.readLine();
		String[] temp;
		String[] names = current.split(" ");

		int P = names.length;
		Graph graph = new Graph(P);

		current = in.readLine();
		while (current.contains("svagestevenskab") != true) {
			temp = current.split(" ");
			graph.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
					Integer.parseInt(temp[2]));
			current = in.readLine();
		}

		temp = current.split(" ");
		Integer[] p = dijkstra(graph, Integer.parseInt(temp[1]));

		Integer e = Integer.parseInt(temp[2]);
		String str = "";
		do {
			str = names[e]+" "+str;
			e = p[e];
		} while (e != null);
		
		System.out.println(str);

	}

	private Integer[] dijkstra(Graph graph, int s) {
		Integer[] parent = new Integer[graph.size()];
		LinkedList<Node>[] edges = graph.getEdges();
		int[] dist = new int[graph.size()];

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < graph.size(); i++) {
			parent[i] = null;
			dist[i] = -1;
			pq.insert(i, Integer.MAX_VALUE);
		}

		pq.changeKey(s, 0);

		while (!pq.isEmpty()) {
			int d = pq.min();
			int u = pq.extractMin();
			dist[u] = d;

			for (Node edge : edges[u]) {
				if (dist[edge.getKey()] == -1) {
					if (dist[u] + edge.getSat() < pq.getKey(edge.getKey())) {
						pq.changeKey(edge.getKey(), dist[u] + edge.getSat());
						parent[edge.getKey()] = u;
					}
				}

			}

		}
		return parent;
	}
}
