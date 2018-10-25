package Problem_2;

public class TesterPerson implements Person, Tester {
    protected String name;
    protected int age;
    protected int ID;
    protected int Exp;
    public TesterPerson(){
        name = "no_name";
        age = 0;
        ID  = 0;
        Exp = 0;
    }
    // also when lots of methods abstract is better, or when we change our papa class a lot abstract is better;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getExp() {
        return Exp;
    }

    @Override
    public int getID() {
        return ID;
    }
}
