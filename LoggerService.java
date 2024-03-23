package ma.emi.ac.exam;

import java.util.ArrayList;
import java.util.List;

public class LoggerService implements Observer {

    private static volatile LoggerService instance;
    private LoggerStrategy logger;
    private List<Compte> comptes = new ArrayList<>();

    private LoggerService(LoggerStrategy logger) {
        this.logger = logger;
    }

    public static LoggerService getInstance(LoggerStrategy logger) {
        if (instance == null)
            instance = new LoggerService(logger);
        return instance;
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.addObserver(this);
    }

    public void update(Compte compte) {
        logger.journalisation(compte.getOperations().toString());
    }

    public void setLogger(LoggerStrategy logger) {
        this.logger = logger;
    }
}
