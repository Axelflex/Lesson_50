const regForm = document.querySelector('.reg-form');
const BASE_URL = "http://localhost:8080/"

function regHandler(event) {
    event.preventDefault()
    let valid = false;
    const data = {
        nickname: regForm.nickname.value,
        name: regForm.name.value,
        email: regForm.email.value,
        password: regForm.password1.value,
        password2: regForm.password2.value
    }
    console.log(data)

    if (data.password === data.password2) valid = true;

    if (valid) {
        const url = BASE_URL + 'addUser';
        const json = JSON.stringify(data)
        axios.post(url, data, {
                    'content-type': 'application/json',
        })
            .then((response) => {
                if (response.status === 200) {
                    window.location.replace('index.html')
                }
        })
        
    } else {
        alert('passwords do not match')
    }
}

regForm.addEventListener("submit", regHandler);