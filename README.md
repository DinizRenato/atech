# Teste para desenvolvimento - **ATECH**

## Descrição do Projeto
<p align="left">
API REST que recebe pelo endpoint HTTP POST "/rectangle" uma matriz binária 2D tamanho MxN preenchida com "0" (zero) e "1" (um) e retorna o valor da área do maior retângulo formado apenas por "1"
</p>

##  Funcionalidades do projeto
<h4 align="left">
    RectangleService
</h4>

- `convertPontoToInt()`  : Converte os pontos preenchidos como String para int
- `gerarPontos`          : Conforme as coordenadas gera uma lista de Pontos com valor de linha e coluna
- `gerarLinhas`          : Gera as linhas "ligando" os pontos da mesma linha (Linha = Ponto Inicial + Ponto Final)
- `gerarRetangulos`      : Recebe todas as linhas e forma retângulos ligando as Linhas com mesma coluna inicial e final mas valor de linha diferente.
- `areaMaiorRetangulo()` : Recebe matriz binária preenchida com "0" e "1" e retorna o valor da área do maior retãngulo formado apenas por "1".

## OBSERVAÇÃO

**Retêngulo** = Polígono de 4 lados que possui todos os ângulos internos retos (medindo 90º) e sua área é calculada com o resultado da multiplicação de sua base pela altura.

##  Status do Projeto
<h4 align="left"> 
   Finalizado!
</h4>

## 🛠 Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

- `Java 17.0.2`
- `Spring Boot (v2.6.7)`

