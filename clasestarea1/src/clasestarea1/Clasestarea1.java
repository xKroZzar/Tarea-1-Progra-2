
package clasestarea1;
import java.util.Date;

class OrdenCompra{
    private Date fecha;
    private String estado;
    Cliente cliente;
    OrdenCompra(Date x, String d, String Nombre, String Rut, String Dic){ // Se crea una orden de compra con fecha, estado y se asocia (Se hace un new cliente) a un cliente.
        fecha = x;                                                        // y cada cliente nuevo tiene su Nombre, rut y dirección.      
        estado = d;
        cliente= new Cliente(Nombre,Rut,Dic);
    }
    void detalles(){
        System.out.println(fecha+" "+ estado + " " + cliente.Detalles());
    }
}
class Cliente{
    private String nombre;
    private String rut;
    private Direccion dic;
    Cliente(String x, String d, String c){
        nombre=x;
        rut=d;
        dic= new Direccion(c);
    }
    String Detalles(){
       return nombre+" "+rut; 
    }
}
class Direccion{
    private String direccion;
    Direccion(String x){
        direccion = x;
    }
    String Detalles(){
        return direccion;
    }
}


public class Clasestarea1 {

   
    public static void main(String[] args) {
      Date fecha= new Date(2021,9,20);
      OrdenCompra Mercadolibre = new OrdenCompra(fecha, "enviado", "Cristobal", "20732101k", "ohiggins");
      Mercadolibre.detalles();
    }
    
}
