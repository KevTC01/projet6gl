package emplyesAvecHeritage;

public class EmployeNormal extends EmployeAvecHSup{

    public EmployeNormal(String nom) {
        super(nom);
        majoration = 1.25;
    }
}
