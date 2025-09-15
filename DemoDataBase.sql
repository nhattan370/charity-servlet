DROP DATABASE IF EXISTS charity_servlet;
CREATE DATABASE charity_servlet;
USE charity_servlet;
CREATE TABLE role (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE user (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    email VARCHAR(255),
    full_name VARCHAR(255),
    note VARCHAR(255),
    password VARCHAR(128),
    phone_number VARCHAR(255),
    status INT(11),
    user_name VARCHAR(255),
    created VARCHAR(255),
    role_id INT(11),
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE donation (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255),
    created VARCHAR(255),
    description VARCHAR(255),
    end_date VARCHAR(255),
    money INT(11),
    name VARCHAR(255),
    organization_name VARCHAR(255),
    phone_number VARCHAR(255),
    start_date VARCHAR(255),
    status INT(11)
);

CREATE TABLE user_donation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created DATETIME DEFAULT CURRENT_TIMESTAMP,
    money INT(11) NOT NULL,
    name VARCHAR(255),                 -- tên người quyên góp
    status TINYINT DEFAULT 1,          -- 1 = active, 0 = pending, ...
    text TEXT,                         -- lời nhắn
    donation_id INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_user_donation_donation 
        FOREIGN KEY (donation_id) REFERENCES donation(id),
    CONSTRAINT fk_user_donation_user 
        FOREIGN KEY (user_id) REFERENCES user(id)
);
	
-- Insert into role
INSERT INTO role (role_name) VALUES
('Admin'),
('User');

-- Insert into user
INSERT INTO user (address, email, full_name, note, password, phone_number, status, user_name, created, role_id) VALUES
('Hà Nội - Ba Đình', 'an.nguyen@mail.com', 'Nguyễn Văn An', 'Note 1', 'pass123', '0901111111', 1, 'annguyen', '2025-01-01', 1),
('Hà Nội - Cầu Giấy', 'bich.tran@mail.com', 'Trần Thị Bích', 'Note 2', 'pass123', '0901111112', 1, 'btran', '2025-01-02', 2),
('TP. HCM - Quận 1', 'cuong.le@mail.com', 'Lê Văn Cường', 'Note 3', 'pass123', '0901111113', 1, 'lcuong', '2025-01-03', 2),
('Đà Nẵng - Hải Châu', 'dung.pham@mail.com', 'Phạm Thị Dung', 'Note 4', 'pass123', '0901111114', 1, 'pdung', '2025-01-04', 2),
('Hải Phòng - Lê Chân', 'e.nguyen@mail.com', 'Nguyễn Văn Em', 'Note 5', 'pass123', '0901111115', 1, 'emnguyen', '2025-01-05', 2),
('Hà Nội - Hoàn Kiếm', 'f.tran@mail.com', 'Trần Thị Phương', 'Note 6', 'pass123', '0901111116', 1, 'ptran', '2025-01-06', 2),
('TP. HCM - Bình Thạnh', 'giang.le@mail.com', 'Lê Văn Giang', 'Note 7', 'pass123', '0901111117', 1, 'lgiang', '2025-01-07', 2),
('Đà Nẵng - Thanh Khê', 'h.pham@mail.com', 'Phạm Thị Hoa', 'Note 8', 'pass123', '0901111118', 1, 'hpham', '2025-01-08', 2),
('Hải Phòng - Ngô Quyền', 'i.nguyen@mail.com', 'Nguyễn Văn Ích', 'Note 9', 'pass123', '0901111119', 1, 'inguyen', '2025-01-09', 2),
('Hà Nội - Thanh Xuân', 'j.tran@mail.com', 'Trần Thị Lan', 'Note 10', 'pass123', '0901111120', 1, 'lantran', '2025-01-10', 2);


-- Insert into donation (19 records)
INSERT INTO donation (code, start_date, name, end_date, money, description, organization_name, phone_number, created, status) VALUES
('D001','2025-01-01','Ủng hộ miền Trung lũ lụt','2025-02-01',10000000,'Kêu gọi đồng bào cả nước chung tay hỗ trợ bà con miền Trung bị ảnh hưởng bởi lũ','Hội Chữ thập đỏ Việt Nam','0902000001','2025-01-05',1),
('D002','2025-01-02','Quỹ học bổng cho trẻ em nghèo','2025-02-02',20000000,'Hỗ trợ học phí và dụng cụ học tập cho học sinh khó khăn','Quỹ Khuyến học Việt Nam','0902000002','2025-01-06',2),
('D003','2025-01-03','Chung tay chống dịch Covid-19','2025-02-03',30000000,'Quyên góp mua trang thiết bị y tế, khẩu trang, nước sát khuẩn','Mặt trận Tổ quốc Việt Nam','0902000003','2025-01-07',2),
('D004','2025-01-04','Ủng hộ bệnh nhi ung thư','2025-02-04',40000000,'Gây quỹ giúp các em nhỏ đang điều trị ung thư tại bệnh viện K','Quỹ Ngày mai tươi sáng','0902000004','2025-01-08',4),
('D005','2025-01-05','Xây cầu nông thôn','2025-02-05',50000000,'Đóng góp xây dựng cầu dân sinh cho các vùng sâu vùng xa','Tổ chức Thiện nguyện Xanh','0902000005','2025-01-09',3),
('D006','2025-01-06','Hỗ trợ người vô gia cư mùa đông','2025-02-06',60000000,'Quyên góp chăn ấm, quần áo, thức ăn cho người vô gia cư','Nhóm Ánh Sáng','0902000006','2025-01-10',4),
('D007','2025-01-07','Tiếp sức mùa thi 2025','2025-02-07',70000000,'Hỗ trợ chỗ ở, nước uống, xe miễn phí cho sĩ tử đi thi','Đoàn Thanh niên Việt Nam','0902000007','2025-01-11',4),
('D008','2025-01-08','Hiến máu nhân đạo','2025-02-08',80000000,'Kêu gọi người dân tham gia hiến máu cứu người','Viện Huyết học - Truyền máu TW','0902000008','2025-01-12',3),
('D009','2025-01-09','Cứu trợ đồng bào bị hạn mặn','2025-02-09',90000000,'Giúp người dân Đồng bằng sông Cửu Long chống hạn, xâm nhập mặn','Tổ chức Nước sạch Việt Nam','0902000009','2025-01-13',1),
('D010','2025-01-10','Gây quỹ phẫu thuật nụ cười','2025-02-10',100000000,'Tài trợ phẫu thuật cho trẻ em bị sứt môi, hở hàm ếch','Operation Smile Việt Nam','0902000010','2025-01-14',2),
('D011','2025-01-11','Ủng hộ chiến sĩ biển đảo','2025-02-11',110000000,'Đóng góp nhu yếu phẩm, quần áo ấm và thiết bị cho chiến sĩ Trường Sa','Quỹ Vì Biển đảo Việt Nam','0902000011','2025-01-15',1),
('D012','2025-01-12','Bữa cơm cho em','2025-02-12',120000000,'Cung cấp suất ăn miễn phí cho học sinh nghèo miền núi','Tổ chức Trẻ em Hạnh phúc','0902000012','2025-01-16',1),
('D013','2025-01-13','Chung tay bảo vệ rừng','2025-02-13',130000000,'Gây quỹ trồng cây, phục hồi rừng đầu nguồn','GreenViet','0902000013','2025-01-17',3),
('D014','2025-01-14','Tiếp sức đồng bào lũ quét Tây Bắc','2025-02-14',140000000,'Hỗ trợ lương thực, nhu yếu phẩm cho bà con vùng núi bị lũ quét','Hội Từ thiện Nhân Ái','0902000014','2025-01-18',4),
('D015','2025-01-15','Quỹ hỗ trợ bệnh nhân nghèo','2025-02-15',150000000,'Giúp đỡ chi phí điều trị cho bệnh nhân có hoàn cảnh khó khăn','Hội Bảo trợ bệnh nhân nghèo Việt Nam','0902000015','2025-01-19',2),
('D016','2025-01-16','Mái ấm cho em','2025-02-16',160000000,'Xây dựng nhà tình thương cho trẻ em mồ côi','Tổ chức Trái tim Nhân hậu','0902000016','2025-01-20',1),
('D017','2025-01-17','Áo ấm mùa đông','2025-02-17',170000000,'Tặng áo ấm, giày dép cho học sinh vùng cao','Nhóm Thiện nguyện Hà Nội','0902000017','2025-01-21',3),
('D018','2025-01-18','Nước sạch cho bản làng','2025-02-18',180000000,'Đào giếng, xây hệ thống lọc nước sạch cho người dân miền núi','Quỹ Nước sạch & Môi trường','0902000018','2025-01-22',2),
('D019','2025-01-19','Cứu trợ động vật hoang dã','2025-02-19',190000000,'Hỗ trợ trung tâm bảo tồn, cứu hộ động vật quý hiếm','Wildlife at Risk (WAR)','0902000019','2025-01-23',4);

-- Insert into user_donation (17 records)
INSERT INTO user_donation (money, name, status, text, donation_id, user_id) VALUES
(500,'Ủng hộ 1',1,'Ủng hộ xây cầu nông thôn',3,1),
(600,'Ủng hộ 2',1,'Ủng hộ đồng bào miền Trung',1,2);
-- (700,'Ủng hộ 3',1,'Ủng hộ bệnh nhi ung thư',4,5),
(800,'Ủng hộ 4',1,'Ủng hộ học bổng học sinh nghèo',2,3),  
(900,'Ủng hộ 5',1,'Ủng hộ chiến sĩ Trường Sa',11,6),
(1000,'Ủng hộ 6',1,'Ủng hộ nước sạch miền núi',18,4),
(1100,'Ủng hộ 7',1,'Ủng hộ trẻ em mồ côi',16,7),
(1200,'Ủng hộ 8',1,'Ủng hộ phẫu thuật nụ cười',10,2),
(1300,'Ủng hộ 9',1,'Ủng hộ cứu trợ lũ quét Tây Bắc',14,8),
(1400,'Ủng hộ 10',1,'Ủng hộ áo ấm mùa đông',17,9),
(1500,'Ủng hộ 11',1,'Ủng hộ hiến máu nhân đạo',8,1),
(1600,'Ủng hộ 12',1,'Ủng hộ bệnh nhân nghèo',15,3),
(1700,'Ủng hộ 13',1,'Ủng hộ người vô gia cư',6,5),
(1800,'Ủng hộ 14',1,'Ủng hộ chống dịch Covid-19',3,10),
(1900,'Ủng hộ 15',1,'Ủng hộ cứu trợ hạn mặn',9,4),
(2000,'Ủng hộ 16',1,'Ủng hộ bảo vệ động vật hoang dã',19,7),
(2100,'Ủng hộ 17',1,'Ủng hộ tiếp sức mùa thi',7,6);

-- SELECT * FROM donation;
-- SELECT * FROM user_donation;  