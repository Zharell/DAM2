<?php
//va a la base de datos y crea un registro con los datos que le pasamos desde PagCrear.php
require('../../../php/db.php');
//inserta los datos en la base de datos y vuelve a index
$sql = "INSERT INTO origen (nombre, ciudad, cp ,telefono ,direccion) VALUES
(:name,:ciudad,:cp,:telefono,:direccion)";

$stmt = $conn->prepare($sql);
$stmt->bindParam(':name', $_POST["nombre"], PDO::PARAM_STR); 
$stmt->bindParam(':ciudad', $_POST["ciudad"], PDO::PARAM_STR);
$stmt->bindParam(':cp', $_POST["cp"], PDO::PARAM_STR);
$stmt->bindParam(':telefono', $_POST["telefono"], PDO::PARAM_STR);
$stmt->bindParam(':direccion', $_POST["direccion"], PDO::PARAM_STR);

if($stmt->execute()==true)
    header("Location: PagCrear.php");
?>
