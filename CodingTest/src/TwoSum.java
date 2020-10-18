import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 8, 10, 21 };
        int target = 10;

        TwoSum a = new TwoSum();
        int[] result = a.solve(nums, target);

        for(int element: result) {
            System.out.print(element);
            System.out.print(' ');
        }
    }

    private int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int mapValue = map.get(nums[i]);
                result[0] = mapValue;
                result[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
}
