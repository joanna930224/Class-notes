package com.example.demo;


import com.example.demo.entity.test.ClassRoom;
import com.example.demo.entity.test.TestStudent;
import com.example.demo.repository.test.ClassRoomRepository;
import com.example.demo.repository.test.TestStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentTestCase {

    @Autowired
    private TestStudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    /** 등록 Test */
    @Test
    void registerStudentTest() {
        //ClassRoom classRoom = new ClassRoom("test-room");
        //ClassRoom classRoom = new ClassRoom("save-room");
        ClassRoom classRoom = new ClassRoom("unique-room");
        classRoomRepository.save(classRoom);

        //TestStudent student = new TestStudent("test-student");
        //TestStudent student = new TestStudent("save-student");
        TestStudent student = new TestStudent("unique-student");

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }

    /** 지정한 1건에 대한 조회 Test */
    @Test
    void findStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findById((long) 1);
        TestStudent student = maybeStudent.get();

        System.out.println(student);
    }

    /** 모든 항목 조회 Test*/
    @Test
    void findAllStudents () {
        List<TestStudent> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    /** 지정한 RoomName 으로 조회 Test */
    @Test
    void findStudentWithRoomName () {
        // Optional의 경우 1개로 확정되는 경우에만 사용해야함.
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("unique-room");
        TestStudent student = maybeStudent.get();

        System.out.println(student);
    }

    /** 지정한 RoomName 정보 List 로 조회 */
    @Test
    void findStudentListWithRoomName () {
        List<TestStudent> studentList = studentRepository.findTestStudentListByRoomName("save-room");

        System.out.println(studentList);
    }

    /** 수정 Test */
    @Test
    void modifyStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("unique-room");
        TestStudent student = maybeStudent.get();

        ClassRoom classRoom = new ClassRoom("modify-room");
        classRoomRepository.save(classRoom);

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }

    /** 삭제 Test */
    @Test
    void deleteStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("modify-room");
        TestStudent student = maybeStudent.get();

        student.setClassRoom(null);
        studentRepository.delete(student);
    }
}
