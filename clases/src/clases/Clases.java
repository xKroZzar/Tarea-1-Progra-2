package clases;
import java.util.Date;
import java.util.ArrayList; 
class OrdenCompra{
    private Date fecha;
    private String estado;
    OrdenCompra(Date a, String b, Cliente d,int c){
        fecha = a;
        estado = b;
    }    
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float  precio;
    Articulo(float a, String b, String c, float d){
        peso=a;
        nombre=b;
        descripcion=c;
        precio=d;
    }
    float entregarprecio(){
        return precio;
    }
    
}
class DetalleOrden{
    private int cantidad;
    public Articulo copia;
    DetalleOrden(int a, Articulo b){
        cantidad=a;
        copia = b;
    }
    void calcPrecio(){
        System.out.println(cantidad*copia.entregarprecio());
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
}
class DocTributario{
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
/*
class Efectivo extends Pago{}    // Maquetas, terminar cuando terminemos de crear articulos y Detalle orden
class Traferencia extends Pago{}
class Tarjeta extends Pago{}
*/

public class Clases {
    public static void main(String[] args) {  
    }    
}
