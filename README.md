# 🎯  Thi Trắc Nghiệm Trực Tuyến - Microservices

Thiết kế dựa trên kiến trúc Microservices nhằm đảm bảo tính mở rộng, độ tin cậy cao, và khả năng duy trì tính nhất quán trong quá trình xử lý nghiệp vụ — đặc biệt là trong quy trình tạo và quản lý bài thi.

Mỗi dịch vụ độc lập chịu trách nhiệm cho một chức năng cụ thể, giao tiếp thông qua API và triển khai độc lập, giúp hệ thống linh hoạt trong quá trình phát triển và vận hành ở quy mô lớn.

## 📦 Cấu trúc Dự án

```text
docs/
├── api-specs/                    # Định nghĩa API theo chuẩn OpenAPI (Swagger)
│   ├── service-answer.yaml
│   ├── service-question.yaml
│   ├── service-quizz.yaml
│   ├── service-result.yaml
│   └── service-user.yaml
├── analysis-and-design.md        # Phân tích và thiết kế hệ thống
├── architecture.md               # Kiến trúc tổng quan hệ thống

services/
├── service-user/         # Quản lý người dùng (đăng ký, đăng nhập, phân quyền)
├── service-question/     # Quản lý ngân hàng câu hỏi trắc nghiệm
├── service-answer/       # Xử lý câu trả lời từ người dùng
├── service-quizz/        # Tạo và cấu hình đề thi (quiz) từ danh sách câu hỏi
├── service-result/       # Nhận và xử lý kết quả thi

gateway/                          # API Gateway định tuyến request từ client

scripts/                          # Chứa các script tiện ích (nếu có)

docker-compose.yml                # Cấu hình các service Docker

.env.example                      # File cấu hình biến môi trường mẫu
README.md                         # Hướng dẫn sử dụng và mô tả dự án
```
## ✅ Quy trình Thi Trắc Nghiệm Trực Tuyến
Hệ thống thi trắc nghiệm trực tuyến được xây dựng theo kiến trúc Microservices, đảm bảo khả năng mở rộng, dễ bảo trì và có tính phân tách cao giữa các chức năng.

1. 🎯 Đăng nhập & Xác thực
- Người dùng truy cập hệ thống và thực hiện đăng nhập.
- `service-user` kiểm tra thông tin xác thực.
    + Nếu hợp lệ, hệ thống trả về **JWT Token**.
    + Token được gửi kèm trong tất cả các request tiếp theo để xác minh người dùng và quyền truy cập.

2. 📝 Chọn đề thi
- Người dùng yêu cầu danh sách đề thi.
- `service-quizz` trả về danh sách đề đang mở:
    + `title`: Tên đề thi
    + `duration`: Thời gian làm bài
    + `questionCount`: Số câu hỏi

3. 🚀 Bắt đầu làm bài
- Người dùng chọn một đề thi để bắt đầu.
- Hệ thống thực hiện:
    + Gọi `service-question` để lấy danh sách câu hỏi.
    + Tạo bản ghi thi mới trong `service-result`.
    + Khóa đề thi để giữ nguyên cấu trúc câu hỏi trong suốt thời gian làm bài.

4. ✍️ Trả lời câu hỏi
- Người dùng gửi câu trả lời:
    + Theo từng câu hỏi hoặc toàn bộ một lần.
- `service-answer` tiếp nhận, lưu trữ và xử lý:
    + Chấm điểm tự động (nếu đề hỗ trợ).
    + Lưu dữ liệu tạm để phòng trường hợp mất kết nối.

5. 📤 Nộp bài
- Người dùng nhấn "Nộp bài".
- Hệ thống:
    + Ghi nhận kết quả chính thức vào `service-result`.
    + Trả kết quả ngay hoặc chờ đánh giá thủ công (tùy cấu hình đề).

6. 📊 Xem kết quả & Thống kê
- Người dùng có thể xem lại:
    + Điểm số tổng.
    + Kết quả từng câu.
    + Thời gian làm bài.

🔒 Bảo mật & Kiểm soát truy cập
- Tất cả các API yêu cầu JWT Token hợp lệ.
- Kiểm tra `role` (USER/ADMIN) trước khi thực hiện các hành động đặc biệt (ví dụ tạo đề, xoá câu hỏi).
## 🧠 Mô tả Các Service
| Service          | Mô tả chức năng chính                                     |
|------------------|-----------------------------------------------------------|
| service-user     | Quản lý người dùng và xác thực JWT                        |
| service-quizz    | Quản lý đề thi                                            |
| service-question | Quản lý ngân hàng câu hỏi                                 |
| service-answer   | Ghi nhận và chấm điểm câu trả lời                         |
| service-result   | Lưu kết quả thi, thống kê kết quả  

---

## ⚙️ Hướng Dẫn Chạy Dự án

### 1. Clone Repository

```bash
git clone https://github.com/jnp2018/mid-project-499475439.git
cd mid-project-499475439.git
```

### 2. Tạo File `.env`

```bash
cp .env.example .env
```

Thay đổi các giá trị nếu cần thiết.

### 3. Khởi chạy bằng Docker Compose

```bash
docker-compose up --build
```

### 4. Theo dõi log của các service

```bash
docker-compose logs -f service-user
docker-compose logs -f service-question
...
```

---

## 📌 Ví dụ `.env.example`

```env
DB_HOST=localhost
DB_PORT=5432
```

---

## 📊 Tài liệu API

Các API được định nghĩa theo định dạng OpenAPI (Swagger) trong thư mục:

```
docs/api-specs/
├── service-user.yaml
├── service-question.yaml
├── service-quizz.yaml
├── service-result.yaml
...
```

👈 Có thể xem tại: [https://editor.swagger.io](https://editor.swagger.io)

---

## 👥 Thành viên Nhóm

| Họ tên       | Vai trò                 | Đóng góp chính                                                |
| ------------ | ----------------------- | ------------------------------------------------------------- |
| Nguyễn Thành Long B21DCCN499 | Backend Developer       | Xây dựng `service-question`, `service-answer`, Triển khai Docker Compose cho toàn bộ hệ thống |
| Đào Tùng Lâm B21DCCN475  | Backend Developer       | Xây dựng `service-user`, `service-quizz`, Thiết lập và tích hợp API Gateway (route, JWT filter), Phân quyền bảo mật nâng cao theo vai trò (USER/ADMIN)|
| Phạm Quang Huy B21DCCN439    | Backend Developer  | Xây dựng `service-result`, Viết tài liệu kiến trúc hệ thống, mô hình dữ liệu và luồng xử lý |

---

## 🧪 Ghi chú Phát triển
* Hệ thống áp dụng kiến trúc **Microservices**, giao tiếp thông qua **REST API** kết hợp xác thực bằng **JWT** tại API Gateway.
* Các service độc lập, container hóa và kết nối qua **Docker Compose** sử dụng internal network.
* **JWT filter** tại API Gateway kiểm tra `token`, giải mã `role`, phân quyền truy cập từng API.
* Các service giao tiếp trực tiếp với nhau thông qua **REST API**.
* Các lỗi sẽ được xử lý đồng bộ tại các service tương ứng, với khả năng rollback và ghi nhận lỗi rõ ràng.
  * Nếu lỗi xảy ra trong `service-question`, người dùng không thể tiếp tục làm bài cho đến khi lỗi được xử lý.
  * Nếu lỗi xảy ra trong `service-result`, bài thi sẽ bị hủy và không ghi nhận kết quả.
* **Chấm điểm tự động** được tích hợp tại `service-answer`, đảm bảo phản hồi nhanh và lưu kết quả tạm thời trong quá trình làm bài.
* Các thông tin liên quan đến đề thi và kết quả bài thi được lưu trữ tách biệt, giúp dễ dàng mở rộng và bảo trì hệ thống trong tương lai.
---

## ✅ Checklist Nộp Bài

* [x] Mỗi service có `Dockerfile` riêng
* [x] Hoàn thiện Phân tích và thiết kế hệ thống trong tệp `analysis-and-design.md`
* [x] Định nghĩa tất cả các API bằng OpenAPI YAML trong thư mục `docs/api-specs/`
* [x] `README.md` chi tiết, rõ ràng
* [x] Các dịch vụ giao tiếp với nhau nội bộ thông qua tên dịch vụ (Docker Compose sẽ xử lý kết nối mạng).

---

## 📌 Một số lệnh hữu ích

```bash
DOCKER_BUILDKIT=0 docker-compose up --build -d

docker-compose logs -f service-user
docker-compose logs -f service-question
docker-compose logs -f service-quizz
docker-compose logs -f service-answer
docker-compose logs -f service-result
```

---

## 👨‍🏫 Giảng viên Hướng dẫn

Template ban đầu được cung cấp bởi **Thầy Hùng Đặng**

* 📧 Email: [hungdn@ptit.edu.vn](mailto:hungdn@ptit.edu.vn)
* 🐙 GitHub: [@hungdn1701](https://github.com/hungdn1701)

---
