/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.rest.model;

/**
 * Response result container
 */
public final class ResponseEntity<T> {
    private boolean success;

    private Error error;

    private String message;

    private T data;

    private ResponseEntity() {
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }



    public static <T> ResponseEntity<T> success(final T data) {
        return success(data, null);
    }

    public static <T> ResponseEntity<T> success(final T data, final String message) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.success = true;
        result.data = data;
        result.message = message;
        return result;
    }

    public static ResponseEntity success() {
        ResponseEntity<?> result = new ResponseEntity<>();
        result.success = true;
        return result;
    }

    public static ResponseEntity error(final Throwable throwable) {
        return error(throwable, null);
    }

    public static ResponseEntity error(final Throwable throwable, final String message) {
        ResponseEntity<?> result = new ResponseEntity();
        result.success = false;
        result.error = new Error(throwable);
        result.message = message;
        return result;
    }
}
