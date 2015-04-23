package afl1;

import java.io.*;
import java.util.*;

public class Taetvenskab {
	public static void main(String[] args) throws IOException {
		new Taetvenskab().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		String current = in.readLine();
		String[] temp;
		String[] names = current.split(" ");
		
		int P = names.length;
		Graph graph = new Graph(P);
   
		current = in.readLine();
		while(current.contains("taetvenskab")!=true){
			temp = current.split(" ");
			graph.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 0);
			current = in.readLine();
		}
		
		temp = current.split(" ");
		
		int[] members = new int[temp.length - 1];
		for(int i = 1; i < temp.length; i++) {
			members[i-1] = Integer.parseInt(temp[i]);
		}
		
		boolean closeRelation = true;
		
		outerloop:
		for(int i = 0; i <members.length -1; i++){
			for(int j = i+1; j<members.length; j++){
				if(!graph.contains(members[i], members[j])){
					closeRelation = false;
					break outerloop;
				}
			}
		}
		
		if(closeRelation){
			out.print("ja");
		} else{
			out.print("nej");
		}
		out.flush();
	}
}
