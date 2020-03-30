package controller;

import java.util.concurrent.Semaphore;

public class ThreadDuelo extends Thread{

	/*int[] timeA = new int[5];
	int[] timeB = new int[5];*/
	
	
	Jogador jog1, jog2;
	Semaphore semaforo;
	
	public static int timeA = 0, timeB = 0;
	
	public ThreadDuelo(Jogador jog1, Jogador jog2, Semaphore semaforo) {
		this.jog1 = jog1;
		this.jog2 = jog2;
		

		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			semaforo.acquire(); 
			duelar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.run();
	}
	
	public void duelar() {
		int i = 0;
		boolean ganhou = false;
		
		while(i < 5) {
			
			try {
				sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("DUELO ENTRE " + jog1.nome + " E " + jog2.nome);

			
			if((jog1.pontos == 3)) {
				System.out.println("Jogador " + jog1.nome + " ganhou O DUELO");
				ganhou = true;
				timeA++;
				
				
				
				break;
			
			}else if ((jog2.pontos == 3)) {
				System.out.println("Jogador " + jog2.nome + " ganhou O DUELO");
				timeB++;
				ganhou = true;
				break;
			
			}else {
				
				jog1.jogada = (int) ((Math.random() * 3) + 1);
				jog2.jogada = (int) ((Math.random() * 3) + 1);

				
				//Pontos time A
				
				if((jog1.jogada ==3 && jog2.jogada == 2)
				|| (jog1.jogada == 2 && jog2.jogada == 1)
				|| (jog1.jogada == 1 && jog2.jogada == 3)) {
					
					jog1.pontos++;
					
				//Pontos time B
				}else if((jog2.jogada ==3 && jog1.jogada == 2)
				|| (jog2.jogada == 2 && jog1.jogada == 1)
				|| (jog2.jogada == 1 && jog1.jogada == 3)){
					
					jog2.pontos++;
				}
				
				System.out.println(jog1.nome + ":" + jog1.pontos + " X " + jog2.pontos + ":" + jog2.nome);
			}
			
			
			
			i++;
		}
		if(ganhou == false) {
			System.out.println("NINGUÉM GANHOUU");
		}
		jog1.pontos = 0;
		jog2.pontos = 0;
		semaforo.release();
		
		
	}
	
	public void ganhador() {
		System.out.println("TIME A: " + timeA + "TIME B: " + timeB);
		
		
	}

}
