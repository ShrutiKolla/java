public class q2_shortestpath 
{
    //shortest path
    public static void shortestPath(String str)
    {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i) == 'E')    
                x++;
            else if(str.charAt(i) == 'W')    
                x--;
            else if(str.charAt(i) == 'N')    
                y++;
            else     
                y--;
        }
        double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("distance: " + dist);
    }
    
    //main fn..
    public static void main(String args[])
    {
        String path = "WNEENESENNN";
        shortestPath(path);   
    }
}
