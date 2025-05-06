package com.example.service_quizz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quizzes")  // Tên bảng trong cơ sở dữ liệu
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int duration;
    private String description;

    // Các trường khác liên quan đến Quiz nếu cần
}
