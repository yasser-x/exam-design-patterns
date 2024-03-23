package ma.emi.ac.exam;

public class LoggerFactory {
    private static volatile LoggerFactory instance;

    private LoggerFactory() {

    }

    public static LoggerFactory getInstance() {
        if (instance==null)
            instance = new LoggerFactory();
        return instance;
    }

    public LoggerStrategy createLogger(TypeLogger typeLogger) throws IllegalAccessException {
        switch (typeLogger) {
            case CONSOLE :
                return new ConsoleLogger();
            case CSV :
                return new CsvLogger();
            case TEXT:
                return new TextLogger();
            default:
                throw new IllegalAccessException("Invalid logger type :" + typeLogger);
        }
    }


}
