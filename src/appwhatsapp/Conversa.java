package appwhatsapp;

import java.io.Serializable;
import java.util.ArrayList;


public class Conversa implements Serializable{

    private String contato;
    protected ArrayList<Mensagem> listaMensagens = new ArrayList<>();
    private String vistoPorUltimo;

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getVistoPorUltimo() {
        return vistoPorUltimo;
    }

    public void setVistoPorUltimo(String vistoPorUltimo) {
        this.vistoPorUltimo = vistoPorUltimo;
    }

    public Conversa(String contato, String vistoPorUltimo) {
        this.contato = contato;
        this.vistoPorUltimo = vistoPorUltimo;
    }

    public void addMensagem(Mensagem m) {
        listaMensagens.add(m);
    }

    public ArrayList<Mensagem> Buscar(String palavra) throws nenhumaMensagemException{
        ArrayList<Mensagem> resultadoBusca = new ArrayList<Mensagem>();
        /*for (int i = 0; i < listaMensagens.size() ; i++) {
            if (listaMensagens.get(i).getTexto().contains(palavra)) {
                resultadoBusca.add(listaMensagens.get(i));
            }
        }*/
        resultadoBusca.removeAll(resultadoBusca);
        palavra.toLowerCase();
        for (Mensagem mensagem : listaMensagens) {
            if (mensagem.getTexto().toLowerCase().contains(palavra)) {
                resultadoBusca.add(mensagem);
            }
        }
        if (resultadoBusca.size() == 0) {
            throw new nenhumaMensagemException(palavra);
        }
        return resultadoBusca;
    }

    public StringBuilder TodaConversa() {
        StringBuilder todaConversa = new StringBuilder();
        /*for (int i = 0; i < listaMensagens.size(); i++) {
            todaConversa.append(listaMensagens.get(i));
        }*/
        todaConversa.delete(0, todaConversa.length());
        for (Mensagem conversa : listaMensagens) {
            todaConversa.append(conversa);
        }
        return todaConversa;
    }
}
