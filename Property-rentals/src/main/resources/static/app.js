const apiBase = '/api/properties';


async function fetchProperties() {
const res = await fetch(apiBase);
const data = await res.json();
return data;
}


function renderProperties(list) {
const container = document.getElementById('list');
container.innerHTML = '';
list.forEach(p => {
const el = document.createElement('div');
el.className = 'card';


const img = document.createElement('img');
img.src = p.imageUrl || 'https://via.placeholder.com/400x200?text=Property';
el.appendChild(img);


const title = document.createElement('h3');
title.textContent = p.title;
el.appendChild(title);


const meta = document.createElement('div');
meta.className = 'meta';
meta.textContent = `${p.bedrooms} beds • ₹${p.pricePerMonth}/month`;
el.appendChild(meta);


const desc = document.createElement('p');
desc.textContent = p.description;
el.appendChild(desc);


const addr = document.createElement('p');
addr.className = 'meta';
addr.textContent = p.address;
el.appendChild(addr);


const del = document.createElement('button');
del.textContent = 'Delete';
del.className = 'danger';
del.onclick = async () => {
if (!confirm('Delete this property?')) return;
await fetch(`${apiBase}/${p.id}`, { method: 'DELETE' });
load();
};
el.appendChild(del);


container.appendChild(el);
});
}


async function load() {
const props = await fetchProperties();
renderProperties(props);
}


document.getElementById('property-form').addEventListener('submit', async (e) => {
e.preventDefault();
const fd = new FormData(e.target);
const body = {
title: fd.get('title'),
address: fd.get('address'),
pricePerMonth: parseFloat(fd.get('pricePerMonth')),
bedrooms: parseInt(fd.get('bedrooms')),
imageUrl: fd.get('imageUrl'),
description: fd.get('description')
};
await fetch(apiBase, {
method: 'POST',
headers: { 'Con