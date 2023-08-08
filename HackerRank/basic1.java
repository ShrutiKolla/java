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
     * Complete the 'maxCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. STRING_ARRAY labels
     *  3. INTEGER dailyCount
     */

    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
    // Write your code here
    int maxCost = 0;
    int legalLaptops = 0;
    int currCost = 0;
    for(int i = 0; i < cost.size(); i++) {
        if(legalLaptops == dailyCount) {
            maxCost = Math.max(currCost, maxCost);
            System.out.println("max: " + maxCost);
            currCost = legalLaptops = 0;
        }
        currCost += cost.get(i);
        System.out.println("currCost : " + currCost + " i: " + i);
        String str = labels.get(i);
        System.out.println(str.contains("illegal"));
        if(!labels.get(i).contains("illegal")) {
            legalLaptops++;
        }
    }
    if(legalLaptops == dailyCount) {
        maxCost = Math.max(currCost, maxCost);
            System.out.println("max: " + maxCost);
        currCost = 0;
    }
    return maxCost;
    }

}
public class basic1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int costCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cost = new ArrayList<>();

        for (int i = 0; i < costCount; i++) {
            int costItem = Integer.parseInt(bufferedReader.readLine().trim());
            cost.add(costItem);
        }

        int labelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> labels = new ArrayList<>();

        for (int i = 0; i < labelsCount; i++) {
            String labelsItem = bufferedReader.readLine();
            labels.add(labelsItem);
        }

        int dailyCount = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maxCost(cost, labels, dailyCount);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}