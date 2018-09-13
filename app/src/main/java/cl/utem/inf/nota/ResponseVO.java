package cl.utem.inf.nota;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class ResponseVO {

    public boolean ok = false;
    public String message = null;
    public Date date = null;

    public ResponseVO() {
        this.ok = false;
        this.message = StringUtils.EMPTY;
        this.date = new Date();
    }

    public ResponseVO(boolean ok, String message) {
        this.ok = ok;
        this.message = StringUtils.trimToEmpty(message);
        this.date = new Date();
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
