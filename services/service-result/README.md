# Result Service API Endpoints

## Base URL: /api/v1/results

---

### 1. Lấy kết quả theo người dùng

- **Method:** GET  
- **Endpoint:** /api/v1/results/{userId}  
- **Path Variable:**  
  - `userId` (Integer): ID của người dùng muốn lấy danh sách kết quả  
- **Response:**
  - Nếu thành công, trả về mã trạng thái `200 OK` và một danh sách các đối tượng `ResultDTO` dạng JSON.
  - Nếu không tìm thấy kết quả hoặc có lỗi xảy ra, trả về mã trạng thái phù hợp (`404 Not Found`, `500 Internal Server Error`, v.v.)

---

### 2. Lưu kết quả mới

- **Method:** POST  
- **Endpoint:** /api/v1/results  
- **Request Body:**  
  Đối tượng `ResultDTO` dạng JSON, bao gồm các trường như:
  - `userId` (Integer): ID của người dùng
  - `quizId` (Integer): ID của bài kiểm tra
  - `score` (Double): Điểm số
  - `submitTime` (String): Thời gian nộp (ISO format)

- **Response:**
  - Nếu lưu thành công, trả về mã trạng thái `200 OK` và đối tượng `ResultDTO` đã được lưu.
  - Nếu dữ liệu không hợp lệ hoặc có lỗi xử lý, trả về mã lỗi tương ứng (`400 Bad Request`, `500 Internal Server Error`, v.v.)

---

### 3. Cập nhật kết quả theo ID

- **Method:** PATCH  
- **Endpoint:** /api/v1/results/{resultId}  
- **Path Variable:**  
  - `resultId` (Integer): ID của kết quả cần cập nhật  
- **Request Body:**  
  Đối tượng `ResultDTO` dạng JSON, bao gồm các trường cần cập nhật.  
  Lưu ý: Trường `id` trong body sẽ được ghi đè bằng `resultId` từ path.

- **Response:**
  - Nếu cập nhật thành công, trả về mã trạng thái `200 OK` và đối tượng `ResultDTO` đã cập nhật.
  - Nếu `resultId` không tồn tại, trả về `404 Not Found`.
  - Nếu dữ liệu không hợp lệ, trả về `400 Bad Request`.

---