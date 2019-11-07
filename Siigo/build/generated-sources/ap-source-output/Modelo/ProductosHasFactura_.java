package Modelo;

import Modelo.Factura;
import Modelo.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-06T20:42:59")
@StaticMetamodel(ProductosHasFactura.class)
public class ProductosHasFactura_ { 

    public static volatile SingularAttribute<ProductosHasFactura, Productos> Productos;
    public static volatile SingularAttribute<ProductosHasFactura, String> id;
    public static volatile SingularAttribute<ProductosHasFactura, Factura> Factura;
    public static volatile SingularAttribute<ProductosHasFactura, Float> proValorUnidad;
    public static volatile SingularAttribute<ProductosHasFactura, Integer> proCantidad;

}