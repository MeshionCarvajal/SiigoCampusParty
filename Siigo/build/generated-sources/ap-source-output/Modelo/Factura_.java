package Modelo;

import Modelo.Empresa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-06T20:42:59")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Integer> facTotal;
    public static volatile SingularAttribute<Factura, Empresa> Empresa;
    public static volatile SingularAttribute<Factura, Integer> facDescuento;
    public static volatile SingularAttribute<Factura, Date> facFecha;
    public static volatile SingularAttribute<Factura, String> facNumero;
    public static volatile SingularAttribute<Factura, Integer> id;
    public static volatile SingularAttribute<Factura, Integer> facIva;

}