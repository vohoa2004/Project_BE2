# Project_BE2_LibraryManagement
HỆ THỐNG QUẢN LÝ THƯ VIỆN

## 1.	Giới thiệu:
-	Hệ thống quản lý thư viện trực tuyến là một khái niệm không quá xe lạ cho đối với mọi người nhất là học sinh, sinh viên. Hệ thống sẽ quản lý các tài nguyên của thư viện như thông tin sách, thông tin người đọc, thông tin thủ thư.

## 2.	Các tính năng chính của hệ thống quản lý thư viện:
Hệ thống sẽ được chia ra làm 2 luồng người dùng

### a.	Người đọc (Reader):
1.	Xem thông tin cá nhân:
-	Người đọc có thể xem thông tin cá nhân của bản thân bao gồm ID, UserID, tên, email, số điện thoại, giới tính.

2.	Cập nhật thông tin cá nhân:
-	Người dùng có thể cập nhật mật khẩu (nếu muốn)
-	Người dùng có thể cập nhật lại tên, giới thiệu, email, số điện thoại.

3.	Tìm kiếm sách bằng tên sách:
-	Người đọc có thể tìm kiếm sách theo tựa sách bằng cách nhập tên sách
-	 Kết quả tìm kiếm sẽ hiển thị danh sách các sách có tựa sách chứa từ khóa, bao gồm ID, tên sách, tác giả, giá thành, thể loại, số lượng, số nhày được mượn quyển sách đó.

4.	Tìm kiếm sách bằng tên tác giả:
-	Người đọc có thể tìm kiếm sách theo tên tác giả bằng cách nhập tên sách
-	 Kết quả tìm kiếm sẽ hiển thị danh sách các sách có tựa sách chứa từ khóa, bao gồm ID, tên sách, tác giả, giá thành, thể loại, số lượng, số người được mượn quyển sách đó.

5.	Mượn sách:
-	Nhập ID của quyển sách muốn mượn.
-	Nhập số lượng sách muốn mượn
-	Sách sẽ được hiển thị ở chế độ “Borrowing” trong danh sách sách đã mượn.

6.	Xem danh sách sách đã và đang mượn:
-	Sẽ hiển thị danh sách các quyển sách đã và đang mượn bao gồm TransactionsID, Giá thành, ngày mượn sách, trả sách, tiền phạt (khi trả trễ ngày), ReaderID, số lượng sách đã mượn, tình trạng mượn và BookID.

7.	Trả sách:
-	Người dùng nhập TransactionID muốn trả sách.
-	Tình trạng mượn sách sẽ được cập nhật.

8.	Đăng xuất:
-	Đăng xuất khỏi hệ thống.

### b.	Thủ thư (Librarian):
1.	Xem thông tin cá nhân:
-	Người đọc có thể xem thông tin cá nhân của bản thân bao gồm ID, UserID, tên, email, số điện thoại, giới tính.

2.	Cập nhật thông tin cá nhân:
-	Người dùng có thể cập nhật mật khẩu (nếu muốn)
-	Người dùng có thể cập nhật lại tên, giới thiệu, email, số điện thoại.

3.	Quản lí sách:
-	Trong mục quản lý sách thủ thư có thể:
o	Thêm đầu sách mới:
	Thủ thư sẽ nhập tên sách, tác giả, giá tiền, thể loại, số lượng sách, số ngày được mượn.
o	Tìm kiếm sách bằng tên sách:
	Người đọc có thể tìm kiếm sách theo tựa sách bằng cách nhập tên sách
	 Kết quả tìm kiếm sẽ hiển thị danh sách các sách có tựa sách chứa từ khóa, bao gồm ID, tên sách, tác giả, giá thành, thể loại, số lượng, số ngày được mượn quyển sách đó.

o	Tìm kiếm sách bằng tên tác giả:
	Thủ thư có thể tìm kiếm sách theo tên tác giả bằng cách nhập tên sách
	 Kết quả tìm kiếm sẽ hiển thị danh sách các sách có tựa sách chứa từ khóa, bao gồm ID, tên sách, tác giả, giá thành, thể loại, số lượng, số ngày được mượn quyển sách đó.
o	Cập nhật thông tin sách:
	Nhập ID sách thủ thư muốn cập nhập.
	Nhập lần lượt tên sách, tác giả, giá thành, thể loại, số ngày được mượn sách.
o	Xem danh sách sách:
	Sẽ hiển thị danh sách các quyển sách bao gồm thông tin ID, tựa sách, tên tác giả, giá thành, thể loại, số lượng, số ngày được mượn sách.

4.	Quản lí danh sách người đọc:
-	Trong mục quản lý người đọc thủ thư có thể:
o	Thêm người đọc mới:
	Đăng kí cho người dùng tên đăng nhập
	Sau đó nhập các thông tin: tên, giới tính, email, số điện thoại.
o	Tìm kiếm người đọc bằng ID:
	Nhập ID người đọc 
	Kết quả sẽ in ra ID, UserID, tên, email, số điện thoại, giới tính.
o	Hiển thị danh sách người đọc:
	Hiển thị danh sách người đọc bao gồm thông tin ID, UserID, tên, email, số điện thoại, giới tính.

5.	Quản lí giao dịch:
-	Thủ thư có thể tạo ra các giao dịch:
o	Mượn sách giùm người đọc: 
	Thay vì người đọc lên hệ thống để mượn thì có thẻ thông qua thủ thư để làm việc này.
	Nhập ID sách mà người đọc muốn mượn.
	Nhập ID của người đọc và số lượng muốn mượn.
o	Xem hết tất cả các giao dịch sách:
	Hiển thị danh sách các giao dịch bao gồm thông tin: TransactionID, giá thành, ngày mượn và trả sách, tiền phạt, ReaderID, số lượng, tình trạng mượn sách và bookID.

o	Tìm các giao dịch đã thực hiện thông qua Reader ID:
	Nhập ReaderID
	Hiển thị các giao dịch đã được thực hiện

o	Trả sách giùm người đọc:
	Nhập TransactionID và tình trạng sách sẽ được cập nhật

6.	Quản lí những thủ thư khác(công việc của thủ thư trưởng):
o	Thêm thông tin những thủ thư mới:
o	Thêm đầu sách mới:
	Thủ thư trưởng sẽ nhập tên đăng nhập, tên, giới tính, email, số điện thoại, lương.
o	Xem danh sách sách:
	Sẽ hiển thị danh sách các quyển sách bao gồm thông tin ID, tên, địa chỉ email, số điện thoại, giới tính, lương.
o	Tìm các giao dịch đã thực hiện thông qua Reader ID:
	Nhập LibrarianID
	Hiển thị các thông tin của người thủ thư được tìm kiếm.
o	Cập nhật lương của thủ thư:
	Nhập ID thủ thư muốn cập nhập lương.
	Nhập lương cần thay đổi.
7.	Đăng xuất:
-	Đăng xuất khỏi hệ thống.

## 3.	Các ứng dụng đã sử dụng:
-	NetBeans: môi trường làm việc sử dụng ngôn ngữ java.
-	MySQL: Thiết lập Cơ sở dữ liệu
-	JDBC: Kết nối cơ sở dữ liệu với Netbeans
-	Git & GitHub: Kiểm soát nguồn

 
