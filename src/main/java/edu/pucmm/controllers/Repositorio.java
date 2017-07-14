package edu.pucmm.controllers;

/**
 * Created by Jhon on 5/6/2017.
 */
public class Repositorio {
    private static Repositorio instance;
    private EstudianteDAO estudianteDAO;

    private Repositorio(){
        estudianteDAO = new EstudianteDAO();
    }

    public static Repositorio getInstance(){
        if (instance == null){
            instance = new Repositorio();
        }
        return instance;
    }

    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

}
