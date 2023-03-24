<?php
require('../../../php/db.php');
$id = $_GET["id"];

$stmt = $conn->prepare("SELECT * FROM origen WHERE id=:id");
$stmt->bindParam(':id', $id);
$stmt->execute();
$result = $stmt->fetch(PDO::FETCH_ASSOC);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../recursos/css/todo.css">
    <link rel="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Editar origen</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="editar.php" method="post" id="formulario">
                <label>Nombre<br><input type="text" name="nombre" id="nombre"
                        value='<?php echo $result["nombre"] ?>'><br></label>
                <label>Ciudad<br><input type="text" name="ciudad" id="ciudad"
                        value='<?php echo $result["ciudad"] ?>'><br></label>
                <label>CP<br><input type="text" name="cp" id="cp" value='<?php echo $result["cp"] ?>'><br></label>
                <label>Teléfono<br><input type="text" name="telefono" id="telefono"
                        value='<?php echo $result["telefono"] ?>'><br></label>
                <label>Dirección<br><input type="text" name="direccion" id="direccion"
                        value='<?php echo $result["direccion"] ?>'><br></label>
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
        const ciudad = form.elements['ciudad'];
        const cp = form.elements['cp'];
        const telefono = form.elements['telefono'];
        const direccion = form.elements['direccion'];

        if (nombre.value === '') {
            alert('Por favor ingrese un nombre.');
            return;
        }
        if (ciudad.value === '') {
            alert('Por favor ingrese una ciudad.');
            return;
        }
        if (cp.value === '') {
            alert('Por favor ingrese un cp.');
            return;
        }
        if (telefono.value === '') {
            alert('Por favor ingrese un nombre.');
            return;
        }
        if (direccion.value === '') {
            alert('Por favor ingrese un direccion.');
            return;
        }
        if (isNaN(cp.value)) {
            alert('El cp debe ser un número.');
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