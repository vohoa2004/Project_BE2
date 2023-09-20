-- Trigger tự động sinh mã User cho Librarian
DELIMITER //
CREATE TRIGGER Before_Insert_Librarian
BEFORE INSERT ON Librarian FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(LibrarianId, 2), SIGNED)), 0) + 1 FROM Librarian);
    SET NEW.LibrarianId = CONCAT('L', LPAD(new_id, 4, '0'));
END;
//
DELIMITER ;

-- Trigger tự động sinh mã User cho Reader
DELIMITER //
CREATE TRIGGER Before_Insert_Reader
BEFORE INSERT ON Reader FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(ReaderId, 2), SIGNED)), 0) + 1 FROM Reader);
    SET NEW.ReaderId = CONCAT('R', LPAD(new_id, 4, '0'));
END;
//
DELIMITER ;

-- Tạo trigger sau khi chèn dữ liệu vào bảng issuebook
DELIMITER //
CREATE TRIGGER update_returned_book
BEFORE UPDATE ON issuebook
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu status là FALSE (đã trả sách)
    IF NEW.Status = FALSE THEN
        -- Cập nhật ngày trả (Return_date) thành ngày hiện tại
        SET NEW.Return_date = CURDATE();
    END IF;
END;
//
DELIMITER ;

DROP TRIGGER update_returned_book;