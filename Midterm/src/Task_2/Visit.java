package Task_2;

import java.util.Date;

public class Visit {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpence;

    public Visit (String name, String date){
        customer = new Customer(name);
        this.date = date;
    }
    public Visit (Customer customer, String date){
        this.customer = customer;
        this.date = date;
    }
    public String getName(){
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense - (serviceExpense * DiscountRate.GetServiceDiscountRate(customer.getMemberType()));
    }

    public double getProductExpence() {
        return productExpence;
    }

    public void setProductExpence(double productExpence) {
        this.productExpence = productExpence - (productExpence * DiscountRate.GetProductDiscountRate(customer.getMemberType()));
    }
    public double getTotalExpence(){
        return serviceExpense + productExpence;
    }

    @Override
    public String toString() {
        return customer.getName() + "member: "+ customer.isMember() +"membership type: " + customer.getMemberType() + " " + date + " " + serviceExpense + " " + productExpence + "";
    }
}
