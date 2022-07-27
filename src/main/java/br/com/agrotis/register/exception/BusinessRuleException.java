package br.com.agrotis.register.exception;

public class BusinessRuleException extends Exception {

    private String title;
    private String detail;

    public BusinessRuleException(String detail) {
        super(detail);
        this.title = null;
        this.detail = detail;
    }

    public BusinessRuleException(String title, String detail) {
        super(detail);
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetail() {
        return this.detail;
    }
}
