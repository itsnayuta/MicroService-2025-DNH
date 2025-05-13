CREATE DATABASE IF NOT EXISTS question_db;

USE question_db;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text TEXT NOT NULL,    -- Câu hỏi
    option_1 VARCHAR(255) NOT NULL, -- Lựa chọn 1
    option_2 VARCHAR(255) NOT NULL, -- Lựa chọn 2
    option_3 VARCHAR(255) NOT NULL, -- Lựa chọn 3
    option_4 VARCHAR(255) NOT NULL, -- Lựa chọn 4
    correct_option INT NOT NULL,    -- Số của lựa chọn đúng (1, 2, 3, 4)
    quiz_id INT NOT NULL,           -- ID của quiz mà câu hỏi thuộc về
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- Quiz 1: Giới thiệu về dịch vụ và các loại hình dịch vụ
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Khái niệm nào sau đây miêu tả chính xác nhất về dịch vụ?', 
'Hoạt động chỉ liên quan đến sản xuất hàng hóa', 
'Hoạt động tạo ra các sản phẩm hữu hình', 
'Hoạt động mang lại giá trị không hữu hình cho khách hàng', 
'Hoạt động chỉ diễn ra trong lĩnh vực công nghiệp', 
3, 1),

('Ngành dịch vụ bao gồm những lĩnh vực nào sau đây?', 
'Chỉ bao gồm dịch vụ tài chính và bảo hiểm', 
'Chỉ bao gồm dịch vụ công nghệ thông tin', 
'Chỉ bao gồm dịch vụ vận tải và logistics', 
'Bao gồm nhiều lĩnh vực như tài chính, giáo dục, y tế, du lịch, v.v.', 
4, 1),

('Đặc điểm nào sau đây KHÔNG phải là đặc điểm của dịch vụ?', 
'Tính không đồng nhất', 
'Tính không thể tách rời', 
'Tính hữu hình', 
'Tính không thể lưu trữ', 
3, 1),

('Xu hướng nào sau đây đang định hình sự phát triển của ngành dịch vụ hiện nay?', 
'Giảm sự phụ thuộc vào công nghệ số', 
'Tăng cường cá nhân hóa dịch vụ theo nhu cầu khách hàng', 
'Tập trung vào sản phẩm hơn là trải nghiệm khách hàng', 
'Giảm thiểu vai trò của dữ liệu lớn trong phân tích khách hàng', 
2, 1),

('Khái niệm "Kinh tế dịch vụ" đề cập đến?', 
'Nền kinh tế chỉ tập trung vào sản xuất công nghiệp', 
'Nền kinh tế có tỷ trọng GDP từ ngành dịch vụ chiếm ưu thế', 
'Nền kinh tế không có các hoạt động thương mại quốc tế', 
'Nền kinh tế chỉ dựa vào xuất khẩu nông sản', 
2, 1);

-- Quiz 2: Dịch vụ khách hàng và quản lý dịch vụ
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Yếu tố nào quan trọng nhất trong dịch vụ khách hàng chất lượng cao?', 
'Cung cấp dịch vụ với giá thấp nhất có thể', 
'Sự hiểu biết và đáp ứng nhu cầu của khách hàng', 
'Đảm bảo khách hàng luôn đúng trong mọi tình huống', 
'Tự động hóa hoàn toàn quy trình phục vụ khách hàng', 
2, 2),

('Mô hình SERVQUAL được sử dụng để đánh giá điều gì?', 
'Tốc độ phục vụ của nhân viên', 
'Chất lượng dịch vụ dựa trên khoảng cách giữa kỳ vọng và cảm nhận', 
'Chi phí vận hành dịch vụ', 
'Mức độ đầu tư vào công nghệ dịch vụ', 
2, 2),

('Khái niệm "Khoảnh khắc của sự thật" (Moment of Truth) trong dịch vụ đề cập đến điều gì?', 
'Thời điểm khách hàng phát hiện ra lỗi trong dịch vụ', 
'Thời điểm tương tác trực tiếp giữa khách hàng và nhà cung cấp dịch vụ', 
'Thời điểm công ty công bố báo cáo tài chính', 
'Thời điểm ra mắt sản phẩm dịch vụ mới', 
2, 2),

('Chiến lược nào là hiệu quả nhất để giải quyết khiếu nại của khách hàng?', 
'Từ chối mọi khiếu nại không có bằng chứng cụ thể', 
'Lắng nghe, thừa nhận vấn đề và đưa ra giải pháp phù hợp', 
'Đưa ra nhiều lý do giải thích tại sao vấn đề xảy ra', 
'Chuyển khiếu nại đến bộ phận khác để tránh trách nhiệm', 
2, 2),

('Khái niệm "Service Blueprint" là gì?', 
'Bản thiết kế kiến trúc của cơ sở vật chất dịch vụ', 
'Bản mô tả chi tiết về quy trình cung cấp dịch vụ từ góc nhìn khách hàng và nội bộ', 
'Bản kế hoạch tài chính cho việc triển khai dịch vụ mới', 
'Bản thiết kế đồng phục cho nhân viên dịch vụ', 
2, 2);

-- Quiz 3: Quản lý chất lượng dịch vụ
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Mô hình quản lý chất lượng toàn diện (TQM) trong dịch vụ tập trung vào yếu tố nào?', 
'Chỉ quan tâm đến lợi nhuận ngắn hạn', 
'Cải tiến liên tục và sự tham gia của toàn bộ tổ chức', 
'Chỉ tập trung vào cải thiện cơ sở vật chất', 
'Giảm thiểu chi phí mà không quan tâm đến chất lượng', 
2, 3),

('Phương pháp nào sau đây KHÔNG phải là công cụ để đo lường chất lượng dịch vụ?', 
'Khảo sát sự hài lòng của khách hàng', 
'Phân tích doanh thu từng sản phẩm', 
'Phân tích khiếu nại của khách hàng', 
'Đánh giá bí mật (Mystery Shopping)', 
2, 3),

('Chu trình PDCA (Plan-Do-Check-Act) của Deming được áp dụng trong quản lý chất lượng dịch vụ nhằm mục đích gì?', 
'Tăng cường kiểm soát nhân viên', 
'Cải tiến liên tục quy trình dịch vụ', 
'Giảm chi phí nhân sự', 
'Phát triển sản phẩm mới', 
2, 3),

('Tiêu chuẩn ISO 9001 liên quan đến lĩnh vực nào trong quản lý dịch vụ?', 
'Quản lý an toàn thông tin', 
'Quản lý môi trường', 
'Quản lý hệ thống chất lượng', 
'Quản lý sức khỏe và an toàn nghề nghiệp', 
3, 3),

('Khái niệm "Zero Defects" (Không lỗi) của Philip Crosby trong quản lý chất lượng dịch vụ đề cập đến điều gì?', 
'Không thừa nhận bất kỳ khiếu nại nào từ khách hàng', 
'Triết lý làm đúng ngay từ đầu và nỗ lực để không có lỗi trong dịch vụ', 
'Chỉ áp dụng cho sản xuất công nghiệp, không áp dụng cho dịch vụ', 
'Chấp nhận một tỷ lệ lỗi nhỏ là không thể tránh khỏi', 
2, 3);

-- Quiz 4: Chiến lược marketing trong ngành dịch vụ
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Đặc điểm nào làm cho marketing dịch vụ khác biệt so với marketing sản phẩm hữu hình?', 
'Marketing dịch vụ chỉ tập trung vào giá cả', 
'Marketing dịch vụ phải đối phó với tính vô hình của dịch vụ', 
'Marketing dịch vụ không cần quan tâm đến trải nghiệm khách hàng', 
'Marketing dịch vụ không cần chiến lược dài hạn', 
2, 4),

('Mô hình 7Ps trong marketing dịch vụ bao gồm những yếu tố nào?', 
'Product, Price, Place, Promotion (4Ps truyền thống)', 
'Product, Price, Place, Promotion, People, Process, Physical Evidence', 
'Planning, Positioning, Pricing, Publishing', 
'Performance, Popularity, Profit, Partnership', 
2, 4),

('Chiến lược nào sau đây hiệu quả để giảm thiểu tính biến động trong cung cấp dịch vụ?', 
'Tăng cường tự động hóa và tiêu chuẩn hóa quy trình', 
'Loại bỏ hoàn toàn yếu tố con người trong dịch vụ', 
'Giảm số lượng dịch vụ cung cấp', 
'Tăng giá dịch vụ để giảm nhu cầu', 
1, 4),

('Khái niệm "Internal Marketing" trong ngành dịch vụ đề cập đến điều gì?', 
'Quảng cáo nội bộ giữa các phòng ban', 
'Chiến lược marketing chỉ nhắm vào thị trường trong nước', 
'Hoạt động marketing nhằm thu hút, phát triển và tạo động lực cho nhân viên', 
'Chiến lược giảm chi phí marketing', 
3, 4),

('Trong marketing dịch vụ, "Service Recovery Paradox" đề cập đến hiện tượng nào?', 
'Khách hàng không bao giờ quay lại sau khi gặp vấn đề với dịch vụ', 
'Khách hàng có thể trở nên trung thành hơn sau khi vấn đề dịch vụ được giải quyết tốt', 
'Doanh nghiệp luôn thua lỗ khi giải quyết khiếu nại của khách hàng', 
'Không thể phục hồi chất lượng dịch vụ sau sự cố', 
2, 4);

-- Quiz 5: Phân tích và đo lường sự hài lòng của khách hàng
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Chỉ số Net Promoter Score (NPS) được tính toán như thế nào?', 
'Tổng số khách hàng hài lòng chia cho tổng số khách hàng', 
'Phần trăm người ủng hộ (Promoters) trừ đi phần trăm người chỉ trích (Detractors)', 
'Tổng doanh thu chia cho chi phí marketing', 
'Số lượng khách hàng mới trừ đi số lượng khách hàng rời bỏ', 
2, 5),

('Phương pháp nào sau đây thường được sử dụng để thu thập dữ liệu về sự hài lòng của khách hàng?', 
'Chỉ sử dụng dữ liệu doanh thu', 
'Chỉ theo dõi số lượng khiếu nại', 
'Kết hợp nhiều phương pháp như khảo sát, phỏng vấn, nhóm tập trung, phân tích dữ liệu', 
'Chỉ dựa vào báo cáo của nhân viên', 
3, 5),

('Mô hình KANO phân loại các thuộc tính của dịch vụ thành những nhóm nào?', 
'Tốt, Xấu, Trung bình', 
'Cơ bản, Hiệu suất, Phấn khích, Thờ ơ, Ngược đời', 
'Đắt, Rẻ, Trung bình', 
'Hữu hình, Vô hình, Bán hữu hình', 
2, 5),

('Customer Effort Score (CES) đo lường yếu tố nào của trải nghiệm khách hàng?', 
'Mức độ hạnh phúc của khách hàng', 
'Mức độ nỗ lực mà khách hàng phải bỏ ra để sử dụng dịch vụ', 
'Số tiền khách hàng chi tiêu', 
'Tần suất mua hàng của khách hàng', 
2, 5),

('Tại sao việc phân tích dữ liệu về sự hài lòng theo phân khúc khách hàng lại quan trọng?', 
'Để tăng giá dịch vụ cho tất cả khách hàng', 
'Để tập trung vào những khách hàng có giá trị nhất', 
'Để hiểu rõ nhu cầu và kỳ vọng khác nhau của từng nhóm khách hàng', 
'Để giảm chi phí dịch vụ khách hàng', 
3, 5);

-- Quiz 6: Dịch vụ tài chính và bảo hiểm
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Đặc điểm nào sau đây KHÔNG phải là đặc trưng của dịch vụ tài chính?', 
'Tính vô hình cao', 
'Quy định và giám sát chặt chẽ', 
'Tính đồng nhất giữa các nhà cung cấp', 
'Mức độ rủi ro và tin cậy cao', 
3, 6),

('Fintech là gì?', 
'Thuật ngữ chỉ các ngân hàng truyền thống', 
'Công nghệ được sử dụng để cải thiện và tự động hóa dịch vụ tài chính', 
'Phương pháp đầu tư cổ phiếu', 
'Loại tiền điện tử', 
2, 6),

('Nguyên tắc cơ bản nào của bảo hiểm cho phép công ty bảo hiểm có thể chi trả cho những rủi ro lớn?', 
'Tính minh bạch', 
'Phân tán rủi ro giữa nhiều người được bảo hiểm', 
'Marketing sản phẩm hiệu quả', 
'Đánh giá sức khỏe khách hàng', 
2, 6),

('Dịch vụ ngân hàng di động (Mobile Banking) mang lại lợi ích chính nào cho khách hàng?', 
'Tăng lãi suất tiết kiệm', 
'Tiếp cận và quản lý tài khoản mọi lúc, mọi nơi', 
'Giảm phí giao dịch quốc tế', 
'Tự động tăng hạn mức tín dụng', 
2, 6),

('Khái niệm "Underwriting" trong ngành bảo hiểm đề cập đến quy trình nào?', 
'Quá trình giải quyết khiếu nại', 
'Quá trình marketing sản phẩm bảo hiểm', 
'Quá trình đánh giá rủi ro để quyết định bảo hiểm và phí bảo hiểm', 
'Quá trình đào tạo đại lý bảo hiểm', 
3, 6);

-- Quiz 7: Dịch vụ chăm sóc sức khỏe và y tế
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Xu hướng nào sau đây đang định hình ngành dịch vụ y tế hiện đại?', 
'Giảm sử dụng công nghệ trong chẩn đoán', 
'Tập trung vào điều trị hơn là phòng ngừa', 
'Y tế từ xa (Telemedicine) và chăm sóc cá nhân hóa', 
'Giảm vai trò của dữ liệu bệnh nhân', 
3, 7),

('Mô hình nào sau đây là một cách tiếp cận hiện đại trong cung cấp dịch vụ y tế?', 
'Chăm sóc tập trung vào bệnh viện', 
'Chăm sóc tập trung vào bệnh nhân và kết quả điều trị', 
'Chăm sóc chỉ dựa vào ý kiến bác sĩ', 
'Chăm sóc chỉ tập trung vào điều trị thuốc', 
2, 7),

('Khái niệm "Y tế điện tử" (e-Health) bao gồm những yếu tố nào?', 
'Chỉ đơn thuần là tư vấn sức khỏe qua điện thoại', 
'Sử dụng công nghệ thông tin và truyền thông để hỗ trợ các dịch vụ y tế và chăm sóc sức khỏe', 
'Chỉ là hệ thống đặt lịch khám trực tuyến', 
'Thay thế hoàn toàn bác sĩ bằng trí tuệ nhân tạo', 
2, 7),

('Yếu tố nào tạo nên sự phức tạp trong quản lý chất lượng dịch vụ y tế?', 
'Thiếu các tiêu chuẩn đánh giá chất lượng', 
'Tính đa dạng của bệnh lý và cá nhân hóa điều trị', 
'Sự đơn giản của các quy trình y tế', 
'Sự thiếu quan tâm của bệnh nhân đến chất lượng dịch vụ', 
2, 7),

('Hồ sơ y tế điện tử (EMR - Electronic Medical Records) mang lại lợi ích chính nào?', 
'Giảm chi phí in ấn giấy tờ', 
'Tăng thời gian nhập liệu cho bác sĩ', 
'Cải thiện quản lý thông tin bệnh nhân và hỗ trợ quyết định lâm sàng', 
'Loại bỏ nhu cầu gặp trực tiếp bác sĩ', 
3, 7);

-- Quiz 8: Dịch vụ vận chuyển và logistics
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Khái niệm "Last Mile Delivery" trong logistics đề cập đến giai đoạn nào?', 
'Vận chuyển hàng hóa từ nhà máy đến trung tâm phân phối', 
'Vận chuyển hàng hóa giữa các quốc gia', 
'Giai đoạn cuối cùng của quá trình giao hàng đến người tiêu dùng', 
'Vận chuyển hàng hóa giữa các trung tâm phân phối', 
3, 8),

('Công nghệ nào sau đây đang làm thay đổi cách thức hoạt động của ngành logistics?', 
'Điện thoại cố định', 
'Internet vạn vật (IoT), trí tuệ nhân tạo và blockchain', 
'Máy fax', 
'Công nghệ in ấn truyền thống', 
2, 8),

('Mô hình Supply Chain 4.0 đặc trưng bởi yếu tố nào?', 
'Giảm thiểu việc sử dụng công nghệ số', 
'Tích hợp số hóa, tự động hóa và phân tích dữ liệu', 
'Tăng cường sử dụng lao động thủ công', 
'Giảm tính minh bạch trong chuỗi cung ứng', 
2, 8),

('Dịch vụ 3PL (Third-Party Logistics) cung cấp những gì cho doanh nghiệp?', 
'Chỉ dịch vụ vận tải', 
'Chỉ dịch vụ kho bãi', 
'Các dịch vụ logistics bên ngoài bao gồm vận tải, kho bãi, đóng gói và phân phối', 
'Chỉ dịch vụ tư vấn logistics', 
3, 8),

('Các giai đoạn chính trong quản lý chuỗi cung ứng bao gồm những gì?', 
'Chỉ có mua hàng và bán hàng', 
'Lập kế hoạch, mua sắm, sản xuất, giao hàng và hoàn trả', 
'Chỉ có marketing và bán hàng', 
'Chỉ có sản xuất và phân phối', 
2, 8);

-- Quiz 9: Dịch vụ giáo dục và đào tạo
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Mô hình học tập kết hợp (Blended Learning) là gì?', 
'Chỉ học trực tuyến', 
'Chỉ học trực tiếp trong lớp', 
'Kết hợp giữa học trực tuyến và học trực tiếp', 
'Chỉ học qua sách giáo khoa', 
3, 9),

('Khái niệm "Học tập suốt đời" (Lifelong Learning) đề cập đến điều gì?', 
'Chỉ học tập trong trường học', 
'Quá trình học tập liên tục diễn ra trong suốt cuộc đời một người', 
'Học tập chỉ dành cho người trẻ', 
'Học tập chỉ để lấy bằng cấp', 
2, 9),

('Xu hướng nào sau đây đang định hình ngành giáo dục hiện đại?', 
'Loại bỏ hoàn toàn vai trò của giáo viên', 
'Giảm thiểu sử dụng công nghệ trong lớp học', 
'Cá nhân hóa việc học tập và sử dụng công nghệ hỗ trợ', 
'Chỉ tập trung vào kiến thức học thuật, bỏ qua kỹ năng mềm', 
3, 9),

('MOOCs (Massive Open Online Courses) có đặc điểm nào sau đây?', 
'Chỉ dành cho một số ít người học', 
'Yêu cầu học phí cao', 
'Mở cho số lượng lớn người học và thường miễn phí hoặc chi phí thấp', 
'Chỉ cung cấp chứng chỉ chính thức', 
3, 9),

('Yếu tố nào sau đây quyết định chất lượng của một dịch vụ đào tạo trực tuyến?', 
'Chỉ dựa vào nền tảng công nghệ sử dụng', 
'Chỉ dựa vào danh tiếng của tổ chức cung cấp', 
'Kết hợp nhiều yếu tố: nội dung, phương pháp giảng dạy, tương tác, hỗ trợ học viên và công nghệ', 
'Chỉ dựa vào số lượng bài giảng', 
3, 9);

-- Quiz 10: Dịch vụ công nghệ thông tin và phần mềm
INSERT INTO questions (question_text, option_1, option_2, option_3, option_4, correct_option, quiz_id) VALUES
('Mô hình SaaS (Software as a Service) có đặc điểm nào sau đây?', 
'Khách hàng phải cài đặt phần mềm trên máy chủ riêng', 
'Phần mềm được cung cấp qua internet và người dùng truy cập qua trình duyệt hoặc ứng dụng', 
'Khách hàng phải mua giấy phép vĩnh viễn', 
'Không có khả năng cập nhật tự động', 
2, 10),

('DevOps trong phát triển phần mềm đề cập đến điều gì?', 
'Chỉ là quy trình phát triển phần mềm', 
'Chỉ là quy trình vận hành hệ thống', 
'Văn hóa và phương pháp kết hợp phát triển phần mềm và vận hành hệ thống', 
'Một ngôn ngữ lập trình mới', 
3, 10),

('Dịch vụ điện toán đám mây thường được phân loại thành những mô hình nào?', 
'Chỉ có phần mềm và phần cứng', 
'IaaS (Infrastructure as a Service), PaaS (Platform as a Service), SaaS (Software as a Service)', 
'Chỉ có dịch vụ lưu trữ', 
'Chỉ có dịch vụ bảo mật', 
2, 10),

('Vai trò của Service Level Agreement (SLA) trong dịch vụ IT là gì?', 
'Chỉ là tài liệu marketing', 
'Thỏa thuận quy định mức độ dịch vụ, chất lượng, trách nhiệm giữa nhà cung cấp và khách hàng', 
'Chỉ quy định giá cả dịch vụ', 
'Chỉ là hướng dẫn sử dụng phần mềm', 
2, 10),

('Xu hướng nào sau đây đang định hình ngành dịch vụ IT hiện đại?', 
'Giảm tầm quan trọng của bảo mật dữ liệu', 
'Trí tuệ nhân tạo, điện toán đám mây, dữ liệu lớn và bảo mật thông tin', 
'Quay trở lại với phần mềm cài đặt truyền thống', 
'Giảm thiểu việc cập nhật phần mềm', 
2, 10),

('ITIL (Information Technology Infrastructure Library) là gì?', 
'Một ngôn ngữ lập trình', 
'Bộ các thực hành tốt nhất để quản lý dịch vụ IT hiệu quả', 
'Một loại phần cứng máy tính', 
'Một công ty phần mềm', 
2, 10);