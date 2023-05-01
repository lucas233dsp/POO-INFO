package janelas2;

import java.awt.Color;
import java.awt.Graphics;

public class DiscoM {
	private int x;
	private int y;
	
	public static final int LARGURA = 75;
	public static final int ALTURA  = 25;

	public DiscoM(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g, Color c) {
	    g.setColor(c); //seleciona cor de fundo
	    g.fillRect( this.x, this.y,DiscoM.LARGURA, DiscoM.ALTURA);//pinta tudo com a cor selecionada
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