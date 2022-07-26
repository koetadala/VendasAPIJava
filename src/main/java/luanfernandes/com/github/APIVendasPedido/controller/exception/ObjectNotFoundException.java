package luanfernandes.com.github.APIVendasPedido.controller.exception;

import java.text.RuleBasedCollator;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
