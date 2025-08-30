document.addEventListener("DOMContentLoaded", function () {
    const yearSpan = document.querySelector(".footer-copy");
    if (yearSpan) {
        const currentYear = new Date().getFullYear();
        yearSpan.innerHTML = "&copy; " + currentYear + " Your E-commerce Website";
    }
});
