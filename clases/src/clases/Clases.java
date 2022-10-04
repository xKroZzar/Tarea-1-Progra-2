
package clases;
import java.util.Date;
import java.util.ArrayList; 
class OrdenCompra{
    private Date fecha;
    private String estado;
    public DetalleOrden orden1;
    OrdenCompra(Date a, String b, Cliente d,int c){
        fecha = a;
        estado = b;
        orden1 = new DetalleOrden(c);
    }
    void detalles(){
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float  precio;
    public float total=0;
    Articulo(float a, String b, String c, float d){
        peso=a;
        nombre=b;
        descripcion=c;
        precio=d;
        total=total+d;
    }
    void r(){
    System.out.println(total);
    }
}
class DetalleOrden{
    private int cantidad;
    public ArrayList<Articulo> articulos;
    DetalleOrden(int a){
        cantidad=a;
        articulos = new ArrayList<Articulo>(cantidad);
    }
    void AgregarArticulo(Articulo x){ // Para meter los articulos a la Arraylist de cantidad x.
        articulos.add(x);
    }
    void calcPrecio(){
        
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
}/*
class Efectivo extends Pago{}    // Maquetas, terminar cuando terminemos de crear articulos y Detalle orden
class Traferencia extends Pago{}
class Tarjeta extends Pago{}
*/
public class Clases {
    public static void main(String[] args) {
       
    }
    
}
