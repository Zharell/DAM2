<?php require('../../../php/check_login_anadir.php'); ?>
<?php require('../../../php/db.php'); ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../recursos/css/todo.css">
    <link rel="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Añadir viaje</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="crear.php" method="post" id="formulario">
                <label><input type="text" name="id_pedido" id="id_pedido" placeholder="Id pedido"></label><br>
                <label><input type="text" name="id_origen" id="id_origen" placeholder="Id origen"></label><br>
                <label><input type="text" name="id_destino" id="id_destino" placeholder="Id destino"></label><br>
                <label><input type="text" name="id_fecha" id="id_fecha" placeholder="Id fecha"></label><br>
                <label><input type="text" name="id_conductor" id="id_conductor" placeholder="Id conductor"></label><br>
                <input type="submit" class="btn btn-success" value="Insertar">
            </form>
            <a href="../../../index.php">Volver</a>
        </div>
        <div class="contenedorVolver">

            <?php
            //coge el valor de la variable viaje que se le pasa por el método POST para mostrar la tabla de viaje
            
            $stmt = $conn->prepare("SELECT * FROM viaje");
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
            echo '<h3>Viaje</h3>';
            echo '<table width="100px" id="tabla" class="table table-striped">';
            echo '<tr><th>Id</th><th>Id_pedido</th><th>Id_origen</th><th>Id_destino</th><th>Id_fecha</th><th>Id_conductor</th><th><a href=tablas/viaje/crud/PagCrear.php>Añadir</a></th></tr>';
            echo '<tr>
                <td colspan="100"><input style="width:100%;" type="text" id="buscar" placeholder="Escriba para buscar"/></td>
          </tr>';
            //pinta la tabla con los datos de la base de datos
            foreach ($result as $row) {
                echo "<tr><td>" . $row["id"] . "</td>"
                    . "<td>" . $row["id_pedido"] . "</td>"
                    . "<td>" . $row["id_origen"] . "</td>"
                    . "<td>" . $row["id_destino"] . "</td>"
                    . "<td>" . $row["id_fecha"] . "</td>"
                    . "<td>" . $row["id_conductor"] . "</td>"
                    . "<td>" . "<a href='borrarMod.php?id=" . $row["id"] . "' onclick='return confirm(\"¿Seguro que deseas borrar este registro?\")'>Borrar</a>" . "</td></tr>";
            }
            echo '</table>';
            //Utiliza el código Javascript para crear la barra filtradora
            echo '<script type="text/javascript" src="../../../recursos/javascript/TablaBuscador.js"></script>';
            ?>
        </div>
</body>
<script>//comprueba que los campos no estén vacíos y que los id sean numeros
    const form = document.querySelector('#formulario');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Evita que se envíe el formulario por defecto

        const id_pedido = form.elements['id_pedido'];
        const id_origen = form.elements['id_origen'];
        const id_destino = form.elements['id_destino'];
        const id_fecha = form.elements['id_fecha'];
        const id_conductor = form.elements['id_conductor'];

        if ((id_pedido.value || id_origen.value || id_destino.value || id_fecha.value || id_conductor.value) === '') {
            alert('Por favor ingrese los todos los id.');
            return;
        }
        if (isNaN(id_pedido.value || id_origen.value || id_destino.value || id_fecha.value || id_conductor.value)) {
            alert('Los id deben ser un números.');
            return;
        }
        // Si todo está bien, se puede enviar el formulario
        form.submit();
    });
</script>

</html>