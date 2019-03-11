package com.report.ytb.annotation;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
    private Map<Class<?>, IAnnotationHandler<?>> handlers = new HashMap<>();

    public <T extends Annotation> void registerHandler(Class<T> type, IAnnotationHandler<T> handler) {
        handlers.put(type, handler);
    }

    public void process(Class<?> root) throws Exception {
        for (Annotation annotation: root.getAnnotations()) {
            handle(annotation);
            for (Annotation subAnnotation: annotation.annotationType().getAnnotations()) {
                handle(subAnnotation);
            }
        }
    }

    private void handle(Annotation annotation) {
        IAnnotationHandler<?> handler = handlers.get(annotation.annotationType());
        if (handler != null) {
            handler.handle(annotation);
        }
    }
}
