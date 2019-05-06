package com.maven.app;

import com.maven.model.Person;

public class App {
  public static void main(String[] args) {
    Person person = new Person();
    person.setId(1);
    person.setName("Cristian Camilo");
    person.setAge(23);    
    //System.out.println(person.getId() + " " + person.getName());
    System.out.println(person.toString());
  }
}
