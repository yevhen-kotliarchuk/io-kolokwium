public class Main {

    public static void main(String[] args) {
        wielokat Kolko = new wielokat();
        Kolko.rodzaj = wielokat.KOLO;
        Kolko.a = 3;
        System.out.println(Kolko.liczObwod() + "  " + Kolko.liczPole());

        wielokat Prostokat = new wielokat();
        Prostokat.rodzaj = wielokat.PROSTOKAT;
        Prostokat.a = 2;
        Prostokat.b = 4;
        System.out.println(Prostokat.liczObwod() + "  " + Prostokat.liczPole());

        wielokat Trojkat = new wielokat();
        Trojkat = new wielokat();
        Trojkat.rodzaj = wielokat.TROJKAT;
        Trojkat.a = 3;
        Trojkat.b = 4;
        Trojkat.c = 5;
        System.out.println(Trojkat.liczObwod() + "   " + Trojkat.liczPole());
    }
}

interface Wielokąt {
    public double obliczPole();
    public double obliczObwod();
}

class Trojkąt implements Wielokąt {
    private double a;
    private double b;
    private double c;

    public double obliczPole() {
        double p = 0.5 * (a + b + c);
        double x = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(x);
    }
}

abstract class Wielokąt {
    static int TROJKAT = 1;
    static int PROSTOKAT = 2;
    static int KWADRAT = 3;
    static int KOLO = 4;

    int rodzaj;

    double a;
    double b;
    double c;

    public double obliczPole() {
        if (rodzaj == TROJKAT) {
            // Liczymy ze wzoru Herona
            double p = 0.5 * (a + b + c);
            double x = p * (p - a) * (p - b) * (p - c);
            return Math.sqrt(x);
        } else if (rodzaj == PROSTOKAT) {
            return a * b;
        } else if (rodzaj == KWADRAT) {
            return a * a;
        } else if (rodzaj == KOLO) {
            return Math.PI * a * a;
        } else {
            return -1;
        }
    }

    public double obliczObwod() {
        if (rodzaj == TROJKAT) {
            return a + b + c;
        } else if (rodzaj == PROSTOKAT) {
            return 2 * a + 2 * b;
        } else if (rodzaj == KWADRAT) {
            return 4 * a;
        } else if (rodzaj == KOLO) {
            return 2 * Math.PI * a;
        } else {
            return -1;
        }
    }
}
