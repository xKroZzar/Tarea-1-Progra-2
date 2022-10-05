package clases;
import java.util.Date;
import java.util.ArrayList; 
class OrdenCompra{
    private Date fecha;
    private String estado;
    public ArrayList<DetalleOrden> ordenes;
    public Cliente cliente;
    public float totalIva;
    OrdenCompra(Date a,String b,Cliente c){
        fecha=a;
        estado=b;
        cliente=c;
        ordenes= new ArrayList<DetalleOrden>();
    }
    void agregarArticulo(int a,Articulo b){
        DetalleOrden nuevoArticulo = new DetalleOrden(a,b);
        ordenes.add(nuevoArticulo);
    }
    void actualizarEstado(String a){
        estado=a;
    }
    void tamaño(){
        System.out.println(ordenes.size());
    }
    void calcPrecio(){
        for(int i = 0; i < ordenes.size(); i++) {
            ordenes.get(0).calcPrecio();
        }
    
    }
    void calcIva(){
        for (int i = 0; i < ordenes.size(); i++) {
                totalIva=totalIva+ordenes.get(i).calcIva();
        }
        System.out.println(totalIva);
    }
    void calcPrecioSinIva(){}
    void calcPeso(){}
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
    float entregarpeso(){
        return peso;
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
        System.out.println((cantidad*copia.entregarprecio())+cantidad*copia.entregarprecio()*0.19);
    }
    void calcPrecioSinIva(){
        System.out.println(cantidad*copia.entregarprecio());
    }
    float calcIva(){
        return (float)(cantidad*copia.entregarprecio()*0.19);
    }
    void calcPeso(){
        System.out.println(cantidad*copia.entregarpeso());
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

class Efectivo extends Pago{
    Efectivo(float a, Date b){
        super(a,b);
    }
    void calcDevolucion(){
    
    }
} 
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    Transferencia(float a, Date b, String ba, String num){
        super(a,b);
        banco=ba;
        numCuenta=num;
    }
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    Tarjeta(float a, Date b, String t, String n){
        super(a,b);
        tipo=t;
        numTransaccion=n;
    }
}

public class Clases {
    public static void main(String[] args) {
        Articulo Polera = new Articulo((float)50.5,"Ropa","ropa comoda",(float)1000);
        Articulo Zapatilla = new Articulo((float)12.5,"Zapatillas","zapatillas dc",(float)1000);
        Direccion casa = new Direccion("Cochrane");
        Cliente cliente1= new Cliente("Raul Figueroa","19.200.333-k",casa);
        Date fecha = new Date();
        OrdenCompra compra1ra = new OrdenCompra(fecha,"Enviado",cliente1);
        compra1ra.agregarArticulo(1, Polera);
        compra1ra.agregarArticulo(1,Zapatilla);
        compra1ra.tamaño();
        compra1ra.calcIva();
    }  
}
