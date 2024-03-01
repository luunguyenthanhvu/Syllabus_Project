
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

// range active, inactive user
const radioInput = document.getElementById('statusActive');
let active = true;
radioInput.addEventListener('click', function() {
  const statusText = document.querySelector(".user-status-text");
  if (active) {
    this.value = 'inactive';
    statusText.textContent = 'Inactive';
  } else {
    this.value = 'active';
    statusText.textContent = 'Active';
  }
  active = !active;
  console.log(this.value);
});

// pop-up add new user
const addUserBtn = document.getElementById('add-user-btn');
const addUserPopup = document.getElementById('add-user-popup');
const overlay = document.getElementById('overlay');

addUserBtn.addEventListener('click', function() {
  addUserPopup.style.display = 'block';
  overlay.style.display = 'block';
});

overlay.addEventListener('click', function() {
  addUserPopup.style.display = 'none';
  overlay.style.display = 'none';
});

// close popup
const closeUserPopup = document.querySelector('.close-pop-up-add-user');
closeUserPopup.addEventListener('click', function() {
  addUserPopup.style.display = 'none';
  overlay.style.display = 'none';
})
