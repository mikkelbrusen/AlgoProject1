package afl1;

import java.io.*;
import java.util.*;

public class stoerrelse {
	public static void main(String[] args) throws IOException {
		new stoerrelse().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));
		int counter = 0;
		
		int P = in.readLine().split(" ").length;
		out.print(P);
		out.print(" ");

		while(in.readLine().contentEquals("stoerrelse")!=true){
			counter ++;
		}
		out.print(counter);
		
		out.flush();
	}
}