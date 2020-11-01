package by.wb.webstore.controller;

public class DBConPoolListenerRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7509923341412756567L;

    public DBConPoolListenerRuntimeException() {
        super();
    }

    public DBConPoolListenerRuntimeException(String message) {
        super(message);
    }

    public DBConPoolListenerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBConPoolListenerRuntimeException(Throwable cause) {
        super(cause);
    }

    protected DBConPoolListenerRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
