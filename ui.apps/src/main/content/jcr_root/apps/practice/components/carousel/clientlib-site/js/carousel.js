//document.addEventListener("DOMContentLoaded", function () {
//    let currentIndex = 0;
//    const slides = document.querySelectorAll(".slide");
//    const dots = document.querySelectorAll(".dot");
//    const slidesContainer = document.querySelector(".slides");
//
//    function showSlide(index) {
//        if (index >= slides.length) currentIndex = 0;
//        else if (index < 0) currentIndex = slides.length - 1;
//        else currentIndex = index;
//
//        slidesContainer.style.transform =
//            "translateX(" + (-currentIndex * 100) + "%)";
//
//        dots.forEach(dot => dot.classList.remove("active"));
//        if (dots[currentIndex]) {
//            dots[currentIndex].classList.add("active");
//        }
//    }
//
//    document.querySelector(".prev")?.addEventListener("click", () => showSlide(currentIndex - 1));
//    document.querySelector(".next")?.addEventListener("click", () => showSlide(currentIndex + 1));
//
//    dots.forEach((dot, index) => {
//        dot.addEventListener("click", () => showSlide(index));
//    });
//
//    // Show first slide initially
//    showSlide(0);
//
//    // Auto slide
//    setInterval(() => showSlide(currentIndex + 1), 5000);
//});

document.addEventListener("DOMContentLoaded", function () {
    let currentIndex = 0;
    const slides = document.querySelectorAll(".slide");
    const dots = document.querySelectorAll(".dot");
    const slidesContainer = document.querySelector(".slides");

    function showSlide(index) {
        if (index >= slides.length) currentIndex = 0;
        else if (index < 0) currentIndex = slides.length - 1;
        else currentIndex = index;

        slidesContainer.style.transform =
            "translateX(" + (-currentIndex * 100) + "%)";

        dots.forEach(dot => dot.classList.remove("active"));
        if (dots[currentIndex]) {
            dots[currentIndex].classList.add("active");
        }
    }

    document.querySelector(".prev")?.addEventListener("click", () => showSlide(currentIndex - 1));
    document.querySelector(".next")?.addEventListener("click", () => showSlide(currentIndex + 1));

    dots.forEach((dot, index) => {
        dot.addEventListener("click", () => showSlide(index));
    });

    // Show first slide initially
    showSlide(0);

    // Auto slide
    setInterval(() => showSlide(currentIndex + 1), 5000);
});