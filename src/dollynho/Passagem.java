package dollynho;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by vinimaz and carlos on 5/5/16.
 */
public class Passagem {
    private FloatProperty               preco;
    private IntegerProperty             qtd;
    private StringProperty              origem, destino;
    private ObjectProperty<LocalDate>   dataIda;
    private int                         id;

    public Passagem(String origem, String destino, LocalDate dataIda, float preco, int qtd, int id){
        this.id             = id;
        this.dataIda        = new SimpleObjectProperty<LocalDate>(dataIda);
        this.preco          = new SimpleFloatProperty(preco);
        this.qtd            = new SimpleIntegerProperty(qtd);
        this.destino        = new SimpleStringProperty(destino);
        this.origem         = new SimpleStringProperty(origem);
        System.out.println("Passagem criada:");
        System.out.println(origem + " -> " + destino + " $" + preco);
        System.out.println("QTD: " + qtd +  " " + dataIda.getDayOfMonth() + "/" +
                dataIda.getMonth() + "/" + dataIda.getYear());
    }


    public StringProperty origemProperty(){return origem;}
    public StringProperty destinoProperty(){return destino;}
    public ObjectProperty<LocalDate> dataIdaProperty(){return dataIda;}
    public FloatProperty precoProperty(){return preco;}
    public IntegerProperty quantidadeProperty(){return qtd;}
    public int getId(){return id;}
}
