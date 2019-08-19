/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Clase Persona desde donde se manipulan los datos de busqueda de las persomas
 * @author Natalia Beltran
 * @version 1.0
 */
public class Person implements Comparable<Person> {
    protected String name;
 /**
 * Clase General de la clase Person 
 * @since version 1.0
 */
    public Person() {
    }
 /**
 * Los metodos a continuación escriben, guardan y comparan nombres
 * @since version 1.0
 */
    public Person(String name) {
        setName(name);
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
 
        this.name = name;
    }
 
    public String toString() {
        return this.name;
    }
 
    public int compareTo(Person another) {
        return this.name.compareTo(another.getName());
    }
 
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Person) {
            Person another = (Person) obj;
            if (this.name.equals(another.getName())) {
                return true;
            }
        }
 
        return false;
    }
 
    public int hashCode() {
        return this.name.hashCode();
    }
}