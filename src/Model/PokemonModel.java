/*
 * Dawn Myers
 * ITDEV 140 Mequon 2016
 */
package Model;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author Dawn
 */
public class PokemonModel {
    
    private int id = 1;                     //This is the ID of the Pokemon in the Pokedex
    private String name = "Bulbasaur";      //Pokemon's name
    private int height = 7;                 //Height of the Pokemon in decimeters
    private int weight = 69;                //Weight of the Pokemon 
    private Connection conn;                //Connection used to connect to PokemonDB
    
    
    //Constructor used to initiate the database connection
    public PokemonModel (String fileName) throws IOException, SQLException, ClassNotFoundException
    { 
        PokemonDataSource.init(fileName);
    }    
    
    //Gets the next Pokemon from the database. These two methods could be combined
    public void getNextPokemon() throws IOException, SQLException, ClassNotFoundException
    {
        conn = PokemonDataSource.getConnection();
        PreparedStatement stat = conn.prepareStatement("SELECT * FROM Pokemon WHERE Id = ?");
        stat.setInt(1, id+1);        
        ResultSet rs = stat.executeQuery();
        
        while(rs.next())
        {
            id = rs.getInt("Id");
            name = rs.getString("Name");
            height = rs.getInt("Height");
            weight = rs.getInt("Weight");
        }
        
        conn.close();
    }
    
    //Gets the previous Pokemon from the database. 
    public void getPrevPokemon() throws IOException, SQLException, ClassNotFoundException
    {
        conn = PokemonDataSource.getConnection();
        PreparedStatement stat = conn.prepareStatement("SELECT * FROM Pokemon WHERE Id = ?");
        stat.setInt(1, id-1);        
        ResultSet rs = stat.executeQuery();
        
        while(rs.next())
        {
            id = rs.getInt("Id");
            name = rs.getString("Name");
            height = rs.getInt("Height");
            weight = rs.getInt("Weight");
        }
        
        conn.close();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
