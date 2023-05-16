public class printSpiral{

//spiral fn
    public static void spiral(int arr[][])
    {
        int n = arr.length;//4
        int m = arr[0].length;//4
        int sr = 0, sc = 0, er = arr.length-1 , ec = arr[0].length-1;
        //    < 2           < 2           >= 2           >= 2   
        while(sr < (n/2) || sc < (m/2) || er >= (n/2) || ec >= (m/2))//if starts
        {
            for(int i = sr ; i <= er ; i++)
            {
                for(int j = sc ; j <= ec ; j++)
                {
                    if(i == sr)
                    {
                        //System.out.print(i + " " + j + ", " );
                         System.out.print(arr[i][j] + " ");
                    }
                }
            }
            
            for(int i = sr ; i <= er ; i++)
            {
                //System.out.println("loop 2");
                for(int j = sc ; j <= ec ; j++)
                {
                    if(j == ec && i != sr)
                    {
                        // System.out.print(i + " " + j + " ");
                         System.out.print(arr[i][j] + " ");
                    }
                }
            }
            
            for(int i = sr ; i <= er ; i++)
            {
                //System.out.println("loop 3");
                for(int j = ec ; j >= sc ; j--)
                {
                    if(i == er && j != ec)
                    {
                        // System.out.print(i + " " + j + ", ");
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }
            
            for(int i = er ; i >= sr ; i--)
            {
                //System.out.println("loop 4");
                for(int j = sc ; j <= ec ; j++)
                {
                    if(j == sc && i != sr && i != er)
                    {
                        // System.out.print(i + " " + j + " ");
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }

            sr++; sc++; er--; ec--;
        }//if ends..
        
    }

//spiral modified
public static void spiralMod(int arr[][])
{
    int n = arr.length;
    int m = arr[0].length;
    int sr = 0, sc = 0, er = n - 1, ec = m - 1;
    while(sr <= er && sc <= ec)
    {
        //top
        for(int j = sc ; j <= ec ; j++)
        {
            System.out.print(arr[sr][j] + " ");
        }
        //right
        for(int i = sr + 1 ; i <= er ; i++)
        {
            System.out.print(arr[i][ec] + " ");
        }
        //down
        for(int j = ec - 1 ; j >= sc ; j--)
        {
            System.out.print(arr[er][j] + " ");
        }
        //left
        for(int i = er - 1 ; i > sr ; i--)
        {
            System.out.print(arr[i][sc] + " ");
        }
        sr++; sc++; er--; ec--;
    }
}
//main fn..
    public static void main(String args[])
    {
        int arr[][] =  {{1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                    };
        spiralMod(arr);
    }
}