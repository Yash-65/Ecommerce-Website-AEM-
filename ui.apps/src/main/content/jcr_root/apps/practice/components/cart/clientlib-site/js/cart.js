document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".remove-item").forEach(btn => {
        btn.addEventListener("click", () => {
            const itemId = btn.getAttribute("data-id");
            alert("Removed item with ID: " + itemId);
            // Later: integrate with backend service
        });
    });

    document.querySelector(".checkout-btn").addEventListener("click", () => {
        alert("Proceeding to checkout...");
        // Later: redirect to checkout page
    });
});

