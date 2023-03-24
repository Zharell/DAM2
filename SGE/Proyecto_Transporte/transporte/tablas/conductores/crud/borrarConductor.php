<?php
//requiere el archivo de conexion a la base de datos
require('../../../php/db.php');
$id=$_GET["id"];
var_dump($id);
if (isset($id)) {

        //borra el conductor de la base de datos
        $sql = "DELETE FROM conductor 
        WHERE id = :id";
    
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':id', $id); 
        if($stmt->execute()==true)
        header("Location: ../../../index.php");
   
}


?>