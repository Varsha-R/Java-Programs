import  java.util.*;
import java.lang.*;
public class Knapsack_GreedyMethod {
    public static void main(String[] args)
    {
        Scanner inscan = new Scanner(System.in);
        System.out.println("Number of items: ");
        int n= inscan.nextInt();
        System.out.println("Ratio:");
        int[] r= new int[n];
        for(int i=0; i<n; i++)
            r[i]=inscan.nextInt();
        System.out.println("Weights:");
        int[] w = new int[n];
        for(int i=0; i<n; i++)
            w[i]=inscan.nextInt();
        int[] dup = new int[n];
        int[] random = new int[n];
        int max= r[0], z=0;
        for(int i=1;i<n;i++)
        {
            if(max < r[i])
            {
                max = r[i];
                dup[z] = r[i];
                random[z]=i;
                z++;
            }
            else if(max== r[i])
            {
                if(w[z]<w[i])
                {
                    max = r[i];
                    dup[z] = r[i];
                    random[z]=i;
                    z++;
                }
                else
                {
                    max = r[i];
                    dup[z] = r[z];
                    random[z] = i;
                    z++;
                }
            }
        }
        System.out.println("Dup:");
        for(int i=0;i<n;i++)
            System.out.println(dup[i]);
        System.out.println("Random:");
        for(int i=0;i<n;i++)
            System.out.println(random[i]);
    }
}
