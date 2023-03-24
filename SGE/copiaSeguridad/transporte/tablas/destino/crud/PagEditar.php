<?php
require('../../../php/db.php');
$id = $_GET["id"];

$stmt = $conn->prepare("SELECT * FROM destino WHERE id=:id");
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
    <title>Editar destino</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="editar.php" method="post" id="formulario">
                <label>Cif<br><input type="text" name="cif" id="cif" value='<?php echo $result["cif"] ?>'><br></label>
                <label>Nombre<br><input type="text" name="nombre" id="nombre"
                        value='<?php echo $result["nombre"] ?>'><br></label>
                <label>Dirección<br><input type="text" name="direccion" id="direccion"
                        value='<?php echo $result["direccion"] ?>'><br></label>
                <input type="hidden" name="id" value='<?php echo $id ?>'>
                <input type="submit" value="Editar">
            </form>
            <a href="../../../index.php">Volver sin modificar</a>
</body>
<script>
    const form = document.querySelector('#formulario');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Evita que se envíe el formulario por defecto

        const nombre = form.elements['nombre'];
        const cif = form.elements['cif'];
        const direccion = form.elements['direccion'];

        if (nombre.value === '') {
            alert('Por favor ingrese un nombre.');
            return;
        }
        if (cif.value === '') {
            alert('Por favor ingrese un cif.');
            return;
        }
        if (direccion.value === '') {
            alert('Por favor ingrese un direccion.');
            return;
        }
        if (isNaN(cif.value)) {
            alert('El cif debe ser un número.');
            return;
        }

        // Si todo está bien, se puede enviar el formulario
        form.submit();
    });
</script>

</html>