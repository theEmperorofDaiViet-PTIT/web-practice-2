## About
Web Development > Practice > 2

## Built With
* [![Java][Java-shield]][Java-url]:&nbsp;<font size=4>Servlet & JSP</font>
* [![Apache Ant][Apache Ant-shield]][Apache Ant-url]
* [![Apache Tomcat][Apache Tomcat-shield]][Apache Tomcat-url]
* [![HTML5][HTML5-shield]][HTML5-url]
* [![MySQL][MySQL-shield]][MySQL-url]

## Requirements
<i>Trong bài thực hành này, bạn sẽ tạo một trang Web cho phép thêm, sửa, xóa 1 sản phẩm hàng hoá. Dưới đây là các màn hình của ứng dụng:</i>

### The Index page
<p>
    <img src="web\images\the Index page.jpg" width="75%">
</p>

### The Products page
<p>
    <img src="web\images\the Products page.jpg" width="75%">
</p>

### The Product page
<p>
    <img src="web\images\the Product page.jpg" width="75%">
</p>

### The Confirm Delete page
<p>
    <img src="web\images\the Confirm Delete page.jpg" width="75%">
</p>

### Hoạt động của hệ thống:
* Khi hệ thống khởi tạo, trang Index sẽ được hiển thị. Trang này chứa 1 liên kết tới trang Products chứa danh sách các sản phẩm cho phép người dùng xem và có thể thêm, sửa, xóa sản phẩm.
* Để thêm mới 1 sản phẩm, người dùng chọn nút Add Product. Trang Product sẽ hiển thị với các trường nhập dữ liệu trống. Người dùng có thể nhập thông tin vào và bấm nút Update Product để thêm sản phẩm.
* Để sửa sản phẩm, người dùng chọn liên kết Edit. Trang Product sẽ hiển thị cùng với các thông tin hiện tại trên các ô nhập liệu. Người dùng có thể sửa thông tin và bấm nút Update Product để cập nhật sửa thông tin.
* Để xóa sản phẩm, người dùng chọn liên kết Delete tương ứng. Trang Confirm Delete sẽ hiển thị. Người dùng có thể xác nhận xóa bằng cách bấm nút Yes và sản phẩm sẽ bị xóa. Nếu người dùng chọn No, sản phẩm sẽ không bị xóa và hệ thống quay về trang Products.

### Yêu cầu bổ sung ngoài hoạt động của hệ thống:
* Sử dụng một lớp ProductIO để thực hiện các thao tác đọc, ghi, xóa sản phẩm từ bảng trong CSDL MySQL.
* Thực hiện việc validate thông tin người dùng nhập vào từ server. Cụ thể, kiểm tra việc người dùng đưa các thông tin về code, description, và price cho mỗi sản phẩm. Kiểm tra giá sản phẩm là số.
* Sử dụng JSP EL và JSTL để thay thế cho các code Java trong trang JSP.



<!-- MARKDOWN LINKS & IMAGES -->
<!-- Tech stack -->
[Java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[Apache Ant-shield]: https://img.shields.io/badge/Apache%20Ant-A81C7D?style=for-the-badge&logo=Apache%20Ant&logoColor=white
[Apache Ant-url]: https://ant.apache.org/
[Apache Tomcat-shield]: https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black
[Apache Tomcat-url]: https://tomcat.apache.org/
[HTML5-shield]: https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white
[HTML5-url]: https://www.w3.org/html/
[MySQL-shield]: https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/