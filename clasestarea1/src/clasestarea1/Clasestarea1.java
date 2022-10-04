
package clasestarea1;
import java.util.Date;

class OrdenCompra{
    private Date fecha;
    private String estado;
    OrdenCompra(Date a, String b, Cliente d){
        fecha = a;                                                             
        estado = b;
    }
    void detalles(){
    }
}
class Cliente{
    private String nombre;
    private String rut;
    private Direccion dic;
    Cliente(String a, String b, Direccion c){
        nombre=a;
        rut=b;
        dic=c;
    }
}
class Direccion{
    private String direccion;
    Direccion(String x){
        direccion = x;
    }
}class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    DocTributario(String a,String b, Date c,Direccion d){
        numero=a;
        rut=b;
        fecha=c;
    }
}class Boleta extends DocTributario{
    Boleta(String a,String b, Date c, Direccion d){
        super(a,b,c,d);
    }
}
class Factura extends DocTributario{
    Factura(String a, String b, Date c, Direccion d){
        super(a,b,c,d);
    }
}
class Pago{
    private float monto;
    private Date fecha;
    Pago(Float a, Date b){
        monto=a;
        fecha=b;
    }  
}
class Efectivo extends Pago{}    // Maquetas, terminar cuando terminemos de crear articulos y Detalle orden
class Traferencia extends Pago{}
class Tarjeta extends Pago{}

public class Clasestarea1 {

   
    public static void main(String[] args) {
        Date fecha = new Date(1021,9,29);
        Direccion dic1 = new Direccion("ohiggns");
        Cliente us1= new Cliente("Raul","Figueroa",dic1);
        
    }
    
}
