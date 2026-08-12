/* =========================
   REGISTER FORM VALIDATION
========================= */

function validateRegisterForm(){

    const name =
        document.getElementById('name').value.trim();

    const email =
        document.getElementById('email').value.trim();

    const phone =
        document.getElementById('phone').value.trim();

    const password =
        document.getElementById('password').value.trim();

    /* Name Validation */

    if(name === ''){

        alert('Full Name is required');
        return false;

    }

    /* Email Validation */

    const emailPattern =
        /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    if(email === ''){

        alert('Email is required');
        return false;

    }

    if(!email.match(emailPattern)){

        alert('Enter valid email address');
        return false;

    }

    /* Phone Validation */

    const phonePattern =
        /^[0-9]{10}$/;

    if(!phone.match(phonePattern)){

        alert('Enter valid 10 digit phone number');
        return false;

    }

    /* Password Validation */

    if(password.length < 6){

        alert('Password must contain at least 6 characters');
        return false;

    }

    return true;

}

/* =========================
   LOGIN FORM VALIDATION
========================= */

function validateLoginForm(){

    const email =
        document.getElementById('loginEmail').value.trim();

    const password =
        document.getElementById('loginPassword').value.trim();

    if(email === '' || password === ''){

        alert('Please fill all fields');
        return false;

    }

    return true;

}

/* =========================
   APPLY FORM VALIDATION
========================= */

function validateApplicationForm(){

    const fullName =
        document.getElementById('fullName').value.trim();

    const resume =
        document.getElementById('resume').value;

    const skills =
        document.getElementById('skills').value.trim();

    if(fullName === ''){

        alert('Please enter full name');
        return false;

    }

    if(resume === ''){

        alert('Please upload your resume');
        return false;

    }

    if(skills === ''){

        alert('Please enter skills');
        return false;

    }

    alert('Application Submitted Successfully');

    return true;

}

/* =========================
   PASSWORD SHOW/HIDE
========================= */

function togglePassword(inputId, iconId){

    const passwordInput =
        document.getElementById(inputId);

    const icon =
        document.getElementById(iconId);

    if(passwordInput.type === 'password'){

        passwordInput.type = 'text';

        icon.classList.remove('fa-eye');

        icon.classList.add('fa-eye-slash');

    }else{

        passwordInput.type = 'password';

        icon.classList.remove('fa-eye-slash');

        icon.classList.add('fa-eye');

    }

}

/* =========================
   CHARACTER COUNTER
========================= */

function countCharacters(textareaId, counterId){

    const textarea =
        document.getElementById(textareaId);

    const counter =
        document.getElementById(counterId);

    counter.innerText =
        textarea.value.length + ' Characters';

}

/* =========================
   FILE SIZE VALIDATION
========================= */

function validateFile(input){

    const file = input.files[0];

    if(file){

        const maxSize =
            5 * 1024 * 1024;

        if(file.size > maxSize){

            alert('File size must be less than 5MB');

            input.value = '';

            return false;

        }

    }

    return true;

}

/* =========================
   ONLY LETTERS
========================= */

function onlyLetters(event){

    const char =
        String.fromCharCode(event.which);

    if(!(/[a-zA-Z ]/.test(char))){

        event.preventDefault();

    }

}

/* =========================
   ONLY NUMBERS
========================= */

function onlyNumbers(event){

    const char =
        String.fromCharCode(event.which);

    if(!(/[0-9]/.test(char))){

        event.preventDefault();

    }

}

/* =========================
   LIVE SEARCH
========================= */

function liveSearch(inputId, cardClass){

    const input =
        document.getElementById(inputId);

    const filter =
        input.value.toLowerCase();

    const cards =
        document.querySelectorAll(cardClass);

    cards.forEach(card => {

        const text =
            card.innerText.toLowerCase();

        if(text.includes(filter)){

            card.style.display = '';

        }else{

            card.style.display = 'none';

        }

    });

}

console.log('Validation JS Loaded Successfully');