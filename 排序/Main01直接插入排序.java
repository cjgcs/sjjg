package 排序;



import java.util.Scanner;

public class Main01直接插入排序  {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        sqList X=new sqList();
        int changdu = 8;
        int[] arr = new int[changdu];

        for (int i = 0; i < changdu; i++) {
            int xx = kb.nextInt();
            arr[i] = xx;
        }

        X.insertSort(arr); 

    }

    

}

class sqList{
	public static void display(int[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++)
            res += arr[i] + " ";

        System.out.println(res);
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        if (arr.length <= 1)
            return;

        for (int i = 1; i < arr.length; i++) {
            // 打印函数
            display(arr);

            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }

        // 打印函数
        display(arr);
    }

}