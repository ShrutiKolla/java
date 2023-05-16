public class trappedwater
{

//calculate total trapped water -- fn
public static void fn(int h[]) // O(n)
{
    //calculate left max bound
    int left[] = new int[h.length];
    left[0] = h[0];
    for(int i = 1; i < h.length ; i++)
    {
        left[i] = Math.max(h[i], left[i - 1]);
    }
    
    //calculate right max bound
    int right[] = new int[h.length];
    right[h.length - 1] = h[h.length - 1];
    for(int i = h.length - 2 ; i >= 0 ; i--)
    {
        right[i] = Math.max(h[i], right[i + 1]);
    }

    //loop --
    int tw = 0;
    for(int i = 0 ; i < h.length ; i++)
    {
        //water level = min(left bound, right bound)
        int wl = Math.min(left[i], right[i]);
        //trapped water =water level - height
        tw += wl - h[i];
    }
    System.out.println("ttw : " + tw + "\n");

}

    public static void main(String args[])
    {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        fn(height);
    }
}