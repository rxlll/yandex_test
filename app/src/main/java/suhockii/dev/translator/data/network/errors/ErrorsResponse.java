package suhockii.dev.translator.data.network.errors;

import java.util.List;

public class ErrorsResponse {
    private List<ServerError> errors;

    public List<ServerError> getErrors() {
        return errors;
    }
}
