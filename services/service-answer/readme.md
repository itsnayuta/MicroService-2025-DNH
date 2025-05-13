# Answer Service API Endpoints

## Base URL: `/api/v1/answers`

### 1. Tạo câu trả lời

- **Method:** `POST`  
- **Endpoint:** `/api/v1/answers`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Request Body:** Đối tượng `AnswerRequest` dạng JSON gồm:
  - `questionId` (Integer): ID của câu hỏi liên quan
  - `userId` (Integer): ID người trả lời
  - `answer` (String): Nội dung câu trả lời

- **Response:**
  - ✅ `201 Created`: Trả về `AnswerResponse` chứa thông tin câu trả lời đã lưu
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 2. Lấy câu trả lời theo ID người dùng

- **Method:** `GET`  
- **Endpoint:** `/api/v1/answers/user/{userId}`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `userId` (Integer): ID người dùng cần truy vấn

- **Response:**
  - ✅ `200 OK`: Trả về danh sách các `AnswerResponse` của người dùng
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 3. Lấy toàn bộ câu trả lời (Chỉ dành cho ADMIN)

- **Method:** `GET`  
- **Endpoint:** `/api/v1/answers`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`

- **Response:**
  - ✅ `200 OK`: Trả về danh sách tất cả các `AnswerResponse`
  - ⛔ `403 Forbidden`: Không có quyền truy cập → `"NOT ALLOW"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 4. Lấy câu trả lời theo ID

- **Method:** `GET`  
- **Endpoint:** `/api/v1/answers/{id}`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `id` (Integer): ID câu trả lời cần truy vấn

- **Response:**
  - ✅ `200 OK`: Trả về `AnswerResponse` theo ID
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 5. Lấy câu trả lời theo ID câu hỏi

- **Method:** `GET`  
- **Endpoint:** `/api/v1/answers/question/{questionId}`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `questionId` (Integer): ID câu hỏi cần truy vấn câu trả lời

- **Response:**
  - ✅ `200 OK`: Trả về danh sách các `AnswerResponse` theo câu hỏi
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 6. Tìm kiếm câu trả lời (Chỉ dành cho ADMIN)

- **Method:** `GET`  
- **Endpoint:** `/api/v1/answers/search?keyword={keyword}`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Query Param:**
  - `keyword` (String): Từ khóa tìm kiếm

- **Response:**
  - ✅ `200 OK`: Trả về danh sách `AnswerResponse` khớp với từ khóa
  - ⛔ `403 Forbidden`: Không có quyền truy cập → `"NOT ALLOW"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 7. Cập nhật câu trả lời

- **Method:** `PUT`  
- **Endpoint:** `/api/v1/answers/{id}`  
- **Yêu cầu Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
