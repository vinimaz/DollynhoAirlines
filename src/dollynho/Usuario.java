package dollynho;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

/**
 * Created by vinimaz on 5/10/16.
 */
public class Usuario {
    private IntegerProperty id;
    private ObjectProperty<InterfaceCli> refCli;
    private FloatProperty precoAnterior;

    public IntegerProperty getId(){return id;}
    public ObjectProperty<InterfaceCli> getRefCli(){return refCli;}
    public FloatProperty getPrecoAnterior(){return precoAnterior;}
}
