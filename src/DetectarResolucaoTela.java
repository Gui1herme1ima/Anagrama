import java.awt.Dimension;
import java.awt.Toolkit;

public class DetectarResolucaoTela {

    public int largura, altura;
    DetectarResolucaoTela(int width, int height) {

        this.largura = width;
        this.altura = height;

    }

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
