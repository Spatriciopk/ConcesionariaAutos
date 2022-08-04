package controller;

import java.util.ArrayList;

import javax.swing.JLabel;

public class bannerImagen extends Thread {

	ArrayList<JLabel> listaImagenAux ;
	double ximg1;
	double yimg1;
	double ximg2;
	double yimg2;
	double ximg3;
	double yimg3;
	boolean act,act1,act2 ;
	
	public bannerImagen(ArrayList<JLabel> listaImagen) {
		this.listaImagenAux = listaImagen;
		listaImagenAux.get(0).setBounds(10,122, 185, 184);
		listaImagenAux.get(1).setBounds(205,122, 185, 184);
		listaImagenAux.get(2).setBounds(402,122, 185, 184);
		this.ximg1 =listaImagenAux.get(0).getLocation().getX();
		this.ximg2 =listaImagenAux.get(1).getLocation().getX();
		this.ximg3 =listaImagenAux.get(2).getLocation().getX();
		this.yimg1 =listaImagenAux.get(0).getLocation().getY();
		this.yimg2 =listaImagenAux.get(1).getLocation().getY();
		this.yimg3 =listaImagenAux.get(2).getLocation().getY();
		
		act=false;
		act1=false;
		act2=false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			ximg1 =  ximg1 +10;
			ximg2 = ximg2 +10;
			ximg3 = ximg3 +10;
			listaImagenAux.get(0).setBounds((int)ximg1,(int) yimg1, 185, 184);
			listaImagenAux.get(1).setBounds((int)ximg2,(int) yimg2, 185, 184);
			listaImagenAux.get(2).setBounds((int)ximg3,(int) yimg3, 185, 184);
		
			
			if(ximg1  >= 660 && act ==false )  {
				ximg1 = -20;
				listaImagenAux.get(0).setBounds((int)ximg1,(int) yimg1, 185, 184);
				act=true;
			}
			
			if( act &&  ximg1 >= 670) {
				ximg1 = -20;
				listaImagenAux.get(0).setBounds((int)ximg1,(int) yimg1, 185, 184);
				act=true;
			}
			
			
			
			if(ximg2  >= 650 && act2 ==false )  {
				ximg2 = -20;
				listaImagenAux.get(1).setBounds((int)ximg2,(int) yimg2, 185, 184);
				act2=true;
			}
			
			if( act2 &&  ximg2 >= 670) {
				ximg2 = -20;
				listaImagenAux.get(1).setBounds((int)ximg2,(int) yimg2, 185, 184);
				act2=true;
			}
			
			if(ximg3  >= 640 && act1 ==false )  {
				ximg3 = -20;
				listaImagenAux.get(2).setBounds((int)ximg3,(int) yimg3, 185, 184);
				act1=true;
			}
			
			if( act1 &&  ximg3 >= 670) {
				ximg3 = -20;
				listaImagenAux.get(2).setBounds((int)ximg3,(int) yimg3, 185, 184);
				act1=true;
			}
			

			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
}
