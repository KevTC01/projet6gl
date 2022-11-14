package animaux;

public class TestPhenix {

    public static void main(String[] args) {
        Animal p1 = Phenix.uniqueInstance();
        Animal p2 = Phenix.uniqueInstance();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("C'est le même phenix : " + (p1 == p2));
    }
}
