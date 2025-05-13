# Question Service API Endpoints

## Base URL: `/api/v1/questions`

### 1. Tạo câu hỏi (Chỉ dành cho ADMIN)

- **Method:** `POST`
- **Endpoint:** `/api/v1/questions`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Request Body:** JSON dạng `QuestionRequest`:
  - `quizId` (Integer): ID bài quiz liên quan
  - `questionText` (String): Nội dung câu hỏi
  - `options` (List<String>): Danh sách các phương án
  - `correctAnswer` (String): Đáp án đúng

- **Response:**
  - ✅ `201 Created`: Trả về `QuestionResponse` với thông tin câu hỏi đã tạo
  - ⛔ `403 Forbidden`: Không phải ADMIN → `"NOT ALLOWED"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 2. Lấy danh sách câu hỏi theo Quiz ID

- **Method:** `GET`
- **Endpoint:** `/api/v1/questions/quiz/{quizId}`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `quizId` (Integer): ID bài quiz

- **Response:**
  - ✅ `200 OK`: Trả về danh sách `QuestionResponse` thuộc quiz
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 3. Lấy toàn bộ câu hỏi (Chỉ dành cho ADMIN)

- **Method:** `GET`
- **Endpoint:** `/api/v1/questions`
- **Header:**
  - `Authorization: Bearer <JWT>`

- **Response:**
  - ✅ `200 OK`: Trả về danh sách tất cả `QuestionResponse`
  - ⛔ `403 Forbidden`: Không phải ADMIN → `"NOT ALLOWED"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 4. Lấy câu hỏi theo ID

- **Method:** `GET`
- **Endpoint:** `/api/v1/questions/{id}`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `id` (Integer): ID của câu hỏi

- **Response:**
  - ✅ `200 OK`: Trả về `QuestionResponse` theo ID
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 5. Tìm kiếm câu hỏi theo từ khóa (Chỉ dành cho ADMIN)

- **Method:** `GET`
- **Endpoint:** `/api/v1/questions/search?keyword={keyword}`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Query Param:**
  - `keyword` (String): Từ khóa tìm kiếm

- **Response:**
  - ✅ `200 OK`: Trả về danh sách `QuestionResponse` phù hợp
  - ⛔ `403 Forbidden`: Không phải ADMIN → `"NOT ALLOWED"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 6. Cập nhật câu hỏi (Chỉ dành cho ADMIN)

- **Method:** `PUT`
- **Endpoint:** `/api/v1/questions/{id}`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `id` (Integer): ID của câu hỏi cần cập nhật
- **Request Body:** JSON dạng `QuestionRequest`:
  - `quizId` (Integer)
  - `questionText` (String)
  - `options` (List<String>)
  - `correctAnswer` (String)

- **Response:**
  - ✅ `200 OK`: Trả về `QuestionResponse` đã cập nhật
  - ⛔ `403 Forbidden`: Không phải ADMIN → `"NOT ALLOWED"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`

---

### 7. Xóa câu hỏi (Chỉ dành cho ADMIN)

- **Method:** `DELETE`
- **Endpoint:** `/api/v1/questions/{id}`
- **Header:**
  - `Authorization: Bearer <JWT>`
- **Path Variable:**
  - `id` (Integer): ID câu hỏi cần xóa

- **Response:**
  - ✅ `200 OK`: `"DELETED QUESTION SUCCESSFULLY"`
  - ⛔ `403 Forbidden`: Không phải ADMIN → `"NOT ALLOWED"`
  - 🔒 `401 Unauthorized`: Token không hợp lệ → `"UNAUTHORIZED"`
