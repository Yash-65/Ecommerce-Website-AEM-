document.addEventListener("DOMContentLoaded", () => {
    const priceRange = document.getElementById("priceRange");
    const priceValue = document.getElementById("priceValue");
    const applyBtn = document.querySelector(".apply-filters");

    priceRange.addEventListener("input", () => {
        priceValue.textContent = priceRange.value;
    });

    applyBtn.addEventListener("click", () => {
        const selectedCategories = [];
        document.querySelectorAll(".category-filter:checked").forEach(cb => {
            selectedCategories.push(cb.value);
        });

        const maxPrice = priceRange.value;

        alert(`Filters Applied:\nCategories: ${selectedCategories.join(", ")}\nMax Price: ₹${maxPrice}`);

        // Here you can integrate with backend service
    });
});
