package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Fee implements Serializable {
    private double value;
    private int id;

    private Map<LocalDate,Boolean> payDay;

    public Fee(){
        this.value = 0.0;
        this.payDay = new LinkedHashMap<>();
        LocalDate x = LocalDate.now();
        x.withDayOfMonth(1);

        for(int i=1;i<13;i++){//adiciona 1 ano
            x = x.withMonth(i);
            this.payDay.put(x,false);

        }
    }

    public Fee(double value, LocalDate today){
        this.value = value;
        this.payDay = new LinkedHashMap<>();
        LocalDate x = LocalDate.now();
        x = x.withDayOfMonth(1);

        for(int i=1;i<13;i++){//adiciona 1 ano
            x = x.withMonth(i);
            this.payDay.put(x,false);

        }
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public Map<LocalDate, Boolean> getPayDay() {
        return this.payDay;
    }

    public void setPayDay(Map<LocalDate, Boolean> payDay) {
        this.payDay = new LinkedHashMap<>(payDay);
    }

    public Fee clone(){return this.clone();}

    public String toString() {
        return "Fee{" +
                "value=" + value +
                ", payDay=" + payDay +
                '}';
    }

}
