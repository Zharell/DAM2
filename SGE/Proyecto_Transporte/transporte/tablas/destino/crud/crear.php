<?php
//va a la base de datos y crea un registro con los datos que le pasamos desde PagCrear.php
require('../../../php/db.php');
//inserta los datos en la base de datos y vuelve a index
$sql = "INSERT INTO destino (cif, nombre, direccion) VALUES
(:cif,:nombre,:direccion)";

$stmt = $conn->prepare($sql);
$stmt->bindParam(':cif', $_POST["cif"], PDO::PARAM_STR); 
$stmt->bindParam(':nombre', $_POST["nombre"], PDO::PARAM_STR);
$stmt->bindParam(':direccion', $_POST["direccion"], PDO::PARAM_STR);

if($stmt->execute()==true)
    header("Location: PagCrear.php");
?>
