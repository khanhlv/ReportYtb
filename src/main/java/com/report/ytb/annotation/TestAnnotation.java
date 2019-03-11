package com.report.ytb.annotation;

public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        AnnotationProcessor processor = new AnnotationProcessor();
        processor.registerHandler(IntegrationTest.class, a -> System.out.println("Found a class annotated with @IntegrationTest"));
        processor.registerHandler(SlowTest.class, a -> System.out.println("Found a class annotated with @SlowTest"));
        processor.registerHandler(Test.class, a -> System.out.println("Found a class annotated with @Test(" + a.value() + ")"));
        processor.process(SomeIntegrationTest.class);
    }
}
