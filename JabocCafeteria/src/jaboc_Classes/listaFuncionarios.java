package jaboc_Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Paula
 */
public class listaFuncionarios {
    //Definindo um tamanho CONSTANTE para a minha lista
    final private int tamanhoMax = 100;
    private int nAtualElementos;
    //Criando a lista que armazenará os MÚLTIPLOS dados
    private Conta_Funcionario[] lista;
    
    public listaFuncionarios(){
        this.lista = new Conta_Funcionario[tamanhoMax];
        this.nAtualElementos = 0;
    }
    public int getNAtualElementos(){
        return this.nAtualElementos;
    }
    public int getTamanho(){
        return tamanhoMax;
    }
    public void setNAtualElementos(int qtdeAtual){
        this.nAtualElementos = qtdeAtual;
    }
    //Esse método pega a variável this.lista (array) e muda a sua referência de memória, criando assim um array "vazio".
    public boolean apagarLista(){
        this.lista = new Conta_Funcionario[this.getTamanho()];
        return true;
    }
    //Esse método adiciona os itens em fila.
    public boolean inserirItem(Conta_Funcionario CF){
        boolean inseriu = false;
        if(this.getNAtualElementos() < this.getTamanho() && this.lista[this.getNAtualElementos()] == null){
                this.lista[this.getNAtualElementos()] = CF;
                this.setNAtualElementos(this.getNAtualElementos() + 1);
                inseriu = true;
        }
        return inseriu;
    }
    //Esse método remove um Item com base na chave informada.
    public boolean removerItem(String chave){
        int posRemover = buscarContaFuncionario(chave, this.getNAtualElementos() - 1, -1);
        if(posRemover != -1){
            this.lista[posRemover] = null;
            this.setNAtualElementos(this.getNAtualElementos() - 1);
            return true;
        }else{
            return false;
        }
    }   
    //Esse método remove um Item com base na posição informada.
    public boolean removerItem(int posItem){
        if(posItem < this.getTamanho() && posItem >= 0 && this.lista[posItem] != null){
            this.lista[posItem] = null;
            this.setNAtualElementos(this.getNAtualElementos() - 1);
            this.preencheLista(posItem);
            return true;
        }else{
            return false;
        }
    }   
    //Esse método preenche os espaços que ficaram vazios na lista, após um item ser apagado.
    private void preencheLista(int indice){
        if(indice == this.tamanhoMax - 2){
            return;
        }
        if(this.lista[indice] == null){
            this.lista[indice] = this.lista[indice + 1];
            this.lista[indice + 1] = null;
        }    
        preencheLista(indice + 1);
    }
    //Esse método retorna o item armazenado na posição "posItem" ou null caso essa posição não exista.
    public Conta_Funcionario getItem(int posItem){
        if(posItem < this.getTamanho() && this.lista[posItem] != null){
            return this.lista[posItem];
        }else{
            return null;
        }
    }
    //Esse método retorna o ultimoItem de uma lista
    public Conta_Funcionario ultimoItem(int indice){
        if(this.lista[indice] != null && this.lista[indice + 1] == null){
            return this.lista[indice];
        }
        return ultimoItem(indice + 1);
    }
    //Esse método inverte a posição dos elementos da Lista. Os primeiros serão os últimos, e os últimos serão os primeiros.
    public void inverteLista(int posInicial, int posFinal){
        if(posInicial >= posFinal){
            return;
        }
        
        inverteLista(posInicial + 1, posFinal - 1);
        Conta_Funcionario aux = this.lista[posInicial];
        this.lista[posInicial] = this.lista[posFinal];
        this.lista[posFinal] = aux;
    }
    //Esse método retorna um item armazenado na lista com base na chave informada ou null caso o item não seja encontrado.
    public Conta_Funcionario getItem(String chave){
        int posItem = buscarContaFuncionario(chave, this.getTamanho() - 1, -1);
        if(posItem != -1){
            return this.lista[posItem];
        }else{
            return null;
        }
    }
    //Esse método me retorne TRUE se a lista estiver vazia, e FALSE caso não.
    public boolean estaVazia(){
        return (this.getNAtualElementos() == 0);
    }
    //Esse método busca um item na Lista com base em uma chave e retorna a posição do item na lista, ou -1 caso não encontre
    public int buscarContaFuncionario(String chave, int indice, int posItem){
        if(indice == -1){
            return posItem;
        }      
        if(this.lista[indice] != null){
            if(this.lista[indice].getTitularFuncionario().getCpfFuncionario().equals(chave)){  
                return indice;
            }
        }
        return buscarContaFuncionario(chave, indice - 1, posItem);
    }
}