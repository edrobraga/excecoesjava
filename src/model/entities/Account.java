package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
    
    private Integer number;
    private String holder;
    private Double balance;
    private Double whithdrawLimit;

    public Account(Integer number, String holder, Double balance, Double whithdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.whithdrawLimit = whithdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWhithdrawLimit() {
        return whithdrawLimit;
    }

    public void setWhithdrawLimit(Double whithdrawLimit) {
        this.whithdrawLimit = whithdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void whithdraw(Double amount){
       validatewhithdraw(amount);
       balance -= amount;
    }
    
    public void validatewhithdraw(Double amount) {
        if (amount > getBalance()) {
            throw new DomainExceptions("Whithdraw error: Not enough balance");
        }
        if (amount > getWhithdrawLimit()) {
            throw new DomainExceptions("Whithdraw error : The amount exceeds withdraw limit");
        }
    }

    
}
