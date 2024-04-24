package leetcode;

public class T01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        T01 t01 = new T01();
        int[] res = t01.twoSum(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }

        return res;

    }
}