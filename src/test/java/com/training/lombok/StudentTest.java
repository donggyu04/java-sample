package com.training.lombok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StudentTest {

    @Test
    public void testCommonLombok() {
        Student student = Student.builder().build();
        assertEquals("korea", student.getAddress());
        assertEquals("lombok", student.getName());

        Student student2 = new Student();
        assertEquals(student.getAddress(), student2.getAddress());
        assertEquals(student.getName(), student2.getName());

        System.out.println("student(use builder) : " + student);
        System.out.println("student2(use default constructor) : " + student2);
    }

    @Test
    public void testLazyGetter() {
        new Student();
        assertEquals(0, Student.initLazyValueCallCount);
    }
}
