package main.Compnay.Google;

public class DietPlanPerformance {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int k = 1;
        int upper = 3;
        int lower = 3;

        System.out.println(dietPlanPerformance(data, k, upper, lower));
        System.out.println();

        int[] d = {2, 3};
        int j = 2;
        int u= 0;
        int l = 1;
        System.out.println();
        System.out.println(dietPlanPerformance(d, j, u, l));
        System.out.println();

    }

    public static int dietPlanPerformance(int[] data, int k, int upper, int lower) {
        int points = 0;
        int sum = 0;

        for (int i =0; i<k; i++) {
            sum = sum + data[i];
        }
        if (sum > upper) {
            points++;
        } else if (sum < lower) {
            points--;
        }

        System.out.println("my sum at now " + sum);

        for (int i = k; i<data.length; i++) {
            System.out.println("i is " + i);
            sum = sum + data[i];
            System.out.println("i-k is " + (i-k));
            sum = sum - data[i-k];
            System.out.println("sum " + sum);
            if (sum > upper) {
                points++;
                System.out.println(points);
            } else if (sum < lower) {
                points--;
                System.out.println(points);
                System.out.println();
            }
        }

        return points;
    }
}
