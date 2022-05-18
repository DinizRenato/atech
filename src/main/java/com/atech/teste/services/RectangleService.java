package com.atech.teste.services;

import java.util.ArrayList;
import java.util.List;

import com.atech.teste.domain.Linha;
import com.atech.teste.domain.Ponto;
import com.atech.teste.domain.Retangulo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RectangleService {

    public int areaMaiorRetangulo(String value){

        JSONObject obj = new JSONObject(value);
        JSONArray map = obj.getJSONArray("map");

        List<List<Integer>> coordenadas = this.convertPontoToInt(map);
        List<Ponto> pontos = this.gerarPontos(coordenadas);
        List<Linha> linhas = this.gerarLinhas(pontos);
        List<Retangulo> retangulos = this.gerarRetangulos(linhas);

        return retangulos.stream().mapToInt(r -> r.getArea()).max().orElse(0);
    }

    /*
        CONVERTER MATRIZ STRING PARA INT
    */
    private List<List<Integer>> convertPontoToInt(JSONArray map){

        List<List<Integer>> pontos = new ArrayList<>();

        for (int i = 0; i < map.length(); i++) {

            String[] itens = map.get(i).toString().replace("[", "").replace("]", "").split(",");

            List<Integer> linha = new ArrayList<>();

            for (String item : itens) {
                linha.add(Integer.parseInt(item.replace("\"", "")));
            }

            pontos.add(linha);

        }
        
        return pontos;
    }
    
    /*
        SEPARAR SOMENTE OS PONTOS COM VALOR 1 DAS COORDENADAS RECEBIDAS
    */
    private List<Ponto> gerarPontos(List<List<Integer>> coordenadas){

        List<Ponto> pontos = new ArrayList<>();

        for (int linha = 0; linha < coordenadas.size(); linha++) {

            List<Integer> linhas = coordenadas.get(linha);

            for (int coluna = 0; coluna < linhas.size(); coluna++) {

                int info = linhas.get(coluna);

                if (info == 1) {
                    pontos.add(new Ponto(linha, coluna));
                }

            }

        }
        
        return pontos;
    }

    /*
        GERAR LINHAS CONSIDERANDO OS PONTOS DAS COORDENADAS
    */
    private List<Linha> gerarLinhas(List<Ponto> pontos){

        List<Linha> linhas = new ArrayList<>();

        for (Ponto ponto : pontos){

            List<Ponto> pontos_a_frente = pontos.stream().filter(p -> p.getLinha() == ponto.getLinha() && p.getColuna() > ponto.getColuna()).toList();
            
            for (Ponto frente : pontos_a_frente){
                linhas.add(new Linha(ponto, frente));
            }

        }
        return linhas;
    }

    /*
        GERAR RETANGULOS COM AS LINHAS  
    */
    private List<Retangulo> gerarRetangulos(List<Linha> linhas){

        List<Retangulo> retangulos = new ArrayList<>();

        for (Linha linha : linhas){

            List<Linha> linhas_a_baixo = linhas.stream().filter(
                l -> l.getInicio().getLinha() > linha.getInicio().getLinha() && 
                l.getInicio().getColuna() == linha.getInicio().getColuna() && 
                l.getFim().getColuna() == linha.getFim().getColuna()).toList();

            for (Linha baixo : linhas_a_baixo){
                retangulos.add(new Retangulo(linha, baixo));
            }

        }

        return retangulos;
    }

}
