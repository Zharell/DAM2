<?php
//va a la base de datos y borra el registro con el id que le pasamos desde destino.php
require('../../../php/db.php');
$id = $_GET["id"];
if (isset($id)) {
        //cuando se hace el delete se redirige a index.php
        $sql = "DELETE FROM destino 
        WHERE id = :id";

        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':id', $id);
        if($stmt->execute()==true)
        header("Location: PagCrear.php");
}
?>