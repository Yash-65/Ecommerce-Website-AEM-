document.addEventListener("DOMContentLoaded", () => {
    const checkoutForm = document.getElementById("checkoutForm");

    checkoutForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const formData = {
            name: document.getElementById("name").value,
            address: document.getElementById("address").value,
            phone: document.getElementById("phone").value,
            payment: document.getElementById("payment").value
        };

        alert("Order placed successfully!\n" + JSON.stringify(formData, null, 2));

        // Later: integrate with CheckoutService via AJAX or Sling POST
    });
});
