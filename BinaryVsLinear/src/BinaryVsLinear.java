/**
 * Created by Rafael on 3/4/2016.
 */
public class BinaryVsLinear {
    private static int linearSearch(int key, int[] array)
    {
        for(int i=0;i<array.length;i++){
            if(array[i]==key){
                return i; //Success Case
            }
        }
        return -1; // Failure Case
    }

    private static int binarySearch(int key, int[] array)
    {

        int left=0;
        int mid;
        int right = array.length-1;
        int comp =0;
        while(true){
            if (left>right){
                mid=-1; // Failure
                break;
            }
            else{
                mid = (left+right)/2;
                comp = comp+1; // counts comp of first IF case, computer counts both T/F cases
                if(key < array[mid]){
                    right = mid-1;
                }
                else
                {
                    comp = comp+1;
                    if(key>array[mid]){
                        left = mid+1;
                    }
                    else{
                        break; // Found
                    }
                }
            }
        }
        return comp;
    }

    public static void main(String[] args)
    {
        for (int length = 1; length <= 30; length += 1)
        {
            int[] array = new int[length];
            for (int index = 0; index < length; index += 1)
            {
                array[index] = index;
            }

            double linearTotal = 0.0;
            double binaryTotal = 0.0;
            for (int element = 0; element < length; element += 1)
            {
                linearTotal += linearSearch(element, array);
                binaryTotal += binarySearch(element, array);
            }

            double linearAverage = linearTotal / length;
            double binaryAverage = binaryTotal / length;
            System.out.println(length + " " + linearAverage + " " + binaryAverage);
        }
    }
}
/*
OUTPUT
1 0.0 2.0
2 0.5 3.0
3 1.0 3.0
4 1.5 3.75
5 2.0 4.0
6 2.5 4.166666666666667
7 3.0 4.142857142857143
8 3.5 4.625
9 4.0 4.888888888888889
10 4.5 5.1
11 5.0 5.181818181818182
12 5.5 5.333333333333333
13 6.0 5.384615384615385
14 6.5 5.428571428571429
15 7.0 5.4
16 7.5 5.6875
17 8.0 5.882352941176471
18 8.5 6.055555555555555
19 9.0 6.157894736842105
20 9.5 6.3
21 10.0 6.380952380952381
22 10.5 6.454545454545454
23 11.0 6.478260869565218
24 11.5 6.583333333333333
25 12.0 6.64
26 12.5 6.6923076923076925
27 13.0 6.703703703703703
28 13.5 6.75
29 14.0 6.758620689655173
30 14.5 6.766666666666667
 */