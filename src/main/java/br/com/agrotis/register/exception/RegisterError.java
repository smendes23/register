package br.com.agrotis.register.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class RegisterError {

    private final String code;
    private final String title;
    private final String detail;

    public RegisterError(String code, String title, String detail) {
        super();
        this.code = code;
        this.title = title;
        this.detail = detail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterError)) return false;
        RegisterError that = (RegisterError) o;
        return getCode().equals(that.getCode()) && getTitle().equals(that.getTitle()) && getDetail().equals(that.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getTitle(), getDetail());
    }
}
