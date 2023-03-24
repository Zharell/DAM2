<?php
//borra el registro de la base de datos y vuelve a la página principal
require('../../../php/db.php');
$id = $_GET["id"];
var_dump($id);
if (isset($id)) {
        // your code to execute when confirmed
        $sql = "DELETE FROM viaje 
        WHERE id = :id";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':id', $id);
        if ($stmt->execute() == true)
                header("Location: PagCrear.php");
}
?>