package ma.emi.ac.exam;

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(LocalDate.now());
        LoggerFactory loggerFactory = LoggerFactory.getInstance();
        LoggerStrategy consoleLogger = loggerFactory.createLogger(TypeLogger.CONSOLE);

        LoggerService loggerService = LoggerService.getInstance(consoleLogger);

        Compte compte = new Compte(1000.0);
        loggerService.addCompte(compte);

        System.out.println(compte.getSolde());
        compte.debiter(1500.0);
        System.out.println(compte.getSolde());
        compte.crediter(800.0);
        System.out.println(compte.getSolde());
    }
}
