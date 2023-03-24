<?php
    $id = $_GET['id'];
    $server = "hl1173.dinaserver.com";
    $user = "sge";
    $pass = "DAM2v2023!";
    $dab = "pharmadam";
    //Utiliza el Statement para realizar la query
    $conn = new PDO("mysql:host=$server;dbname=$dab;charset=utf8", $user, $pass);
    $stmt = $conn->prepare("SELECT * FROM viaje WHERE id_conductor=:id");
    $stmt->execute();
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

    //Construimos la tabla y sus respectivos títulos
    echo '<table width="100px" id="tabla" class="table table-striped">';
    echo '<tr><th>Id</th><th>Id_pedido</th><th>Id_origen</th><th>Id_destino</th><th>Id_fecha</th><th>Id_conductor</th></tr>';
    foreach ($result as $row) {
        echo "<tr><td>" . $row["id"] . "</td>"
            . "<td>" . $row["id_pedido"] . "</td>"
            . "<td>" . $row["id_origen"] . "</td>"
            . "<td>" . $row["id_destino"] . "</td>"
            . "<td>" . $row["id_fecha"] . "</td>"
            . "<td>" . $row["id_conductor"] . "</td>";
    }
    echo '</table>';



?>