package Models;

import org.apache.http.HttpStatus;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 22 July, 2024
 **/
public class Response {

    private int status;
    private String message;
    private Object response;

    public Response() {
        setStatus(HttpStatus.SC_OK);
        setMessage("Success!");
    }

    public int getStatus() {
        return status;
    }

    public Response setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResponse() {
        return response;
    }

    public Response setResponse(Object response) {
        this.response = response;
        return this;
    }
}
