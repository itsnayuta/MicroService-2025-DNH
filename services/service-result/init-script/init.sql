CREATE DATABASE IF NOT EXISTS result_db;

USE result_db;

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    quiz_id INT,
    score INT NOT NULL,
    total_questions INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Kết quả của người dùng 1 (b21dccn001)
INSERT INTO results (user_id, quiz_id, score, total_questions) VALUES
(1, 1, 4, 5),  -- User 1 làm quiz 1, đúng 4/5 câu
(1, 2, 3, 5);  -- User 1 cũng làm quiz 2, đúng 3/5 câu

-- Kết quả của người dùng 2 (b21dccn002)
INSERT INTO results (user_id, quiz_id, score, total_questions) VALUES
(2, 1, 3, 5),  -- User 2 làm quiz 1, đúng 3/5 câu
(2, 3, 5, 5);  -- User 2 cũng làm quiz 3, đúng 5/5 câu

-- Kết quả của người dùng 3 (b21dccn003)
INSERT INTO results (user_id, quiz_id, score, total_questions) VALUES
(3, 2, 2, 5),  -- User 3 làm quiz 2, đúng 2/5 câu
(3, 3, 4, 5),  -- User 3 cũng làm quiz 3, đúng 4/5 câu
(3, 4, 3, 5);  -- User 3 cũng làm quiz 4, đúng 3/5 câu

-- Kết quả của người dùng 4 (b21dccn004)
INSERT INTO results (user_id, quiz_id, score, total_questions) VALUES
(4, 1, 5, 5),  -- User 4 làm quiz 1, đúng 5/5 câu
(4, 4, 4, 5);  -- User 4 cũng làm quiz 4, đúng 4/5 câu

-- Kết quả của người dùng 5 (b21dccn005)
INSERT INTO results (user_id, quiz_id, score, total_questions) VALUES
(5, 5, 3, 5),  -- User 5 làm quiz 5, đúng 3/5 câu
(5, 6, 2, 5),  -- User 5 cũng làm quiz 6, đúng 2/5 câu
(5, 7, 4, 5);  -- User 5 cũng làm quiz 7, đúng 4/5 câu