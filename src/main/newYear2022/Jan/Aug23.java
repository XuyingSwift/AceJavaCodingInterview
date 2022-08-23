package main.newYear2022.Jan;

public class Aug23 {
    public static void main(String[] args) {
        int[] test1 = new int[] {4,2,0,3,2,5};
        int r = trapRian(test1);
        System.out.println(r);
        int re = trap(test1);
        System.out.println(re);

    }

    public static int trapRian(int[] height) {
        int totalAmount = 0;

        // check out base case
        if (height == null || height.length == 0) {
            return 0;
        }
        // set up points
        int left = 0;
        int right = height.length - 1;
        // to store the max height on each side
        int maxLeft = 0;
        int maxRight = 0;

        // loop through the height array from both side
        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                }else {
                    totalAmount += maxLeft - height[left];
                }
                left ++;
            }else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                }else{
                    totalAmount += maxRight - height[right];
                }
                right --;
            }
        }
        return totalAmount;
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                totalWater += leftMax - height[left];
                left ++;
            }else {
                totalWater += rightMax - height[right];
                right --;
            }
        }
        return totalWater;
    }
}
