/*
 * Dawn Myers
 * ITDEV 140 Mequon 2016
 */
package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Dawn
 */
public class PokemonController {
    private PokemonView pokeView = new PokemonView();
    PokemonModel pokemon;
    
    //Constructor that accepts view and model object. Not happy with the View making its way in here
    public PokemonController(PokemonView view, PokemonModel model) 
    {
        this.pokeView = view;
        this.pokemon = model;  
        pokeView.setVisible(true);      
        pokeView.setDefaultCloseOperation(pokeView.EXIT_ON_CLOSE);
        
        pokeView.prevButtonActionListener(new PrevPokemonListener());
        pokeView.nextButtonActionListener(new NextPokemonListener());
        getNewPokemon();
    }
    
    //sends text of the current pokemon over to the view
    public void getNewPokemon()
    {
        pokeView.setPokemonText(pokemon.getId(), pokemon.getName(), pokemon.getHeight(), pokemon.getWeight());
    }
    
    //listens for a button to be pressed, and tells the model to get a new pokemon
    class NextPokemonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            try{
                pokemon.getNextPokemon();  
            }
            catch(Exception er)
            {
                System.out.println(er);
            }                 
            getNewPokemon();
        }        
    }
    
    //listens for a button to be pressed, and tells the model to get a new pokemon
    class PrevPokemonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
                pokemon.getPrevPokemon();  
            }
            catch(Exception er)
            {
                System.out.println(er);
            }
            getNewPokemon();
        }
    }
    
}
