package eg.com.otloblana.common.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by eltntawy on 09/07/15.
 */
@XmlRootElement
public class ResponseEntity<T> {

    private T object;
    private boolean isError;
    private String errorMessage;
    private String successMessage;
    private String technicalErrorMessage;

    public ResponseEntity() {
        setSuccessMessage("");
        setError(false);
        setErrorMessage("");
        setTechnicalErrorMessage("");
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        this.isError = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTechnicalErrorMessage() {
        return technicalErrorMessage;
    }

    public void setTechnicalErrorMessage(String technicalErrorMessage) {
        this.technicalErrorMessage = technicalErrorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
