public class ConstructorException extends Exception {
	private static final long serialVersionUID = 7267976422309213041L;
	private String code;

    public ConstructorException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public ConstructorException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
