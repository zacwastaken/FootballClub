package model;

abstract public class Employee {
  String name;
  String id;
  int salary;
  boolean status;

  /**
   * @param name The name of the employee.<br>
   * @param id The id of the employee.<br>
   * @param salary The salary of the employee.<br>
   * @param status Wether the employee is active in a team or not.<br>
   */
  public Employee(String name, String id, int salary, boolean status) {
      this.name = name;
      this.id = id;
      this.salary = salary;
      this.status = status;
  }

  public abstract String showInfo();

  //Getters

  /**
   * @return the name
   */
  public String getName() {
  	return name;
  }

  /**
   * @return the id
   */
  public String getId() {
  	return id;
  }

  /**
   * @return the salary
   */
  public int getSalary() {
  	return salary;
  }

  /**
   * @return the status
   */
  public boolean getStatus() {
    return status;
  }

  //Setters

  /**
   * @param name the name to set
   */
  public void setName(String name) {
  	this.name = name;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
  	this.id = id;
  }

  /**
   * @param salary the salary to set
   */
  public void setSalary(int salary) {
  	this.salary = salary;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(boolean status) {
  	this.status = status;
  }
}
