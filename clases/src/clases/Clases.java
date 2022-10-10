package clases;
import java.util.Date;
import java.util.ArrayList; 
class OrdenCompra{
    private Date fecha;
    private String estado;
    public ArrayList<DetalleOrden> ordenes;
    public Cliente cliente;
    public float totalIva,totalsinIva,totalPeso,totalPrecio,totaldevolver;
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
    void Pagar(Pago x){
                   
    }
    DocTributario generarDoc(String a,String b, Date c,Direccion d, int e){
        switch(e){
            case 1:
                Boleta bol = new Boleta(a,b,c,d);
                return bol;
            case 2:
                Factura fac = new Factura (a,b,c,d);
                return fac;
            default:
                System.out.println("Error, marque 1 o 2 para boleta o factura respectivamente");
                return null;
        }
    
    }
    
    float calcPrecio(){
        for(int i = 0; i < ordenes.size(); i++) {
            totalPrecio=totalPrecio+ordenes.get(i).calcPrecio();
        }
        totaldevolver=totalPrecio;
        totalPrecio=0;
        return totaldevolver;
    }
    float calcIva(){
        for (int i = 0; i < ordenes.size(); i++) {
                totalIva=totalIva+ordenes.get(i).calcIva();
        }
        return totalIva;
    }
    float calcPrecioSinIva(){
        for (int i = 0; i < ordenes.size(); i++) {
                totalsinIva=totalsinIva+ordenes.get(i).calcPrecioSinIva();
        }
        return totalsinIva;
    }
    float calcPeso(){
        for (int i = 0; i < ordenes.size(); i++) {
                totalPeso=totalPeso+ordenes.get(i).calcPeso();
        }
       return totalPeso;
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
    float calcPrecio(){
        return (float)((cantidad*copia.entregarprecio())+cantidad*copia.entregarprecio()*0.19);
    }
    float calcPrecioSinIva(){
        return (float)(cantidad*copia.entregarprecio());
    }
    float calcIva(){
        return (float)(cantidad*copia.entregarprecio()*0.19);
    }
    float calcPeso(){
        return (float)(cantidad*copia.entregarpeso());
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
    private float devol;
    Efectivo(float a, Date b){
        super(a,b);
        devol=a;
    }
    void calcDevolucion(OrdenCompra x){
       if(devol > x.calcPrecio()){
          System.out.println("El monto a devolver es de: "+(devol-x.calcPrecio()));
       }else{
        System.out.println("Monto insuficiente");
       
       }
 
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
       Date fecha = new Date();
       Efectivo Pesos = new Efectivo((float)10000,fecha);
       Direccion Casa = new Direccion("Ohiggins 1504");
       Direccion MiCasa = new Direccion("Lomas San Sebastian");
       Cliente cliente = new Cliente("Miguel Rodriguez","19.203.232-k",Casa);
       Cliente cliente1= new Cliente("Nicolas Dominic","20.732.232-9",MiCasa);
       OrdenCompra Paris = new OrdenCompra(fecha,"Pidiendo",cliente);
       OrdenCompra MallDelTrebol = new OrdenCompra(fecha,"Pagar",cliente1);
       Articulo polera1 = new Articulo((float)0.23,"Polera Dc","Polera Dc negra manga corta",(float)2000);
       Articulo Zapatilla1 = new Articulo((float)0.52,"Zapatilla DC","Zapatilla Dc x Starwars",(float)7400);
       Articulo polera2 = new Articulo((float)0.25,"Polera Gap","Polera Gap negra manga larga",(float)2400);
       Articulo Tecnologia = new Articulo((float)25,"Televisor Sony","Televisor Sony 300 pulgadas",(float)1400);
       Paris.agregarArticulo(1, polera1);
       Paris.agregarArticulo(1,Zapatilla1);
       MallDelTrebol.agregarArticulo(1, Tecnologia);
       MallDelTrebol.agregarArticulo(1, polera2);
       Pesos.calcDevolucion(Paris);
       Pesos.calcDevolucion(MallDelTrebol);
       Paris.Pagar(Pesos);
       MallDelTrebol.Pagar(Pesos);
       DocTributario factura = Paris.generarDoc("a", "b",fecha, Casa, 2);
       
    }  
}
