import java.awt.Dimension;
import java.awt.Toolkit;

public class DetectarResolucaoTela {

    public int largura, altura;
    //No código main (AnagramaApp), há um código que pega a resolução da tela.
    //As variáveis de largura e altura da tela, é enviada como parâmetro.
    DetectarResolucaoTela(int width, int height) {

        this.largura = width;
        this.altura = height;

    }
    //Sem uso, por enquanto.
    public int LayoutPanelSuperior() {
        if (largura == 1920 && altura == 1080) {
        return 100;
        } else if (largura == 1600 && altura == 900) {
            return 100;
        } else if (largura == 1366 && altura == 768) {
            return 100;
        } else {
            return 100;
        }
    }
    //Em diferentes resoluções de tela, o código desorganiza. Para organizar, selecionei as resoluções mais comuns.
    //O valor retornado, define o espaçamento horizontal do painel no AnagramaAPP, de acordo com a resolução da tela.
    public int LayoutPanelLetraPalavra() {
        if (largura == 1920 && altura == 1080) {
            return 50;
        } else if (largura == 1600 && altura == 900) {
            return 45;
        } else if (largura == 1366 && altura == 768) {
            return 20;
        } else {
            return 100;
        }
    }
    //Em diferentes resoluções de tela, o código desorganiza. Para organizar, selecionei as resoluções mais comuns.
    //O valor retornado, define o espaçamento horizontal do painel no AnagramaAPP, de acordo com a resolução da tela.
    public int LayoutPanelLinha() {
        if (largura == 1920 && altura == 1080) {
            return 100;
        } else if (largura == 1600 && altura == 900) {
            return 85;
        } else if (largura == 1366 && altura == 768) {
            return 75;
        } else {
            return 100;
        }
    }
    //Sem uso, por enquanto.
    public int LayoutPanelInferior() {
        if (largura == 1920 && altura == 1080) {
            return 100;
        } else if (largura == 1600 && altura == 900) {
            return 100;
        } else if (largura == 1366 && altura == 768) {
            return 100;
        } else {
            return 100;
        }
    }
    //Em diferentes resoluções de tela, o código desorganiza. Para organizar, selecionei as resoluções mais comuns.
    //O valor retornado, é uma gambiarrakkkk, mas esses espaços em brancos, foram testsados manualmente, de modo que cada letra ficasse em cima da linha, de acordo com cada resolução.
    //Cada número a frente do "LayoutPalavra", é a quantidade de letras em cada palavra. Quanto mais palavraas, menor os espaços em branco, pois ele vai aproximando mais da borda da janela.
    //Obs: falta configurar a resolução 1920x1080
    public String LayoutPalavra2(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "                                                                                                   " +
                    "                                                                                 ";
        } else if (largura == 1366 && altura == 768) {
            return "                                                                                            " +
                    "                                                                                                   " +
                    "                       ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra3(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "                                                                                                   " +
                    "                                            ";
        } else if (largura == 1366 && altura == 768) {
            return "                                                                                            " +
                    "                                                                                     ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra4(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "                                                                                                   " +
                    "           ";
        } else if (largura == 1366 && altura == 768) {
            return "                                                                                            " +
                    "                                                 ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra5(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "                                                                            ";
        } else if (largura == 1366 && altura == 768) {
            return "                                                                                            " +
                    "              ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra6(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "                                           ";
        } else if (largura == 1366 && altura == 768) {
            return "                                                                        ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra7(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                                                            " +
                    "      ";
        } else if (largura == 1366 && altura == 768) {
            return "                                       ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra8(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                                                              ";
        } else if (largura == 1366 && altura == 768) {
            return "  ";
        } else {
            return "";
        }
    }
    public String LayoutPalavra9(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return "                          ";
        } else if (largura == 1366 && altura == 768) {
            return ""; //Não aceita palavras com 9 letras
        } else {
            return "";
        }
    }
    public String LayoutPalavra10(){
        if (largura == 1920 && altura == 1080) {
            return "";
        } else if (largura == 1600 && altura == 900) {
            return ""; //Com 10 letras não há necessidade de espaço
        } else if (largura == 1366 && altura == 768) {
            return ""; //Não aceita palavras com 9 letras
        } else{
            return "";
        }
    }
}
