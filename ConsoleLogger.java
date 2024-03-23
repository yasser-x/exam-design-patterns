package ma.emi.ac.exam;

public class ConsoleLogger implements LoggerStrategy{



    public ConsoleLogger() {

    }


    @Override
    public void journalisation(String journal) {
        System.out.println("Console Logger : " +journal);
    }


}
