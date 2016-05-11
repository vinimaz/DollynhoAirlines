package dollynho;

import javafx.beans.property.*;

/**
 * Created by vinimaz on 5/10/16.
 */
public class Usuario {
    private IntegerProperty id;
    private ObjectProperty<InterfaceCli> refCli;
    private FloatProperty precoAnterior;
    private StringProperty descricao;

    public IntegerProperty getId(){return id;}
    public StringProperty getRefCli(){return new SimpleStringProperty(refCli.getName());}
    public FloatProperty getPrecoAnterior(){return precoAnterior;}
    public StringProperty getDescricao(){return descricao;}
}
