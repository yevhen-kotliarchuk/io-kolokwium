// zadanie 4

abstract class Turysta {
    protected double dziennyKoszt;
    protected double dystans; // Dystans pokonany dziennie w kilometrach
    protected double spalanieNaKm; // Spalanie kalorii na kilometr

    public Turysta(double dziennyKoszt, double dystans, double spalanieNaKm) {
        this.dziennyKoszt = dziennyKoszt;
        this.dystans = dystans;
        this.spalanieNaKm = spalanieNaKm;
    }

    abstract public double obliczKosztCałejPodrozy();

    public double obliczSpaloneKalorie() {
        double kalorie = this.dystans * this.spalanieNaKm;
        return kalorie;
    }

    public void ustawDystans(double dystans) {
        this.dystans = dystans;
    }

    public void ustawDziennyKoszt(double dziennyKoszt) {
        this.dziennyKoszt = dziennyKoszt;
    }

}

class TurystaPieszyGorski extends Turysta {

    public TurystaPieszyGorski(double dziennyKoszt, double dystans, double spalanieNaKm) {
        super(dziennyKoszt, dystans, spalanieNaKm);
    }

    public double obliczKosztCałejPodrozy() {
        if (this.dystans > 10) {
            return dziennyKoszt + 10; // Jeśli dystans > 10 km, dodajemy dodatkowy koszt
        }
        return dziennyKoszt;
    }
}

class TurystaNaRowerze extends Turysta {
    private double sredniaPredkosc; // km/h

    public TurystaNaRowerze(double dziennyKoszt, double dystans,
                            double spalanieNaKm, double sredniaPredkosc) {
        super(dziennyKoszt, dystans, spalanieNaKm);
        this.sredniaPredkosc = sredniaPredkosc;
    }

    public double obliczKosztCałejPodrozy() {
        double dziennyKoszt = this.dziennyKoszt;
        if (this.dystans > 20) {
            dziennyKoszt += 5; // Jeśli dystans > 20 km, dodajemy dodatkowy koszt
        }
        // Koszt podróży rowerowej jest uzależniony od czasu jazdy dziennie
        double czasJazdy = obliczCzasJazdy();
        if (czasJazdy > 12) {
            dziennyKoszt -= 2; // Jeśli czas jazdy > 12 godz, odejmujemy dodatkowy koszt (mniej przystanków na jedzenie itd)
        }
        return dziennyKoszt;
    }

    public void ustawSredniaPredkosc(double sredniaPredkosc) {
        this.sredniaPredkosc = sredniaPredkosc;
    }

    public double obliczCzasJazdy() {
        return this.dystans / this.sredniaPredkosc; // Czas w godzinach
    }
}
