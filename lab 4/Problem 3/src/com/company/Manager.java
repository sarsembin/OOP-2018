package com.company;

import java.util.ArrayList;
import java.util.List;

class Manager extends Employee implements Comparable, Cloneable{
    private List<Employee> team;
    private double bonus;
    public Manager(){
        super();
        team = new ArrayList<>();
        bonus = 0;
    }
    public Manager(List<Employee> team){
        super();
        this.team = team;
        bonus = team.size();
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public boolean compare(Object obj) {
        Manager m = (Manager) obj;
        if (super.getSalary() >= m.getSalary()){
            if (super.getSalary() == m.getSalary()){
                if (bonus >= m.getBonus()) {
                    return true;
                }
                else return false;
            }
            else return true;
        }
        else return false;
    }

    @Override
    public Manager clone_this() {
        return this;
    }
    public void addTeam(Employee member){
        team.add(member);
    }
    public Employee removeTeam(){
        return team.remove(team.size()-1);
    }
    public double calculateBonus(){
        return team.size();
    }

}
