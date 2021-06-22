package in.reqres.usersadmin.testing.exceptions;

public class ConnectionError extends AssertionError{
    public ConnectionError(String mensaje) {
        super(mensaje);
    }
}
