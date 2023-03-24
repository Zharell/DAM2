<?php require('../../../php/check_login_anadir.php'); ?>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../recursos/css/todo.css">
    <link rel="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Editar origen</title>
</head>

<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir">
            <form action="editar.php" method="post" id="formulario">
                <label><input type="text" name="cif" id="cif" placeholder="Cif"></label><br>
                <label><input type="text" name="nombre" id="nombre" placeholder="Nombre"></label><br>
                <label><input type="text" name="direccion" id="direccion" placeholder="Dirección"></label><br>
                <input type="submit" class="btn btn-success" value="Editar">
            </form>
            <a href="../../../index.php">Volver</a>
        </div>
        <div class="contenedorVolver">
            <?php
            //coge el post del input destino 
                $stmt = $conn->prepare("SELECT * FROM destino");
                $stmt->execute();

                $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
                //muestra la tabla con los datos de la base de datos
                echo '<table width="100px" id="tabla" class="table table-striped">';
                echo '<tr>
              <th>Id</th>
              <th>CIF</th>
              <th>Nombre</th>
              <th>Dirección</th>
              <th></th>
         </tr>';
                echo '<tr>
              <td colspan="100"><input style="width:100%;" type="text" id="buscar" placeholder="Escriba para buscar"/></td>
         </tr>';
                //pinta las filas de la tabla
                foreach ($result as $row) {
                    echo "<tr>
                  <td>" . $row["id"] . "</td>"
                        . "<td>" . $row["cif"] . "</td>"
                        . "<td>" . $row["nombre"] . "</td>"
                        . "<td>" . $row["direccion"] . "</td>"
                        . "<td>" . "<a href='borrarMod.php?id=" . $row["id"] . "' onclick='return confirm(\"¿Seguro que deseas borrar este registro?\")'>Borrar</a>" . "</td>
             </tr>";

                }

                echo '</table>';

                //Utiliza el código Javascript para crear la barra filtradora
                echo '<script type="text/javascript" src="recursos/javascript/TablaBuscador.js"></script>';
            ?>
        </div>
</body>
<script>//comprueba que los campos no estén vacíos y que el cp y el teléfono sean números
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