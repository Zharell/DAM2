<?php
require('../../../php/db.php');
//modifica los datos en la base de datos y vuelve a index
$sql = "UPDATE destino SET cif = :cif, 
            nombre = :nombre, 
            direccion = :direccion  
            WHERE id = :id";

$stmt = $conn->prepare($sql);
$stmt->bindParam(':cif', $_POST["cif"], PDO::PARAM_STR); 
$stmt->bindParam(':nombre', $_POST["nombre"], PDO::PARAM_STR);
$stmt->bindParam(':direccion', $_POST["direccion"], PDO::PARAM_STR);
$stmt->bindParam(':id', $_POST["id"], PDO::PARAM_STR); 

if($stmt->execute()==true)
    header("Location: ../../../index.php");
 
?>
