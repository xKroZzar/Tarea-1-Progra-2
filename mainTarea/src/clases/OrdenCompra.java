package clases;

import java.util.ArrayList;
import java.util.Date;

public class OrdenCompra {
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
    DocTributario Pagar(Pago x,int d,String a,String b, Date c,Direccion f){
        switch(d){
            case 1:
                Boleta boleta = new Boleta(a,b,c,f);
                return boleta;
            case 2:
                Factura factura= new Factura(a,b,c,f);
                return factura;
            default:
                System.out.println("Porfavor reintente nuevamente, 1 para Boleta, 2 para factura");
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
