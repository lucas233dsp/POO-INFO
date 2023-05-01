package janelas2;
import java.awt.Color;
import java.awt.Graphics;

public class Colunainicial {

	private int x;
	private int y;
	
	public static final int LARGURA = 25;
	public static final int ALTURA  = 150;

	public Colunainicial(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void move(int xm, Graphics g) {
		if ((xm < 800 - Colunainicial.LARGURA -2)&&(xm > 2)){
			this.draw(g,Color.WHITE);
			this.x=xm;
			this.draw(g,Color.BLACK);
		}
		
	}
	
	public void draw(Graphics g, Color c) {
	    g.setColor(c); //seleciona cor de fundo
	    g.fillRect( this.x, this.y,Colunainicial.LARGURA, Colunainicial.ALTURA);//pinta tudo com a cor selecionada
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


}