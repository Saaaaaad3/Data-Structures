package RoughClass;

import java.util.Arrays;
import java.util.Comparator;

public class Rough{
    public static void main(String[] args){
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};

        int ans = findMinArrowShots(arr);
//        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
//
//        for(int i=0; i<arr.length;i++){
//            for(int j=0;j<arr[0].length;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrowCount = 1;

        int currArrow = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (currArrow >= points[i][0]) {
                continue;
            }
            arrowCount++;
            currArrow = points[i][1];
        }
        return arrowCount;
    }
}