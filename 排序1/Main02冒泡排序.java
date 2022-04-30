package ≈≈–Ú;

import java.util.Scanner;

public class Main02√∞≈›≈≈–Ú {
	public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        s1qList X=new s1qList();
        int changdu = 8;
        int[] arr = new int[changdu];

        for (int i = 0; i < changdu; i++) {
            int xx = kb.nextInt();
            arr[i] = xx;
        }

        //X.insertSort(arr); 
        X.bubbleSort(arr);
    }

    

}

class s1qList{
	public static void display(int[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++)
            res += arr[i] + " ";

        System.out.println(res);
    }



//    // ≤Â»Î≈≈–Ú
//    public static void insertSort(int[] arr) {
//        if (arr.length <= 1)
//            return;
//
//        for (int i = 1; i < arr.length; i++) {
//            // ¥Ú”°∫Ø ˝
//            display(arr);
//
//            int value = arr[i];
//            int j = i - 1;
//            for (; j >= 0; j--) {
//                if (arr[j] > value) {
//                    arr[j + 1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j + 1] = value;
//        }
//
//        // ¥Ú”°∫Ø ˝
//        display(arr);
//    }

     //√∞≈›≈≈–Ú
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // ¥Ú”°Ω·π˚
            display(arr);

            Boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }

        // ¥Ú”°Ω·π˚
        display(arr);
    }
}