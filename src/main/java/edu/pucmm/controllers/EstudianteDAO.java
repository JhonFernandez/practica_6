package edu.pucmm.controllers;

import edu.pucmm.encapsulacion.Estudiante;

import java.util.ArrayList;

/**
 * Created by Jhon on 5/6/2017.
 */
public class EstudianteDAO {
    private ArrayList<Estudiante> estudiantes;
    private int id = 1;

    public EstudianteDAO (){
        estudiantes = new ArrayList<>();
    }

    public Estudiante findEstudianteById(int id){
        for (Estudiante estudiante :
                estudiantes) {
            if (estudiante.getId() == id){
                return estudiante;
            }
        }
        return null;
    }

    public  ArrayList<Estudiante> findEstudiantes(){
        return estudiantes;
    }

    public void create(Estudiante estudiante){
        estudiante.setId(this.id);
        estudiantes.add(estudiante.clone());
        this.id++;
    }

    public void edit(Estudiante estudiante){
        for (Estudiante est :
                estudiantes) {
            if (est.getId() == estudiante.getId()){
                est.setNombre(estudiante.getNombre());
                est.setApellido(estudiante.getApellido());
                est.setMatricula(estudiante.getMatricula());
                est.setTelefono(estudiante.getTelefono());
            }
        }
    }

    public void destroy(Estudiante estudiante){
        for (int i=0;i<estudiantes.size();i++){
            if (estudiantes.get(i).getId() == estudiante.getId()){
                estudiantes.remove(i);
                System.out.println(i);
                System.out.println(estudiantes);
                return;
            }
        }
    }

    public int size(){
        return estudiantes.size();
    }


}
