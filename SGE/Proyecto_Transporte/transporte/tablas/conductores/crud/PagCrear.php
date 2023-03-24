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
    <link rel ="stylesheet" href="../../../recursos/css/todo.css">
    <link rel ="stylesheet" href="../../../recursos/css/anadir.css">
    <title>Añadir conductor</title>
</head>
<body>
    <div class="contenedorPadre">
        <div class="contenedorAñadir" >
            <form action="crear.php" method="post" id="formulario">
                <label><input type="text" name="nombre" id="nombre" placeholder="Nombre"></label><br>
                <label><input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" ></label><br>
                <label><input type="text" name="dni" id="dni" placeholder="Dni"></label><br>
                <label><input type="text" name="matricula" id="matricula" placeholder="Matrícula" ></label><br>
                <label><input type="text" size="9" name="telefono" id="telefono" placeholder="Teléfono"></label><br>
                <label><input type="text" size="100" name="email" id="email" placeholder="Email"></label><br>
                <label><input type="text" size="100" name="nacionalidad" id="nacionalidad" placeholder="Nacionalidad"></label><br>
                <input type="submit" class="btn btn-success" value="Insertar">
            </form>
            <a href="../../../index.php">Volver</a>
        </div>
        <div class="contenedorVolver">
        

            
            <?php
                //Utiliza el Statement para realizar la query
                $stmt = $conn->prepare("SELECT * FROM conductor");
                $stmt->execute();
                $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

                //Construimos la tabla y sus respectivos títulos
                echo '<table width="100px" id="tabla" class="table table-striped">';
                echo '<tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Dni</th>
                            <th>Matrícula</th>
                            <th>Teléfono</th>
                            <th>Email</th>
                            <th>Nacionalidad</th>
				    <th></th>
                        </tr>';
                echo '<tr>
                            <td colspan="100"><input style="width:100%;" type="text" id="buscar" placeholder="Escriba para buscar"/></td>
                    </tr>';

                //Inserta en la tabla los datos extraídos de la base de datos
                foreach ($result as $row) {
                    echo
                        "<tr>
                               <td>" . $row["id"] . "</td>"
                            . "<td>" . $row["nombre"] . "</td>"
                            . "<td>" . $row["apellidos"] . "</td>"
                            . "<td>" . $row["dni"] . "</td>"
                            . "<td>" . $row["matricula"] . "</td>"
                            . "<td>" . $row["telefono"] . "</td>"
                            . "<td>" . $row["email"] . "</td>"
                            . "<td>" . $row["nacionalidad"] . "</td>"
                            . "<td><a href='borrarMod.php?id=" . $row["id"] . "' onclick='return confirm(\"¿Seguro que deseas borrar este registro?\")'>Borrar</a></td>
                            </tr>";
                }

                echo '</table>';
                //Utiliza el código Javascript para crear la barra filtradora
                echo '<script type="text/javascript" src="../../../recursos/javascript/TablaBuscador.js"></script>';
            
            ?>
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
