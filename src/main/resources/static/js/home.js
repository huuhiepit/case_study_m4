const dBody = document.getElementById("dBody");
let products;
window.onload = async () => {
    await renderProducts();
}
function renderItemStr(item) {
    return `
        <div class="col-md-3 col-sm-6">
            <div class="single-shop-product">
                <div class="product-upper">
                    <img src="${item.urlImage}" alt="">
                </div>
                <h2><a href="">${item.name}</a></h2>
                <div class="product-carousel-price">
                    <ins>${formatCurrency(item.price)}</ins> <del>${formatCurrency(item.price - (item.price * 10/100))}</del>
                </div>

                <div class="product-option-shop">
                    <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="/canvas/shop/?add-to-cart=70">Add to cart</a>
                </div>
            </div>
        </div>  
    `;
}

async function getProduct() {
    const res = await fetch(`/api/products/home`);
    return await res.json();
}

async function renderProducts() {
    const pageable = await getProduct();
    products = pageable.content;
    renderDBody(products);
}

function renderDBody(items) {
    let str = '';
    items.forEach((e) => {
        str += renderItemStr(e);
    })
    dBody.innerHTML = str;
}

function formatCurrency(amount) {
    if (amount !== null && amount !== undefined) {
        // Sử dụng replace để thay thế dấu chấm thành dấu phẩy
        return amount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }).replace(/\./g, ',');
    } else {
        return 'N/A'; // Hoặc giá trị mặc định khác tùy bạn chọn
    }
}