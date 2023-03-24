<?php
//require('../../../check_login.php');
require('../../../php/db.php');

$id = $_GET["id"];

$stmt = $conn->prepare("SELECT * FROM conductor WHERE id=:id");
$stmt->bindParam(':id', $id);
$stmt->execute();
$result = $stmt->fetch(PDO::FETCH_ASSOC);
//var_dump($result);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../recursos/css/todo.css">
    <link rel="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Editar conductor</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="editar.php" method="post" id="formulario">
                <label>Nombre<br><input type="text" name="nombre" id="nombre"
                        value='<?php echo $result["nombre"] ?>'><br></label>
                <label>Apellidos<br><input type="text" name="apellidos" id="apellidos"
                        value='<?php echo $result["apellidos"] ?>'><br></label>
                <label>DNI<br><input type="text" name="dni" id="dni" value='<?php echo $result["dni"] ?>'><br></label>
                <label>Matricula<br><input type="text" name="matricula" id="matricula"
                        value='<?php echo $result["matricula"] ?>'><br></label>
                <label>Telefono<br><input type="text" name="telefono" id="telefono"
                        value='<?php echo $result["telefono"] ?>'><br></label>
                <label>Email<br><input type="text" name="email" id="email"
                        value='<?php echo $result["email"] ?>'><br></label>
                <label>Nacionalidad<br><input type="text" name="nacionalidad" id="nacionalidad"
                        value='<?php echo $result["nacionalidad"] ?>'><br></label>
                <input type="hidden" name="id" value='<?php echo $id ?>'>
                <input type="submit" value="Editar">
            </form>
        </div>
        <div class="contenedorVolver">
            <a href="../../../index.php">Volver sin modificar</a>
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