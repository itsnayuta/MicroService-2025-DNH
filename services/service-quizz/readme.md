# Quiz Service API Endpoints

## Base URL: /api/v1/quizzes

### 1. Lấy danh sách tất cả các câu hỏi (Quizzes)

- **Method:** GET
- **Endpoint:** /api/v1/quizzes
- **Response:**
  - Nếu token hợp lệ, trả về mã trạng thái 200 (OK) và danh sách tất cả các câu hỏi (quiz) dưới dạng JSON.
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized).

---

### 2. Lấy thông tin câu hỏi theo ID

- **Method:** GET
- **Endpoint:** /api/v1/quizzes/{id}
- **Path Variable:**
  - `id` (Long): ID của câu hỏi cần lấy thông tin
- **Response:**
  - Nếu token hợp lệ và câu hỏi tồn tại, trả về mã trạng thái 200 (OK) và thông tin câu hỏi dưới dạng JSON.
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized).
  - Nếu câu hỏi không tồn tại, trả về mã trạng thái 404 (Not Found).

---

### 3. Tạo câu hỏi mới (Chỉ dành cho admin)

- **Method:** POST
- **Endpoint:** /api/v1/quizzes
- **Request Body:** Đối tượng `QuizDTO` dạng JSON, bao gồm các trường:
  - `title` (String): Tiêu đề câu hỏi
  - `duration` (Integer): Thời gian làm bài (tính bằng phút)
  - `description` (String): Mô tả câu hỏi
- **Response:**
  - Nếu token hợp lệ và người dùng có vai trò `ADMIN`, trả về mã trạng thái 201 (Created) và thông tin câu hỏi mới tạo dưới dạng JSON.
  - Nếu token không hợp lệ hoặc người dùng không phải `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED".

---

### 4. Cập nhật câu hỏi (Chỉ dành cho admin)

- **Method:** PUT
- **Endpoint:** /api/v1/quizzes/{id}
- **Path Variable:**
  - `id` (Long): ID của câu hỏi cần cập nhật
- **Request Body:** Đối tượng `QuizDTO` dạng JSON, bao gồm các trường:
  - `title` (String): Tiêu đề câu hỏi
  - `duration` (Integer): Thời gian làm bài (tính bằng phút)
  - `description` (String): Mô tả câu hỏi
- **Response:**
  - Nếu token hợp lệ và người dùng có vai trò `ADMIN`, trả về mã trạng thái 200 (OK) và thông báo "UPDATED".
  - Nếu câu hỏi không tồn tại, trả về mã trạng thái 404 (Not Found) với thông báo "NOT FOUND".
  - Nếu người dùng không có quyền `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED".

---

### 5. Xóa câu hỏi (Chỉ dành cho admin)

- **Method:** DELETE
- **Endpoint:** /api/v1/quizzes/{id}
- **Path Variable:**
  - `id` (Long): ID của câu hỏi cần xóa
- **Response:**
  - Nếu token hợp lệ và người dùng có vai trò `ADMIN`, trả về mã trạng thái 200 (OK) và thông báo "DELETED".
  - Nếu câu hỏi không tồn tại, trả về mã trạng thái 404 (Not Found) với thông báo "NOT FOUND".
  - Nếu người dùng không có quyền `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED".
