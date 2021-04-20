package Polymorphism;

public class SuperExecutive extends Executive {
    protected double extraBonus;

    public SuperExecutive(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double extraBonus) {
        super (eName, eAddress, ePhone, socSecNumber, rate);
        this.extraBonus = extraBonus;
    }

    public double pay() {
        double payment = super.pay() + this.extraBonus;
        extraBonus = 0;
        return payment;
    }
}
