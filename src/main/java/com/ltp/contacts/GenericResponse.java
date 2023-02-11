package com.ltp.contacts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericResponse<D, E> {
    private boolean success;
    private D data;
    private E error;

    public GenericResponse() {
    }

    public GenericResponse(boolean success, D data, E error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public E getError() {
        return error;
    }

    public void setError(E error) {
        this.error = error;
    }
}