package javaBD;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Color;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BDOrdenadores extends javax.swing.JFrame {
    
    public static DB db;
    public static Ordenador ordenador = new Ordenador();
    
    public BDOrdenadores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        añadirViajero = new javax.swing.JButton();
        eliminarViajero = new javax.swing.JButton();
        modificarViajero = new javax.swing.JButton();
        verViajeros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableObject = new javax.swing.JTable();
        ENombre = new javax.swing.JTextField();
        EModelo = new javax.swing.JTextField();
        EPrecio = new javax.swing.JTextField();
        EMarca = new javax.swing.JTextField();
        EStock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Ordenadores Premium");

        añadirViajero.setText("Añadir Ordenador");
        añadirViajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                añadirViajeroMouseClicked(evt);
            }
        });

        eliminarViajero.setText("Eliminar ordenador");
        eliminarViajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarViajeroMouseClicked(evt);
            }
        });

        modificarViajero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        modificarViajero.setText("Modificar Ordenador");
        modificarViajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarViajeroMouseClicked(evt);
            }
        });

        verViajeros.setText("Mostrar Todos");
        verViajeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verViajerosMouseClicked(evt);
            }
        });

        tableObject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Modelo", "Marca", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tableObject);

        jLabel2.setText("Nombre");

        jLabel3.setText("Modelo");

        jLabel4.setText("Marca");

        jLabel5.setText("Precio");

        jLabel6.setText("Stock");

        EFiltrar.setText("Filtrar por Modelo");
        EFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EFiltrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ENombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarViajero, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(añadirViajero, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarViajero, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EStock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verViajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ENombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(añadirViajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(modificarViajero)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarViajero)
                        .addGap(18, 18, 18)
                        .addComponent(verViajeros)
                        .addGap(18, 18, 18)
                        .addComponent(EFiltrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirViajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirViajeroMouseClicked

            //Extrae información de los EditText
            boolean validado=true;
            ordenador.nombre = ENombre.getText();
            if((ordenador.nombre.equals(""))){
                validado=false;
            }
            ordenador.modelo = EModelo.getText();
            if((ordenador.modelo.equals(""))){
                validado=false;
            }
            ordenador.marca = EMarca.getText();
            if((ordenador.marca.equals(""))){
                validado=false;
            }
            ordenador.precio = EPrecio.getText();
            if((ordenador.precio.equals(""))){
                validado=false;
            }
            ordenador.stock = EStock.getText();
            if((ordenador.stock.equals(""))){
                validado=false;
            }
        
        //Inserta un registro
        if(!validado){
            JOptionPane.showMessageDialog(null, "Debes insertar todos los campos");
        }
        else if(!(ordenador.stock.matches("[0-9]+"))||(!(ordenador.precio.matches("[0-9]+")))){
            JOptionPane.showMessageDialog(null, "Solo puedes insertar números");
        }
        else{
            insertarOrdenador(db,"ordenadores",ordenador);
            mostrarColeccion(db, "ordenadores");
        }
        
        
    }//GEN-LAST:event_añadirViajeroMouseClicked

    private void eliminarViajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarViajeroMouseClicked
        
        //Eliminar Viajero aquí
        ordenador.modelo=EModelo.getText();
        borrarOrdenador(db,"ordenadores",ordenador);
        mostrarColeccion(db, "ordenadores");
        
    }//GEN-LAST:event_eliminarViajeroMouseClicked

    private void modificarViajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarViajeroMouseClicked
        
        //Modificar Viajero
        boolean validado=true;
            ordenador.nombre = ENombre.getText();
            if((ordenador.nombre.equals(""))){
                validado=false;
            }
            ordenador.modelo = EModelo.getText();
            ordenador.marca = EMarca.getText();
            if((ordenador.marca.equals(""))){
                validado=false;
            }
            ordenador.precio = EPrecio.getText();
            if((ordenador.precio.equals(""))){
                validado=false;
            }
            ordenador.stock = EStock.getText();
            if((ordenador.stock.equals(""))){
                validado=false;
            }
        
        //Inserta un registro
        if(!validado){
            JOptionPane.showMessageDialog(null, "Debes insertar todos los campos");
        }
        else if(!(ordenador.stock.matches("[0-9]+"))||(!(ordenador.precio.matches("[0-9]+")))){
            JOptionPane.showMessageDialog(null, "Solo puedes insertar números");
        }
        else{
            actualizarOrdenador(db,"ordenadores",ordenador);
            mostrarColeccion(db, "ordenadores");
        }
        
        
        
    }//GEN-LAST:event_modificarViajeroMouseClicked

    private void verViajerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verViajerosMouseClicked
        
        //Ver todos los viajeros
        mostrarColeccion(db, "ordenadores");
        
    }//GEN-LAST:event_verViajerosMouseClicked

    private void EFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFiltrarMouseClicked
        
        //Modificar Viajero
        ordenador.nombre=ENombre.getText();
        ordenador.modelo=EModelo.getText();
        ordenador.marca=EMarca.getText();
        ordenador.precio=EPrecio.getText();
        ordenador.stock=EStock.getText();
        
        buscarPorModelo(db, "ordenadores", ordenador);
        
    }//GEN-LAST:event_EFiltrarMouseClicked
    
    public static MongoClient crearConexion() {
      MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException ex) {
            System.out.println("No ha podido conectar con la base de datos");
        }
      return mongo;
  }  
    
    public static void main(String args[]) {
        
        //Crea la conexión con la BD
        MongoClient mongo = crearConexion();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BDOrdenadores().setVisible(true);
                
                if (mongo != null) {
                    db = mongo.getDB("TiendaBD");
                }

                
            }
        });
        
    }
    
    //Método encargado de añadir truplas a la BD
    public static void insertarOrdenador(DB db, String coleccion, Ordenador ordenador) {
        DBCollection colec = db.getCollection(coleccion);
        // Creamos un objeto con los parámetros pasados
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre", ordenador.nombre);
        documento.put("modelo", ordenador.modelo);
        documento.put("marca", ordenador.marca);
        documento.put("precio", ordenador.precio);
        documento.put("stock", ordenador.stock);

        // Insertamos el objeto (documento)
        colec.insert(documento);
    }
    
    //Método encargado de borrar
    public static void borrarOrdenador(DB db, String coleccion,Ordenador ordenador) {
        DBCollection colec = db.getCollection(coleccion);
        colec.remove(new BasicDBObject().append("modelo", ordenador.modelo));
    }
    
    //Método que modifica a través de un modelo
    public static void actualizarOrdenador (DB db, String coleccion, Ordenador ordenador) {
        
        //Accede a la BD
        DBCollection colec = db.getCollection(coleccion);
        
        //Información a remplazar
        BasicDBObject actualizarNombre = new BasicDBObject();
        actualizarNombre.append("$set",new BasicDBObject().append("nombre",ordenador.nombre));
        //Información a remplazar
        BasicDBObject actualizarMarca = new BasicDBObject();
        actualizarMarca.append("$set",new BasicDBObject().append("marca",ordenador.marca));
        //Información a remplazar
        BasicDBObject actualizarPrecio = new BasicDBObject();
        actualizarPrecio.append("$set",new BasicDBObject().append("precio",ordenador.precio));
        //Información a remplazar
        BasicDBObject actualizarStock = new BasicDBObject();
        actualizarStock.append("$set",new BasicDBObject().append("stock",ordenador.stock));
        
        
        //Muestra en pantalla
        BasicDBObject busquedaPorModelo = new BasicDBObject();
        busquedaPorModelo.append("modelo",ordenador.modelo);
        
        //Realiza el update
        colec.updateMulti(busquedaPorModelo,actualizarNombre);
        colec.updateMulti(busquedaPorModelo,actualizarMarca);
        colec.updateMulti(busquedaPorModelo,actualizarPrecio);
        colec.updateMulti(busquedaPorModelo,actualizarStock);
        
    }
    
    //Muestra todos los ordenadores
    public static void mostrarColeccion(DB db, String coleccion) {
     
        // Obtenemos la coleccion de la base de datos que nos pasan
        DBCollection colec = db.getCollection(coleccion);

        // Consulta la colección y obtiene un objeto 'cursor' equivalente al ResultSet de SQL
        DBCursor cursor = colec.find();
        
        //Creo los objetos necesarios para atacar a la tabla
        DefaultTableModel model = (DefaultTableModel) tableObject.getModel();
        
        //Limpia la tabla para volver a mostrar
        model.setRowCount(0);
        
        //Indícamos a la tabla la cantidad de columnas
        model.setColumnIdentifiers(new Object[]{"nombre","modelo","marca","precio","stock"});
        
        // Recorremos el 'cursor' y pintamos los valores de los registros
        while(cursor.hasNext()) {
           
            DBObject obj = cursor.next();
            model.addRow(new Object[]{obj.get("nombre"),obj.get("modelo"),obj.get("marca"),obj.get("precio"),obj.get("stock")});
            
        }
        
    }
    
    //Busca el registro a través del módelo
    public static void buscarPorModelo(DB db, String coleccion, Ordenador ordenador) {
        DBCollection colect = db.getCollection("ordenadores");
        
        DefaultTableModel model = (DefaultTableModel) tableObject.getModel();
        
        //Limpia la tabla para volver a mostrar
        model.setRowCount(0);
        
        //Indícamos a la tabla la cantidad de columnas
        model.setColumnIdentifiers(new Object[]{"nombre","modelo","marca","precio","stock"});
        
        //Lo que se ha de remplazar
        BasicDBObject consulta= new BasicDBObject();
        consulta.put("modelo",ordenador.modelo);
        
        //Se realiza el update
        DBCursor cursor = colect.find(consulta);

        //Mostramos en pantalla
        while(cursor.hasNext()) {
          System.out.println("-- " + cursor.next().get("modelo") + " - " + cursor.curr().get("nombre"));
          
          DBObject obj = cursor.one();
          model.addRow(new Object[]{obj.get("nombre"),obj.get("modelo"),obj.get("marca"),obj.get("precio"),obj.get("stock")});
          
        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EFiltrar;
    private javax.swing.JTextField EMarca;
    private javax.swing.JTextField EModelo;
    private javax.swing.JTextField ENombre;
    private javax.swing.JTextField EPrecio;
    private javax.swing.JTextField EStock;
    private javax.swing.JButton añadirViajero;
    private javax.swing.JButton eliminarViajero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarViajero;
    private static javax.swing.JTable tableObject;
    private javax.swing.JButton verViajeros;
    // End of variables declaration//GEN-END:variables
}
