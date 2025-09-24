//document.addEventListener("DOMContentLoaded", () => {
//    document.querySelectorAll(".add-to-cart").forEach(btn => {
//        btn.addEventListener("click", () => {
//            const productTitle = btn.getAttribute("data-title");
//
//            fetch(`/bin/addtocart?name=${encodeURIComponent(productTitle)}`)
//                .then(response => response.text())
//                .then(message => alert(message));
//        });
//    });
//});

document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".add-to-cart").forEach(btn => {
        btn.addEventListener("click", () => {
            const productTitle = btn.getAttribute("data-title");
            if (!productTitle) return;

            fetch(`/bin/addtocart?name=${encodeURIComponent(productTitle)}`, { credentials: 'same-origin' })
                .then(res => {
                    if (!res.ok) throw new Error('Add failed: ' + res.status);
                    return res.json(); // servlet returns cart JSON
                })
                .then(json => {
                    // if servlet returned JSON (cart) — update UI from that
                    if (json) {
                        if (typeof window.refreshCart === 'function') {
                            // use refreshCart to fetch latest (or render using returned JSON)
                            window.refreshCart();
                        } else {
                            // fallback: attempt to render using returned JSON by calling update function if available
                            console.log('Added to cart', productTitle);
                        }
                    }
                })
                .catch(err => {
                    console.error('Add to cart error', err);
                });
        });
    });
});
