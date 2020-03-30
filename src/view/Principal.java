package view;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import controller.Jogador;
import controller.ThreadDuelo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Semaphore s = new Semaphore(2);
		ThreadDuelo duelo = null;
		int i = 0;
		ArrayList<Jogador> timeA = new ArrayList<Jogador>();
		ArrayList<Jogador> timeB = new ArrayList<Jogador>();
		
		timeA.add(new Jogador("Thor"));
		timeA.add(new Jogador("Homem de ferro"));
		timeA.add(new Jogador("Capitão America"));
		timeA.add(new Jogador("Hulk"));
		timeA.add(new Jogador("Viuva Negra"));
		
		timeB.add(new Jogador("Loki"));
		timeB.add(new Jogador("Mordok"));
		timeB.add(new Jogador("Caveira Vermelha"));
		timeB.add(new Jogador("Thanos"));
		timeB.add(new Jogador("Ultron"));
		
		for(i = 0; i<4; i++) {

			duelo = new ThreadDuelo(timeA.get(i), timeB.get(i), s);
			duelo.start();
			
			ThreadDuelo duelo2 = new ThreadDuelo(timeA.get(i+1), timeB.get(i+1), s);
			duelo2.start();
			
		}
		
		if(i > 0) {
			if(duelo.timeA > duelo.timeB) {
				System.out.println("TIME A GANHOU");
			}else{
				System.out.println("TIME B GANHOU");
			}
			
			System.out.println("PONTUAÇÃO");
			System.out.println("A: " + duelo.timeA + "\nB: " + duelo.timeB);
		}
		
		
	}

}
