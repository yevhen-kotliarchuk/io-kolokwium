// zadanie 3

public class NumberProcessor {

    private int calculateSumOfPower(int[] numbers, int power) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += Math.pow(numbers[i], power);
        }
        return total;
    }

    public int calculateSum(int[] numbers) {
        return calculateSumOfPower(numbers, 1);
    }
    public double calculateAverage(int[] numbers) {
        return calculateCubeAverageOfPower(numbers, 1);
    }

    public double calculateSquareAverage(int[] numbers) {
        return calculateCubeAverageOfPower(numbers, 2);
    }

    public double calculateCubeAverage(int[] numbers) {
        return calculateCubeAverageOfPower(numbers, 3);
    }
    
    public double calculateCubeAverageOfPower(int[] numbers, int power) {
        int total = calculateSumOfPower(numbers, power);
        double average = (double) Math.pow(total, (double) 1.0 / power) / numbers.length;
        return average;
    }

}

