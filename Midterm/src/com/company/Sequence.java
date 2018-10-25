package com.company;

public class Sequence {
    private String s;
    public Sequence(){
        s = "";
    }
    public Sequence(String s){
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
    public boolean isPalindrome(){
        for (int i = 0 ; i< s.length();i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        return true;
    }
    public boolean isSubString(Sequence s){
        return this.s.contains(s.getS());

    }
}
