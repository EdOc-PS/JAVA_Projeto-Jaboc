/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author 0057138
 */
public class listaProdutos{
    final private int tamanhoMax = 100;
    private int nAtualElementos;
    //Criando a lista que armazenará os MÚLTIPLOS dados
    private Produto[] lista;
    
    public listaProdutos(){
        this.lista = new Produto[tamanhoMax];
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
 
    //Esse método adiciona os itens em fila.
    public boolean inserirItem(Produto P){
        boolean inseriu = false;
        if(this.getNAtualElementos() < this.getTamanho() && this.lista[this.getNAtualElementos()] == null){
                this.lista[this.getNAtualElementos()] = P;
                this.setNAtualElementos(this.getNAtualElementos() + 1);
                inseriu = true;
        }
        return inseriu;
    }
    //Esse método remove um Item com base na chave informada.
    public boolean removerItem(int chave){
        int posRemover = buscarProduto(chave, this.getNAtualElementos() - 1, -1);
        if(posRemover != -1){
            this.lista[posRemover] = null;
            this.setNAtualElementos(this.getNAtualElementos() - 1);
            return true;
        }else{
            return false;
        }
    }   
   
    //Esse método retorna um item armazenado na lista com base na chave informada ou null caso o item não seja encontrado.
    public Produto getItem(int chave){
        int posItem = buscarProduto(chave, this.getTamanho() - 1, -1);
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
    public int buscarProduto(int chave, int indice, int posItem){
        if(indice == -1){
            return posItem;
        }      
        if(this.lista[indice] != null){
            if(this.lista[indice].getIdProduto() == chave){  
                return indice;
            }
        }
        return buscarProduto(chave, indice - 1, posItem);
    }
    //Esse método retorna o ultimoItem de uma lista
    public Produto ultimoItem(int indice){
        if(this.lista[indice] != null && this.lista[indice + 1] == null){
            return this.lista[indice];
        }
        return ultimoItem(indice + 1);
    }
}

