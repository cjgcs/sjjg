package 排序;

import java.util.Scanner;

public class Main03快速排序 {
    public static void main(String[] args) {
    	Scanner kb = new Scanner(System.in);
        s1qList X=new s1qList();
        int changdu = 8;
        int[] arr = new int[changdu];

        for (int i = 0; i < changdu; i++) {
            int xx = kb.nextInt();
            arr[i] = xx;
        }

        X.Partition(arr, 0, arr.length - 1);
    }

    

}

class s2qList{
	public static void display(int[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++)
            res += arr[i] + " ";

        System.out.println(res);
    }

//    // 递归快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int i = left;
        int j = right;
        int base = arr[left];

        while (i < j) {
            while (i < j && arr[j] >= base)
                j--;
            while (i < j && arr[i] <= base)
                i++;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[i];
        arr[i] = base;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // 一趟快速排序
    public static void Partition(int[] arr, int i, int j) {
        int point = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= point) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= point) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = point;

        // 打印函数
        display(arr);
    }

  
}