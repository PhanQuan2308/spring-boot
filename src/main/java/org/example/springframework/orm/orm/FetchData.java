package org.example.springframework.orm.orm;

// Cascade Type: - xác định những hành động nào (như lưu, xóa, cập nhật) được thực hiện trên một thực thể cha cũng sẽ được tự động thực hiện trên các thực thể con liên quan.
//               - CascadeType.PERSIST: luu
//               - CascadeType.MERGE: hop nhat
//
// Fetch Data:   - Xac dinh thoi diem du lieu duoc tai tu co so du lieu:
//                 + FetchType.LAZY: Chi hanh dong khi no duoc truy cap
//                 + FetchType.EAGER: Thực thể liên quan sẽ được tải ngay lập tức khi thực thể cha được truy vấn.
//
//Dùng FetchType.LAZY khi dữ liệu liên quan không luôn cần truy cập, giúp tối ưu hóa hiệu suất.
//Dùng FetchType.EAGER khi dữ liệu liên quan luôn cần thiết khi tải thực thể cha, thường dùng cho quan hệ một-một hoặc nhiều-một.
//
//
//
//




public class FetchData {
}
