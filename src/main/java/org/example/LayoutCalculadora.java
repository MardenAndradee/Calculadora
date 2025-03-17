package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutCalculadora extends JFrame implements ActionListener {
    private JPanel painel;
    private JPanel painelBotoes;
    private JTextArea taArea;

    private double valorAnterior = 0;
    private String operador = "";
    private boolean novoValor = true;

    JButton btnAC = new JButton("AC");
    JButton btnMaismenos = new JButton("±");
    JButton btnPorcentagem = new JButton("%");
    JButton btnRaiz = new JButton("√");
    JButton btnBarra = new JButton("/");
    JButton btnSete = new JButton("7");
    JButton btnOito = new JButton("8");
    JButton btnNove = new JButton("9");
    JButton btnXY = new JButton("xʸ");
    JButton btnMultiplicar = new JButton("*");
    JButton btnQuatro = new JButton("4");
    JButton btnCinco = new JButton("5");
    JButton btnSeis = new JButton("6");
    JButton btnQuadrado = new JButton("x²");
    JButton btnSubtrair = new JButton("-");
    JButton btnUm = new JButton("1");
    JButton btnDois = new JButton("2");
    JButton btnTres = new JButton("3");
    JButton btnCubo = new JButton("x³");
    JButton btnMais = new JButton("+");
    JButton btnZero = new JButton("0");
    JButton btnPonto = new JButton(".");
    JButton btnFatorial = new JButton("!");
    JButton btnElevadoDez = new JButton("10ˣ");
    JButton btnResultado = new JButton("=");

    public LayoutCalculadora(){
        painel = new JPanel();
        painelBotoes = new JPanel();
        taArea = new JTextArea();

        configurarFrame();
    }

    public void configurarFrame(){
        setTitle("Calculadora");
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(painel);
        configurarPainel();
        configurarBotoes();
    }

    public void configurarPainel(){
        painel.setLayout(null);
        painel.add(taArea);
        taArea.setBounds(10,10,350,25);

        painel.add(painelBotoes);
        painelBotoes.setBounds(10,50,560,400);

    }

    public void configurarBotoes(){
        painelBotoes.setLayout(new GridLayout(5, 5, 5, 5));
        JButton[] botoes = {btnAC, btnMaismenos, btnPorcentagem, btnRaiz,
                btnBarra, btnSete, btnOito, btnNove, btnXY, btnMultiplicar,
                btnQuatro, btnCinco, btnSeis, btnQuadrado, btnSubtrair,
                btnUm, btnDois, btnTres, btnCubo, btnMais,
                btnZero, btnPonto, btnFatorial, btnElevadoDez, btnResultado};

        painelBotoes.setSize(350,200);

        for (JButton btn : botoes) {
            painelBotoes.add(btn);
            btn.addActionListener(this);
        }


    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String texto = taArea.getText();
        String comando = ae.getActionCommand();

        if(ae.getSource().equals(btnAC)){
            taArea.setText("");
            valorAnterior = 0;
            operador = "";
        }
        if(ae.getSource().equals(btnUm)){
            texto += "1";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnDois)){
            texto += "2";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnTres)){
            texto += "3";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnQuatro)){
            texto += "4";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnCinco)){
            texto += "5";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnSeis)){
            texto += "6";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnSete)){
            texto += "7";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnOito)){
            texto += "8";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnNove)){
            texto += "9";
            taArea.setText(texto);
        }
        if(ae.getSource().equals(btnMaismenos)){
            taArea.setText(Double.toString(Double.parseDouble(texto)*-1));

        }
        if(ae.getSource().equals(btnPorcentagem)){
            taArea.setText(Double.toString(Double.parseDouble(texto) / 100));
        }
        if(ae.getSource().equals(btnRaiz)){
            taArea.setText(Double.toString(Math.sqrt(Double.parseDouble(texto))));
        }
        if(ae.getSource().equals(btnQuadrado)){
            taArea.setText(Double.toString(Math.pow(Double.parseDouble(texto), 2)));
        }
        if(ae.getSource().equals(btnCubo)){
            taArea.setText(Double.toString(Math.pow(Double.parseDouble(texto), 3)));
        }
        if(ae.getSource().equals(btnElevadoDez)){
            taArea.setText(Double.toString(Math.pow(10, Double.parseDouble(texto))));
        }
        if(ae.getSource().equals(btnFatorial)){
            int n = Integer.parseInt(texto);
            long fat = 1;
            for (int i = 2; i <= n; i++) fat *= i;
            taArea.setText(Long.toString(fat));
        }
        if ("+-*/xʸ".contains(comando)) {
                if (!operador.isEmpty()) {
                    calcular();
                }
                valorAnterior = Double.parseDouble(taArea.getText());
                operador = comando;
                novoValor = true;
            } 
        if (comando.equals("=")) {
            calcular();
        } else {
            if (!operador.isEmpty()) {
                calcular();
            }
            operador = comando;
            valorAnterior = Double.parseDouble(texto);
            novoValor = true;
        }

    }

     private void calcular() {
        double valorAtual = Double.parseDouble(taArea.getText());
        double resultado = 0;

        switch (operador) {
            case "+": 
                resultado = valorAnterior + valorAtual; 
                break;
            case "-": 
                resultado = valorAnterior - valorAtual; 
                break;
            case "*":
                resultado = valorAnterior * valorAtual; 
                break;
            case "/": 
                resultado = valorAnterior / valorAtual;
                break;
            case "xʸ": resultado = Math.pow(valorAnterior, valorAtual); 
                break;
        }

        taArea.setText(Double.toString(resultado));
        valorAnterior = resultado;
        novoValor = true;
    }

}
