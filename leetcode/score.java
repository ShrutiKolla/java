/* package codechef; // don't place package name! */

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class score {

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
		    int n = sc.nextInt();
		    // int x = sc.nextInt();
		    int[] a = new int[n];
		    for(int i = 0 ; i < n ; i++) {
		        a[i] = sc.nextInt();
		    }
            Arrays.sort(a, Collections.reverseOrder());
		    // Arrays.sort(a, Collections.reverseOrder());
		    for(int i = 0 ; i < n ; i++) {
		        System.out.print(a[i] + " ");
		    }
		    t--;
		}
	}
}


