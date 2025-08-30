document.addEventListener("DOMContentLoaded", () => {
    const searchBox = document.getElementById("searchBox");
    const resultsContainer = document.getElementById("resultsContainer");

    document.querySelector(".search-btn").addEventListener("click", () => {
        const query = searchBox.value.toLowerCase();
        resultsContainer.innerHTML = "";

        if (!query) {
            resultsContainer.innerHTML = "<p>Please enter a search term.</p>";
            return;
        }

        // Dummy product data (replace with backend service if needed)
        const products = ["Shirt", "Shoes", "Laptop", "Watch", "Headphones"];
        const filtered = products.filter(p => p.toLowerCase().includes(query));

        if (filtered.length > 0) {
            filtered.forEach(p => {
                const div = document.createElement("div");
                div.className = "result-item";
                div.textContent = p;
                resultsContainer.appendChild(div);
            });
        } else {
            resultsContainer.innerHTML = "<p>No results found.</p>";
        }
    });
});
