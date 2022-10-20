package com.example.demo;


import com.example.demo.entity.test.ClassRoom;
import com.example.demo.entity.test.TestStudent;
import com.example.demo.repository.test.ClassRoomRepository;
import com.example.demo.repository.test.TestStudentRepository;
import org.junit.jupiter.api.Test;package com.example.demo;

import com.example.demo.entity.test.Comment;
import com.example.demo.entity.test.TestBoard;
import com.example.demo.entity.test.response.CommentResponse;
import com.example.demo.repository.test.CommentRepository;
import com.example.demo.repository.test.TestBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardTestCase {

    @Autowired
    private TestBoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    /** Non-Builder 게시글 생성 */
    @Test
    void createBoard () {
        TestBoard board = new TestBoard("제목1", "본문1");

        boardRepository.save(board);
    }

    /** Non-Builder 댓글 등록 */
    @Test
    void writeComment () {
        Optional<TestBoard> maybeBoard = boardRepository.findById((long) 2);
        TestBoard board = maybeBoard.get();

        Comment comment = new Comment("코멘트1");

        // 아래에 builder 를 쓰면 set 쓰지 않아도 됨 !
        board.setComment(comment);
        boardRepository.save(board);

        commentRepository.save(comment);
    }

    /** builder 를 사용한 게시글 등록 */
    @Test
    void buildBoard () {
        TestBoard board = TestBoard.builder()
                .title("제목2")
                .content("본문2")
                .build();

        boardRepository.save(board);
    }

    /** builder 를 사용한 댓글 등록 */
    @Test
    void buildComment () {
        Optional<TestBoard> maybeBoard = boardRepository.findById((long) 3);
        TestBoard board = maybeBoard.get();

        Comment comment = Comment.builder()
                .content("코멘트2")
                .testBoard(board)
                .build();

        commentRepository.save(comment);
    }

    /** 특정 게시글에 달린 댓글 찾기 */
    @Test
    void findCommentsOnSpecificBoard () {
        List<Comment> commentList = commentRepository.findAllCommentsByBoardId((long) 3);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment : commentList) {
            commentResponses.add(new CommentResponse(comment.getContent()));
        }

        System.out.println(commentResponses);
    }

    /** 댓글 수정 */
    @Test
    void modifyCommentsOnBoard () {
        Optional<Comment> maybeComment = commentRepository.findById((long) 6);
        Comment comment = maybeComment.get();

        comment.modifyContent("댓글 수정");

        commentRepository.save(comment);
    }

    /** 댓글 삭제 */
    @Test
    void deleteCommentsOnBoard () {
        commentRepository.deleteById((long) 5);
    }

    /** 게시글 삭제 (댓글도 같이) */
    @Test
    void deleteBoard () {
        List<Comment> commentList = commentRepository.findAllCommentsByBoardId((long) 1);

        for (Comment comment : commentList) {
            commentRepository.delete(comment);
        }

        boardRepository.deleteById((long) 1);
    }
}

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
