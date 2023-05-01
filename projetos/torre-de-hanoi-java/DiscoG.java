package janelas2;

import java.awt.Color;
import java.awt.Graphics;

public class DiscoG {
	private int x;
	private int y;
	
	public static final int LARGURA = 100;
	public static final int ALTURA  = 25;

	public DiscoG(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g, Color c) {
	    g.setColor(c); //seleciona cor de fundo
	    g.fillRect( this.x, this.y,DiscoG.LARGURA, DiscoG.ALTURA);//pinta tudo com a cor selecionada
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