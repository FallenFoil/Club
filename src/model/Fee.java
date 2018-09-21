package model;

import java.time.LocalDate;


public class Fee {
    private double value;
    private LocalDate payDay;
    private LocalDate paidDay;


    public Fee(){
        this.value = 0.0;
        this.payDay = null;
        this.paidDay = null;
    }

    public Fee(double value, LocalDate payDay){
        this.value = value;
        this.payDay = payDay;
        this.paidDay = null;
    }

    public double getValue(){
        return this.value;
    }

    public LocalDate getPayDay(){
        return this.payDay;
    }

    public LocalDate getPaidDay(){
        return this.paidDay;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void setPayDay(LocalDate payDay){
        this.payDay = payDay;
    }

    public void setPaidDay(LocalDate paidDay){
        this.paidDay = paidDay;
    }

}
