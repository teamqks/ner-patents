package com.jfernandezrico.chemicals.patents.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class ErrorResponseDto implements Serializable {
    private static final long serialVersionUID = 8284174178929255454L;
    @JsonInclude(Include.NON_NULL)
    private String code;
    @JsonInclude(Include.NON_NULL)
    private String status;
    @JsonInclude(Include.NON_NULL)
    private String method;
    @JsonInclude(Include.NON_NULL)
    private String path;
    @JsonInclude(Include.NON_NULL)
    private String exception;
    @JsonInclude(Include.NON_NULL)
    private String message;
    @JsonInclude(Include.NON_NULL)
    @JsonFormat(
        pattern = "yyyy-MM-ddTHH:mm:SS.ssZ"
    )
    private String timestamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS.ssZ")).format(new Date());
    @JsonInclude(Include.NON_NULL)
    private Map<String, String> errors;

    public ErrorResponseDto(final String code, final String status, final String message, final String method, final String exception, final String path) {
        this.status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()).equals(code) ? HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase() : status;
        this.code = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()).equals(code) ? String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()) : code;
        this.message = message;
        this.method = method;
        this.exception = exception;
        this.path = path;
    }

    public void addError(final String key, final String value) {
        if (this.errors == null) {
            this.errors = new HashMap();
        }

        this.errors.put(key, value);
    }

    public String getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setMethod(final String method) {
        this.method = method;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setException(final String exception) {
        this.exception = exception;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public void setErrors(final Map<String, String> errors) {
        this.errors = errors;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponseDto)) {
            return false;
        } else {
            ErrorResponseDto other = (ErrorResponseDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label107;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label107;
                    }

                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$method = this.getMethod();
                Object other$method = other.getMethod();
                if (this$method == null) {
                    if (other$method != null) {
                        return false;
                    }
                } else if (!this$method.equals(other$method)) {
                    return false;
                }

                label86: {
                    Object this$path = this.getPath();
                    Object other$path = other.getPath();
                    if (this$path == null) {
                        if (other$path == null) {
                            break label86;
                        }
                    } else if (this$path.equals(other$path)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$exception = this.getException();
                    Object other$exception = other.getException();
                    if (this$exception == null) {
                        if (other$exception == null) {
                            break label79;
                        }
                    } else if (this$exception.equals(other$exception)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label72;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label72;
                    }

                    return false;
                }

                Object this$timestamp = this.getTimestamp();
                Object other$timestamp = other.getTimestamp();
                if (this$timestamp == null) {
                    if (other$timestamp != null) {
                        return false;
                    }
                } else if (!this$timestamp.equals(other$timestamp)) {
                    return false;
                }

                Object this$errors = this.getErrors();
                Object other$errors = other.getErrors();
                if (this$errors == null) {
                    if (other$errors != null) {
                        return false;
                    }
                } else if (!this$errors.equals(other$errors)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponseDto;
    }

    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $method = this.getMethod();
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        Object $exception = this.getException();
        result = result * 59 + ($exception == null ? 43 : $exception.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $errors = this.getErrors();
        result = result * 59 + ($errors == null ? 43 : $errors.hashCode());
        return result;
    }

    public String toString() {
        return "ErrorResponseDto(code=" + this.getCode() + ", status=" + this.getStatus() + ", method=" + this.getMethod() + ", path=" + this.getPath() + ", exception=" + this.getException() + ", message=" + this.getMessage() + ", timestamp=" + this.getTimestamp() + ", errors=" + this.getErrors() + ")";
    }
}
