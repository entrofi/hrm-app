/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Response entity model repsenting error states
 */
public final class Error {


    private final String errorId;

    private final String errorSource;

    private final List<String> stackTrace;

    private final String message;

    public Error(final Throwable throwable) {
        this(throwable, null, null);
    }


    public Error(final Throwable throwable, final String message, final String errorId) {
        this.errorSource = throwable.getClass().getSimpleName();
        this.message = message;
        this.errorId = errorId;
        this.stackTrace = new ArrayList<>();
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            this.stackTrace.add(stackTraceElement.toString());
        }
    }


    public String getErrorId() {
        return errorId;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public List<String> getStackTrace() {
        return stackTrace;
    }

    public String getMessage() {
        return message;
    }
}
