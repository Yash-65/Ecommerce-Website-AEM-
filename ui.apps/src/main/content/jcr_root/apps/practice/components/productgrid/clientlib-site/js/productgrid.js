document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".add-to-cart").forEach(btn => {
        btn.addEventListener("click", () => {
            const productTitle = btn.getAttribute("data-title");

            fetch(`/bin/addtocart?name=${encodeURIComponent(productTitle)}`)
                .then(response => response.text())
                .then(message => alert(message));
        });
    });
});
