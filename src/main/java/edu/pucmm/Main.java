package edu.pucmm;

import edu.pucmm.controllers.Repositorio;
import edu.pucmm.encapsulacion.Estudiante;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

/**
 * Created by Jhon on 4/6/2017.
 */
public class Main {
    private static Estudiante estudianteActual;
    public static void main(String[] args) {

        //Seteando el puerto en Heroku
        port(getHerokuAssignedPort());

        //indicando los recursos publicos.
        //staticFiles.location("/META-INF/resources"); //para utilizar los WebJars.
        staticFileLocation("/publico");

        //Indicando la carpeta por defecto que estaremos usando.
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        //Agregando Estudiantes iniciales a la lista
        Repositorio.getInstance().getEstudianteDAO().create(new Estudiante(1,"20120945","jhon","fernandez almanzar","8092331802"));
        Repositorio.getInstance().getEstudianteDAO().create(new Estudiante(2,"20121122","marlon","almanzar","8295858252"));

        if (Repositorio.getInstance().getEstudianteDAO().size()>0){
            estudianteActual = Repositorio.getInstance().getEstudianteDAO().findEstudiantes().get(0).clone();
        }

        get("/", (request, response) -> {
            System.out.println(1);
            Map<String, Object> attributes = new HashMap<>();
            System.out.println(2);
            attributes.put("listaEstudiante", Repositorio.getInstance().getEstudianteDAO().findEstudiantes());
            System.out.println(3);
            return new ModelAndView(attributes, "/listarEstudiantes.ftl");
        },freeMarkerEngine);

        post("/ver",(request, response) -> {
            estudianteActual.setId(Integer.parseInt(request.queryParams("id")));
            estudianteActual.setNombre(request.queryParams("nombre"));
            estudianteActual.setApellido(request.queryParams("apellido"));
            estudianteActual.setTelefono(request.queryParams("telefono"));
            estudianteActual.setMatricula(request.queryParams("matricula"));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudianteActual);
            return new ModelAndView(attributes, "/verEstudiante.ftl");
        },freeMarkerEngine);


        get("/ver",(request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudianteActual);
            return new ModelAndView(attributes, "/verEstudiante.ftl");
        },freeMarkerEngine);

        get("/agregar" , (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "/agregarEstudiante.ftl");
        },freeMarkerEngine);

        post("/agregar" , (request, response) -> {

            estudianteActual.setNombre(request.queryParams("nombre"));
            estudianteActual.setApellido(request.queryParams("apellido"));
            estudianteActual.setTelefono(request.queryParams("telefono"));
            estudianteActual.setMatricula(request.queryParams("matricula"));
            Repositorio.getInstance().getEstudianteDAO().create(estudianteActual.clone());

            estudianteActual = Repositorio.getInstance().getEstudianteDAO().findEstudiantes().get(Repositorio.getInstance().getEstudianteDAO().size()-1);
            estudianteActual = Repositorio.getInstance().getEstudianteDAO().findEstudiantes().get(0).clone();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaEstudiante", Repositorio.getInstance().getEstudianteDAO().findEstudiantes());
            System.out.println(Repositorio.getInstance().getEstudianteDAO().findEstudiantes());
            return new ModelAndView(attributes, "/listarEstudiantes.ftl");
        },freeMarkerEngine);

        get("/editar",(request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudianteActual);
            return new ModelAndView(attributes, "/editarEstudiante.ftl");
        },freeMarkerEngine);

        post("/editar" , (request, response) -> {

            estudianteActual.setId(Integer.parseInt(request.queryParams("id")));
            estudianteActual.setNombre(request.queryParams("nombre"));
            estudianteActual.setApellido(request.queryParams("apellido"));
            estudianteActual.setTelefono(request.queryParams("telefono"));
            estudianteActual.setMatricula(request.queryParams("matricula"));
            Repositorio.getInstance().getEstudianteDAO().edit(estudianteActual);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaEstudiante", Repositorio.getInstance().getEstudianteDAO().findEstudiantes());
            return new ModelAndView(attributes, "/listarEstudiantes.ftl");

        },freeMarkerEngine);

        post("/eliminar",  (request, response) -> {
            estudianteActual.setId(Integer.parseInt(request.queryParams("id")));
            estudianteActual.setNombre(request.queryParams("nombre"));
            estudianteActual.setApellido(request.queryParams("apellido"));
            estudianteActual.setTelefono(request.queryParams("telefono"));
            estudianteActual.setMatricula(request.queryParams("matricula"));
            Repositorio.getInstance().getEstudianteDAO().destroy(estudianteActual);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaEstudiante", Repositorio.getInstance().getEstudianteDAO().findEstudiantes());
            return new ModelAndView(attributes, "/listarEstudiantes.ftl");
        },freeMarkerEngine);

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}

