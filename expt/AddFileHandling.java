import java.io.*;
public class AddFileHandling {
    public static void main(String[] args) {
        String n1 = "n1.txt";
        String n2 = "n2.txt"; 
        String sum = "sum.txt";

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(n1));
            int number1 = Integer.parseInt(br1.readLine());
            br1.close();
            BufferedReader br2 = new BufferedReader(new FileReader(n2));
            int number2 = Integer.parseInt(br2.readLine());
            br2.close();
            int result = number1 + number2;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sum));
            bw.write(Integer.toString(result));
            bw.close();

            System.out.println("Calculation completed. Result saved to " + sum);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
} 
