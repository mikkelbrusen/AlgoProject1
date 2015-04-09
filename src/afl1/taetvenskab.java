package afl1;

import java.io.*;
import java.util.*;

public class taetvenskab {
	public static void main(String[] args) throws IOException {
		new taetvenskab().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		int P = in.readLine().split(" ").length;
		int[][] tracker = new int[P][P];
		
		String current = in.readLine();
		String[] temp;

		while(current.contains("taetvenskab")!=true){
			temp = current.split(" ");
			tracker[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
			tracker[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
			
			current = in.readLine();
		}
		
		temp = current.split(" ");
		int[] members = new int[temp.length - 1];
		for(int i = 1; i < temp.length; i++) {
			members[i-1] = Integer.parseInt(temp[i]);
		}
		
		boolean closeRelation = true;
		
		for(int i = 0; i <members.length -1; i++){
			for(int j = i+1; j<members.length; j++){
				if(tracker[members[i]][members[j]] != 1){
					closeRelation = false;
					break;
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
