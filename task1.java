public class task1 {
    public static void main(String[] args) {
        BusinessTrip trip = new BusinessTrip();
        double distance = 150;  // odległość w km
        System.out.println("Obliczenia kosztów podróży służbowej dla odległości " + distance + " km");
        System.out.println("Koszt transportu: " + trip.calculateTransportationCost(distance));
        System.out.println("Koszt diety: " + trip.calculateDietCost(distance));
        System.out.println("Koszt noclegu: " + trip.calculateAccommodationCost(distance));
        System.out.println("Łączny koszt podróży: " + trip.calculateTotalCost(distance));
    }
}

class BusinessTrip {
    private final double RATE_PER_KILOMETER = 0.5; // zł/km
    private final double DAILY_DIET_RATE = 100; // zł/dzień
    private final double RATE_PER_NIGHT = 150;  // zł/noc

    public double calculateTransportationCost(double distance) {
        return distance * RATE_PER_KILOMETER;
    }

    public double calculateDietCost(double distance) {
        // Zakładamy, że każda podróż trwa 1 dzień na 100 km
        double days = Math.ceil(distance / 100);
        return DAILY_DIET_RATE * days;
    }

    public double calculateAccommodationCost(double distance) {
        // Nocleg przypada na każdy dzień podróży
        double days = Math.ceil(distance / 100);
        return RATE_PER_NIGHT * days;
    }

    public double calculateTotalCost(double distance) {
        double transportationCost = calculateTransportationCost(distance);
        double dietCost = calculateDietCost(distance);
        double accommodationCost = calculateAccommodationCost(distance);
        return transportationCost + dietCost + accommodationCost;
    }
}
