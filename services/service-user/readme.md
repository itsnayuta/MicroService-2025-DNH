# User Service API Endpoints

## Base URL: /api/v1/users

### 1. Đăng nhập (Login)

- **Method:** POST
- **Endpoint:** /api/v1/users/login
- **Request Body:** Đối tượng `UserDTO` dạng JSON, bao gồm các trường:
  - `username` (String): Tên người dùng
  - `password` (String): Mật khẩu người dùng
- **Response:**
  - Nếu đăng nhập thành công, trả về mã trạng thái 200 (OK) và một JSON chứa:
    - `token` (String): Token JWT để truy cập các API khác.
  - Nếu thất bại, trả về mã trạng thái 401 (Unauthorized) và một JSON chứa:
    - `error` (String): Mô tả lỗi, ví dụ "Invalid username or password"

---

### 2. Lấy thông tin người dùng hiện tại

- **Method:** GET
- **Endpoint:** /api/v1/users/me
- **Response:**
  - Nếu token hợp lệ và người dùng tồn tại, trả về mã trạng thái 200 (OK) và một JSON chứa thông tin người dùng:
    - `username` (String): Tên người dùng
    - `email` (String): Địa chỉ email
    - `role` (String): Vai trò người dùng
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED"
  - Nếu người dùng không tồn tại, trả về mã trạng thái 404 (Not Found) với thông báo "NOT FOUND USER"

---

### 3. Đăng ký người dùng (Chỉ dành cho admin)

- **Method:** POST
- **Endpoint:** /api/v1/users/register
- **Request Body:** Đối tượng `UserDTO` dạng JSON, bao gồm các trường:
  - `username` (String): Tên người dùng
  - `password` (String): Mật khẩu người dùng
  - `email` (String): Địa chỉ email người dùng
  - `role` (String): Vai trò người dùng (ADMIN/USER)
- **Response:**
  - Nếu yêu cầu hợp lệ và người dùng có vai trò `ADMIN`, trả về mã trạng thái 201 (Created) và thông tin người dùng mới tạo dưới dạng JSON.
  - Nếu token không hợp lệ hoặc người dùng không phải `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED"

---

### 4. Lấy danh sách tất cả người dùng (Chỉ dành cho admin)

- **Method:** GET
- **Endpoint:** /api/v1/users
- **Response:**
  - Nếu yêu cầu hợp lệ và người dùng có vai trò `ADMIN`, trả về mã trạng thái 200 (OK) và danh sách người dùng dưới dạng JSON.
  - Nếu token không hợp lệ hoặc người dùng không phải `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED"

---

### 5. Xóa người dùng (Chỉ dành cho admin)

- **Method:** DELETE
- **Endpoint:** /api/v1/users/{username}
- **Path Variable:**
  - `username` (String): Tên người dùng cần xóa
- **Response:**
  - Nếu người dùng có vai trò `ADMIN` và xóa thành công, trả về mã trạng thái 200 (OK) và thông báo "DELETED USER SUCCESSFULLY".
  - Nếu người dùng không phải `ADMIN`, trả về mã trạng thái 403 (Forbidden) với thông báo "NOT ALLOW".
  - Nếu người dùng không tồn tại, trả về mã trạng thái 404 (Not Found) với thông báo "USER NOT FOUND".
  - Nếu token không hợp lệ, trả về mã trạng thái 401 (Unauthorized) với thông báo "UNAUTHORIZED"
