CREATE DATABASE IF NOT EXISTS quiz_db;

USE quiz_db;

CREATE TABLE IF NOT EXISTS quizzes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration INT NOT NULL,
	description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO quizzes (title, duration, description) VALUES
('Giới thiệu về dịch vụ và các loại hình dịch vụ', 30, 'Câu hỏi về các loại hình dịch vụ và sự phát triển của ngành dịch vụ.'),
('Dịch vụ khách hàng và quản lý dịch vụ', 45, 'Câu hỏi về kỹ năng chăm sóc khách hàng và các mô hình quản lý dịch vụ.'),
('Quản lý chất lượng dịch vụ', 60, 'Câu hỏi về các phương pháp và công cụ đảm bảo chất lượng trong dịch vụ.'),
('Chiến lược marketing trong ngành dịch vụ', 40, 'Các câu hỏi về chiến lược marketing đặc thù cho ngành dịch vụ.'),
('Phân tích và đo lường sự hài lòng của khách hàng', 50, 'Câu hỏi về các phương pháp đo lường mức độ hài lòng của khách hàng.'),
('Dịch vụ tài chính và bảo hiểm', 45, 'Câu hỏi liên quan đến các loại dịch vụ tài chính và bảo hiểm.'),
('Dịch vụ chăm sóc sức khỏe và y tế', 50, 'Câu hỏi về các dịch vụ chăm sóc sức khỏe và y tế hiện đại.'),
('Dịch vụ vận chuyển và logistics', 40, 'Câu hỏi về các loại hình dịch vụ vận chuyển và logistics toàn cầu.'),
('Dịch vụ giáo dục và đào tạo', 45, 'Câu hỏi về các dịch vụ giáo dục, đào tạo và học trực tuyến.'),
('Dịch vụ công nghệ thông tin và phần mềm', 60, 'Câu hỏi về các dịch vụ IT và phần mềm, bao gồm hỗ trợ và phát triển phần mềm.'); 