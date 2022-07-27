package br.com.agrotis.register.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class RegisterErrorResponse implements Serializable {
    private List<RegisterError> errors;

    public RegisterErrorResponse(List<RegisterError> errors){ this.errors = errors; }

    public RegisterErrorResponse(HttpStatus status, String title, String detail){
        this.errors = Collections.singletonList(new RegisterError(String.valueOf(status.value()), title, detail));
    }

    public static RegisterErrorResponse.RegisterErrorResponseBuilder builder() {
        return new RegisterErrorResponse.RegisterErrorResponseBuilder();
    }

    public List<RegisterError> getErrors() {
        return this.errors;
    }

    public void setErrors(final List<RegisterError> errors) {
        this.errors = errors;
    }

    public static class RegisterErrorResponseBuilder {
        private List<RegisterError> errors;

        RegisterErrorResponseBuilder() {
        }

        public RegisterErrorResponse.RegisterErrorResponseBuilder errors(final List<RegisterError> errors) {
            this.errors = errors;
            return this;
        }

        public RegisterErrorResponse build() {
            return new RegisterErrorResponse(this.errors);
        }

        public String toString() {
            return "OpenBankingErrorResponse.OpenBankingErrorResponseBuilder(errors=" + this.errors + ")";
        }
    }
}
