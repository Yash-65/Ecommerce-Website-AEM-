let currentIndex = 0;
const slides = document.querySelectorAll(".slide");
const dots = document.querySelectorAll(".dot");

function showSlide(index) {
    if (index >= slides.length) currentIndex = 0;
    else if (index < 0) currentIndex = slides.length - 1;
    else currentIndex = index;

    document.querySelector(".slides").style.transform =
        "translateX(" + (-currentIndex * 100) + "%)";

    dots.forEach(dot => dot.classList.remove("active"));
    dots[currentIndex].classList.add("active");
}

document.querySelector(".prev").addEventListener("click", () => showSlide(currentIndex - 1));
document.querySelector(".next").addEventListener("click", () => showSlide(currentIndex + 1));

dots.forEach((dot, index) => {
    dot.addEventListener("click", () => showSlide(index));
});

setInterval(() => showSlide(currentIndex + 1), 5000);
