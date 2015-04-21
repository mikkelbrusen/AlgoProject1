package afl1;

import java.io.*;
import java.util.*;

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
