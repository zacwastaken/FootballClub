package model;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Specifies on the players' traits and behaviors.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Player extends Employee implements Calculations{

    private int number;
    private int goals;
    private double averageRating;
    private String position;
    private int posIndex;

    /**
     * @see Employee#Employee(String, String, int) Employee Constructor
     * @param number The shirt number of the player. <b>Must be positive between 0 and 99</b>.<br>
     * @param goals The number of goals in the club pf the player. <b>Must be positive</b>.<br>
     * @param averageRating The average rating of the player. <b>Must be between 0 and 5</b>.<br>
     * @param posIndex The index to fetch the position of the player. <b>Must be between 0 and 3</b>.<br>
     */
    public Player(String name, String id, int salary, int number, int goals, double averageRating, int posIndex) {
        super(name,id,salary);
        this.number = number;
        this.goals = goals;
        this.averageRating = averageRating;
        this.posIndex = posIndex;
        position = FieldPosition.get(posIndex).getName();
        setType("Jugador");
    }

    @Override
    public String showInfo() {
      NumberFormat comma = NumberFormat.getInstance();
      comma.setGroupingUsed(true);
      return "" +
            "*------------------------------------------------------------------------------*\n" +
            "*Nombre del empleado: " + getName() + "\n" +
            "*ID: " + getId() + "\n" +
            "*Salario: $" + comma.format(getSalary()) + "\n" +
            "*Tipo de empleado: " + getType() + "\n" +
            "*Estado: " + legibleStatus() + "\n" +
            "*Equipo: " + getTeam() + "\n" +
            "*Posicion y numero: " + position + " (" + number + ")" + "\n" +
            "*Precio de mercado: $" + marketPrice() + "\n" +
            "*Nivel de estrella: " + String.format("%.2f",starLevel());
    }

    @Override
    public String marketPrice() {
        double price = 0;
        switch (FieldPosition.get(posIndex)) {
            case GOALKEEPER:
                price = (getSalary() * 12) + (averageRating * 150);
                break;
            case DEFENDER:
                price = (getSalary() * 13) + (averageRating * 125) + (goals * 100);
                break;
            case MIDFIELD:
                price = (getSalary() * 14) + (averageRating * 135) + (goals * 125);
                break;
            case FORWARD:
                price = (getSalary() * 15) + (averageRating * 145) + (goals * 150);
                break;
        }
        DecimalFormat doppelComma = new DecimalFormat("#.##");
        doppelComma.setGroupingUsed(true);
        doppelComma.setGroupingSize(3);
        return doppelComma.format(price);
    }

    @Override
    public double starLevel() {
        double level = 0;
        switch (FieldPosition.get(posIndex)) {
            case GOALKEEPER:
                level = averageRating * 0.9;
                break;
            case DEFENDER:
                level = (averageRating * 0.9) + (goals / 100);
                break;
            case MIDFIELD:
                level = (averageRating * 0.9) + (goals / 90);
                break;
            case FORWARD:
                level = (averageRating * 0.9) + (goals / 80);
                break;
        }
        return level;
    }

    //Getters

    /**
     * @return the number
     */
    public int getNumber() {
    	return number;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
    	return goals;
    }

    /**
     * @return the averageRating
     */
    public double getAverageRating() {
    	return averageRating;
    }

    /**
     * @return the posIndex
     */
    public int getPosIndex() {
    	return posIndex;
    }

    /**
     * @return the position
     */
    public String getPosition() {
    	return position;
    }

    //Setters

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
    	this.number = number;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
    	this.goals = goals;
    }

    /**
     * @param posIndex the position to set
     */
    public void setPosition(int posIndex) {
    	this.posIndex = posIndex;
      position = FieldPosition.get(posIndex).getName();
    }

    /**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(double averageRating) {
    	this.averageRating = averageRating;
    }
}
