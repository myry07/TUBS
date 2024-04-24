package chapter17;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();//可获取当前电脑的cpu数量
        System.out.println(cpuNums);
    }
}
