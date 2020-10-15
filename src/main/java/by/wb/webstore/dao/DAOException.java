package by.wb.webstore.dao;

public class DAOException extends Exception {
    private static final long serialVersionUID = 8699290676813772045L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
