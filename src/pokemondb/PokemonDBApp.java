/*
 * Dawn Myers
 * ITDEV 140 Mequon 2016
 */
package pokemondb;
import Model.*;
import View.*;
import Controller.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Dawn
 */
public class PokemonDBApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
        // TODO code application logic here
        PokemonView pokeView = new PokemonView();           //creates new instance of PokemonView
        PokemonModel pokemon = new PokemonModel(args[0]);   //creates new instance of PokemonModel, passing in command line args
        PokemonController pokeController = new PokemonController(pokeView, pokemon);    //passes instances to the controller
    }
    
}
