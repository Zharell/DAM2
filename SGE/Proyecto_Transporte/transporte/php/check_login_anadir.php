<?php
//Crea la sesión y comprueba que el usuario está logueado
session_start();
    if (!isset($_SESSION['login']) || !$_SESSION['login']) {
        header("Location: ../../../../login/index.html");
    } 
?>