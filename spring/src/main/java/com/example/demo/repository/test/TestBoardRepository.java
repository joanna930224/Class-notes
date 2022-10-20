package com.example.demo.repository.test;

import com.example.demo.entity.test.TestBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestBoardRepository extends JpaRepository<TestBoard, Long> {
}
