package br.com.vainaweb.backendt3.megaSena;

import java.util.Scanner;
import java.util.Random;

public class MegaSena {

	public static void main(String[] args) {
		
		int numeros [] = new int[7];
		
		Scanner scan = new Scanner(System.in);
		
		  for (int i = 0; i < numeros.length; i++) {
	            boolean continuar = true;
	            boolean repetido = false;

	            while (continuar) {
	                System.out.println("Escolha um numero entre 1 e 100: ");
	                if (scan.hasNextInt()) {
	                    int numero = scan.nextInt();
	                    
	                    if (numero >= 1 && numero <= 100) {
	                        repetido = false;

	                        for (int digitado : numeros) {
	                            if (numero == digitado) {
	                                repetido = true;
	                                break;
	                            }
	                        }

	                        if (repetido) {
	                            System.out.println("Numero ja digitado, tente outro");
	                        } else {
	                            numeros[i] = numero;
	                            continuar = false;
	                        }
	                    } else {
	                        System.out.println("Por favor, digite um numero entre 1 e 100.");
	                    }
	                } else {
	                    System.out.println("Por favor, digite um numero inteiro valido.");
	                    scan.next();
	                }
	            }
	        }
		
		Random aleatorio = new Random();
		int sorteados [] = new int[7];
		
		for(int j = 0; j < sorteados.length; j++) {
			boolean continuar = true;
			boolean repetido = false;
			while(continuar) {
				int valor = aleatorio.nextInt(100) + 1;
				repetido = false;
				for(int sorteado : sorteados) {
					if(sorteado == valor) {
						repetido = true;
						break;
					}
				}
				
				if(repetido) {
					continue;
				} else {
					sorteados[j] = valor;
					continuar = false;
				}
 
			}
		}
		
		for(int n : numeros) {
			System.out.print(n + " ");
		}
		
		System.out.println();
		
		for(int s : sorteados) {
			System.out.print(s + " ");
		}
		
		int matches = 0;
		for(int comparadoNumero : numeros) {
			for(int comparadoSorteados: sorteados) {
				if(comparadoNumero == comparadoSorteados) {
					matches++;
				}
			}
		}
		
		System.out.println();
		
		if(matches >= 7) {
			System.out.println("Parabes, voce acertou " + matches + " numeros. Seu premio: R$200.000");
		}
		else if(matches > 5) {
			System.out.println("Parabes, voce acertou " + matches + " numeros. Seu premio: R$50.000");
		}
		else if(matches > 4) {
			System.out.println("Parabes, voce acertou " + matches + " numeros. Seu premio: R$10.000");
		} else {
			System.out.println("Infelizmente nao foi dessa vez! Voce nao ganhou nenhum premio");
		}
		
	}
}

