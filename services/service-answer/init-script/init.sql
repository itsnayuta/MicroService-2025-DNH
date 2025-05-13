CREATE DATABASE IF NOT EXISTS answer_db;

USE answer_db;

CREATE TABLE answers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    question_id INT,
    answer VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tạo database và sử dụng database
CREATE DATABASE IF NOT EXISTS answer_db;

USE answer_db;

-- Tạo bảng answers theo yêu cầu
CREATE TABLE answers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    question_id INT,
    answer VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Thêm dữ liệu mẫu cho 5 người dùng
-- Người dùng 1 (b21dccn001) làm quiz 1
INSERT INTO answers (user_id, question_id, answer) VALUES
(1, 1, '3'),  -- Câu 1 quiz 1, chọn đáp án 3
(1, 2, '4'),  -- Câu 2 quiz 1, chọn đáp án 4
(1, 3, '2'),  -- Câu 3 quiz 1, chọn đáp án 2
(1, 4, '2'),  -- Câu 4 quiz 1, chọn đáp án 2
(1, 5, '2');  -- Câu 5 quiz 1, chọn đáp án 2

-- Người dùng 2 (b21dccn002) làm quiz 2
INSERT INTO answers (user_id, question_id, answer) VALUES
(2, 6, '2'),   -- Câu 1 quiz 2, chọn đáp án 2
(2, 7, '1'),   -- Câu 2 quiz 2, chọn đáp án 1
(2, 8, '2'),   -- Câu 3 quiz 2, chọn đáp án 2
(2, 9, '3'),   -- Câu 4 quiz 2, chọn đáp án 3
(2, 10, '2');  -- Câu 5 quiz 2, chọn đáp án 2

-- Người dùng 3 (b21dccn003) làm quiz 3
INSERT INTO answers (user_id, question_id, answer) VALUES
(3, 11, '2'),  -- Câu 1 quiz 3, chọn đáp án 2
(3, 12, '3'),  -- Câu 2 quiz 3, chọn đáp án 3
(3, 13, '2'),  -- Câu 3 quiz 3, chọn đáp án 2
(3, 14, '3'),  -- Câu 4 quiz 3, chọn đáp án 3
(3, 15, '2');  -- Câu 5 quiz 3, chọn đáp án 2

-- Người dùng 4 (b21dccn004) làm quiz 4
INSERT INTO answers (user_id, question_id, answer) VALUES
(4, 16, '2'),  -- Câu 1 quiz 4, chọn đáp án 2
(4, 17, '1'),  -- Câu 2 quiz 4, chọn đáp án 1
(4, 18, '1'),  -- Câu 3 quiz 4, chọn đáp án 1
(4, 19, '3'),  -- Câu 4 quiz 4, chọn đáp án 3
(4, 20, '2');  -- Câu 5 quiz 4, chọn đáp án 2

-- Người dùng 5 (b21dccn005) làm quiz 5
INSERT INTO answers (user_id, question_id, answer) VALUES
(5, 21, '2'),  -- Câu 1 quiz 5, chọn đáp án 2
(5, 22, '3'),  -- Câu 2 quiz 5, chọn đáp án 3
(5, 23, '2'),  -- Câu 3 quiz 5, chọn đáp án 2
(5, 24, '2'),  -- Câu 4 quiz 5, chọn đáp án 2
(5, 25, '3');  -- Câu 5 quiz 5, chọn đáp án 3