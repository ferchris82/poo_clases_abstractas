package org.chrisferdev.pooclasesbstractas.form;

import org.chrisferdev.pooclasesbstractas.form.elementos.*;
import org.chrisferdev.pooclasesbstractas.form.elementos.select.Opcion;
import org.chrisferdev.pooclasesbstractas.form.validador.*;


import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        lenguaje.addOpcion(new Opcion("1", "Java"))
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected())
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo"){
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value=\"" +this.valor+ "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado");
        username.setValor("chrisfer");
        password.setValor("12345g");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... más de 10 años de experiencia ...");
        //java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);
                }
        });
    }
}
