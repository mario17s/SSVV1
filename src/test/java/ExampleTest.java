import org.example.domain.Student;
import org.example.repository.StudentXMLRepository;
import org.example.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@Tag("AppTest")
public class ExampleTest {

    @Mock
    private StudentXMLRepository studentXmlRepo;

    private Service studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new Service(studentXmlRepo, null, null);
    }

    @Test
    void testSaveStudentWithPositiveId() {
        String id = "123";
        String name = "John Doe";
        int group = 101;
        Student student = new Student(id, name, group);

        when(studentXmlRepo.save(student)).thenReturn(new Student(id, name, group));

        int result = studentService.saveStudent(id, name, group);

        assertEquals(0, result);
        verify(studentXmlRepo, times(1)).save(student);
    }

    @Test
    void testSaveStudentWithNegativeId() {
        String id = "-123";
        String name = "Jane Doe";
        int group = 102;
        Student student = new Student(id, name, group);

        when(studentXmlRepo.save(student)).thenReturn(null);

        int result = studentService.saveStudent(id, name, group);

        assertEquals(1, result);
        verify(studentXmlRepo, times(1)).save(student);
    }
}

