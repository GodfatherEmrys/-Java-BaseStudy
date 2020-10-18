import java.util.Arrays;

public class MoveZeros {
    public static void main(String []args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;

        for (int element: nums) {
            if(element != 0) {
                nums[index] = element;
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        for (int element: nums) {
            System.out.println(element);
        }
    }
}
