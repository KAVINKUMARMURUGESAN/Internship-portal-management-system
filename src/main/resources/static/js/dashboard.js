/* =========================
   SIDEBAR ACTIVE MENU
========================= */

const sidebarLinks = document.querySelectorAll('.sidebar-menu a');

sidebarLinks.forEach(link => {

    link.addEventListener('click', function(){

        sidebarLinks.forEach(item => {
            item.classList.remove('active');
        });

        this.classList.add('active');

    });

});

/* =========================
   DASHBOARD CARD HOVER
========================= */

const cards = document.querySelectorAll('.dashboard-card');

cards.forEach(card => {

    card.addEventListener('mouseenter', () => {

        card.style.transform = 'translateY(-8px)';
        card.style.transition = '0.3s';

    });

    card.addEventListener('mouseleave', () => {

        card.style.transform = 'translateY(0px)';

    });

});

/* =========================
   SEARCH FILTER
========================= */

function filterTable(inputId, tableId){

    const input = document.getElementById(inputId);
    const filter = input.value.toLowerCase();

    const table = document.getElementById(tableId);

    const tr = table.getElementsByTagName('tr');

    for(let i = 1; i < tr.length; i++){

        let found = false;

        const td = tr[i].getElementsByTagName('td');

        for(let j = 0; j < td.length; j++){

            if(td[j]){

                const textValue = td[j].textContent || td[j].innerText;

                if(textValue.toLowerCase().indexOf(filter) > -1){

                    found = true;

                }

            }

        }

        tr[i].style.display = found ? '' : 'none';

    }

}

/* =========================
   CONFIRM DELETE
========================= */

function confirmDelete(){

    return confirm('Are you sure you want to delete this item?');

}

/* =========================
   SUCCESS ALERT
========================= */

function showSuccess(message){

    const alertBox = document.createElement('div');

    alertBox.className =
        'alert alert-success position-fixed top-0 end-0 m-4 shadow rounded-pill px-4 py-3';

    alertBox.style.zIndex = '9999';

    alertBox.innerHTML = `
        <i class="fa-solid fa-circle-check"></i>
        ${message}
    `;

    document.body.appendChild(alertBox);

    setTimeout(() => {

        alertBox.remove();

    }, 3000);

}

/* =========================
   SIDEBAR TOGGLE (MOBILE)
========================= */

function toggleSidebar(){

    const sidebar = document.querySelector('.sidebar');

    if(sidebar.style.left === '-280px'){

        sidebar.style.left = '0';

    }else{

        sidebar.style.left = '-280px';

    }

}

/* =========================
   LOADING EFFECT
========================= */

window.addEventListener('load', () => {

    document.body.style.opacity = '1';

});

/* =========================
   COUNTER ANIMATION
========================= */

const counters = document.querySelectorAll('.counter');

counters.forEach(counter => {

    counter.innerText = '0';

    const updateCounter = () => {

        const target = +counter.getAttribute('data-target');

        const current = +counter.innerText;

        const increment = target / 100;

        if(current < target){

            counter.innerText = `${Math.ceil(current + increment)}`;

            setTimeout(updateCounter, 20);

        }else{

            counter.innerText = target;

        }

    };

    updateCounter();

});

/* =========================
   PREVIEW IMAGE
========================= */

function previewImage(event, previewId){

    const image = document.getElementById(previewId);

    image.src = URL.createObjectURL(event.target.files[0]);

}

/* =========================
   DARK MODE TOGGLE
========================= */

function toggleDarkMode(){

    document.body.classList.toggle('dark-mode');

}

/* =========================
   TOOLTIP ENABLE
========================= */

const tooltipTriggerList =
    [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));

const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {

    return new bootstrap.Tooltip(tooltipTriggerEl);

});

console.log('Dashboard JS Loaded Successfully');