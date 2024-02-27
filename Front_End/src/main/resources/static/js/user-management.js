
// Gender js for client site
var genderCells = document.querySelectorAll('.td-gender-user');

genderCells.forEach(function(cell) {
  var gender = cell.textContent.trim();
  if (gender === 'MALE') {
    cell.innerHTML = "<i class='bx bxs-user' style='color: #2D3748;'></i>";
  } else if (gender === 'FEMALE') {
    cell.innerHTML = "<i class='bx bxs-user' style='color: #E74A3B;'></i>";
  }
});

// User type for client site
var userTypeElements = document.querySelectorAll('.user-type-text');

userTypeElements.forEach(function(element) {
  var type = element.textContent.trim();

  if (type === 'ADMIN') {
    element.classList.add('admin');
    element.textContent = 'Admin';
  } else if (type === 'TRAINER') {
    element.classList.add('trainer');
    element.textContent = 'Trainer';
  } else if (type === 'SUPER_ADMIN') {
    element.classList.add('super-admin');
    element.textContent = 'Super admin';
  }
});

// pop-up user function
function showUserFunction(userId) {
  // Tìm popup cụ thể dựa trên userId
  var popup = document.getElementById("popup-" + userId);

  // Tắt tất cả các popup khác
  var allPopups = document.querySelectorAll('.popup');
  allPopups.forEach(function(popup) {
    popup.classList.remove("show");
  });

  // Hiển thị hoặc ẩn popup tương ứng
  popup.classList.toggle("show");

  // Lấy tọa độ của con trỏ chuột khi click
  var x = event.clientX;
  var y = event.clientY;

  // Đặt vị trí của popup
  popup.style.left = x + 'px';
  popup.style.top = y + 'px';

  // Lắng nghe sự kiện click bên ngoài popup để đóng nó
  window.addEventListener("click", function(event) {
    if (!popup.contains(event.target)) {
      popup.classList.remove("show");
    }
  });
}
