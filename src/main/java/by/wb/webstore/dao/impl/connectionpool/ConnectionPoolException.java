package by.wb.webstore.dao.impl.connectionpool;

public class ConnectionPoolException extends Exception{
    private static final long serialVersionUID = 8327069028641377043L;

    public ConnectionPoolException(String message, Exception exception) {
        super(message, exception);
    }
}
