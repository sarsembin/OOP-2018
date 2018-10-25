package Task_2;

public class Customer {
    private String name;
    private boolean member;
    private String memberType;
    public Customer(String s){
        name = s;
    }

    public String getName() {
        return name;
    }
    public boolean isMember(){
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }

    @Override
    public String toString() {
        if (member) return name + " member " + memberType;
        else return name + "not member";
    }
}
