public class q3_largestSubstr 
{
    public static void main(String args[]) // O(x * N)--x is the max lenth of a string in the array
    {
        String[] fruits = {"apple", "mango", "banana"};
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) 
        {
            if(fruits[i].compareToIgnoreCase(largest) > 0)
            {
                largest = fruits[i];
            }    
        }
        System.out.println(largest);
    }
}
