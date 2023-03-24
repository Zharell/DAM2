SELECT * FROM PEDIDOS;
SELECT * FROM DETALLE;
SELECT * FROM ARTICULOS;
DROP TABLE TEMP;

CREATE TABLE TEMP (
ARTICULO NUMBER(5),
MENSAJE VARCHAR2(15)
);

DECLARE

	V_ARTICULO NUMBER:=&ARTICULO;
	V_STOCK NUMBER:=0;
	V_CLIENTE NUMBER:=&CLIENTE;
	CONT NUMBER:=8;
	
BEGIN
	WHILE (CONT<16) LOOP
		SELECT STOCK INTO V_STOCK FROM ARTICULOS WHERE IDART=V_ARTICULO;			
		IF (V_STOCK>0) THEN
			INSERT INTO TEMP VALUES (V_ARTICULO,'VENDIDO');
			UPDATE ARTICULOS SET STOCK=STOCK-1 
			WHERE IDART=V_ARTICULO;
			DBMS_OUTPUT.PUT_LINE('Se ha vendido correctamente');
			INSERT INTO PEDIDOS VALUES (CONT,V_CLIENTE,SYSDATE,SYSDATE);
			INSERT INTO DETALLE VALUES (CONT,V_ARTICULO,1);
		ELSE 
			DBMS_OUTPUT.PUT_LINE('No hay existencias del producto');
			INSERT INTO TEMP VALUES (V_ARTICULO,'No hay stock');
			INSERT INTO PEDIDOS VALUES (CONT,V_CLIENTE,SYSDATE,SYSDATE);
			INSERT INTO DETALLE VALUES (CONT,V_ARTICULO,0);
		END IF;	
		CONT:=CONT+1;
	END LOOP;	
END;
/

SELECT * FROM PEDIDOS;
SELECT * FROM DETALLE;
SELECT * FROM ARTICULOS;