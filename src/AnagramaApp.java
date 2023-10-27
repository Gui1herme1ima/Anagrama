import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;


public class AnagramaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> Screen());
    }

    private static boolean botaoHifenClicado = false;
    private static int contA = 0;
    private static boolean botaoAClicado = false, botaoA2Clicado = false, botaoA3Clicado = false, botaoA4Clicado = false;
    private static boolean botaoAagudoClicado = false;
    private static boolean botaoAcircClicado = false;
    private static boolean botaoAtilClicado = false;
    private static int contB = 0;
    private static boolean botaoBClicado = false, botaoB2Clicado = false;
    private static int contC = 0;
    private static boolean botaoCClicado = false, botaoC2Clicado = false;
    private static boolean botaoCedilhaClicado = false;
    private static int contD = 0;
    private static boolean botaoDClicado = false, botaoD2Clicado = false;
    private static int contE = 0;
    private static boolean botaoEClicado = false, botaoE2Clicado = false, botaoE3Clicado = false, botaoE4Clicado = false;
    private static boolean botaoEagudoClicado = false;
    private static boolean botaoEcircClicado = false;
    private static int contF = 0;
    private static boolean botaoFClicado = false, botaoF2Clicado = false;
    private static int contG = 0;
    private static boolean botaoGClicado = false, botaoG2Clicado = false;
    private static int contH = 0;
    private static boolean botaoHClicado = false, botaoH2Clicado = false;
    private static int contI = 0;
    private static boolean botaoIClicado = false, botaoI2Clicado = false, botaoI3Clicado = false, botaoI4Clicado = false;
    private static boolean botaoIagudoClicado = false;
    private static int contJ = 0;
    private static boolean botaoJClicado = false, botaoJ2Clicado = false;
    private static int contK = 0;
    private static boolean botaoKClicado = false, botaoK2Clicado = false;
    private static int contL = 0;
    private static boolean botaoLClicado = false, botaoL2Clicado = false;
    private static int contM = 0;
    private static boolean botaoMClicado = false, botaoM2Clicado = false;
    private static int contN = 0;
    private static boolean botaoNClicado = false, botaoN2Clicado = false;
    private static int contO = 0;
    private static boolean botaoOClicado = false, botaoO2Clicado = false, botaoO3Clicado = false, botao04Clicado = false;
    private static boolean botaoOagudoClicado = false;
    private static boolean botaoOcircClicado = false;
    private static boolean botaoOtilClicado = false;
    private static int contP = 0;
    private static boolean botaoPClicado = false, botaoP2Clicado = false;
    private static int contQ = 0;
    private static boolean botaoQClicado = false, botaoQ2Clicado = false;
    private static int contR = 0;
    private static boolean botaoRClicado = false, botaoR2Clicado = false;
    private static int contS = 0;
    private static boolean botaoSClicado = false, botaoS2Clicado = false;
    private static int contT = 0;
    private static boolean botaoTClicado = false, botaoT2Clicado = false;
    private static int contU = 0;
    private static boolean botaoUClicado = false, botaoU2Clicado = false, botaoU3Clicado = false;
    private static boolean botaoUagudoClicado = false;
    private static int contV = 0;
    private static boolean botaoVClicado = false, botaoV2Clicado = false;
    private static int contW = 0;
    private static boolean botaoWClicado = false, botaoW2Clicado = false;
    private static int contX = 0;
    private static boolean botaoXClicado = false, botaoX2Clicado = false;
    private static int contY = 0;
    private static boolean botaoYClicado = false, botaoY2Clicado = false;
    private static int contZ = 0;
    private static boolean botaoZClicado = false, botaoZ2Clicado = false;

    private static void Screen() {

        //Importando Fonte
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/Bungee-Regular.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int tamanhoFont = 100;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        //JFrame
        JFrame frame = new JFrame("Anagrama");

        //Pega a resolução da tela
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        frame.setSize(width, height);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setResizable(true);
        //teste.setIconImage(); -> selecionar ícone do programa

        //Receber palavra
        BancoPalavras banco = new BancoPalavras(width, height);
        TratamentoPalavra palavra = new TratamentoPalavra(banco.getPalavraAleatoria());
        palavra.getPalavraEbaralhada();
        palavra.getArraydeCharLength();


        //JPanel

        DetectarResolucaoTela resolucao = new DetectarResolucaoTela(width, height);

        //Painel onde ficará as letras embaralhadas
        JPanel panelSuperior = Panel(0.5);
        panelSuperior.setBackground(Color.RED);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 1, resolucao.LayoutPanelSuperior()));


        //Painel onde ficará a palavra digitada pelo usuário
        JPanel panelLetraPalavra = Panel(0.1);
        panelLetraPalavra.setBackground(Color.CYAN);
        panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.CENTER, 70, resolucao.LayoutPanelLetraPalavra()));

        //Modificar Layout de acordo do tamanho de cada palavra, para as letras alinharem nas linhas
        switch (palavra.getArraydeCharLength()) {
            case 2:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label2 = new JLabel();
                label2.setFont(new Font("Bungee", Font.PLAIN, 10));
                label2.setText(resolucao.LayoutPalavra2());
                panelLetraPalavra.add(label2);
                break;
            case 3:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label3 = new JLabel();
                label3.setFont(new Font("Bungee", Font.PLAIN, 10));
                label3.setText(resolucao.LayoutPalavra3());
                panelLetraPalavra.add(label3);
                break;
            case 4:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label4 = new JLabel();
                label4.setFont(new Font("Bungee", Font.PLAIN, 10));
                label4.setText(resolucao.LayoutPalavra4());
                panelLetraPalavra.add(label4);
                break;
            case 5:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label5 = new JLabel();
                label5.setFont(new Font("Bungee", Font.PLAIN, 10));
                label5.setText(resolucao.LayoutPalavra5());
                panelLetraPalavra.add(label5);
                break;
            case 6:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label6 = new JLabel();
                label6.setFont(new Font("Bungee", Font.PLAIN, 10));
                label6.setText(resolucao.LayoutPalavra6());
                panelLetraPalavra.add(label6);
                break;
            case 7:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label7 = new JLabel();
                label7.setFont(new Font("Bungee", Font.PLAIN, 10));
                label7.setText(resolucao.LayoutPalavra7());
                panelLetraPalavra.add(label7);
                break;
            case 8:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label8 = new JLabel();
                label8.setFont(new Font("Bungee", Font.PLAIN, 10));
                label8.setText(resolucao.LayoutPalavra8());
                panelLetraPalavra.add(label8);
                break;
            case 9:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label9 = new JLabel();
                label9.setFont(new Font("Bungee", Font.PLAIN, 10));
                label9.setText(resolucao.LayoutPalavra9());
                panelLetraPalavra.add(label9);
                break;
            case 10:
                panelLetraPalavra.setLayout(new FlowLayout(FlowLayout.LEFT, 70, resolucao.LayoutPanelLetraPalavra()));
                JLabel label10 = new JLabel();
                label10.setFont(new Font("Bungee", Font.PLAIN, 10));
                label10.setText(resolucao.LayoutPalavra10());
                panelLetraPalavra.add(label10);
                break;
        }

        //Painel onde ficará a linha da palavra
        JPanel panelLinha = Panel(0.01);
        panelLinha.setBackground(Color.ORANGE);
        panelLinha.setLayout(new FlowLayout());

        //Painel onde ficarão os botões: Mudar palavra, delete e backspace
        JPanel panelInferior = Panel(0.4);
        panelInferior.setBackground(Color.GREEN);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(panelSuperior);
        frame.add(panelLetraPalavra);
        frame.add(panelLinha);
        frame.add(panelInferior);

        String[] palavras = new String[palavra.getArraydeCharLength()];  //Aqui ficará uma iteração para pegar o tamanho da Array de Char

        for (int i = 0; i < palavra.getArraydeCharLength(); i++) {
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize(new Dimension(110, 1));

            // Crie um JLabel para a imagem de fundo
            JLabel backgroundImageLabel = new JLabel();
            ImageIcon backgroundImage = new ImageIcon("images/OutrosBotoes/Linha.png");
            backgroundImageLabel.setIcon(backgroundImage);
            backgroundImageLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
            layeredPane.add(backgroundImageLabel, (0));
            panelLinha.add(backgroundImageLabel);
            panelLinha.setLayout(new FlowLayout(FlowLayout.CENTER, 42, 1));
        }

        //JToggleButton
        //Criando botões de acordo com cada letra
        palavra.getPalavraEbaralhada();
        for (char c : palavra.getPalavraEbaralhada()) {

            switch (c) {
                case '-':
                    ImageIcon Hifen = new ImageIcon("images/Botões/Botão_Hífen.png");
                    ImageIcon Hifen_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Hífen.png");
                    ImageIcon Hifen_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Hífen.png");

                    JToggleButton botaoHifen = new JToggleButton(Hifen);
                    panelSuperior.add(botaoHifen);
                    botaoHifen.setVisible(true);
                    botaoHifen.setRolloverIcon(Hifen_Hover);
                    botaoHifen.setPressedIcon(Hifen_press);
                    botaoHifen.setSize(new Dimension(100, 100));
                    botaoHifen.setContentAreaFilled(false);
                    botaoHifen.setBorderPainted(false);
                    botaoHifen.setFocusPainted(false);

                    botaoHifen.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoHifenClicado) {
                                botaoHifenClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + " - ");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoHifen.setIcon(Hifen_press);
                                botaoHifen.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'A':
                    contA += 1;
                    if (contA == 1) {
                        ImageIcon A = new ImageIcon("images/Botões/Botão_A.png");
                        ImageIcon A_Hover = new ImageIcon("images/Botões Hover/BotãoHover_A.png");
                        ImageIcon A_press = new ImageIcon("images/Botões Pressionados/BotãoPress_A.png");

                        JToggleButton botaoA = new JToggleButton(A);
                        panelSuperior.add(botaoA);
                        botaoA.setVisible(true);
                        botaoA.setRolloverIcon(A_Hover);
                        botaoA.setPressedIcon(A_press);
                        botaoA.setSize(new Dimension(100, 100));
                        botaoA.setContentAreaFilled(false);
                        botaoA.setBorderPainted(false);
                        botaoA.setFocusPainted(false);

                        botaoA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoAClicado) {
                                    botaoAClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "A");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoA.setIcon(A_press);
                                    botaoA.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contA == 2) {
                        ImageIcon A = new ImageIcon("images/Botões/Botão_A.png");
                        ImageIcon A_Hover = new ImageIcon("images/Botões Hover/BotãoHover_A.png");
                        ImageIcon A_press = new ImageIcon("images/Botões Pressionados/BotãoPress_A.png");

                        JToggleButton botaoA = new JToggleButton(A);
                        panelSuperior.add(botaoA);
                        botaoA.setVisible(true);
                        botaoA.setRolloverIcon(A_Hover);
                        botaoA.setPressedIcon(A_press);
                        botaoA.setSize(new Dimension(100, 100));
                        botaoA.setContentAreaFilled(false);
                        botaoA.setBorderPainted(false);
                        botaoA.setFocusPainted(false);

                        botaoA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoA2Clicado) {
                                    botaoA2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "A");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoA.setIcon(A_press);
                                    botaoA.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contA == 3) {
                        ImageIcon A = new ImageIcon("images/Botões/Botão_A.png");
                        ImageIcon A_Hover = new ImageIcon("images/Botões Hover/BotãoHover_A.png");
                        ImageIcon A_press = new ImageIcon("images/Botões Pressionados/BotãoPress_A.png");

                        JToggleButton botaoA = new JToggleButton(A);
                        panelSuperior.add(botaoA);
                        botaoA.setVisible(true);
                        botaoA.setRolloverIcon(A_Hover);
                        botaoA.setPressedIcon(A_press);
                        botaoA.setSize(new Dimension(100, 100));
                        botaoA.setContentAreaFilled(false);
                        botaoA.setBorderPainted(false);
                        botaoA.setFocusPainted(false);

                        botaoA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoA3Clicado) {
                                    botaoA3Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "A");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoA.setIcon(A_press);
                                    botaoA.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contA == 4) {
                        ImageIcon A = new ImageIcon("images/Botões/Botão_A.png");
                        ImageIcon A_Hover = new ImageIcon("images/Botões Hover/BotãoHover_A.png");
                        ImageIcon A_press = new ImageIcon("images/Botões Pressionados/BotãoPress_A.png");

                        JToggleButton botaoA = new JToggleButton(A);
                        panelSuperior.add(botaoA);
                        botaoA.setVisible(true);
                        botaoA.setRolloverIcon(A_Hover);
                        botaoA.setPressedIcon(A_press);
                        botaoA.setSize(new Dimension(100, 100));
                        botaoA.setContentAreaFilled(false);
                        botaoA.setBorderPainted(false);
                        botaoA.setFocusPainted(false);

                        botaoA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoA4Clicado) {
                                    botaoA4Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "A");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoA.setIcon(A_press);
                                    botaoA.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Á':
                    ImageIcon A_agudo = new ImageIcon("images/Botões/Botão_Á.png");
                    ImageIcon A_agudo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Á.png");
                    ImageIcon A_agudo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Á.png");

                    JToggleButton botaoA_agudo = new JToggleButton(A_agudo);
                    panelSuperior.add(botaoA_agudo);
                    botaoA_agudo.setVisible(true);
                    botaoA_agudo.setRolloverIcon(A_agudo_Hover);
                    botaoA_agudo.setPressedIcon(A_agudo_press);
                    botaoA_agudo.setSize(new Dimension(100, 100));
                    botaoA_agudo.setContentAreaFilled(false);
                    botaoA_agudo.setBorderPainted(false);
                    botaoA_agudo.setFocusPainted(false);

                    botaoA_agudo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAagudoClicado) {
                                botaoAagudoClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Á");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoA_agudo.setIcon(A_agudo_press);
                                botaoA_agudo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'Â':
                    ImageIcon A_circunflexo = new ImageIcon("images/Botões/Botão_Â.png");
                    ImageIcon A_circunflexo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Â.png");
                    ImageIcon A_circunflexo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Â.png");

                    JToggleButton botaoA_circunflexo = new JToggleButton(A_circunflexo);
                    panelSuperior.add(botaoA_circunflexo);
                    botaoA_circunflexo.setVisible(true);
                    botaoA_circunflexo.setRolloverIcon(A_circunflexo_Hover);
                    botaoA_circunflexo.setPressedIcon(A_circunflexo_press);
                    botaoA_circunflexo.setSize(new Dimension(100, 100));
                    botaoA_circunflexo.setContentAreaFilled(false);
                    botaoA_circunflexo.setBorderPainted(false);
                    botaoA_circunflexo.setFocusPainted(false);

                    botaoA_circunflexo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAcircClicado) {
                                botaoAcircClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Â");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoA_circunflexo.setIcon(A_circunflexo_press);
                                botaoA_circunflexo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'Ã':
                    ImageIcon A_til = new ImageIcon("images/Botões/Botão_Ã.png");
                    ImageIcon A_til_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ã.png");
                    ImageIcon A_til_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ã.png");

                    JToggleButton botaoA_til = new JToggleButton(A_til);
                    panelSuperior.add(botaoA_til);
                    botaoA_til.setVisible(true);
                    botaoA_til.setRolloverIcon(A_til_Hover);
                    botaoA_til.setPressedIcon(A_til_press);
                    botaoA_til.setSize(new Dimension(100, 100));
                    botaoA_til.setContentAreaFilled(false);
                    botaoA_til.setBorderPainted(false);
                    botaoA_til.setFocusPainted(false);

                    botaoA_til.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAtilClicado) {
                                botaoAtilClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ã");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoA_til.setIcon(A_til_press);
                                botaoA_til.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'B':
                    contB += 1;
                    if (contB == 1) {
                        ImageIcon B = new ImageIcon("images/Botões/Botão_B.png");
                        ImageIcon B_Hover = new ImageIcon("images/Botões Hover/BotãoHover_B.png");
                        ImageIcon B_press = new ImageIcon("images/Botões Pressionados/BotãoPress_B.png");

                        JToggleButton botaoB = new JToggleButton(B);
                        panelSuperior.add(botaoB);
                        botaoB.setVisible(true);
                        botaoB.setRolloverIcon(B_Hover);
                        botaoB.setPressedIcon(B_press);
                        botaoB.setSize(new Dimension(100, 100));
                        botaoB.setContentAreaFilled(false);
                        botaoB.setBorderPainted(false);
                        botaoB.setFocusPainted(false);

                        botaoB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoBClicado) {
                                    botaoBClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "B");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoB.setIcon(B_press);
                                    botaoB.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contB == 2) {
                        ImageIcon B = new ImageIcon("images/Botões/Botão_B.png");
                        ImageIcon B_Hover = new ImageIcon("images/Botões Hover/BotãoHover_B.png");
                        ImageIcon B_press = new ImageIcon("images/Botões Pressionados/BotãoPress_B.png");

                        JToggleButton botaoB = new JToggleButton(B);
                        panelSuperior.add(botaoB);
                        botaoB.setVisible(true);
                        botaoB.setRolloverIcon(B_Hover);
                        botaoB.setPressedIcon(B_press);
                        botaoB.setSize(new Dimension(100, 100));
                        botaoB.setContentAreaFilled(false);
                        botaoB.setBorderPainted(false);
                        botaoB.setFocusPainted(false);

                        botaoB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoB2Clicado) {
                                    botaoB2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "B");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoB.setIcon(B_press);
                                    botaoB.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'C':
                    contC += 1;
                    if (contC == 1) {
                        ImageIcon C = new ImageIcon("images/Botões/Botão_C.png");
                        ImageIcon C_Hover = new ImageIcon("images/Botões Hover/BotãoHover_C.png");
                        ImageIcon C_press = new ImageIcon("images/Botões Pressionados/BotãoPress_C.png");

                        JToggleButton botaoC = new JToggleButton(C);
                        panelSuperior.add(botaoC);
                        botaoC.setVisible(true);
                        botaoC.setRolloverIcon(C_Hover);
                        botaoC.setPressedIcon(C_press);
                        botaoC.setSize(new Dimension(100, 100));
                        botaoC.setContentAreaFilled(false);
                        botaoC.setBorderPainted(false);
                        botaoC.setFocusPainted(false);

                        botaoC.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoCClicado) {
                                    botaoCClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "C");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoC.setIcon(C_press);
                                    botaoC.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contC == 2) {
                        ImageIcon C = new ImageIcon("images/Botões/Botão_C.png");
                        ImageIcon C_Hover = new ImageIcon("images/Botões Hover/BotãoHover_C.png");
                        ImageIcon C_press = new ImageIcon("images/Botões Pressionados/BotãoPress_C.png");

                        JToggleButton botaoC = new JToggleButton(C);
                        panelSuperior.add(botaoC);
                        botaoC.setVisible(true);
                        botaoC.setRolloverIcon(C_Hover);
                        botaoC.setPressedIcon(C_press);
                        botaoC.setSize(new Dimension(100, 100));
                        botaoC.setContentAreaFilled(false);
                        botaoC.setBorderPainted(false);
                        botaoC.setFocusPainted(false);

                        botaoC.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoC2Clicado) {
                                    botaoC2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "C");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoC.setIcon(C_press);
                                    botaoC.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Ç':
                    ImageIcon Cedilha = new ImageIcon("images/Botões/Botão_Ç.png");
                    ImageIcon Cedilha_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ç.png");
                    ImageIcon Cedilha_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ç.png");

                    JToggleButton botaoCedilha = new JToggleButton(Cedilha);
                    panelSuperior.add(botaoCedilha);
                    botaoCedilha.setVisible(true);
                    botaoCedilha.setRolloverIcon(Cedilha_Hover);
                    botaoCedilha.setPressedIcon(Cedilha_press);
                    botaoCedilha.setSize(new Dimension(100, 100));
                    botaoCedilha.setContentAreaFilled(false);
                    botaoCedilha.setBorderPainted(false);
                    botaoCedilha.setFocusPainted(false);

                    botaoCedilha.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoCedilhaClicado) {
                                botaoCedilhaClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ç");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoCedilha.setIcon(Cedilha_press);
                                botaoCedilha.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'D':
                    contD += 1;
                    if (contD == 1) {
                        ImageIcon D = new ImageIcon("images/Botões/Botão_D.png");
                        ImageIcon D_Hover = new ImageIcon("images/Botões Hover/BotãoHover_D.png");
                        ImageIcon D_press = new ImageIcon("images/Botões Pressionados/BotãoPress_D.png");

                        JToggleButton botaoD = new JToggleButton(D);
                        panelSuperior.add(botaoD);
                        botaoD.setVisible(true);
                        botaoD.setRolloverIcon(D_Hover);
                        botaoD.setPressedIcon(D_press);
                        botaoD.setSize(new Dimension(100, 100));
                        botaoD.setContentAreaFilled(false);
                        botaoD.setBorderPainted(false);
                        botaoD.setFocusPainted(false);

                        botaoD.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoDClicado) {
                                    botaoDClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "D");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoD.setIcon(D_press);
                                    botaoD.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contD == 2) {
                        ImageIcon D = new ImageIcon("images/Botões/Botão_D.png");
                        ImageIcon D_Hover = new ImageIcon("images/Botões Hover/BotãoHover_D.png");
                        ImageIcon D_press = new ImageIcon("images/Botões Pressionados/BotãoPress_D.png");

                        JToggleButton botaoD = new JToggleButton(D);
                        panelSuperior.add(botaoD);
                        botaoD.setVisible(true);
                        botaoD.setRolloverIcon(D_Hover);
                        botaoD.setPressedIcon(D_press);
                        botaoD.setSize(new Dimension(100, 100));
                        botaoD.setContentAreaFilled(false);
                        botaoD.setBorderPainted(false);
                        botaoD.setFocusPainted(false);

                        botaoD.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoD2Clicado) {
                                    botaoD2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "D");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoD.setIcon(D_press);
                                    botaoD.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'E':
                    contE += 1;
                    if (contE == 1) {
                        ImageIcon E = new ImageIcon("images/Botões/Botão_E.png");
                        ImageIcon E_Hover = new ImageIcon("images/Botões Hover/BotãoHover_E.png");
                        ImageIcon E_press = new ImageIcon("images/Botões Pressionados/BotãoPress_E.png");

                        JToggleButton botaoE = new JToggleButton(E);
                        panelSuperior.add(botaoE);
                        botaoE.setVisible(true);
                        botaoE.setRolloverIcon(E_Hover);
                        botaoE.setPressedIcon(E_press);
                        botaoE.setSize(new Dimension(100, 100));
                        botaoE.setContentAreaFilled(false);
                        botaoE.setBorderPainted(false);
                        botaoE.setFocusPainted(false);

                        botaoE.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoEClicado) {
                                    botaoEClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "E");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoE.setIcon(E_press);
                                    botaoE.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contE == 2) {
                        ImageIcon E = new ImageIcon("images/Botões/Botão_E.png");
                        ImageIcon E_Hover = new ImageIcon("images/Botões Hover/BotãoHover_E.png");
                        ImageIcon E_press = new ImageIcon("images/Botões Pressionados/BotãoPress_E.png");

                        JToggleButton botaoE = new JToggleButton(E);
                        panelSuperior.add(botaoE);
                        botaoE.setVisible(true);
                        botaoE.setRolloverIcon(E_Hover);
                        botaoE.setPressedIcon(E_press);
                        botaoE.setSize(new Dimension(100, 100));
                        botaoE.setContentAreaFilled(false);
                        botaoE.setBorderPainted(false);
                        botaoE.setFocusPainted(false);

                        botaoE.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoE2Clicado) {
                                    botaoE2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "E");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoE.setIcon(E_press);
                                    botaoE.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contE == 3) {
                        ImageIcon E = new ImageIcon("images/Botões/Botão_E.png");
                        ImageIcon E_Hover = new ImageIcon("images/Botões Hover/BotãoHover_E.png");
                        ImageIcon E_press = new ImageIcon("images/Botões Pressionados/BotãoPress_E.png");

                        JToggleButton botaoE = new JToggleButton(E);
                        panelSuperior.add(botaoE);
                        botaoE.setVisible(true);
                        botaoE.setRolloverIcon(E_Hover);
                        botaoE.setPressedIcon(E_press);
                        botaoE.setSize(new Dimension(100, 100));
                        botaoE.setContentAreaFilled(false);
                        botaoE.setBorderPainted(false);
                        botaoE.setFocusPainted(false);

                        botaoE.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoE3Clicado) {
                                    botaoE3Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "E");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoE.setIcon(E_press);
                                    botaoE.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contE == 4) {
                        ImageIcon E = new ImageIcon("images/Botões/Botão_E.png");
                        ImageIcon E_Hover = new ImageIcon("images/Botões Hover/BotãoHover_E.png");
                        ImageIcon E_press = new ImageIcon("images/Botões Pressionados/BotãoPress_E.png");

                        JToggleButton botaoE = new JToggleButton(E);
                        panelSuperior.add(botaoE);
                        botaoE.setVisible(true);
                        botaoE.setRolloverIcon(E_Hover);
                        botaoE.setPressedIcon(E_press);
                        botaoE.setSize(new Dimension(100, 100));
                        botaoE.setContentAreaFilled(false);
                        botaoE.setBorderPainted(false);
                        botaoE.setFocusPainted(false);

                        botaoE.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoE4Clicado) {
                                    botaoE4Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "E");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoE.setIcon(E_press);
                                    botaoE.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'É':
                    ImageIcon E_agudo = new ImageIcon("images/Botões/Botão_É.png");
                    ImageIcon E_agudo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_É.png");
                    ImageIcon E_agudo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_É.png");

                    JToggleButton botaoE_agudo = new JToggleButton(E_agudo);
                    panelSuperior.add(botaoE_agudo);
                    botaoE_agudo.setVisible(true);
                    botaoE_agudo.setRolloverIcon(E_agudo_Hover);
                    botaoE_agudo.setPressedIcon(E_agudo_press);
                    botaoE_agudo.setSize(new Dimension(100, 100));
                    botaoE_agudo.setContentAreaFilled(false);
                    botaoE_agudo.setBorderPainted(false);
                    botaoE_agudo.setFocusPainted(false);

                    botaoE_agudo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoEagudoClicado) {
                                botaoEagudoClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "É");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoE_agudo.setIcon(E_agudo_press);
                                botaoE_agudo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'Ê':
                    ImageIcon E_circunflexo = new ImageIcon("images/Botões/Botão_Ê.png");
                    ImageIcon E_circunflexo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ê.png");
                    ImageIcon E_circunflexo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ê.png");

                    JToggleButton botaoE_circunflexo = new JToggleButton(E_circunflexo);
                    panelSuperior.add(botaoE_circunflexo);
                    botaoE_circunflexo.setVisible(true);
                    botaoE_circunflexo.setRolloverIcon(E_circunflexo_Hover);
                    botaoE_circunflexo.setPressedIcon(E_circunflexo_press);
                    botaoE_circunflexo.setSize(new Dimension(100, 100));
                    botaoE_circunflexo.setContentAreaFilled(false);
                    botaoE_circunflexo.setBorderPainted(false);
                    botaoE_circunflexo.setFocusPainted(false);

                    botaoE_circunflexo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoEcircClicado) {
                                botaoEcircClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ê");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoE_circunflexo.setIcon(E_circunflexo_press);
                                botaoE_circunflexo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'F':
                    contF += 1;
                    if (contF == 1) {
                        ImageIcon F = new ImageIcon("images/Botões/Botão_F.png");
                        ImageIcon F_Hover = new ImageIcon("images/Botões Hover/BotãoHover_F.png");
                        ImageIcon F_press = new ImageIcon("images/Botões Pressionados/BotãoPress_F.png");

                        JToggleButton botaoF = new JToggleButton(F);
                        panelSuperior.add(botaoF);
                        botaoF.setVisible(true);
                        botaoF.setRolloverIcon(F_Hover);
                        botaoF.setPressedIcon(F_press);
                        botaoF.setSize(new Dimension(100, 100));
                        botaoF.setContentAreaFilled(false);
                        botaoF.setBorderPainted(false);
                        botaoF.setFocusPainted(false);

                        botaoF.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoFClicado) {
                                    botaoFClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "F");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoF.setIcon(F_press);
                                    botaoF.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contF == 2) {
                        ImageIcon F = new ImageIcon("images/Botões/Botão_F.png");
                        ImageIcon F_Hover = new ImageIcon("images/Botões Hover/BotãoHover_F.png");
                        ImageIcon F_press = new ImageIcon("images/Botões Pressionados/BotãoPress_F.png");

                        JToggleButton botaoF = new JToggleButton(F);
                        panelSuperior.add(botaoF);
                        botaoF.setVisible(true);
                        botaoF.setRolloverIcon(F_Hover);
                        botaoF.setPressedIcon(F_press);
                        botaoF.setSize(new Dimension(100, 100));
                        botaoF.setContentAreaFilled(false);
                        botaoF.setBorderPainted(false);
                        botaoF.setFocusPainted(false);

                        botaoF.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoF2Clicado) {
                                    botaoF2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "F");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoF.setIcon(F_press);
                                    botaoF.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'G':
                    contG += 1;
                    if (contG == 1) {
                        ImageIcon G = new ImageIcon("images/Botões/Botão_G.png");
                        ImageIcon G_Hover = new ImageIcon("images/Botões Hover/BotãoHover_G.png");
                        ImageIcon G_press = new ImageIcon("images/Botões Pressionados/BotãoPress_G.png");

                        JToggleButton botaoG = new JToggleButton(G);
                        panelSuperior.add(botaoG);
                        botaoG.setVisible(true);
                        botaoG.setRolloverIcon(G_Hover);
                        botaoG.setPressedIcon(G_press);
                        botaoG.setSize(new Dimension(100, 100));
                        botaoG.setContentAreaFilled(false);
                        botaoG.setBorderPainted(false);
                        botaoG.setFocusPainted(false);

                        botaoG.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoGClicado) {
                                    botaoGClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "G");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoG.setIcon(G_press);
                                    botaoG.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contG == 2) {
                        ImageIcon G = new ImageIcon("images/Botões/Botão_G.png");
                        ImageIcon G_Hover = new ImageIcon("images/Botões Hover/BotãoHover_G.png");
                        ImageIcon G_press = new ImageIcon("images/Botões Pressionados/BotãoPress_G.png");

                        JToggleButton botaoG = new JToggleButton(G);
                        panelSuperior.add(botaoG);
                        botaoG.setVisible(true);
                        botaoG.setRolloverIcon(G_Hover);
                        botaoG.setPressedIcon(G_press);
                        botaoG.setSize(new Dimension(100, 100));
                        botaoG.setContentAreaFilled(false);
                        botaoG.setBorderPainted(false);
                        botaoG.setFocusPainted(false);

                        botaoG.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoG2Clicado) {
                                    botaoG2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "G");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoG.setIcon(G_press);
                                    botaoG.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'H':
                    contH += 1;
                    if (contH == 1) {
                        ImageIcon H = new ImageIcon("images/Botões/Botão_H.png");
                        ImageIcon H_Hover = new ImageIcon("images/Botões Hover/BotãoHover_H.png");
                        ImageIcon H_press = new ImageIcon("images/Botões Pressionados/BotãoPress_H.png");

                        JToggleButton botaoH = new JToggleButton(H);
                        panelSuperior.add(botaoH);
                        botaoH.setVisible(true);
                        botaoH.setRolloverIcon(H_Hover);
                        botaoH.setPressedIcon(H_press);
                        botaoH.setSize(new Dimension(100, 100));
                        botaoH.setContentAreaFilled(false);
                        botaoH.setBorderPainted(false);
                        botaoH.setFocusPainted(false);

                        botaoH.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoHClicado) {
                                    botaoHClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "H");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoH.setIcon(H_press);
                                    botaoH.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contH == 2) {
                        ImageIcon H = new ImageIcon("images/Botões/Botão_H.png");
                        ImageIcon H_Hover = new ImageIcon("images/Botões Hover/BotãoHover_H.png");
                        ImageIcon H_press = new ImageIcon("images/Botões Pressionados/BotãoPress_H.png");

                        JToggleButton botaoH = new JToggleButton(H);
                        panelSuperior.add(botaoH);
                        botaoH.setVisible(true);
                        botaoH.setRolloverIcon(H_Hover);
                        botaoH.setPressedIcon(H_press);
                        botaoH.setSize(new Dimension(100, 100));
                        botaoH.setContentAreaFilled(false);
                        botaoH.setBorderPainted(false);
                        botaoH.setFocusPainted(false);

                        botaoH.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoH2Clicado) {
                                    botaoH2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "H");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoH.setIcon(H_press);
                                    botaoH.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'I':
                    contI += 1;
                    if (contI == 1) {
                        ImageIcon I = new ImageIcon("images/Botões/Botão_I.png");
                        ImageIcon I_Hover = new ImageIcon("images/Botões Hover/BotãoHover_I.png");
                        ImageIcon I_press = new ImageIcon("images/Botões Pressionados/BotãoPress_I.png");

                        JToggleButton botaoI = new JToggleButton(I);
                        panelSuperior.add(botaoI);
                        botaoI.setVisible(true);
                        botaoI.setRolloverIcon(I_Hover);
                        botaoI.setPressedIcon(I_press);
                        botaoI.setSize(new Dimension(100, 100));
                        botaoI.setContentAreaFilled(false);
                        botaoI.setBorderPainted(false);
                        botaoI.setFocusPainted(false);

                        botaoI.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoIClicado) {
                                    botaoIClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "I");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoI.setIcon(I_press);
                                    botaoI.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contI == 2) {
                        ImageIcon I = new ImageIcon("images/Botões/Botão_I.png");
                        ImageIcon I_Hover = new ImageIcon("images/Botões Hover/BotãoHover_I.png");
                        ImageIcon I_press = new ImageIcon("images/Botões Pressionados/BotãoPress_I.png");

                        JToggleButton botaoI = new JToggleButton(I);
                        panelSuperior.add(botaoI);
                        botaoI.setVisible(true);
                        botaoI.setRolloverIcon(I_Hover);
                        botaoI.setPressedIcon(I_press);
                        botaoI.setSize(new Dimension(100, 100));
                        botaoI.setContentAreaFilled(false);
                        botaoI.setBorderPainted(false);
                        botaoI.setFocusPainted(false);

                        botaoI.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoI2Clicado) {
                                    botaoI2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "I");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoI.setIcon(I_press);
                                    botaoI.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contI == 3) {
                        ImageIcon I = new ImageIcon("images/Botões/Botão_I.png");
                        ImageIcon I_Hover = new ImageIcon("images/Botões Hover/BotãoHover_I.png");
                        ImageIcon I_press = new ImageIcon("images/Botões Pressionados/BotãoPress_I.png");

                        JToggleButton botaoI = new JToggleButton(I);
                        panelSuperior.add(botaoI);
                        botaoI.setVisible(true);
                        botaoI.setRolloverIcon(I_Hover);
                        botaoI.setPressedIcon(I_press);
                        botaoI.setSize(new Dimension(100, 100));
                        botaoI.setContentAreaFilled(false);
                        botaoI.setBorderPainted(false);
                        botaoI.setFocusPainted(false);

                        botaoI.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoI3Clicado) {
                                    botaoI3Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "I");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoI.setIcon(I_press);
                                    botaoI.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contI == 4) {
                        ImageIcon I = new ImageIcon("images/Botões/Botão_I.png");
                        ImageIcon I_Hover = new ImageIcon("images/Botões Hover/BotãoHover_I.png");
                        ImageIcon I_press = new ImageIcon("images/Botões Pressionados/BotãoPress_I.png");

                        JToggleButton botaoI = new JToggleButton(I);
                        panelSuperior.add(botaoI);
                        botaoI.setVisible(true);
                        botaoI.setRolloverIcon(I_Hover);
                        botaoI.setPressedIcon(I_press);
                        botaoI.setSize(new Dimension(100, 100));
                        botaoI.setContentAreaFilled(false);
                        botaoI.setBorderPainted(false);
                        botaoI.setFocusPainted(false);

                        botaoI.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoI4Clicado) {
                                    botaoI4Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "I");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoI.setIcon(I_press);
                                    botaoI.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Í':
                    ImageIcon I_agudo = new ImageIcon("images/Botões/Botão_Í.png");
                    ImageIcon I_agudo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Í.png");
                    ImageIcon I_agudo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Í.png");

                    JToggleButton botaoI_agudo = new JToggleButton(I_agudo);
                    panelSuperior.add(botaoI_agudo);
                    botaoI_agudo.setVisible(true);
                    botaoI_agudo.setRolloverIcon(I_agudo_Hover);
                    botaoI_agudo.setPressedIcon(I_agudo_press);
                    botaoI_agudo.setSize(new Dimension(100, 100));
                    botaoI_agudo.setContentAreaFilled(false);
                    botaoI_agudo.setBorderPainted(false);
                    botaoI_agudo.setFocusPainted(false);

                    botaoI_agudo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoIagudoClicado) {
                                botaoIagudoClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Í");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoI_agudo.setIcon(I_agudo_press);
                                botaoI_agudo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'J':
                    contJ += 1;
                    if (contJ == 1) {
                        ImageIcon J = new ImageIcon("images/Botões/Botão_J.png");
                        ImageIcon J_Hover = new ImageIcon("images/Botões Hover/BotãoHover_J.png");
                        ImageIcon J_press = new ImageIcon("images/Botões Pressionados/BotãoPress_J.png");

                        JToggleButton botaoJ = new JToggleButton(J);
                        panelSuperior.add(botaoJ);
                        botaoJ.setVisible(true);
                        botaoJ.setRolloverIcon(J_Hover);
                        botaoJ.setPressedIcon(J_press);
                        botaoJ.setSize(new Dimension(100, 100));
                        botaoJ.setContentAreaFilled(false);
                        botaoJ.setBorderPainted(false);
                        botaoJ.setFocusPainted(false);

                        botaoJ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoJClicado) {
                                    botaoJClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "J");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoJ.setIcon(J_press);
                                    botaoJ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contJ == 2) {
                        ImageIcon J = new ImageIcon("images/Botões/Botão_J.png");
                        ImageIcon J_Hover = new ImageIcon("images/Botões Hover/BotãoHover_J.png");
                        ImageIcon J_press = new ImageIcon("images/Botões Pressionados/BotãoPress_J.png");

                        JToggleButton botaoJ = new JToggleButton(J);
                        panelSuperior.add(botaoJ);
                        botaoJ.setVisible(true);
                        botaoJ.setRolloverIcon(J_Hover);
                        botaoJ.setPressedIcon(J_press);
                        botaoJ.setSize(new Dimension(100, 100));
                        botaoJ.setContentAreaFilled(false);
                        botaoJ.setBorderPainted(false);
                        botaoJ.setFocusPainted(false);

                        botaoJ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoJ2Clicado) {
                                    botaoJ2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "J");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoJ.setIcon(J_press);
                                    botaoJ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'K':
                    contK += 1;
                    if (contK == 1) {
                        ImageIcon K = new ImageIcon("images/Botões/Botão_K.png");
                        ImageIcon K_Hover = new ImageIcon("images/Botões Hover/BotãoHover_K.png");
                        ImageIcon K_press = new ImageIcon("images/Botões Pressionados/BotãoPress_K.png");

                        JToggleButton botaoK = new JToggleButton(K);
                        panelSuperior.add(botaoK);
                        botaoK.setVisible(true);
                        botaoK.setRolloverIcon(K_Hover);
                        botaoK.setPressedIcon(K_press);
                        botaoK.setSize(new Dimension(100, 100));
                        botaoK.setContentAreaFilled(false);
                        botaoK.setBorderPainted(false);
                        botaoK.setFocusPainted(false);

                        botaoK.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoKClicado) {
                                    botaoKClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "K");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoK.setIcon(K_press);
                                    botaoK.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contK == 2) {
                        ImageIcon K = new ImageIcon("images/Botões/Botão_K.png");
                        ImageIcon K_Hover = new ImageIcon("images/Botões Hover/BotãoHover_K.png");
                        ImageIcon K_press = new ImageIcon("images/Botões Pressionados/BotãoPress_K.png");

                        JToggleButton botaoK = new JToggleButton(K);
                        panelSuperior.add(botaoK);
                        botaoK.setVisible(true);
                        botaoK.setRolloverIcon(K_Hover);
                        botaoK.setPressedIcon(K_press);
                        botaoK.setSize(new Dimension(100, 100));
                        botaoK.setContentAreaFilled(false);
                        botaoK.setBorderPainted(false);
                        botaoK.setFocusPainted(false);

                        botaoK.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoK2Clicado) {
                                    botaoK2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "K");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoK.setIcon(K_press);
                                    botaoK.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'L':
                    contL += 1;
                    if (contL == 1) {
                        ImageIcon L = new ImageIcon("images/Botões/Botão_L.png");
                        ImageIcon L_Hover = new ImageIcon("images/Botões Hover/BotãoHover_L.png");
                        ImageIcon L_press = new ImageIcon("images/Botões Pressionados/BotãoPress_L.png");

                        JToggleButton botaoL = new JToggleButton(L);
                        panelSuperior.add(botaoL);
                        botaoL.setVisible(true);
                        botaoL.setRolloverIcon(L_Hover);
                        botaoL.setPressedIcon(L_press);
                        botaoL.setSize(new Dimension(100, 100));
                        botaoL.setContentAreaFilled(false);
                        botaoL.setBorderPainted(false);
                        botaoL.setFocusPainted(false);

                        botaoL.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoLClicado) {
                                    botaoLClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "L");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoL.setIcon(L_press);
                                    botaoL.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contL == 2) {
                        ImageIcon L = new ImageIcon("images/Botões/Botão_L.png");
                        ImageIcon L_Hover = new ImageIcon("images/Botões Hover/BotãoHover_L.png");
                        ImageIcon L_press = new ImageIcon("images/Botões Pressionados/BotãoPress_L.png");

                        JToggleButton botaoL = new JToggleButton(L);
                        panelSuperior.add(botaoL);
                        botaoL.setVisible(true);
                        botaoL.setRolloverIcon(L_Hover);
                        botaoL.setPressedIcon(L_press);
                        botaoL.setSize(new Dimension(100, 100));
                        botaoL.setContentAreaFilled(false);
                        botaoL.setBorderPainted(false);
                        botaoL.setFocusPainted(false);

                        botaoL.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoL2Clicado) {
                                    botaoL2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "L");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoL.setIcon(L_press);
                                    botaoL.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'M':
                    contM += 1;
                    if (contM == 1) {
                        ImageIcon M = new ImageIcon("images/Botões/Botão_M.png");
                        ImageIcon M_Hover = new ImageIcon("images/Botões Hover/BotãoHover_M.png");
                        ImageIcon M_press = new ImageIcon("images/Botões Pressionados/BotãoPress_M.png");

                        JToggleButton botaoM = new JToggleButton(M);
                        panelSuperior.add(botaoM);
                        botaoM.setVisible(true);
                        botaoM.setRolloverIcon(M_Hover);
                        botaoM.setPressedIcon(M_press);
                        botaoM.setSize(new Dimension(100, 100));
                        botaoM.setContentAreaFilled(false);
                        botaoM.setBorderPainted(false);
                        botaoM.setFocusPainted(false);

                        botaoM.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoMClicado) {
                                    botaoMClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "M");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoM.setIcon(M_press);
                                    botaoM.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contM == 2) {
                        ImageIcon M = new ImageIcon("images/Botões/Botão_M.png");
                        ImageIcon M_Hover = new ImageIcon("images/Botões Hover/BotãoHover_M.png");
                        ImageIcon M_press = new ImageIcon("images/Botões Pressionados/BotãoPress_M.png");

                        JToggleButton botaoM = new JToggleButton(M);
                        panelSuperior.add(botaoM);
                        botaoM.setVisible(true);
                        botaoM.setRolloverIcon(M_Hover);
                        botaoM.setPressedIcon(M_press);
                        botaoM.setSize(new Dimension(100, 100));
                        botaoM.setContentAreaFilled(false);
                        botaoM.setBorderPainted(false);
                        botaoM.setFocusPainted(false);

                        botaoM.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoM2Clicado) {
                                    botaoM2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "M");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoM.setIcon(M_press);
                                    botaoM.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'N':
                    contN += 1;
                    if (contN == 1) {
                        ImageIcon N = new ImageIcon("images/Botões/Botão_N.png");
                        ImageIcon N_Hover = new ImageIcon("images/Botões Hover/BotãoHover_N.png");
                        ImageIcon N_press = new ImageIcon("images/Botões Pressionados/BotãoPress_N.png");

                        JToggleButton botaoN = new JToggleButton(N);
                        panelSuperior.add(botaoN);
                        botaoN.setVisible(true);
                        botaoN.setRolloverIcon(N_Hover);
                        botaoN.setPressedIcon(N_press);
                        botaoN.setSize(new Dimension(100, 100));
                        botaoN.setContentAreaFilled(false);
                        botaoN.setBorderPainted(false);
                        botaoN.setFocusPainted(false);

                        botaoN.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoNClicado) {
                                    botaoNClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "N");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoN.setIcon(N_press);
                                    botaoN.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contN == 2) {
                        ImageIcon N = new ImageIcon("images/Botões/Botão_N.png");
                        ImageIcon N_Hover = new ImageIcon("images/Botões Hover/BotãoHover_N.png");
                        ImageIcon N_press = new ImageIcon("images/Botões Pressionados/BotãoPress_N.png");

                        JToggleButton botaoN = new JToggleButton(N);
                        panelSuperior.add(botaoN);
                        botaoN.setVisible(true);
                        botaoN.setRolloverIcon(N_Hover);
                        botaoN.setPressedIcon(N_press);
                        botaoN.setSize(new Dimension(100, 100));
                        botaoN.setContentAreaFilled(false);
                        botaoN.setBorderPainted(false);
                        botaoN.setFocusPainted(false);

                        botaoN.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoN2Clicado) {
                                    botaoN2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "N");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoN.setIcon(N_press);
                                    botaoN.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'O':
                    contO += 1;
                    if (contO == 1) {
                        ImageIcon O = new ImageIcon("images/Botões/Botão_O.png");
                        ImageIcon O_Hover = new ImageIcon("images/Botões Hover/BotãoHover_O.png");
                        ImageIcon O_press = new ImageIcon("images/Botões Pressionados/BotãoPress_O.png");

                        JToggleButton botaoO = new JToggleButton(O);
                        panelSuperior.add(botaoO);
                        botaoO.setVisible(true);
                        botaoO.setRolloverIcon(O_Hover);
                        botaoO.setPressedIcon(O_press);
                        botaoO.setSize(new Dimension(100, 100));
                        botaoO.setContentAreaFilled(false);
                        botaoO.setBorderPainted(false);
                        botaoO.setFocusPainted(false);

                        botaoO.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoOClicado) {
                                    botaoOClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "O");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoO.setIcon(O_press);
                                    botaoO.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contO == 2) {
                        ImageIcon O = new ImageIcon("images/Botões/Botão_O.png");
                        ImageIcon O_Hover = new ImageIcon("images/Botões Hover/BotãoHover_O.png");
                        ImageIcon O_press = new ImageIcon("images/Botões Pressionados/BotãoPress_O.png");

                        JToggleButton botaoO = new JToggleButton(O);
                        panelSuperior.add(botaoO);
                        botaoO.setVisible(true);
                        botaoO.setRolloverIcon(O_Hover);
                        botaoO.setPressedIcon(O_press);
                        botaoO.setSize(new Dimension(100, 100));
                        botaoO.setContentAreaFilled(false);
                        botaoO.setBorderPainted(false);
                        botaoO.setFocusPainted(false);

                        botaoO.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoO2Clicado) {
                                    botaoO2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "O");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoO.setIcon(O_press);
                                    botaoO.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contO == 3) {
                        ImageIcon O = new ImageIcon("images/Botões/Botão_O.png");
                        ImageIcon O_Hover = new ImageIcon("images/Botões Hover/BotãoHover_O.png");
                        ImageIcon O_press = new ImageIcon("images/Botões Pressionados/BotãoPress_O.png");

                        JToggleButton botaoO = new JToggleButton(O);
                        panelSuperior.add(botaoO);
                        botaoO.setVisible(true);
                        botaoO.setRolloverIcon(O_Hover);
                        botaoO.setPressedIcon(O_press);
                        botaoO.setSize(new Dimension(100, 100));
                        botaoO.setContentAreaFilled(false);
                        botaoO.setBorderPainted(false);
                        botaoO.setFocusPainted(false);

                        botaoO.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoO3Clicado) {
                                    botaoO3Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "O");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoO.setIcon(O_press);
                                    botaoO.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contO == 4) {
                        ImageIcon O = new ImageIcon("images/Botões/Botão_O.png");
                        ImageIcon O_Hover = new ImageIcon("images/Botões Hover/BotãoHover_O.png");
                        ImageIcon O_press = new ImageIcon("images/Botões Pressionados/BotãoPress_O.png");

                        JToggleButton botaoO = new JToggleButton(O);
                        panelSuperior.add(botaoO);
                        botaoO.setVisible(true);
                        botaoO.setRolloverIcon(O_Hover);
                        botaoO.setPressedIcon(O_press);
                        botaoO.setSize(new Dimension(100, 100));
                        botaoO.setContentAreaFilled(false);
                        botaoO.setBorderPainted(false);
                        botaoO.setFocusPainted(false);

                        botaoO.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botao04Clicado) {
                                    botao04Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "O");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoO.setIcon(O_press);
                                    botaoO.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Ó':
                    ImageIcon O_agudo = new ImageIcon("images/Botões/Botão_Ó.png");
                    ImageIcon O_agudo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ó.png");
                    ImageIcon O_agudo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ó.png");

                    JToggleButton botaoO_agudo = new JToggleButton(O_agudo);
                    panelSuperior.add(botaoO_agudo);
                    botaoO_agudo.setVisible(true);
                    botaoO_agudo.setRolloverIcon(O_agudo_Hover);
                    botaoO_agudo.setPressedIcon(O_agudo_press);
                    botaoO_agudo.setSize(new Dimension(100, 100));
                    botaoO_agudo.setContentAreaFilled(false);
                    botaoO_agudo.setBorderPainted(false);
                    botaoO_agudo.setFocusPainted(false);

                    botaoO_agudo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoOagudoClicado) {
                                botaoOagudoClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ó");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoO_agudo.setIcon(O_agudo_press);
                                botaoO_agudo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'Ô':
                    ImageIcon O_circunflexo = new ImageIcon("images/Botões/Botão_Ô.png");
                    ImageIcon O_circunflexo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ô.png");
                    ImageIcon O_circunflexo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ô.png");

                    JToggleButton botaoO_circunflexo = new JToggleButton(O_circunflexo);
                    panelSuperior.add(botaoO_circunflexo);
                    botaoO_circunflexo.setVisible(true);
                    botaoO_circunflexo.setRolloverIcon(O_circunflexo_Hover);
                    botaoO_circunflexo.setPressedIcon(O_circunflexo_press);
                    botaoO_circunflexo.setSize(new Dimension(100, 100));
                    botaoO_circunflexo.setContentAreaFilled(false);
                    botaoO_circunflexo.setBorderPainted(false);
                    botaoO_circunflexo.setFocusPainted(false);

                    botaoO_circunflexo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoOcircClicado) {
                                botaoOcircClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ô");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoO_circunflexo.setIcon(O_circunflexo_press);
                                botaoO_circunflexo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'Õ':
                    ImageIcon O_til = new ImageIcon("images/Botões/Botão_Õ.png");
                    ImageIcon O_til_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Õ.png");
                    ImageIcon O_til_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Õ.png");

                    JToggleButton botaoO_til = new JToggleButton(O_til);
                    panelSuperior.add(botaoO_til);
                    botaoO_til.setVisible(true);
                    botaoO_til.setRolloverIcon(O_til_Hover);
                    botaoO_til.setPressedIcon(O_til_press);
                    botaoO_til.setSize(new Dimension(100, 100));
                    botaoO_til.setContentAreaFilled(false);
                    botaoO_til.setBorderPainted(false);
                    botaoO_til.setFocusPainted(false);

                    botaoO_til.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoOtilClicado) {
                                botaoOtilClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Õ");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoO_til.setIcon(O_til_press);
                                botaoO_til.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'P':
                    contP += 1;
                    if (contP == 1) {
                        ImageIcon P = new ImageIcon("images/Botões/Botão_P.png");
                        ImageIcon P_Hover = new ImageIcon("images/Botões Hover/BotãoHover_P.png");
                        ImageIcon P_press = new ImageIcon("images/Botões Pressionados/BotãoPress_P.png");

                        JToggleButton botaoP = new JToggleButton(P);
                        panelSuperior.add(botaoP);
                        botaoP.setVisible(true);
                        botaoP.setRolloverIcon(P_Hover);
                        botaoP.setPressedIcon(P_press);
                        botaoP.setSize(new Dimension(100, 100));
                        botaoP.setContentAreaFilled(false);
                        botaoP.setBorderPainted(false);
                        botaoP.setFocusPainted(false);

                        botaoP.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoPClicado) {
                                    botaoPClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "P");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoP.setIcon(P_press);
                                    botaoP.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contP == 2) {
                        ImageIcon P = new ImageIcon("images/Botões/Botão_P.png");
                        ImageIcon P_Hover = new ImageIcon("images/Botões Hover/BotãoHover_P.png");
                        ImageIcon P_press = new ImageIcon("images/Botões Pressionados/BotãoPress_P.png");

                        JToggleButton botaoP = new JToggleButton(P);
                        panelSuperior.add(botaoP);
                        botaoP.setVisible(true);
                        botaoP.setRolloverIcon(P_Hover);
                        botaoP.setPressedIcon(P_press);
                        botaoP.setSize(new Dimension(100, 100));
                        botaoP.setContentAreaFilled(false);
                        botaoP.setBorderPainted(false);
                        botaoP.setFocusPainted(false);

                        botaoP.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoP2Clicado) {
                                    botaoP2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "P");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoP.setIcon(P_press);
                                    botaoP.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Q':
                    contQ += 1;
                    if (contQ == 1) {
                        ImageIcon Q = new ImageIcon("images/Botões/Botão_Q.png");
                        ImageIcon Q_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Q.png");
                        ImageIcon Q_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Q.png");

                        JToggleButton botaoQ = new JToggleButton(Q);
                        panelSuperior.add(botaoQ);
                        botaoQ.setVisible(true);
                        botaoQ.setRolloverIcon(Q_Hover);
                        botaoQ.setPressedIcon(Q_press);
                        botaoQ.setSize(new Dimension(100, 100));
                        botaoQ.setContentAreaFilled(false);
                        botaoQ.setBorderPainted(false);
                        botaoQ.setFocusPainted(false);

                        botaoQ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoQClicado) {
                                    botaoQClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Q");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoQ.setIcon(Q_press);
                                    botaoQ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contQ == 2) {
                        ImageIcon Q = new ImageIcon("images/Botões/Botão_Q.png");
                        ImageIcon Q_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Q.png");
                        ImageIcon Q_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Q.png");

                        JToggleButton botaoQ = new JToggleButton(Q);
                        panelSuperior.add(botaoQ);
                        botaoQ.setVisible(true);
                        botaoQ.setRolloverIcon(Q_Hover);
                        botaoQ.setPressedIcon(Q_press);
                        botaoQ.setSize(new Dimension(100, 100));
                        botaoQ.setContentAreaFilled(false);
                        botaoQ.setBorderPainted(false);
                        botaoQ.setFocusPainted(false);

                        botaoQ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoQ2Clicado) {
                                    botaoQ2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Q");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoQ.setIcon(Q_press);
                                    botaoQ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'R':
                    contR += 1;
                    if (contR == 1) {
                        ImageIcon R = new ImageIcon("images/Botões/Botão_R.png");
                        ImageIcon R_Hover = new ImageIcon("images/Botões Hover/BotãoHover_R.png");
                        ImageIcon R_press = new ImageIcon("images/Botões Pressionados/BotãoPress_R.png");

                        JToggleButton botaoR = new JToggleButton(R);
                        panelSuperior.add(botaoR);
                        botaoR.setVisible(true);
                        botaoR.setRolloverIcon(R_Hover);
                        botaoR.setPressedIcon(R_press);
                        botaoR.setSize(new Dimension(100, 100));
                        botaoR.setContentAreaFilled(false);
                        botaoR.setBorderPainted(false);
                        botaoR.setFocusPainted(false);

                        botaoR.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoRClicado) {
                                    botaoRClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "R");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoR.setIcon(R_press);
                                    botaoR.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contR == 2) {
                        ImageIcon R = new ImageIcon("images/Botões/Botão_R.png");
                        ImageIcon R_Hover = new ImageIcon("images/Botões Hover/BotãoHover_R.png");
                        ImageIcon R_press = new ImageIcon("images/Botões Pressionados/BotãoPress_R.png");

                        JToggleButton botaoR = new JToggleButton(R);
                        panelSuperior.add(botaoR);
                        botaoR.setVisible(true);
                        botaoR.setRolloverIcon(R_Hover);
                        botaoR.setPressedIcon(R_press);
                        botaoR.setSize(new Dimension(100, 100));
                        botaoR.setContentAreaFilled(false);
                        botaoR.setBorderPainted(false);
                        botaoR.setFocusPainted(false);

                        botaoR.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoR2Clicado) {
                                    botaoR2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "R");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoR.setIcon(R_press);
                                    botaoR.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'S':
                    contS += 1;
                    if (contS == 1) {
                        ImageIcon S = new ImageIcon("images/Botões/Botão_S.png");
                        ImageIcon S_Hover = new ImageIcon("images/Botões Hover/BotãoHover_S.png");
                        ImageIcon S_press = new ImageIcon("images/Botões Pressionados/BotãoPress_S.png");

                        JToggleButton botaoS = new JToggleButton(S);
                        panelSuperior.add(botaoS);
                        botaoS.setVisible(true);
                        botaoS.setRolloverIcon(S_Hover);
                        botaoS.setPressedIcon(S_press);
                        botaoS.setSize(new Dimension(100, 100));
                        botaoS.setContentAreaFilled(false);
                        botaoS.setBorderPainted(false);
                        botaoS.setFocusPainted(false);

                        botaoS.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoSClicado) {
                                    botaoSClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "S");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoS.setIcon(S_press);
                                    botaoS.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contS == 2) {
                        ImageIcon S = new ImageIcon("images/Botões/Botão_S.png");
                        ImageIcon S_Hover = new ImageIcon("images/Botões Hover/BotãoHover_S.png");
                        ImageIcon S_press = new ImageIcon("images/Botões Pressionados/BotãoPress_S.png");

                        JToggleButton botaoS = new JToggleButton(S);
                        panelSuperior.add(botaoS);
                        botaoS.setVisible(true);
                        botaoS.setRolloverIcon(S_Hover);
                        botaoS.setPressedIcon(S_press);
                        botaoS.setSize(new Dimension(100, 100));
                        botaoS.setContentAreaFilled(false);
                        botaoS.setBorderPainted(false);
                        botaoS.setFocusPainted(false);

                        botaoS.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoS2Clicado) {
                                    botaoS2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "S");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoS.setIcon(S_press);
                                    botaoS.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'T':
                    contT += 1;
                    if (contT == 1) {
                        ImageIcon T = new ImageIcon("images/Botões/Botão_T.png");
                        ImageIcon T_Hover = new ImageIcon("images/Botões Hover/BotãoHover_T.png");
                        ImageIcon T_press = new ImageIcon("images/Botões Pressionados/BotãoPress_T.png");

                        JToggleButton botaoT = new JToggleButton(T);
                        panelSuperior.add(botaoT);
                        botaoT.setVisible(true);
                        botaoT.setRolloverIcon(T_Hover);
                        botaoT.setPressedIcon(T_press);
                        botaoT.setSize(new Dimension(100, 100));
                        botaoT.setContentAreaFilled(false);
                        botaoT.setBorderPainted(false);
                        botaoT.setFocusPainted(false);

                        botaoT.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoTClicado) {
                                    botaoTClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "T");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoT.setIcon(T_press);
                                    botaoT.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contT == 2) {
                        ImageIcon T = new ImageIcon("images/Botões/Botão_T.png");
                        ImageIcon T_Hover = new ImageIcon("images/Botões Hover/BotãoHover_T.png");
                        ImageIcon T_press = new ImageIcon("images/Botões Pressionados/BotãoPress_T.png");

                        JToggleButton botaoT = new JToggleButton(T);
                        panelSuperior.add(botaoT);
                        botaoT.setVisible(true);
                        botaoT.setRolloverIcon(T_Hover);
                        botaoT.setPressedIcon(T_press);
                        botaoT.setSize(new Dimension(100, 100));
                        botaoT.setContentAreaFilled(false);
                        botaoT.setBorderPainted(false);
                        botaoT.setFocusPainted(false);

                        botaoT.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoT2Clicado) {
                                    botaoT2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "T");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoT.setIcon(T_press);
                                    botaoT.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'U':
                    contU += 1;
                    if (contU == 1) {
                        ImageIcon U = new ImageIcon("images/Botões/Botão_U.png");
                        ImageIcon U_Hover = new ImageIcon("images/Botões Hover/BotãoHover_U.png");
                        ImageIcon U_press = new ImageIcon("images/Botões Pressionados/BotãoPress_U.png");

                        JToggleButton botaoU = new JToggleButton(U);
                        panelSuperior.add(botaoU);
                        botaoU.setVisible(true);
                        botaoU.setRolloverIcon(U_Hover);
                        botaoU.setPressedIcon(U_press);
                        botaoU.setSize(new Dimension(100, 100));
                        botaoU.setContentAreaFilled(false);
                        botaoU.setBorderPainted(false);
                        botaoU.setFocusPainted(false);

                        botaoU.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoUClicado) {
                                    botaoUClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "U");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoU.setIcon(U_press);
                                    botaoU.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contU == 2) {
                        ImageIcon U = new ImageIcon("images/Botões/Botão_U.png");
                        ImageIcon U_Hover = new ImageIcon("images/Botões Hover/BotãoHover_U.png");
                        ImageIcon U_press = new ImageIcon("images/Botões Pressionados/BotãoPress_U.png");

                        JToggleButton botaoU = new JToggleButton(U);
                        panelSuperior.add(botaoU);
                        botaoU.setVisible(true);
                        botaoU.setRolloverIcon(U_Hover);
                        botaoU.setPressedIcon(U_press);
                        botaoU.setSize(new Dimension(100, 100));
                        botaoU.setContentAreaFilled(false);
                        botaoU.setBorderPainted(false);
                        botaoU.setFocusPainted(false);

                        botaoU.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoU2Clicado) {
                                    botaoU2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "U");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoU.setIcon(U_press);
                                    botaoU.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contU == 3) {
                        ImageIcon U = new ImageIcon("images/Botões/Botão_U.png");
                        ImageIcon U_Hover = new ImageIcon("images/Botões Hover/BotãoHover_U.png");
                        ImageIcon U_press = new ImageIcon("images/Botões Pressionados/BotãoPress_U.png");

                        JToggleButton botaoU = new JToggleButton(U);
                        panelSuperior.add(botaoU);
                        botaoU.setVisible(true);
                        botaoU.setRolloverIcon(U_Hover);
                        botaoU.setPressedIcon(U_press);
                        botaoU.setSize(new Dimension(100, 100));
                        botaoU.setContentAreaFilled(false);
                        botaoU.setBorderPainted(false);
                        botaoU.setFocusPainted(false);

                        botaoU.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoU3Clicado) {
                                    botaoU3Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "U");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoU.setIcon(U_press);
                                    botaoU.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Ú':
                    ImageIcon U_agudo = new ImageIcon("images/Botões/Botão_Ú.png");
                    ImageIcon U_agudo_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Ú.png");
                    ImageIcon U_agudo_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Ú.png");

                    JToggleButton botaoU_agudo = new JToggleButton(U_agudo);
                    panelSuperior.add(botaoU_agudo);
                    botaoU_agudo.setVisible(true);
                    botaoU_agudo.setRolloverIcon(U_agudo_Hover);
                    botaoU_agudo.setPressedIcon(U_agudo_press);
                    botaoU_agudo.setSize(new Dimension(100, 100));
                    botaoU_agudo.setContentAreaFilled(false);
                    botaoU_agudo.setBorderPainted(false);
                    botaoU_agudo.setFocusPainted(false);

                    botaoU_agudo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoUagudoClicado) {
                                botaoUagudoClicado = true;
                                //JLabel
                                JLabel label = new JLabel();
                                panelLetraPalavra.add(label);
                                label.setText(label.getText() + "Ú");
                                label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                botaoU_agudo.setIcon(U_agudo_press);
                                botaoU_agudo.setRolloverEnabled(false);
                            }
                        }
                    });
                    break;
                case 'V':
                    contV += 1;
                    if (contV == 1) {
                        ImageIcon V = new ImageIcon("images/Botões/Botão_V.png");
                        ImageIcon V_Hover = new ImageIcon("images/Botões Hover/BotãoHover_V.png");
                        ImageIcon V_press = new ImageIcon("images/Botões Pressionados/BotãoPress_V.png");

                        JToggleButton botaoV = new JToggleButton(V);
                        panelSuperior.add(botaoV);
                        botaoV.setVisible(true);
                        botaoV.setRolloverIcon(V_Hover);
                        botaoV.setPressedIcon(V_press);
                        botaoV.setSize(new Dimension(100, 100));
                        botaoV.setContentAreaFilled(false);
                        botaoV.setBorderPainted(false);
                        botaoV.setFocusPainted(false);

                        botaoV.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoVClicado) {
                                    botaoVClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "V");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoV.setIcon(V_press);
                                    botaoV.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contV == 2) {
                        ImageIcon V = new ImageIcon("images/Botões/Botão_V.png");
                        ImageIcon V_Hover = new ImageIcon("images/Botões Hover/BotãoHover_V.png");
                        ImageIcon V_press = new ImageIcon("images/Botões Pressionados/BotãoPress_V.png");

                        JToggleButton botaoV = new JToggleButton(V);
                        panelSuperior.add(botaoV);
                        botaoV.setVisible(true);
                        botaoV.setRolloverIcon(V_Hover);
                        botaoV.setPressedIcon(V_press);
                        botaoV.setSize(new Dimension(100, 100));
                        botaoV.setContentAreaFilled(false);
                        botaoV.setBorderPainted(false);
                        botaoV.setFocusPainted(false);

                        botaoV.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoV2Clicado) {
                                    botaoV2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "V");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoV.setIcon(V_press);
                                    botaoV.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'W':
                    contW += 1;
                    if (contW == 1) {
                        ImageIcon W = new ImageIcon("images/Botões/Botão_W.png");
                        ImageIcon W_Hover = new ImageIcon("images/Botões Hover/BotãoHover_W.png");
                        ImageIcon W_press = new ImageIcon("images/Botões Pressionados/BotãoPress_W.png");

                        JToggleButton botaoW = new JToggleButton(W);
                        panelSuperior.add(botaoW);
                        botaoW.setVisible(true);
                        botaoW.setRolloverIcon(W_Hover);
                        botaoW.setPressedIcon(W_press);
                        botaoW.setSize(new Dimension(100, 100));
                        botaoW.setContentAreaFilled(false);
                        botaoW.setBorderPainted(false);
                        botaoW.setFocusPainted(false);

                        botaoW.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoWClicado) {
                                    botaoWClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "W");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoW.setIcon(W_press);
                                    botaoW.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contW == 2) {
                        ImageIcon W = new ImageIcon("images/Botões/Botão_W.png");
                        ImageIcon W_Hover = new ImageIcon("images/Botões Hover/BotãoHover_W.png");
                        ImageIcon W_press = new ImageIcon("images/Botões Pressionados/BotãoPress_W.png");

                        JToggleButton botaoW = new JToggleButton(W);
                        panelSuperior.add(botaoW);
                        botaoW.setVisible(true);
                        botaoW.setRolloverIcon(W_Hover);
                        botaoW.setPressedIcon(W_press);
                        botaoW.setSize(new Dimension(100, 100));
                        botaoW.setContentAreaFilled(false);
                        botaoW.setBorderPainted(false);
                        botaoW.setFocusPainted(false);

                        botaoW.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoW2Clicado) {
                                    botaoW2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "W");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoW.setIcon(W_press);
                                    botaoW.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'X':
                    contX += 1;
                    if (contX == 1) {
                        ImageIcon X = new ImageIcon("images/Botões/Botão_X.png");
                        ImageIcon X_Hover = new ImageIcon("images/Botões Hover/BotãoHover_X.png");
                        ImageIcon X_press = new ImageIcon("images/Botões Pressionados/BotãoPress_X.png");

                        JToggleButton botaoX = new JToggleButton(X);
                        panelSuperior.add(botaoX);
                        botaoX.setVisible(true);
                        botaoX.setRolloverIcon(X_Hover);
                        botaoX.setPressedIcon(X_press);
                        botaoX.setSize(new Dimension(100, 100));
                        botaoX.setContentAreaFilled(false);
                        botaoX.setBorderPainted(false);
                        botaoX.setFocusPainted(false);

                        botaoX.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoXClicado) {
                                    botaoXClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "X");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoX.setIcon(X_press);
                                    botaoX.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contX == 2) {
                        ImageIcon X = new ImageIcon("images/Botões/Botão_X.png");
                        ImageIcon X_Hover = new ImageIcon("images/Botões Hover/BotãoHover_X.png");
                        ImageIcon X_press = new ImageIcon("images/Botões Pressionados/BotãoPress_X.png");

                        JToggleButton botaoX = new JToggleButton(X);
                        panelSuperior.add(botaoX);
                        botaoX.setVisible(true);
                        botaoX.setRolloverIcon(X_Hover);
                        botaoX.setPressedIcon(X_press);
                        botaoX.setSize(new Dimension(100, 100));
                        botaoX.setContentAreaFilled(false);
                        botaoX.setBorderPainted(false);
                        botaoX.setFocusPainted(false);

                        botaoX.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoX2Clicado) {
                                    botaoX2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "X");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoX.setIcon(X_press);
                                    botaoX.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Y':
                    contY += 1;
                    if (contY == 1) {
                        ImageIcon Y = new ImageIcon("images/Botões/Botão_Y.png");
                        ImageIcon Y_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Y.png");
                        ImageIcon Y_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Y.png");

                        JToggleButton botaoY = new JToggleButton(Y);
                        panelSuperior.add(botaoY);
                        botaoY.setVisible(true);
                        botaoY.setRolloverIcon(Y_Hover);
                        botaoY.setPressedIcon(Y_press);
                        botaoY.setSize(new Dimension(100, 100));
                        botaoY.setContentAreaFilled(false);
                        botaoY.setBorderPainted(false);
                        botaoY.setFocusPainted(false);

                        botaoY.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoYClicado) {
                                    botaoYClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Y");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoY.setIcon(Y_press);
                                    botaoY.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contY == 2) {
                        ImageIcon Y = new ImageIcon("images/Botões/Botão_Y.png");
                        ImageIcon Y_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Y.png");
                        ImageIcon Y_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Y.png");

                        JToggleButton botaoY = new JToggleButton(Y);
                        panelSuperior.add(botaoY);
                        botaoY.setVisible(true);
                        botaoY.setRolloverIcon(Y_Hover);
                        botaoY.setPressedIcon(Y_press);
                        botaoY.setSize(new Dimension(100, 100));
                        botaoY.setContentAreaFilled(false);
                        botaoY.setBorderPainted(false);
                        botaoY.setFocusPainted(false);

                        botaoY.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoY2Clicado) {
                                    botaoY2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Y");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoY.setIcon(Y_press);
                                    botaoY.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;
                case 'Z':
                    contZ += 1;
                    if (contZ == 1) {
                        ImageIcon Z = new ImageIcon("images/Botões/Botão_Z.png");
                        ImageIcon Z_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Z.png");
                        ImageIcon Z_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Z.png");

                        JToggleButton botaoZ = new JToggleButton(Z);
                        panelSuperior.add(botaoZ);
                        botaoZ.setVisible(true);
                        botaoZ.setRolloverIcon(Z_Hover);
                        botaoZ.setPressedIcon(Z_press);
                        botaoZ.setSize(new Dimension(100, 100));
                        botaoZ.setContentAreaFilled(false);
                        botaoZ.setBorderPainted(false);
                        botaoZ.setFocusPainted(false);

                        botaoZ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoZClicado) {
                                    botaoZClicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Z");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoZ.setIcon(Z_press);
                                    botaoZ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    if (contZ == 2) {
                        ImageIcon Z = new ImageIcon("images/Botões/Botão_Z.png");
                        ImageIcon Z_Hover = new ImageIcon("images/Botões Hover/BotãoHover_Z.png");
                        ImageIcon Z_press = new ImageIcon("images/Botões Pressionados/BotãoPress_Z.png");

                        JToggleButton botaoZ = new JToggleButton(Z);
                        panelSuperior.add(botaoZ);
                        botaoZ.setVisible(true);
                        botaoZ.setRolloverIcon(Z_Hover);
                        botaoZ.setPressedIcon(Z_press);
                        botaoZ.setSize(new Dimension(100, 100));
                        botaoZ.setContentAreaFilled(false);
                        botaoZ.setBorderPainted(false);
                        botaoZ.setFocusPainted(false);

                        botaoZ.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!botaoZ2Clicado) {
                                    botaoZ2Clicado = true;
                                    //JLabel
                                    JLabel label = new JLabel();
                                    panelLetraPalavra.add(label);
                                    label.setText(label.getText() + "Z");
                                    label.setFont(new Font("Bungee", Font.PLAIN, tamanhoFont));
                                    botaoZ.setIcon(Z_press);
                                    botaoZ.setRolloverEnabled(false);
                                }
                            }
                        });
                    }
                    break;

                default:
                    JButton botaosla = new JButton("?");
                    frame.add(botaosla);
                    break;
            }
        }

        //Final

        frame.add(panelSuperior);
        frame.add(panelLetraPalavra);
        frame.add(panelLinha);
        frame.add(panelInferior);
        frame.setVisible(true);
    }

    private static JPanel Panel(double heightPercentage) {
        JPanel panel = new JPanel();
        int frameHeight = 400; // Altura total do JFrame
        int panelHeight = (int) (frameHeight * heightPercentage); // Calcula a altura com base na porcentagem
        panel.setPreferredSize(new Dimension(400, panelHeight)); // Largura 100%, altura ajustada
        return panel;
    }
}