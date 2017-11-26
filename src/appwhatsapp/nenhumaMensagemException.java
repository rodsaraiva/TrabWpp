/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appwhatsapp;

/**
 *
 * @author leona
 */
public class nenhumaMensagemException extends Exception {

    /**
     * Creates a new instance of <code>nenhumContatoException</code> without
     * detail message.
     */
    private String palavra;
    
    public nenhumaMensagemException() {
    }

    /**
     * Constructs an instance of <code>nenhumContatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public nenhumaMensagemException(String msg) {
        super(msg);
        this.palavra = msg;
    }

    @Override
    public String toString() {
        return "Não há nenhuma mensagem com \""+palavra+"\"";
    }
}
