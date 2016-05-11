package dollynho;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * Created by vinimaz and carlos on 5/5/16.
 */
public class Hospedagem {

    private IntegerProperty             quartos;
    private FloatProperty               precoQuarto;
    private StringProperty              hotel;
    private StringProperty              cidade;
    private ArrayList<LocalDate>        datasUsadas;
    private int                         id;


    public Hospedagem(String cidade, String hotel, int quartos, float preco, int id){
        this.id          = id;
        this.datasUsadas = new ArrayList<LocalDate>();
        this.cidade      = new SimpleStringProperty(cidade);
        this.hotel       = new SimpleStringProperty(hotel);
        this.quartos     = new SimpleIntegerProperty(quartos);
        this.precoQuarto = new SimpleFloatProperty(preco);
    }

    public IntegerProperty getQuartosProperty(){return quartos;}
    public FloatProperty getPrecoQuartoProperty(){return precoQuarto;}
    public StringProperty getHotelProperty(){return hotel;}
    public StringProperty getCidadeProperty(){return cidade;}
    public int getId(){return id;}
}
