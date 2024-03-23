package ma.emi.ac.exam;

import java.time.LocalDate;

public class Operation {
    private static long lastNumero=100000;
    private long numero;
    private LocalDate dateOperation;
    private double montant;

    public Operation(double montant) {
        this.numero = ++lastNumero;
        this.dateOperation = LocalDate.now();
        this.montant=montant;
    }

    public String toString() {
        return "C'est Loperation No " + numero + "\nEffectue le :" + dateOperation + "\nAvec un montant de : " + montant;
    }
}
