GO
CREATE DATABASE QLTiemThuoc
ON PRIMARY
	(NAME = 'QLTiemThuoc_data',
	FILENAME = N'D:\QLTiemThuoc.mdf',
	SIZE = 8192KB,
	MAXSIZE = UNLIMITED,
	FILEGROWTH = 1024KB)
LOG ON
	(NAME = 'QLTiemThuoc_log',
	FILENAME = N'D:\QLTiemThuoc.ldf',
	SIZE = 2048KB,
	MAXSIZE = 2048GB,
	FILEGROWTH = 1024KB)
GO
USE [QLTiemThuoc]
GO
/****** Object:  Table [HoaDonBanThuoc]    Script Date: 7/11/2020 5:55:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [HoaDonBanThuoc](
	[maHoaDon] [nvarchar](10) NOT NULL,
	[maKH] [nvarchar](10) NOT NULL,
	[hoTenKH] [nvarchar](30) NULL,
	[ngaySinhKH] [date] NULL,
	[gioiTinhKH] [bit] NULL,
	[diaChiKH] [nvarchar](50) NULL,
	[maNV] [nvarchar](10) NOT NULL,
	[hoTenNV] [nvarchar](30) NULL,
	[maThuoc] [nvarchar](10) NOT NULL,
	[tenThuoc] [nvarchar](50) NULL,
	[donViTinh] [nvarchar](10) NULL,
	[soLuong] [int] NULL,
	[ngayLap] [date] NULL,
	[thanhTien] [real] NULL,
 CONSTRAINT [PK_maHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [KhachHang]    Script Date: 7/11/2020 5:55:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [KhachHang](
	[maKH] [nvarchar](10) NOT NULL,
	[hoTenKH] [nvarchar](30) NULL,
	[ngaySinhKH] [date] NULL,
	[gioiTinhKH] [bit] NULL,
	[diaChiKH] [nvarchar](50) NULL,
 CONSTRAINT [PK_maKH] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [NhanVien]    Script Date: 7/11/2020 5:55:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [NhanVien](
	[maNV] [nvarchar](10) NOT NULL,
	[hoTenNV] [nvarchar](30) NULL,
	[ngaySinhNV] [date] NULL,
	[gioiTinhNV] [bit] NULL,
	[diaChiNV] [nvarchar](50) NULL,
	[SDTNV] [nvarchar](13) NULL,
	[CMND] [nvarchar](10) NULL,
 CONSTRAINT [PK_maNV] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Thuoc]    Script Date: 7/11/2020 5:55:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Thuoc](
	[maThuoc] [nvarchar](10) NOT NULL,
	[tenThuoc] [nvarchar](50) NULL,
	[nhaCungCap] [nvarchar](30) NULL,
	[giaThuoc] [real] NULL,
	[congDung] [nvarchar](100) NULL,
	[soLuong] [int] NULL,
	[donViTinh] [nvarchar](10) NULL,
	[ngaySanXuat] [date] NULL,
	[ngayHetHan] [date] NULL,
 CONSTRAINT [PK_maThuoc] PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD001', N'KH01', N'Nguyễn Thanh Trúc', CAST(N'1998-06-15' AS Date), 0, N'T7/96', N'N04', N'Ngô Phúc Duy', N'K09', N'Verapamil', N'Viên', 10, CAST(N'2020-07-10' AS Date), 250000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD002', N'KH01', N'Nguyễn Thanh Trúc', CAST(N'1998-06-15' AS Date), 0, N'T7/96', N'N04', N'Ngô Phúc Duy', N'K03', N'Senna', N'Tuýp', 2, CAST(N'2020-07-10' AS Date), 20000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD003', N'KH02', N'Nguyễn Xuân Mai', CAST(N'2000-02-07' AS Date), 0, N'k7/59', N'N01', N'Nguyễn Anh Tuấn', N'A02', N'Acid tranexamic', N'Vỉ', 1, CAST(N'2020-07-10' AS Date), 20000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD004', N'KH02', N'Nguyễn Xuân Mai', CAST(N'2000-02-07' AS Date), 0, N'k7/59', N'N01', N'Nguyễn Anh Tuấn', N'A05', N'Amitriptyline', N'Viên', 5, CAST(N'2020-07-10' AS Date), 75000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD005', N'KH02', N'Nguyễn Xuân Mai', CAST(N'2000-02-07' AS Date), 0, N'k7/59', N'N01', N'Nguyễn Anh Tuấn', N'B01', N'Aztreonam', N'Viên', 5, CAST(N'2020-07-10' AS Date), 50000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD006', N'KH04', N'Phan Anh Tuấn', CAST(N'2001-05-05' AS Date), 1, N'V5/56', N'N02', N'Trần Thị Ngọc', N'C10', N'Dexamethasone 1', N'Hộp', 1, CAST(N'2020-07-10' AS Date), 10000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD007', N'KH04', N'Phan Anh Tuấn', CAST(N'2001-05-05' AS Date), 1, N'V5/56', N'N02', N'Trần Thị Ngọc', N'D08', N'Epinephrine', N'Vỉ', 2, CAST(N'2020-07-10' AS Date), 20000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD008', N'KH04', N'Phan Anh Tuấn', CAST(N'2001-05-05' AS Date), 1, N'V5/56', N'N02', N'Trần Thị Ngọc', N'E02', N'Fentanyl', N'Vỉ', 2, CAST(N'2020-07-10' AS Date), 60000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD009', N'KH12', N'Trần Đức Pu', CAST(N'1989-05-03' AS Date), 1, N'Bệnh viện tâm thần', N'N03', N'Phan Thị Thanh Duyên', N'E06', N'Heparin sodium', N'Vỉ', 4, CAST(N'2020-07-10' AS Date), 120000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD010', N'KH03', N'Trần Thanh Tâm', CAST(N'2005-04-29' AS Date), 0, N'N8/23', N'N04', N'Ngô Phúc Duy', N'C04', N'Chlorhexidine', N'Viên', 10, CAST(N'2020-07-10' AS Date), 100000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD011', N'KH03', N'Trần Thanh Tâm', CAST(N'2005-04-29' AS Date), 0, N'N8/23', N'N04', N'Ngô Phúc Duy', N'E06', N'Heparin sodium', N'Tuýp', 1, CAST(N'2020-07-10' AS Date), 30000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD012', N'KH05', N'Lê Minh Hiếu', CAST(N'2002-06-04' AS Date), 1, N'C5/87', N'N05', N'Nguyễn Nhật Minh', N'F05', N'Ivermectin', N'Viên', 3, CAST(N'2020-07-10' AS Date), 45000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD013', N'KH14', N'Nguyễn Văn Anh', CAST(N'1969-12-01' AS Date), 1, N'Số 5 Nguyễn Văn Bảo', N'N03', N'Phan Thị Thanh Duyên', N'A01', N'Acetylsalicylic acid', N'Vỉ', 1, CAST(N'2020-07-10' AS Date), 10000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD014', N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10', N'N05', N'Nguyễn Nhật Minh', N'F07', N'Lamotrigine', N'Vỉ', 1, CAST(N'2020-07-11' AS Date), 20000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD015', N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10', N'N05', N'Nguyễn Nhật Minh', N'H02', N'Miconazole', N'Viên', 4, CAST(N'2020-07-11' AS Date), 140000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD016', N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10', N'N05', N'Nguyễn Nhật Minh', N'H06', N'Natri thiosulfate', N'Viên', 4, CAST(N'2020-07-11' AS Date), 100000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD017', N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10', N'N05', N'Nguyễn Nhật Minh', N'H09', N'Ondansetron', N'Viên', 4, CAST(N'2020-07-11' AS Date), 200000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD018', N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10', N'N05', N'Nguyễn Nhật Minh', N'K10', N'Warfarin', N'Tuýp', 1, CAST(N'2020-07-11' AS Date), 20000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD019', N'KH07', N'Hồ Quý Bửu ', CAST(N'1988-06-03' AS Date), 1, N'A7/15', N'N05', N'Nguyễn Nhật Minh', N'B06', N'Bisoprolol', N'Vỉ', 1, CAST(N'2020-07-11' AS Date), 40000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD020', N'KH07', N'Hồ Quý Bửu ', CAST(N'1988-06-03' AS Date), 1, N'A7/15', N'N05', N'Nguyễn Nhật Minh', N'B05', N'Bisoprolol 1', N'Vỉ', 1, CAST(N'2020-07-11' AS Date), 50000)
INSERT [HoaDonBanThuoc] ([maHoaDon], [maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH], [maNV], [hoTenNV], [maThuoc], [tenThuoc], [donViTinh], [soLuong], [ngayLap], [thanhTien]) VALUES (N'HD021', N'KH07', N'Hồ Quý Bửu ', CAST(N'1988-06-03' AS Date), 1, N'A7/15', N'N05', N'Nguyễn Nhật Minh', N'I09', N'Benzylpenicillin', N'Viên', 7, CAST(N'2020-07-11' AS Date), 175000)
GO
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH01', N'Nguyễn Thanh Trúc', CAST(N'1998-06-15' AS Date), 0, N'T7/96')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH02', N'Nguyễn Xuân Mai', CAST(N'2000-02-07' AS Date), 0, N'k7/59')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH03', N'Trần Thanh Tâm', CAST(N'2005-04-29' AS Date), 0, N'N8/23')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH04', N'Phan Anh Tuấn', CAST(N'2001-05-05' AS Date), 1, N'V5/56')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH05', N'Lê Minh Hiếu', CAST(N'2002-06-04' AS Date), 1, N'C5/87')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH06', N'Đinh Ngọc Nhi', CAST(N'2002-07-08' AS Date), 0, N'M9/10')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH07', N'Hồ Quý Bửu ', CAST(N'1988-06-03' AS Date), 1, N'A7/15')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH08', N'Trương Công Định', CAST(N'1999-06-01' AS Date), 1, N'R8/36')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH09', N'Hàn Duy Long', CAST(N'1990-03-12' AS Date), 1, N'O2/52')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH10', N'Hoàng Thị Mỹ Duyên', CAST(N'2000-09-16' AS Date), 0, N'L6/65')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH11', N'Trần Thái Minh Tân', CAST(N'2000-11-04' AS Date), 1, N'254/33 DQH, F5, GV')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH12', N'Trần Đức Pu', CAST(N'1989-05-03' AS Date), 0, N'Bệnh viện tâm thần')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH13', N'Lê Minh Ho', CAST(N'1999-08-03' AS Date), 0, N'Quán chè chửi')
INSERT [KhachHang] ([maKH], [hoTenKH], [ngaySinhKH], [gioiTinhKH], [diaChiKH]) VALUES (N'KH14', N'Nguyễn Văn Anh', CAST(N'1969-12-01' AS Date), 1, N'Số 5 Nguyễn Văn Bảo')
GO
INSERT [NhanVien] ([maNV], [hoTenNV], [ngaySinhNV], [gioiTinhNV], [diaChiNV], [SDTNV], [CMND]) VALUES (N'N01', N'Nguyễn Anh Tuấn', CAST(N'1990-05-10' AS Date), 1, N'D1/34', N'909542581', N'5232312113')
INSERT [NhanVien] ([maNV], [hoTenNV], [ngaySinhNV], [gioiTinhNV], [diaChiNV], [SDTNV], [CMND]) VALUES (N'N02', N'Trần Thị Ngọc', CAST(N'1995-02-25' AS Date), 0, N'F3/89', N'908251632', N'1684894132')
INSERT [NhanVien] ([maNV], [hoTenNV], [ngaySinhNV], [gioiTinhNV], [diaChiNV], [SDTNV], [CMND]) VALUES (N'N03', N'Phan Thị Thanh Duyên', CAST(N'1989-12-30' AS Date), 0, N'G5/56', N'958789545', N'7978441311')
INSERT [NhanVien] ([maNV], [hoTenNV], [ngaySinhNV], [gioiTinhNV], [diaChiNV], [SDTNV], [CMND]) VALUES (N'N04', N'Ngô Phúc Duy', CAST(N'1986-01-01' AS Date), 1, N'B5/54', N'945658763', N'4653563988')
INSERT [NhanVien] ([maNV], [hoTenNV], [ngaySinhNV], [gioiTinhNV], [diaChiNV], [SDTNV], [CMND]) VALUES (N'N05', N'Nguyễn Nhật Minh', CAST(N'1996-02-04' AS Date), 1, N'H5/14', N'965486519', N'7867343123')
GO
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A01', N'Acetylsalicylic acid', N'DHG PHARMA', 10000, N'Thuốc trị đau nhức', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A02', N'Acid tranexamic', N'TRAPACO', 20000, N'Thuốc ảnh hưởng đến đông máu', 50, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A03', N'Albendazole', N'OPC', 30000, N'Thuốc chống giun sán', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A04', N'Amiodarone', N'DHG PHARMA', 15000, N'Thuốc chống loạn nhịp tim', 100, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A05', N'Amitriptyline', N'TRAPACO', 15000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A06', N'Amlodipine', N'OPC', 40000, N'Thuốc chống tăng huyết áp', 50, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A07', N'Amoxicillin', N'DHG PHARMA', 20000, N'Thuốc kháng sinh', 100, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A08', N'Amoxicillin/acid clavulanic', N'DHG PHARMA', 30000, N'Thuốc kháng sinh', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A09', N'Ampicillin', N'OPC', 20000, N'Thuốc kháng sinh', 50, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'A10', N'Axit valproic (natri valproate)', N'OPC', 10000, N'Thuốc chống co giật ', 50, N'Tuýp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B01', N'Aztreonam', N'TRAPACO', 10000, N'Thuốc kháng sinh', 100, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B02', N'Benzathine benzylpenicillin', N'OPC', 20000, N'Thuốc kháng sinh', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B03', N'Benzylpenicillin', N'DHG PHARMA', 30000, N'Thuốc kháng sinh', 50, N'Tuýp', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B04', N'Bisoprolol', N'DHG PHARMA', 30000, N'Thuốc chống tăng huyết áp', 150, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B05', N'Bisoprolol 1', N'OPC', 50000, N'Thuốc chống đau thắt ngực', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B06', N'Bisoprolol 2', N'DHG PHARMA', 40000, N'Thuốc chống loạn nhịp tim', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B07', N'Carbamazepine', N'TRAPACO', 20000, N'Thuốc chống co giật ', 150, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B08', N'Cefalexin', N'OPC', 10000, N'Thuốc kháng sinh', 150, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B09', N'Cefazolin', N'DHG PHARMA', 25000, N'Thuốc kháng sinh', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'B10', N'Cefixime', N'TRAPACO', 50000, N'Thuốc kháng sinh', 50, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C01', N'Cefotaxime', N'OPC', 45000, N'Thuốc kháng sinh', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C02', N'Ceftazidime', N'TRAPACO', 35000, N'Thuốc kháng sinh', 50, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C03', N'Ceftriaxone', N'TRAPACO', 25000, N'Thuốc kháng sinh', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C04', N'Chlorhexidine', N'OPC', 10000, N'Thuốc sát trùng', 100, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C05', N'Cloxacillin', N'DHG PHARMA', 15000, N'Thuốc kháng sinh', 50, N'Tuýp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C06', N'Codeine', N'TRAPACO', 25000, N'Thuốc giảm đau', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C07', N'Cyclizine', N'OPC', 35000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 150, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C08', N'Desmopressin', N'DHG PHARMA', 30000, N'Thuốc ảnh hưởng đến đông máu', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C09', N'Dexamethasone', N'TRAPACO', 50000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'C10', N'Dexamethasone 1', N'OPC', 10000, N'Thuốc chống dị ứng ', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D01', N'Dexamethasone 2', N'DHG PHARMA', 25000, N'Thuốc chống nôn', 100, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D02', N'Diazepam', N'TRAPACO', 35000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 150, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D03', N'Diazepam 1', N'TRAPACO', 25000, N'Thuốc chống co giật ', 50, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D04', N'Digoxin', N'DHG PHARMA', 30000, N'Thuốc chống loạn nhịp tim', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D05', N'Docusate sodium', N'TRAPACO', 15000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D06', N'Enalapril', N'OPC', 35000, N'Thuốc chống tăng huyết áp', 100, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D07', N'Enoxaparin', N'DHG PHARMA', 10000, N'Thuốc ảnh hưởng đến đông máu', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D08', N'Epinephrine', N'TRAPACO', 10000, N'Thuốc chống loạn nhịp tim', 50, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D09', N'Ethinylestradiol/levonorgestrel', N'TRAPACO', 25000, N'Thuốc tránh thai', 100, N'Tuýp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'D10', N'Ethinylestradiol/norethisterone', N'TRAPACO', 35000, N'Thuốc tránh thai', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E01', N'Ethosuximide', N'OPC', 25000, N'Thuốc chống co giật ', 150, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E02', N'Fentanyl', N'OPC', 30000, N'Thuốc giảm đau', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E03', N'Fluoxetine', N'DHG PHARMA', 10000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E04', N'Glyceryl trinitrate', N'TRAPACO', 50000, N'Thuốc chống đau thắt ngực', 150, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E05', N'Haloperidol', N'OPC', 20000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E06', N'Heparin sodium', N'DHG PHARMA', 30000, N'Thuốc ảnh hưởng đến đông máu', 50, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E07', N'Hydralazine', N'TRAPACO', 35000, N'Thuốc chống tăng huyết áp', 150, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E08', N'Hydrochlorothiazide', N'TRAPACO', 15000, N'Thuốc chống tăng huyết áp', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E09', N'Hydrocortisone', N'TRAPACO', 25000, N'Thuốc chống dị ứng ', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'E10', N'Hyoscine butylbromide', N'TRAPACO', 20000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F01', N'Hyoscine hydrobromide', N'OPC', 10000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F02', N'Ibuprofen', N'DHG PHARMA', 20000, N'Thuốc trị đau nhức', 50, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F03', N'Imipenem/cilastatin', N'TRAPACO', 30000, N'Thuốc kháng sinh', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F04', N'Isosorbide dinitrate', N'OPC', 15000, N'Thuốc chống đau thắt ngực', 100, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F05', N'Ivermectin', N'DHG PHARMA', 15000, N'Thuốc chống giun sán', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F06', N'Lactulose', N'TRAPACO', 40000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F07', N'Lamotrigine', N'OPC', 20000, N'Thuốc chống co giật ', 100, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F08', N'Levamisole', N'DHG PHARMA', 30000, N'Thuốc chống giun sán', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F09', N'Levonorgestrel', N'TRAPACO', 20000, N'Thuốc tránh thai', 50, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'F10', N'Lidocaine', N'OPC', 10000, N'Thuốc chống loạn nhịp tim', 50, N'Tuýp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G01', N'Loperamide', N'DHG PHARMA', 10000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G02', N'Loratadin', N'TRAPACO', 20000, N'Thuốc chống dị ứng ', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G03', N'Lorazepam', N'TRAPACO', 30000, N'Thuốc chống co giật ', 50, N'Tuýp', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G04', N'Losartan', N'TRAPACO', 30000, N'Thuốc chống tăng huyết áp', 150, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G05', N'Magie sulfate', N'TRAPACO', 50000, N'Thuốc chống co giật ', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G06', N'Mebendazole', N'OPC', 40000, N'Thuốc chống giun sán', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G07', N'Meropenem', N'DHG PHARMA', 20000, N'Thuốc kháng sinh', 150, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G08', N'Methadone', N'TRAPACO', 10000, N'Thuốc giảm đau', 150, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G09', N'Methyldopa', N'OPC', 25000, N'Thuốc chống tăng huyết áp', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'G10', N'Metoclopramide', N'DHG PHARMA', 50000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 50, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H01', N'Metoclopramide 1', N'DHG PHARMA', 45000, N'Thuốc chống nôn', 100, N'Hộp', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H02', N'Miconazole', N'DHG PHARMA', 35000, N'Thuốc da liễu', 50, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H03', N'Midazolam', N'DHG PHARMA', 25000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H04', N'Midazolam 1', N'TRAPACO', 10000, N'Thuốc chống co giật ', 100, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H05', N'Morphine', N'OPC', 15000, N'Thuốc giảm đau', 50, N'Tuýp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H06', N'Natri thiosulfate', N'DHG PHARMA', 25000, N'Thuốc da liễu', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H07', N'Niclosamide', N'TRAPACO', 35000, N'Thuốc chống giun sán', 150, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H08', N'Ondansetron', N'OPC', 30000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H09', N'Ondansetron 1', N'OPC', 50000, N'Thuốc chống nôn', 50, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'H10', N'Paracetamol', N'TRAPACO', 10000, N'Thuốc trị đau nhức', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I01', N'Phenobarbital', N'OPC', 25000, N'Thuốc chống co giật ', 100, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I02', N'Phenoxymethylpenicillin', N'DHG PHARMA', 35000, N'Thuốc kháng sinh', 150, N'Viên', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I03', N'Phenytoin', N'DHG PHARMA', 25000, N'Thuốc chống co giật ', 50, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I04', N'Phytomenadione', N'OPC', 30000, N'Thuốc ảnh hưởng đến đông máu', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I05', N'Piperacillin/tazobactam', N'DHG PHARMA', 15000, N'Thuốc kháng sinh', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I06', N'Povidone iodine', N'TRAPACO', 35000, N'Thuốc sát trùng', 100, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I07', N'Praziquantel', N'OPC', 10000, N'Thuốc chống giun sán', 50, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I08', N'Prednisolone', N'OPC', 10000, N'Thuốc chống dị ứng ', 50, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I09', N'Procaine benzylpenicillin', N'OPC', 25000, N'Thuốc kháng sinh', 100, N'Tuýp', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'I10', N'Protamine sulfate', N'OPC', 35000, N'Thuốc ảnh hưởng đến đông máu', 150, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K01', N'Pyrantel', N'DHG PHARMA', 25000, N'Thuốc chống giun sán', 150, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K02', N'Selenium sulfide', N'TRAPACO', 30000, N'Thuốc da liễu', 100, N'Vỉ', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K03', N'Senna', N'OPC', 10000, N'Thuốc trị các triệu chứng thông thường trong chăm sóc nhẹ ', 100, N'Viên', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K04', N'Sodium nitroprusside', N'DHG PHARMA', 50000, N'Thuốc chống tăng huyết áp', 150, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K05', N'Spironolactone', N'TRAPACO', 20000, N'Thuốc suy tim', 50, N'Tuýp', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K06', N'Terbinafine', N'OPC', 30000, N'Thuốc da liễu', 50, N'Vỉ', CAST(N'2020-02-20' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K07', N'Ulipristal', N'OPC', 35000, N'Thuốc tránh thai', 150, N'Hộp', CAST(N'2020-10-03' AS Date), CAST(N'2020-10-06' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K08', N'Verapamil', N'OPC', 15000, N'Thuốc chống đau thắt ngực', 100, N'Viên', CAST(N'2020-01-01' AS Date), CAST(N'2020-08-20' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K09', N'Verapamil a', N'OPC', 25000, N'Thuốc chống loạn nhịp tim', 50, N'Vỉ', CAST(N'2020-10-03' AS Date), CAST(N'2020-01-07' AS Date))
INSERT [Thuoc] ([maThuoc], [tenThuoc], [nhaCungCap], [giaThuoc], [congDung], [soLuong], [donViTinh], [ngaySanXuat], [ngayHetHan]) VALUES (N'K10', N'Warfarin', N'DHG PHARMA', 20000, N'Thuốc ảnh hưởng đến đông máu', 100, N'Hộp', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-07' AS Date))
GO
ALTER TABLE [HoaDonBanThuoc]  WITH CHECK ADD  CONSTRAINT [Fk_maKH] FOREIGN KEY([maKH])
REFERENCES [KhachHang] ([maKH])
GO
ALTER TABLE [HoaDonBanThuoc] CHECK CONSTRAINT [Fk_maKH]
GO
ALTER TABLE [HoaDonBanThuoc]  WITH CHECK ADD  CONSTRAINT [Fk_maNV] FOREIGN KEY([maNV])
REFERENCES [NhanVien] ([maNV])
GO
ALTER TABLE [HoaDonBanThuoc] CHECK CONSTRAINT [Fk_maNV]
GO
ALTER TABLE [HoaDonBanThuoc]  WITH CHECK ADD  CONSTRAINT [Fk_maThuoc] FOREIGN KEY([maThuoc])
REFERENCES [Thuoc] ([maThuoc])
GO
ALTER TABLE [HoaDonBanThuoc] CHECK CONSTRAINT [Fk_maThuoc]
GO
ALTER TABLE [Thuoc]  WITH CHECK ADD CHECK  (([soLuong]>=(0)))
GO
