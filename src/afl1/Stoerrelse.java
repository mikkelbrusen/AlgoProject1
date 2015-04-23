package afl1;

import java.io.*;
import java.util.*;

public class Stoerrelse {
	public static void main(String[] args) throws IOException {
		new Stoerrelse().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String current = in.readLine();
		String[] temp;
		String[] names = current.split(" ");

		int P = names.length;
		Graph graph = new Graph(P);

		current = in.readLine();
		while (current.contains("stoerrelse") != true) {
			temp = current.split(" ");
			graph.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 0);
			current = in.readLine();
		}
		
		LinkedList<Node>[] edges = graph.getEdges();
		
		
		int counter = 0;
		for (LinkedList<Node> vertex: edges) {
			counter += vertex.size();
		}
		counter /= 2;
		
		System.out.println(graph.size()+" "+counter);
		
		

	}
}