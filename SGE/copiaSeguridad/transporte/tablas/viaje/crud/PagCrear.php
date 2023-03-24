<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../recursos/css/todo.css">
    <link rel="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Añadir viaje</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="crear.php" method="post" id="formulario">
                <label>Id pedido<br><input type="text" name="id_pedido" id="id_pedido"><br></label>
                <label>Id origen<br><input type="text" name="id_origen" id="id_origen"><br></label>
                <label>Id destino<br><input type="text" name="id_destino" id="id_destino"><br></label>
                <label>Id fecha<br><input type="text" size="100" name="id_fecha" id="id_fecha"><br></label>
                <label>Id conductor<br><input type="text" name="id_conductor" id="id_conductor"><br></label>
                <input type="submit" value="Insertar">
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

        const id_pedido = form.elements['id_pedido'];
        const id_origen = form.elements['id_origen'];
        const id_destino = form.elements['id_destino'];
        const id_fecha = form.elements['id_fecha'];
        const id_conductor = form.elements['id_conductor'];

        if ((id_pedido.value||id_origen.value||id_destino.value||id_fecha.value||id_conductor.value) === '') {
            alert('Por favor ingrese los todos los id.');
            return;
        }
        if (isNaN(id_pedido.value||id_origen.value||id_destino.value||id_fecha.value||id_conductor.value)) {
            alert('Los id deben ser un números.');
            return;
        }
        // Si todo está bien, se puede enviar el formulario
        form.submit();
    });
</script>
</html>