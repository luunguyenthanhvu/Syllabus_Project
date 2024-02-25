let arrow = document.querySelectorAll(".arrow");


for(var i = 0; i < arrow.length; i++) {
  arrow[i].addEventListener("click", (e) => {

    let arrowParent = e.target.parentElement.parentElement;
    arrowParent.classList.toggle("showMenu");
  });
}

let closeSlidebarBtn = document.querySelector("#btn-close-slidebar");


closeSlidebarBtn.addEventListener("click", () => {
  let slidebar = document.querySelector(".slidebar");
  let icon = document.querySelector("#btn-close-slidebar");

  slidebar.classList.toggle("close");

  if (slidebar.classList.contains("close")) {
    icon.classList.remove("bx-x");
    icon.classList.add("bx-menu");
  } else {
    icon.classList.remove("bx-menu");
    icon.classList.add("bx-x");
  }
  isClosed = !isClosed;
});
