package Modelo;

import Modelo.Empresa;
import Modelo.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-06T20:42:59")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Float> proPrecio;
    public static volatile SingularAttribute<Productos, Persona> Persona;
    public static volatile SingularAttribute<Productos, String> proNombre;
    public static volatile SingularAttribute<Productos, Empresa> idEmpresa;
    public static volatile SingularAttribute<Productos, Integer> id;
    public static volatile SingularAttribute<Productos, String> proDescripcion;

}