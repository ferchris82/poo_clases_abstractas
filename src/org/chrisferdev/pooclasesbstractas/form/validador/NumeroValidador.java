package org.chrisferdev.pooclasesbstractas.form.validador;

public class NumeroValidador extends Validador {

    protected String mensaje = "el campo debe ser un número";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return null;
    }

    @Override
    public boolean esValido(String valor) {
        try{
            Integer.parseInt(valor);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
