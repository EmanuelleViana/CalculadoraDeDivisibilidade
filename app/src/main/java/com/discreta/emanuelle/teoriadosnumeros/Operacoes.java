package com.discreta.emanuelle.teoriadosnumeros;

/* Fazer operacoes no contexto dos numeros inteiros.
 * @author Emanuelle Viana Evangelista.
 * @version 1.2
 */
import java.util.*;


public class Operacoes {
    private static Scanner scanner;

    /*
     * Calcular a divisao de dois numeros , obter quociente e resto.
     *
     * @param a dividendo.
     *
     * @param b divisor.
     */
    public static int[] divisao(int a, int b) {

        int[] qr = new int[2];
        qr[0]= getQuociente(a, b) ;
        qr[1] = getResto(a, b);

        return qr;
    }// end divisao()

    /*
     * Obter somente o quociente de dois numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return quociente int.
     *
     */
    public static int getQuociente(int a, int b) {

        int quociente = 0;

        //para a>0 e b<0
        if (a > 0 && b < 0) {
            quociente = ((a / b));
        }
        // para a<0 e b>0
        else if (a < 0 && b > 0) {
            quociente = ((-(Math.abs(a / b))) - 1);     // q = -q' - 1
        }
        // para a<0 e b<0
        else if (a < 0 && b < 0) {

            quociente = ((Math.abs(a / b) + 1));    // q = q' + 1
        }
        // para a>0 e b>0
        else {
            quociente = (a / b);
        } // end if

        return quociente;
    }// end getQuociente()

    /*
     * Obter somente o resto de dois numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return resto int.
     *
     */
    public static int getResto(int a, int b) {

	    int resto = 0;

        //para a>0 e b<0c
        if (a > 0 && b < 0) {
            resto = (a % b);
        }
        // para a<0 e b>0
        else if (a < 0 && b > 0) {
            System.out.println(a + " " + b + " " + a % b);

            resto = (b - (Math.abs(a % b)));        // r = b - r'

        }
        // para a<0 e b<0
        else if (a < 0 && b < 0) {

            resto = (-b + (a % b)); // r = -b + r'
        }
        // para a>0 e b>0
        else {
            resto = (a % b);
        } // end if

        return resto;
    }

    /*
     * Calcular o MDC de dois numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return resp int MDC dos dois numeros.
     */
    public static int calculaMDC(int a, int b) {

        int resp = 0;

        //se b = 0 resto e 0 entao chegou no fim do algoritmo de euclides
        if (b == 0) {
            resp = a;
        } else if (a % b != 0) {    //se nao , enquanto for diferente de 0 calcula o resto

            resp = calculaMDC(b, a % b);
        } else {    //obtem o ultimo valor antes de 0
            resp = Math.abs(b);

        } // end if
        return resp;
    }// end calculaMDC()

    /*
     * Calcular o MDC de tres numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return resp int MDC dos dois numeros.
     */
    public static int calculaMDC(int a, int b, int c) {
        return calculaMDC(a, (calculaMDC(b, c)));
    }// end calculaMDC()

    /*
     * Calcular o MMC de dois numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return resp int MMC dos dois numeros.
     */
    public static int calculaMMC(int a, int b) {
        int resp = 0;
        if (a != 0 || b != 0) {
            resp = (Math.abs(a * b) / (calculaMDC(a, b)));      //mmc = a*b/mdc(a,b)
        }
        return resp;
    }// end calculaMDC()

    /*
     * Calcular o MMC de tres numeros.
     *
     * @param a primeiro numero.
     *
     * @param b segundo numero.
     *
     * @return resp int MDC dos dois numeros.
     */
    public static int calculaMMC(int a, int b, int c) {
        return calculaMMC(a, (calculaMMC(b, c)));
    }// end calculaMMC()

    /*
     * Metodo auxiliar. Armazenar valores para A no Algoritmo de Euclides em uma
     * lista de inteiros.
     */
    private static ArrayList<Integer> armazenarTermoA(int a, int b) {
        ArrayList<Integer> numberA = new ArrayList<>();
        int tmp;

        numberA.add(a);// adiciona o primeiro termo a no fim da lista
        while (b != 0 && a % b != 0) {
            tmp = b;
            b = a % b; // calculo para o termo b(resto)
            a = tmp;

            numberA.add(a);// adiciona o proximo termo a no fim da lista
        }

        return numberA;

    }// end armazenarTermoA()

    /*
     * Metodo auxiliar. Armazenar valores para B no Algoritmo de Euclides em uma
     * lista de inteiros.
     */
    private static ArrayList<Integer> armazenarTermoB(int a, int b) throws Exception {
        ArrayList<Integer> numberB = new ArrayList<>();
        int tmp;

        numberB.add(b);// adiciona o primeiro b no fim da lista

        while (b != 0 && a % b != 0) {      //usa o algoritmo de euclides para calcular restos

            tmp = b;
            b = a % b;
            a = tmp;

            numberB.add(b);// adiciona o a no fim da lista
        }

        return numberB;
    }// end armazenarTermoB()



    /*
     * Escrever mdc(a,b) como combinacao linear de a e b.
     *
     */
    public static int[] combinacaoLinear(int a, int b) throws Exception {
        int[] xy = new int[2];

        int tmp = 0;
        int x = 1;
        int y = 0;
        int i = armazenarTermoA(a, b).size() - 1;

        if (a != 0 && b != 0) {
            while (i >= 0) {

                //calcular x e y (tmp armazena o y anterior)    y = x'-(a/b)*y'
                tmp = y;
                y = x - ((armazenarTermoA(a, b).get(i) / armazenarTermoB(a, b).get(i))) * y; // y = x'-(a/b)*y'
                x = tmp;
                i--;
            }

            // Ignorar valores negativos.
            if ((a * x + b * y) == -(calculaMDC(a, b))) {
                x = -(x);
                y = -(y);
            }

            xy[0] = x;
            xy[1] = y;
        }
        return xy;
    }// end combinacaoLinear()




    /*
 * Escrever mdc(a,b,c) como combinacao linear de a,b e c.
 */
    public static int[]combinacaoLinear(int a, int b, int c) throws Exception {
        int[] xyz = new int[3];

        int c1 = combinacaoLinear(a, b)[0];//x0
        int c2 = combinacaoLinear(a, b)[1];//y0

        int d = calculaMDC(a, b); //mdc(a,b)

        int d1 = combinacaoLinear(d, c)[0];//w0
        int d2 = combinacaoLinear(d, c)[1];//z0

        xyz[0] = c1 * d1;
        xyz[1] = c2 * d1;
        xyz[2] = d2;

        //mdc(a,b,c) = a(x0*w0) + b(y0*w0) + cz0
        return xyz;

    }



	/*
	 * Calcular e Mostrar Solucoes Positivas(x e y).
	 */

	  public static String[] solucoesPositivas(int a, int b,int c){

          String [] positivas = new String[100];
          String[] solucoes = new String[100];
          int count = 0, counter = 0;

          if (a != 0 && b != 0) {
              //Garantir que a equação possui solucoes
              if ((c % calculaMDC(a, b)) == 0) {
                  for (int i = 0; i <= 100; i++) {
                      for (int j = 100; j >= 0; j--) {
                          if (count <= (solucoes.length - 1) && counter <= (solucoes.length - 1)) {
                              //Todas possibilidades de sinais e combinações
                              if (((a * i) + (b * i)) == c) {
                                  positivas[counter] = "x = " + i + ",  y = " + i + "\n";
                                  counter++;
                              } else if (((a * i) + (b * j)) == c) {
                                  positivas[counter] = "x= " + i + ",  y = " + j + "\n";
                                  counter++;
                              } else if (((a * -i) + (b * -j)) == c) {
                                  solucoes[count] = "x= " + -i + ",  y = " + -j + "\n";
                                  count++;
                              } else if (((a * -i) + (b * -i)) == c) {
                                  solucoes[count] = "x= " + -i + ",  y = " + -i + "\n";
                                  count++;
                              } else if (((a * -i) + (b * j)) == c) {
                                  solucoes[count] = "x= " + -i + ",  y = " + j + "\n";
                                  count++;
                              } else if (((a * -i) + (b * i)) == c) {
                                  solucoes[count] = "x= " + -i + ",  y = " + i + "\n";
                                  count++;
                              } else if (((a * i) + (b * -j)) == c) {
                                  solucoes[count] = "x= " + i + ",  y = " + -j + "\n";
                                  count++;
                              }
                          } else {
                              i = 101;
                          }
                      }
                  }
              }
          }
              return positivas;

      }//end solucoesPostivas()



    //verificar se uma equacao diofantina tem solucoes  MDC(a,b) divide c
    public static boolean hasSolutions(int a,int b,int c){
        return (c % calculaMDC(a,b) == 0);
    }





    /**
     * Metodo para calculo da Equação Diofantina por meio do Alg. Extendido de
     * Euclides
     */
    public static ArrayList equacaoDiofantinaAll(int a,int b,int c) {

        ArrayList<String> positivas = new ArrayList<>();
        ArrayList<String> solucoes = new ArrayList<>();

        //String equacao = "Equação Diofantina: " + a + "x + " + b + "y = " + c;

        if (a != 0 && b != 0) {
            //Inserir resultado no painel


            //Garantir que a equação possui solucoes
            if ((c % calculaMDC(a, b)) == 0) {
                for (int i = 0; i <= 100; i++) {
                    for (int j = 100; j >= 0; j--) {
                        //Soluções positivas
                        if (((a * i) + (b * j)) == c) {
                            positivas.add("x = " + i + ",  y = " + j + "\n");
                        } else if (((a * j) + (b * i)) == c) {
                            positivas.add("x = " + j + ",  y = " + i + "\n");
                        } else if (((a * i) + (b * i)) == c) {
                            positivas.add("x = " + i + ",  y = " + i + "\n");
                        } else if (((a * j) + (b * j)) == c) {
                            positivas.add("x = " + j + ",  y = " + j + "\n");
                            //Soluções negativas
                        } else if (((a * (-i)) + (b * (-i))) == c) {
                            solucoes.add("x = " + (-i) + ",  y = " + (-i) + "\n");
                        } else if (((a * (-j)) + (b * (-j))) == c) {
                            solucoes.add("x = " + (-j) + ",  y = " + (-j) + "\n");
                        } else if (((a * (-i)) + (b * (-j))) == c) {
                            solucoes.add("x = " + (-i) + ",  y = " + (-j) + "\n");
                        } else if (((a * (-j)) + (b * (-i))) == c) {
                            solucoes.add("x = " + (-j) + ",  y = " + (-i) + "\n");
                            //Mixadas
                        } else if (((a * i) + (b * (-i))) == c) {
                            solucoes.add("x = " + i + ",  y = " + (-i) + "\n");
                        } else if (((a * j) + (b * (-j))) == c) {
                            solucoes.add("x = " + j + ",  y = " + (-j) + "\n");
                        } else if (((a * (-i)) + (b * i)) == c) {
                            solucoes.add("x = " + (-i) + ",  y = " + i + "\n");
                        } else if (((a * (-j)) + (b * j)) == c) {
                            solucoes.add("x = " + (-j) + ",  y = " + j + "\n");
                        } else if (((a * (-i)) + (b * j)) == c) {
                            solucoes.add("x = " + (-i) + ",  y = " + j + "\n");
                        } else if (((a * i) + (b * (-j))) == c) {
                            solucoes.add("x = " + i + ",  y = " + (-j) + "\n");
                        } else if (((a * (-j)) + (b * i)) == c) {
                            solucoes.add("x = " + (-j) + ",  y = " + i + "\n");
                        } else if (((a * j) + (b * (-i))) == c) {
                            solucoes.add("x = " + j + ",  y = " + (-i) + "\n");
                        }
                    }
                }

                //Encontrar e eliminar duplicatas das duas listas
                Set<String> duplicatas = new HashSet<>();
                duplicatas.addAll(positivas);
                positivas.clear();
                positivas.addAll(duplicatas);
                duplicatas.clear();
                duplicatas.addAll(solucoes);
                solucoes.clear();
                solucoes.addAll(duplicatas);
            }
        }

        return solucoes;
    }




      /*
	 * Calcular e Mostrar Todas Solucoes(incluindo negativas - x e y).
	 */

    public static String[] equacaoDiofantinaAll2(int a, int b,int c){

        String [] positivas = new String[100];
        String[] solucoes = new String[100];
        int count = 0, counter = 0;

        if (a != 0 && b != 0) {
            //Garantir que a equação possui solucoes
            if ((c % calculaMDC(a, b)) == 0) {
                for (int i = 0; i <= 100; i++) {
                    for (int j = 100; j >= 0; j--) {
                        if (count <= (solucoes.length - 1) && counter <= (solucoes.length - 1)) {
                            //Todas possibilidades de sinais e combinações
                            if (((a * i) + (b * i)) == c) {
                                positivas[counter] = "x = " + i + ",  y = " + i + "\n";
                                counter++;
                            } else if (((a * i) + (b * j)) == c) {
                                positivas[counter] = "x= " + i + ",  y = " + j + "\n";
                                counter++;
                            } else if (((a * -i) + (b * -j)) == c) {
                                solucoes[count] = "x= " + -i + ",  y = " + -j + "\n";
                                count++;
                            } else if (((a * -i) + (b * -i)) == c) {
                                solucoes[count] = "x= " + -i + ",  y = " + -i + "\n";
                                count++;
                            } else if (((a * -i) + (b * j)) == c) {
                                solucoes[count] = "x= " + -i + ",  y = " + j + "\n";
                                count++;
                            } else if (((a * -i) + (b * i)) == c) {
                                solucoes[count] = "x= " + -i + ",  y = " + i + "\n";
                                count++;
                            } else if (((a * i) + (b * -j)) == c) {
                                solucoes[count] = "x= " + i + ",  y = " + -j + "\n";
                                count++;
                            }
                        } else {
                            i = 101;
                        }
                    }
                }
            }
            int i = 0;

            int x = 0;

            while (solucoes[i] == solucoes[i + 1] && solucoes[i] != "" && i < solucoes.length) {
                solucoes[i] = "";
            }


        }
        return solucoes;

    }//end equacaoDiofantinaAll2()


    /**
     * Metodo para calculo da Equacao Diofantina por meio do Alg. Extendido de Euclides
     */
    public static String[] equacaoDiofantina(int a,int b,int c) {

        String[] solucoes = new String[c];
        int count = 0;

        //  String equacao = a + "x + " + b + "y = " + c;

        if (a != 0 && b != 0) {
            //Inserir resultado no painel

            //Garantir que a equaÃ§Ã£o possui solucoes
            if ((c % calculaMDC(a, b)) == 0) {
                for (int i = 0; i <= 100; i++) {
                    for (int j = 100; j >= 0; j--) {
                        if (((a * i) + (b * i)) == c) {
                            solucoes[count] = "x = " + i + ",  y = " + i + "\n";
                            count++;
                        } else if (((a * i) + (b * j)) == c) {
                            solucoes[count] = "x= " + i + ",  y = " + j + "\n";
                            count++;
                        }
                    }
                }
            }
        }
        return solucoes;
    }



    /*
     * Pausar a execucao ate que o usuario aperte ENTER.
     *
     * @param msg Instrucao mostrada ao usuario.
     */
    public static void pause(String msg) {
        System.out.println("Aperte ENTER para continuar");
        scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}// end class TeoriaDosNumeros
