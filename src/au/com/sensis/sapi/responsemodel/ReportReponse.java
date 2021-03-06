package au.com.sensis.sapi.responsemodel;

import java.util.Date;
import java.util.List;

public class ReportReponse {

    private Date date;
    private Integer time;
    private Integer code;
    private String message;
    private List<String> validationErrors;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * This is the HTTP response code
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This will contains error messages if you e.g. forgot to include the required content (such as the phone number for a dial event).
     */
    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }

}
