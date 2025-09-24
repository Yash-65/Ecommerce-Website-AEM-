
//document.addEventListener("DOMContentLoaded", () => {
//    document.querySelectorAll(".remove-item").forEach(btn => {
//        btn.addEventListener("click", () => {
//            const itemId = btn.getAttribute("data-id");
//            alert("Removed item with ID: " + itemId);
//            // Later: integrate with backend service
//        });
//    });
//
//    document.querySelector(".checkout-btn").addEventListener("click", () => {
//        alert("Proceeding to checkout...");
//        // Later: redirect to checkout page
//    });
//});

(function () {
  // helper to escape text for HTML insertion (minimal)
  function escapeHtml(s) {
    if (s === undefined || s === null) return '';
    return String(s).replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g,'&quot;');
  }

  // Renders cart JSON into .shopping-cart element
  function renderCart(cartJson) {
    const container = document.querySelector('.shopping-cart');
    if (!container) return;

    const itemsContainer = container.querySelector('.cart-items');
    const totalEl = container.querySelector('.cart-total strong');

    // if server returned success:false, handle gracefully
    if (!cartJson || cartJson.success === false) {
      if (itemsContainer) itemsContainer.innerHTML = '<p>Unable to load cart</p>';
      if (totalEl) totalEl.textContent = 'Total: ₹0';
      return;
    }

    const items = cartJson.items || [];
    if (itemsContainer) {
      if (items.length === 0) {
        itemsContainer.innerHTML = '<p>Your cart is empty.</p>';
      } else {
        itemsContainer.innerHTML = '';
        items.forEach(item => {
          const div = document.createElement('div');
          div.className = 'cart-item';
          div.innerHTML = ''
            + '<span class="item-name">' + escapeHtml(item.name) + '</span>'
            + '<span class="item-price">₹' + escapeHtml(item.price) + '</span>'
            + '<span class="item-qty">Qty: ' + escapeHtml(item.quantity) + '</span>'
            + '<button class="remove-item" data-name="' + escapeHtml(item.name) + '">Remove</button>';
          itemsContainer.appendChild(div);
        });
      }
    }

    if (totalEl) {
      totalEl.textContent = 'Total: ₹' + (cartJson.total || 0);
    }
  }

  // fetch cart from server and render; exposed globally
  async function refreshCart() {
    try {
      const res = await fetch('/bin/getcart', { credentials: 'same-origin' });
      if (!res.ok) throw new Error('Failed to fetch cart: ' + res.status);
      const json = await res.json();
      renderCart(json);
      return json;
    } catch (err) {
      console.error('refreshCart error', err);
      return null;
    }
  }

  // call remove servlet and refresh
  async function removeFromCart(name) {
    try {
      const res = await fetch('/bin/removefromcart?name=' + encodeURIComponent(name), { credentials: 'same-origin' });
      if (!res.ok) throw new Error('Remove failed: ' + res.status);
      const json = await res.json();
      // server returns cart JSON, so update UI with returned JSON OR refresh
      if (json) renderCart(json); else refreshCart();
    } catch (err) {
      console.error('removeFromCart error', err);
    }
  }

  // event delegation for remove buttons
  document.addEventListener('click', function (e) {
    const t = e.target;
    if (t && t.classList && t.classList.contains('remove-item')) {
      const name = t.getAttribute('data-name');
      if (name) removeFromCart(name);
    }
  });

  // expose refreshCart globally so productgrid.js can call it
  window.refreshCart = refreshCart;

  // auto refresh on load
  document.addEventListener('DOMContentLoaded', function () {
    refreshCart();
  });
})();
