document.addEventListener('DOMContentLoaded', function() {

  
  let products = [];


  const form = document.getElementById('productForm');
  const cancelBtn = document.getElementById('cancelBtn');
  
  const tbody = document.getElementById('tableBody');
  const productCountSpan = document.getElementById('productCount');
  const emptyMessage = document.getElementById('emptyMessage');
  const tableWrapper = document.querySelector('.table-wrapper');

 
  function getStatus(qty) {
    if (qty === 0) return { text: 'Sold out', class: 'soldout' };
    if (qty <= 5) return { text: 'Low stock', class: 'low' };
    return { text: 'Active', class: 'active' };
  }

 
  function renderTable() {
    productCountSpan.textContent = `${products.length} item${products.length !== 1 ? 's' : ''}`;

    if (products.length === 0) {
      tbody.innerHTML = '';
      emptyMessage.classList.add('show');
      tableWrapper.style.display = 'none';
      return;
    } else {
      emptyMessage.classList.remove('show');
      tableWrapper.style.display = 'block';
    }

    let html = '';
    products.forEach(product => {
      const status = getStatus(product.quantity);
      html += `
        <tr>
          <td>
            <div style="display: flex; align-items: center; gap: 10px;">
              <span>📦</span>
              <span>${product.name}</span>
            </div>
          </td>
          <td>${product.code}</td>
          <td>${product.quantity}</td>
          <td>$${product.price.toFixed(2)}</td>
          <td><span class="badge ${status.class}">${status.text}</span></td>
          <td>
            <button class="delete-btn" data-id="${product.id}" title="Delete">🗑️</button>
          </td>
        </tr>
      `;
    });

    tbody.innerHTML = html;

    document.querySelectorAll('.delete-btn').forEach(btn => {
      btn.addEventListener('click', function() {
        const id = this.getAttribute('data-id');
        deleteProduct(id);
      });
    });
  }

 
  function deleteProduct(id) {
    products = products.filter(p => p.id !== id);
    renderTable();
  }


  cancelBtn.addEventListener('click', function() {
    form.reset();
  });

  
  form.addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('prodName').value.trim();
    const code = document.getElementById('prodCode').value.trim();
    const qty = parseInt(document.getElementById('prodQty').value, 10);
    const price = parseFloat(document.getElementById('prodPrice').value);

    if (!name || !code || isNaN(qty) || isNaN(price)) {
      alert(' Please fill in all fields.');
      return;
    }

    const newProduct = {
      id: Date.now().toString() + Math.random().toString(36).substr(2, 4),
      name: name,
      code: code,
      quantity: qty,
      price: price
    };

    products.push(newProduct);
    renderTable();
    form.reset();
  });

  renderTable();
});
