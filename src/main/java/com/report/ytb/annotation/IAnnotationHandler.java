package com.report.ytb.annotation;

import java.lang.annotation.Annotation;

public interface  IAnnotationHandler<T extends Annotation> {

    @SuppressWarnings("unchecked")
    public default void handle(Annotation annotation) {
        doHandle((T) annotation);
    }

    public void doHandle(T annotation);
}