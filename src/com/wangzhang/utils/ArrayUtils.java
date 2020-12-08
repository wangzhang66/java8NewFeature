package com.wangzhang.utils;
import java.util.Random;

public class ArrayUtils {

    //随机生成长度为N,范围M以内的数组
    public static int[] getInstallArr(int length, int maxMum){
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = new Random().nextInt(maxMum + 1);
        }
        return arr;
    }

    //数组为空,输出提示
    public static void isNull(int[] arr){
        if(arr == null){
            System.out.println("数组为空！");
        }
    }

    //打印数组，并换行
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1 )
                System.out.print(arr[i]+"]");
            else if(i == 0){
                System.out.print("["+arr[i]+",");
            }else{
                System.out.print(arr[i]+",");
            }

        }
        System.out.println();
    }

    //交换数组中两个位置的值
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *1.简单选择排序
     */
    public static int[] exchangeSort( int[] nums) {
        isNull(nums);

        for(int i = 0; i < nums.length - 1; i++){
            int minNum = nums[i];
            int indexOfMinNum = i;
            for(int j = i; j < nums.length; j++ ){
                //记录最小值的索引和最小值
                if(nums[j] < minNum ){
                    indexOfMinNum = j;
                    minNum = nums[j];
                }
            }

            // 交换
            swap(nums,i,indexOfMinNum);
        }
        return nums;
    }


    /**
     *2.直接插入排序
     *性能：
     *    时间复杂度：
     *        最好的情况下(有序情况下):o(n)
     *        最坏情况下：o(n**2)
     *        平均情况下：o(n**2)
     *
     */
    public static int[] insertSort(int[] arr){
        isNull(arr);
        // 外层循环控制次数
        for(int i = 0; i < arr.length -1; i++){
            int preIndex = i; //涉及到逐一比较，之前的索引需要逐步前移
            int insertValue = arr[preIndex + 1]; //可能会每次整体后移，需要记录要插入的值，避免被覆盖掉

            // 拿当前的数与之前已排好序的序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后挪一步
            while(preIndex >= 0 && insertValue < arr[preIndex]){
                //后移
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            // while循环跳出说明找到了位置
            arr[preIndex + 1] = insertValue;
        }
        return arr;
    }

    /**
     *3.冒泡排序
     *时间复杂度：o(n**2)
     *
     */
    public static int[] bubbleSort(int[] arr){
        isNull(arr);
        // 外层循环控制总趟数
        for(int i =0; i < arr.length - 1; i++){
            // 内层循环控制每趟比较的次数
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    /**
     *4.希尔排序： 分组 + 组内排序用插入排序
     *不稳定
     *时间复杂度：o(n**1.3)
     *比较和交换的次数都小于直接插入排序
     */
    public static int[] shellSort(int[] arr){

        for(int i = 0; i < arr.length -1; i++){

            int preIndex = i; //涉及到逐一比较，之前的索引需要逐步前移
            int insertValue = arr[preIndex + 1]; //可能会每次整体后移，需要记录要插入的值，避免被覆盖掉

            // 拿当前的数与之前已排好序的序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后挪一步
            while(preIndex >= 0 && insertValue < arr[preIndex]){
                //后移
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            // while循环跳出说明找到了位置
            arr[preIndex + 1] = insertValue;
        }
        return arr;
    }

    public static void main(String args[]){
        int[] arr = getInstallArr(10,100);
        printArray(arr);
        // arr = exchangeSort(arr);
        // insertSort(arr);
        // bubbleSort(arr);
        printArray(arr);
    }

    public static long getRunTime(){
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


}
