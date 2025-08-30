document.addEventListener("DOMContentLoaded", () => {
    const searchBtn = document.getElementById("searchBtn");
    const searchInput = document.getElementById("searchInput");

    if (searchBtn) {
        searchBtn.addEventListener("click", () => {
            const query = searchInput.value.trim();
            if (query) {
                window.location.href = `/search.html?q=${encodeURIComponent(query)}`;
            }
        });
    }
});
