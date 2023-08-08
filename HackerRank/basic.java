package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY crew_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
    // Write your code here
    
    Collections.sort(crew_id);
    Collections.sort(job_id);
    long minCost = 0;
 
    for(int i = 0; i < crew_id.size() ; i++) {
        minCost += Math.abs(crew_id.get(i) - job_id.get(i));
    }
    return minCost;
    }

}

public class basic {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int crew_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> crew_id = new ArrayList<>();

        for (int i = 0; i < crew_idCount; i++) {
            int crew_idItem = Integer.parseInt(bufferedReader.readLine().trim());
            crew_id.add(crew_idItem);
        }

        int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> job_id = new ArrayList<>();

        for (int i = 0; i < job_idCount; i++) {
            int job_idItem = Integer.parseInt(bufferedReader.readLine().trim());
            job_id.add(job_idItem);
        }

        long result = Result.getMinCost(crew_id, job_id);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
