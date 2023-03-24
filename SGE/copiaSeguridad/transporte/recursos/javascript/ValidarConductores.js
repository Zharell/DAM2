const form = document.querySelector('#formulario');

form.addEventListener('submit', function (event) {
    event.preventDefault(); // Evita que se envíe el formulario por defecto

    const nombre = form.elements['nombre'];
    const apellidos = form.elements['apellidos'];
    const dni = form.elements['dni'];
    const matricula = form.elements['matricula'];
    const telefono = form.elements['telefono'];
    const email = form.elements['email'];
    const nacionalidad = form.elements['nacionalidad'];
    if (nombre.value === '') {
        alert('Por favor ingrese un nombre.');
        return;
    }

    if (apellidos.value === '') {
        alert('Por favor ingrese apellidos.');
        return;
    }

    if (dni.value === '') {
        alert('Por favor ingrese un dni.');
        return;
    }
    if (matricula.value === '') {
        alert('Por favor ingrese una matricula.');
        return;
    }
    if (telefono.value === '') {
        alert('Por favor ingrese un telefono.');
        return;
    }
    if (email.value === '') {
        alert('Por favor ingrese un email.');
        return;
    }
    if (nacionalidad.value === '') {
        alert('Por favor ingrese una nacionalidad.');
        return;
    }
    if (isNaN(telefono.value)) {
        alert('El telefono debe ser un número.');
        return;
    }

    // Si todo está bien, se puede enviar el formulario
    form.submit();
});

