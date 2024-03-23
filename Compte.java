package ma.emi.ac.exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compte {
    private long code;
    private LocalDate dateDeCreation;
    private double solde;
    private List<Operation> operations;
    private List<Observer> observers;

    {
        operations= new ArrayList<>();
        observers = new ArrayList<>();
        code=generateCode();
    }

    private long generateCode() {
        return System.currentTimeMillis();
    }

    public Compte(double soldInitiale) {
        this.dateDeCreation=LocalDate.now();
        this.solde=soldInitiale;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setSolde(double solde) {
        this.solde = solde;
        notifyObservers();
    }

    public void debiter(double montant) {
        operations.add(new Operation(-1*montant));
        setSolde(this.solde-montant);
    }

    public void crediter(double montant) {
        operations.add(new Operation(montant));
        setSolde(this.solde+montant);
    }

    public double getSolde() {
        return solde;
    }


    public long getCode() {
        return code;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }
}
