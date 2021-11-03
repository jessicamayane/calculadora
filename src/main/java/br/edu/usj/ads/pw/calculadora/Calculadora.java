package br.edu.usj.ads.pw.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculadora {
   
   @PostMapping(value="calcular")
   public ModelAndView postCalcular(@RequestParam String operando1, @RequestParam String operando2, @RequestParam String operador){

      Double operando1Double = Double.valueOf(operando1);
      Double operando2Double = Double.valueOf(operando2);
      
      //resultado matematico
      Double resultadoOperacao = 0.0;

      //tem os operadndo em double e string..

      if (operador.equals("+")){
          resultadoOperacao = operando1Double + operando2Double;

      }
      if (operador.equals("-")){
         resultadoOperacao = operando1Double - operando2Double;

     }
      if (operador.equals("*")){
         resultadoOperacao = operando1Double * operando2Double;

  }
      if (operador.equals("/")){
         resultadoOperacao = operando1Double / operando2Double;

}

      //resultado em texto. 
      String operacao = operando1 + operador + operando2 + " = " + resultadoOperacao;

      ModelAndView modelAndView = new ModelAndView("resultado");
      modelAndView.addObject("texto_resultado", operacao);
      return modelAndView;
   }

}
//depois de fazer/ajustar o "mapeamento do que deve ser feito, olhando o documento index.html, cria-se o documento de resposta (que será o resultado da requisição )no "template" pra só depois fazer as implementações neste doc. 
//do index chama o calcular e do calcular chama o template resultado processa a requisição 

