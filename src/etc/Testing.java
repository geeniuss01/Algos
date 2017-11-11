package etc;

import java.util.Arrays;
import java.util.TreeMap;

public class Testing {
    public static void main(String[] args) {
        //treemapUsage();
//        smallestSubArrayIndiciesToSortEntireArray(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});


    }

    private static void smallestSubArrayIndiciesToSortEntireArray(int [] ar) {

        int [] soretdAr = new int[ar.length];
        System.arraycopy(ar, 0, soretdAr, 0, ar.length );
        System.out.println(Arrays.toString(ar));
        Arrays.sort(soretdAr);
        System.out.println(Arrays.toString(soretdAr));

        int i=0,j=ar.length-1;
        int l = -1, r = -1;
        for(;i<=j;i++,j--) {
            if(l==-1 && ar[i]!=soretdAr[i]) l=i;
            if(r==-1 && ar[j]!=soretdAr[j]) r=j;
        }
        System.out.println(l+","+r);
    }


    private static void treemapUsage() {
        TreeMap<Integer, Integer> timePriceMap = new TreeMap<>();
        timePriceMap.put(2, 12);
        timePriceMap.put(1, 21);
        timePriceMap.put(4, 35);
        System.out.println(timePriceMap);
        System.out.println(timePriceMap.get(2));
        timePriceMap.remove(1);
        System.out.println(timePriceMap);
    }
}
