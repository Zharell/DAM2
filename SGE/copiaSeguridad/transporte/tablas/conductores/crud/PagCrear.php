<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel ="stylesheet" href="../../../recursos/css/todo.css">
    <link rel ="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Añadir conductor</title>
</head>
<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir" >
            <form action="crear.php" method="post" id="formulario">
                <label>Nombre<br><input type="text" name="nombre" id="nombre"><br></label>
                <label>Apellidos<br><input type="text" name="apellidos" id="apellidos" ><br></label>
                <label>Dni<br><input type="text" name="dni" id="dni"><br></label>
                <label>Matrícula<br><input type="text" name="matricula" id="matricula" ><br></label>
                <label>Teléfono<br><input type="text" size="9" name="telefono" id="telefono"><br></label>
                <label>Email<br><input type="text" size="100" name="email" id="email"><br></label>
                <label>Nacionalidad<br><input type="text" size="100" name="nacionalidad" id="nacionalidad"><br></label>
                <input type="submit" value="Insertar">
            </form>
        </div>
        <div class="contenedorVolver">
            <a href="../../../index.php">Volver sin modificar</a>
        </div>
        <div class="margenesDiv">
          <?php include('tablas/conductores/conductoresAnadir.php');?>
        </div>
</body>
<script>
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


</script>
</html>
