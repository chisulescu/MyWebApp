package ro.gebs.myproject.shared.user;

import java.io.Serializable;

public class User implements Serializable {


    private String username;
    private String parola;
    private String nume;
    private String prenume;


    public User(){

    }


    public User(String username, String parola, String nume, String prenume){

        this.username=username;
        this.parola=parola;
        this.nume=nume;
        this.prenume=prenume;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setParola(String parola){
        this.parola=parola;
    }

    public void setNume(String nume){
        this.nume=nume;
    }

    public void setPrenume(String prenume){
        this.prenume=prenume;
    }

    public String getUsername(){
        return this.username;
    }

    public String getParola(){
        return this.parola;
    }

    public String getNume(){
        return this.nume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    public String getFullName(){
        return nume + " " + prenume;
    }



}
