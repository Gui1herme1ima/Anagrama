import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;

public class AnagramaApp {
    public static void main(String[] args) {
        // Garante que a Interface Screen seja atualizada de forma segura e responsiva
        SwingUtilities.invokeLater(AnagramaApp::Screen);
    }

    private static void Screen() {

        // Importando fonte
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/Bungee-Regular.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        JFrame frame = new JFrame("Anagrama");

        novoJogo(frame);
    }

    private static void novoJogo(JFrame frame){
        // Pega a resolução da tela
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        frame.setSize(width, height);
        // frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        // frame.setResizable(true);

        File file = new File("images/logo.png");

        try {
            Image icon = ImageIO.read(file);
            frame.setIconImage(icon);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        // Receber palavra
        BancoPalavras banco = new BancoPalavras(width, height);
        TratamentoPalavra palavra = new TratamentoPalavra(banco.getPalavraAleatoria());
        EstadoJogo estadoJogo = new EstadoJogo(palavra);
        JButton botaoDesfazer = criarBotaoDesfazer();
        JButton botaoDelete = criarBotaoDelete();
        JButton botaoReiniciar = criarBotaoReiniciar();

        PalavraDigitadaComLinhasPanel palavraDigitadaComLinhasPanel = new PalavraDigitadaComLinhasPanel(palavra.getLength());

        BotoesLetrasEmbaralhadasPanel botoesLetrasEmbaralhadasPanel = new BotoesLetrasEmbaralhadasPanel(palavra);
        botoesLetrasEmbaralhadasPanel.addBotaoLetraClickedListener(new BotaoLetraClickListener() {
            @Override
            public void botaoLetraClicked(char letra, int posicao) {
                estadoJogo.adicionarLetraPalavraDigitada(letra);
                estadoJogo.apertarBotao(posicao);
                botoesLetrasEmbaralhadasPanel.setBotoesLetraApertados(estadoJogo.getEstadoBotoes());
                palavraDigitadaComLinhasPanel.setPalavraDigitada(estadoJogo.getPalavraDigitada());

                String palavra = estadoJogo.getTratamentoPalavra().getPalavra();
                String palavraDigitada = estadoJogo.getPalavraDigitada();

                if (palavra.length() == palavraDigitada.length()) {
                    ImageIcon icon = null;
                    try {
                        Image image = ImageIO.read(file).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(image);
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }

                    if (palavra.equals(palavraDigitada)) {
                        botaoDesfazer.setEnabled(false);
                        botaoDelete.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Você acertou!!!", "Anagrama", JOptionPane.INFORMATION_MESSAGE, icon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Você errou.", "Anagrama", JOptionPane.INFORMATION_MESSAGE, icon);
                    }
                }

            }
        });


        JPanel botoesPanel = new JPanel();
        botoesPanel.setOpaque(false);
        botoesPanel.add(botaoDesfazer);
        botoesPanel.add(botaoDelete);
        botoesPanel.add(botaoReiniciar);
        botaoDesfazer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoJogo.desfazer();
                botoesLetrasEmbaralhadasPanel.setBotoesLetraApertados(estadoJogo.getEstadoBotoes());
                palavraDigitadaComLinhasPanel.setPalavraDigitada(estadoJogo.getPalavraDigitada());
            }
        });

        botaoDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoJogo.delete();
                botoesLetrasEmbaralhadasPanel.setBotoesLetraApertados(estadoJogo.getEstadoBotoes());
                palavraDigitadaComLinhasPanel.setPalavraDigitada(estadoJogo.getPalavraDigitada());
            }
        });

        botaoReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                novoJogo(frame);
            }
        });



        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Adiciona os JPanels na JFrame
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.add(botoesLetrasEmbaralhadasPanel);
        frame.add(palavraDigitadaComLinhasPanel);
        frame.add(botoesPanel);
        frame.setVisible(true);
    }


    private static JButton criarBotao(String caminhoIcone, String caminhoIconeHover, String caminhoIconePress) {
        ImageIcon icone = new ImageIcon(caminhoIcone);
        ImageIcon iconeHover = new ImageIcon(caminhoIconeHover);
        ImageIcon iconePress = new ImageIcon(caminhoIconePress);
        JButton botaoDelete = new JButton(icone);
        botaoDelete.setVisible(true);
        botaoDelete.setRolloverIcon(iconeHover);
        botaoDelete.setPressedIcon(iconePress);
        botaoDelete.setSize(new Dimension(100, 100));
        botaoDelete.setContentAreaFilled(false);
        botaoDelete.setBorderPainted(false);
        botaoDelete.setFocusPainted(false);

        return botaoDelete;
    }

    public static JButton criarBotaoReiniciar() {
        return criarBotao(
                "images/OutrosBotoes/Reiniciar.png",
                "images/OutrosBotoes/Reiniciar Hover.png",
                "images/OutrosBotoes/Reiniciar Press.png"
        );
    }

    public static JButton criarBotaoDesfazer() {
        return criarBotao(
                "images/OutrosBotoes/Backspace.png",
                "images/OutrosBotoes/Backspace Hover.png",
                "images/OutrosBotoes/Backspace Press.png"
        );
    }


    public static JButton criarBotaoDelete() {
        return criarBotao(
                "images/OutrosBotoes/Delete.png",
                "images/OutrosBotoes/Delete Hover.png",
                "images/OutrosBotoes/Delete Press.png"
        );
    }
}
