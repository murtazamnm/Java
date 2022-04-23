import stringutils.IterLetter;

public class MainTask5 {
    public static void main(String[] args) {
        IterLetter itt = new IterLetter("sara");

        itt.printNext();
        itt.printNext();

        itt.restart();

        while (itt.hasNext()) {
            itt.printNext();
        }

    }
}