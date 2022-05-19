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

    public int areaMaiorRetangulo(String value) {

        JSONObject obj = new JSONObject(value);
        JSONArray map = obj.getJSONArray("map");

        List<List<Integer>> coordenadas = this.convertPontoToInt(map);
        List<Ponto> pontos = this.gerarPontos(coordenadas);
        List<Linha> linhas = this.gerarLinhas(pontos);
        List<Retangulo> retangulos = this.gerarRetangulos(linhas);

        return retangulos.size() == 0 ? 0 : retangulos.stream().mapToInt(r -> r.getArea()).max().orElse(0);
    }

    /*
     * CONVERTER MATRIZ STRING PARA INT
     */
    private List<List<Integer>> convertPontoToInt(JSONArray map) {

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
     * SEPARAR SOMENTE OS PONTOS COM VALOR 1 DAS COORDENADAS RECEBIDAS
     */
    private List<Ponto> gerarPontos(List<List<Integer>> coordenadas) {

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
     * GERAR LINHAS CONSIDERANDO OS PONTOS DAS COORDENADAS
     */
    private List<Linha> gerarLinhas(List<Ponto> pontos) {

        List<Linha> linhas = new ArrayList<>();

        for (Ponto ponto : pontos) {

            List<Ponto> pontos_a_frente = pontos.stream()
                    .filter(p -> p.getLinha() == ponto.getLinha() && p.getColuna() > ponto.getColuna()).toList();

            List<Ponto> pontos_linhas = new ArrayList<>();

            pontos_linhas.add(ponto);

            for (Ponto frente : pontos_a_frente) {
                if (frente.getColuna() - ponto.getColuna() == pontos_linhas.size()) {
                    pontos_linhas.add(frente);
                }
            }

            linhas.add(new Linha(pontos_linhas));

        }

        // RETORNAR SOMENTE AS LINHAS QUE TENHAM MAIS DE 1 PONTO
        return linhas.stream().filter(l -> l.getPontos().size() > 1).toList();
    }

    /*
     * GERAR RETANGULOS COM AS LINHAS
     */
    private List<Retangulo> gerarRetangulos(List<Linha> linhas) {

        List<Retangulo> retangulos = new ArrayList<>();

        for (Linha linha : linhas) {

            // VARIÁVEIS QUE SERÃO UTILIZADAS PARA FILTRAR AS LINHAS QUE ESTÃO ABAIXO
            int l = linha.getPontos().get(0).getLinha();
            int largura = linha.getPontos().size();
            int coluna_inicial = linha.getPontos().get(0).getColuna();

            List<Linha> linhas_retangulo = new ArrayList<>();

            linhas_retangulo.add(linha);

            List<Linha> linhas_a_baixo = linhas.stream().filter(
                    item -> item.getPontos().get(0).getLinha() > l &&
                            item.getPontos().get(0).getColuna() == coluna_inicial &&
                            item.getPontos().size() == largura)
                    .toList();

            for(Linha inferior : linhas_a_baixo){
                linhas_retangulo.add(inferior);
            }

            retangulos.add(new Retangulo(linhas_retangulo));

        }

        //RETORNAR SOMENTE OS RETANGULOS COM MAIS DE UMA LINHA
        return retangulos.stream().filter(r -> r.getLinhas().size() > 1).toList();
    }

}
