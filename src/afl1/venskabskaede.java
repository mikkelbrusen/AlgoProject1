package afl1;

import java.io.*;
import java.util.*;

class Graph {
	// The number of vertices
	private final int V;
   
	// Contains edges represented as adjacency lists
	private LinkedList<Integer>[] edges;
	
	// Marked vertices
	private int[] markedAndDist;
	
	public int[] getMarkedAndDist() {
		return markedAndDist;
	}

	// Queue for vertices
	private Queue queue;
   
	// Adds an edge between v1 and v2
	public void addEdge(int v1, int v2) {
		edges[v1].add(v2);
		edges[v2].add(v1);
	}

	// Finds the length from start node to all other nodes. 
	public void bfs(int start) {
		// Implement this
		markedAndDist[start] = 0;
		queue.enqueue(start);
		while (queue.queue.size() != 0){
			int v = queue.dequeue();
			for (int j = 0; j < edges[v].size(); j++){
				if (!isMarked(edges[v].get(j))){
					markedAndDist[edges[v].get(j)] = markedAndDist[v]+1;
					queue.enqueue(edges[v].get(j));
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
		edges = (LinkedList<Integer>[]) new LinkedList[V];
		markedAndDist = new int[V];
		queue = new Queue();
		
		for (int i = 0; i < V; i++) {
			edges[i] = new LinkedList<Integer>();
			markedAndDist[i] = -1;
		}
	}
}


class Node {
	
	private int key;
	private Node next;
	
	public Node(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}


class Queue {
	List<Node> queue = new ArrayList<Node>();
	Node head, tail;

	public void enqueue(int e) {
		Node node = new Node(e);
		if (queue.size() == 0){
			queue.add(node);
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			queue.add(node);
			tail = node;
			tail.setNext(head);
		}
	}

	public int dequeue() {
		if (queue.size() == 1){
			Node node = queue.remove(0);
			return node.getKey();
		} else {
			head = queue.get(1);
			Node node = queue.remove(0);
			return node.getKey();
		}
	}
}


public class venskabskaede {
	public static void main(String[] args) throws IOException {
		new venskabskaede().run();
	}
	
	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		   
		String current = in.readLine();
		String[] temp;
		String[] names = current.split(" ");
		
		int P = names.length;
		Graph graph = new Graph(P);
   
		current = in.readLine();
		while(current.contains("tvenner")!=true){
			temp = current.split(" ");
			graph.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			current = in.readLine();
		}
		
		temp = current.split(" ");
		
		graph.bfs(Integer.parseInt(temp[1]));
		
		int [] distance = graph.getMarkedAndDist();
		
		
		for (int i = 0; i < P; i++){
			if (distance[i] <= Integer.parseInt(temp[2])){
				System.out.print(names[i]+" ");
			}
		}
	}
}
