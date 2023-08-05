public class buysellstock
{
    //calculate max profit
    public static int fn(int p[])
    {
        //initialise bp and profit
        int bp = Integer.MAX_VALUE;
        int day = 0;
        int pro_max = Integer.MIN_VALUE;
        //loop--
        for(int i = 0 ; i < p.length ; i++)
        {
            int sp = p[i];
            //case - 1 : if bp > sp -- bp = sp
            if(bp > sp)
                bp = sp;
            else
            {
            //case - 2 : if bp < sp -- profit = sp - bp 
                int profit = sp - bp;
                //--if profit > profitmax --profitmax = profit
                //pro_max = Math.max(profit, pro_max);
                if(profit > pro_max)
                {
                    pro_max = profit;
                    day = i + 1;
                }
            }
        }
        if (pro_max > 0)
        {
            System.out.println("day: " + day);
            return pro_max;
        }
        else
            return 0;
    }
    public static void main(String args[])
    {
        int prices[] = {7,1,5,3,6,4};
        System.out.println("profit: " + fn(prices));
    }
}