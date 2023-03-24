<?php
//va a la base de datos y borra el registro con el id que le pasamos desde destino.php
require('../../../php/db.php');
$id=$_GET["id"];
var_dump($id);
if (isset($id)) {
        $sql = "DELETE FROM origen 
        WHERE id = :id";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':id', $id); 
        if($stmt->execute()==true)
        header("Location: PagCrear.php");
}
?>
