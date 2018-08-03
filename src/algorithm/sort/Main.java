package algorithm.sort;

/**
 * Created by Airy on 2018/8/2
 */

abstract class Sort<T extends Comparable<T>>{

    public abstract void sort(T[] nums);

    /**
     * 只适用于已经实现compareTo的类型
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v,T w){
       return v.compareTo(w) < 0;
    }

    protected void swap(T[] a,int i,int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}


class Selection<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i=0;i<N;i++){
            int min = i; // 选择第一个为最小值
            for (int j=i+1;j<N;j++){
                if (less(nums[j],nums[i])){
                    min = j; //更新最小值
                }
            }
            swap(nums,i,min); // 交换
        }
    }
}

public class Main {
}
