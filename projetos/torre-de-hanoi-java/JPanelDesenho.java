package janelas2;

import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class JPanelDesenho extends JPanel {
	private BufferedImage  bufferedImage;
	private Colunainicial  colunainicial;
	private Colunatrabalho colunatrabalho;
	private Colunafinal    colunafinal;
	private Barra          barra;
	private DiscoG         discoG;
	private DiscoM         discoM;
	private DiscoP         discoP;
	
	
	
	static JPanelDesenho __instance;
	
	
	public static JPanelDesenho getInstance() {
		if (__instance == null) {
			__instance = new JPanelDesenho();
		}
		return __instance;
	}
	
	/**
	 * Construtor do Painel de desenho
	 */
	public JPanelDesenho() {
		super(true);
	    int width = 800;
	    int height = 600;
	    this.colunainicial = new Colunainicial(185,300);
	    this.colunatrabalho = new Colunatrabalho(375,300);
	    this.colunafinal = new Colunafinal(575,300);
	    this.barra = new Barra(150,425);
	    this.discoG = new DiscoG(150,400);
	    this.discoM = new DiscoM(163,375);
	    this.discoP = new DiscoP(174,350);
	    this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    this.addMouseListener(new AcaoMouse());
	    this.addMouseMotionListener(new AcaoMouse());
	    
	    
	
	    __instance = this;
	   
	}

	public JPanelDesenho(LayoutManager layout) {
		super(layout);
	}

	public JPanelDesenho(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public JPanelDesenho(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
	
	    g.setColor(Color.WHITE); 
	   
	    g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
	   
	    g.drawImage(bufferedImage, 0, 0, null); 
	   
	    colunainicial.draw(g,Color.BLACK);
	    colunatrabalho.draw(g,Color.BLACK);
	    colunafinal.draw(g,Color.BLACK);
	    barra.draw(g,Color.BLACK);
	    discoG.draw(g,Color.RED);
	    discoM.draw(g,Color.GREEN);
	    discoP.draw(g,Color.BLUE);
	   
	    g.dispose();
	}
	
	private class AcaoMouse implements MouseListener, MouseMotionListener {

	    public void mouseClicked(MouseEvent e) {
	
	    }

	    public void mousePressed(MouseEvent e) {
	    	
	    }

	    public void mouseReleased(MouseEvent e) {
	    	
	    }

	    public void mouseEntered(MouseEvent e) {
	    }

	    public void mouseExited(MouseEvent e) {
	    }

	    public void mouseDragged(MouseEvent e) {
	    	int x = e.getX();
	    	int y = e.getY();
	    	if (discoG.getX() <= x && x <= discoG.getX() + discoG.LARGURA
	    			&& discoG.getY() <= y && y <= discoG.getY() + discoG.ALTURA) {
	    		Graphics gDoBuffer = bufferedImage.createGraphics();
	    		discoG.setX(e.getX() - discoG.LARGURA / 2);
	    		discoG.setY(e.getY() - discoG.ALTURA / 2);
	    		if(colunatrabalho.getX() <= x && x <= colunatrabalho.getX() + colunatrabalho.LARGURA
		    			&& colunatrabalho.getY() <= y && y <= colunatrabalho.getY() + colunatrabalho.ALTURA) {
	    		
	    			discoG.setX(colunatrabalho.getX()-(colunatrabalho.LARGURA+15));
             	    discoG.setY(barra.getY()-barra.ALTURA);
             	
	    	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA) {
	    		  
             	   discoG.setX(colunafinal.getX()-(colunafinal.LARGURA+15));
             	   discoG.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunainicial.getX() <= x && x <= colunainicial.getX() + colunainicial.LARGURA
		    			&& colunainicial.getY() <= y && y <= colunainicial.getY() + colunainicial.ALTURA) {
	    		  
             	   discoG.setX(colunainicial.getX()-(colunainicial.LARGURA+15));
             	   discoG.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoP.getX() == (colunafinal.getX()-(colunafinal.LARGURA / 2))) {
	    			 discoG.setX(colunafinal.getX()-(colunafinal.LARGURA+15));
	             	 discoG.setY(barra.getY()-(barra.ALTURA*2));
	    		}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoG.getY() == (barra.getY()-(barra.ALTURA*2))) {
	    			JOptionPane.showMessageDialog(null, "Incorreto");
	    		}
	    		gDoBuffer.dispose();
                updateUI();
	    	}
	    	if (discoM.getX() <= x && x <= discoM.getX() + discoM.LARGURA
	    			&& discoM.getY() <= y && y <= discoM.getY() + discoM.ALTURA) {
	    		Graphics gDoBuffer = bufferedImage.createGraphics();
	    		discoM.setX(e.getX() - discoM.LARGURA / 2);
	    		discoM.setY(e.getY() - discoM.ALTURA / 2);
	    		if(colunatrabalho.getX() <= x && x <= colunatrabalho.getX() + colunatrabalho.LARGURA
		    			&& colunatrabalho.getY() <= y && y <= colunatrabalho.getY() + colunatrabalho.ALTURA) {
	    		
	    			discoM.setX(colunatrabalho.getX()-(colunatrabalho.LARGURA));
             	    discoM.setY(barra.getY()-barra.ALTURA);
             	
	    	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA) {
	    		  
	    			discoM.setX(colunafinal.getX()-(colunafinal.LARGURA)); 
             	    discoM.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunainicial.getX() <= x && x <= colunainicial.getX() + colunainicial.LARGURA
		    			&& colunainicial.getY() <= y && y <= colunainicial.getY() + colunainicial.ALTURA) {
	    		  
	    			discoM.setX(colunainicial.getX()-(colunainicial.LARGURA));
             	    discoM.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoG.getX() == (colunafinal.getX()-(colunafinal.LARGURA+15))) {
	    			discoM.setX(colunafinal.getX()-(colunafinal.LARGURA));
             	    discoM.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		gDoBuffer.dispose();
                updateUI();
	    	}
	    	if (discoP.getX() <= x && x <= discoP.getX() + discoP.LARGURA
	    			&& discoP.getY() <= y && y <= discoP.getY() + discoP.ALTURA) {
	    		Graphics gDoBuffer = bufferedImage.createGraphics();
	    		discoP.setX(e.getX() - discoP.LARGURA / 2);
	    		discoP.setY(e.getY() - discoP.ALTURA / 2);
	    		if(colunatrabalho.getX() <= x && x <= colunatrabalho.getX() + colunatrabalho.LARGURA
		    			&& colunatrabalho.getY() <= y && y <= colunatrabalho.getY() + colunatrabalho.ALTURA) {
	    		   
	    			discoP.setX(colunatrabalho.getX()-(colunatrabalho.LARGURA / 2));
             	    discoP.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunatrabalho.getX() <= x && x <= colunatrabalho.getX() + colunatrabalho.LARGURA
		    			&& colunatrabalho.getY() <= y && y <= colunatrabalho.getY() + colunatrabalho.ALTURA
		    			&& discoM.getX() == (colunatrabalho.getX()-(colunatrabalho.LARGURA))) {
	    			discoP.setX(colunatrabalho.getX()-(colunatrabalho.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunatrabalho.getX() <= x && x <= colunatrabalho.getX() + colunatrabalho.LARGURA
		    			&& colunatrabalho.getY() <= y && y <= colunatrabalho.getY() + colunatrabalho.ALTURA
		    			&& discoG.getX() == (colunatrabalho.getX()-(colunatrabalho.LARGURA+15))) {
	    			discoP.setX(colunatrabalho.getX()-(colunatrabalho.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoM.getX() == (colunafinal.getX()-(colunafinal.LARGURA))) {
	    			discoP.setX(colunafinal.getX()-(colunafinal.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunainicial.getX() <= x && x <= colunainicial.getX() + colunainicial.LARGURA
		    			&& colunainicial.getY() <= y && y <= colunainicial.getY() + colunainicial.ALTURA
		    			&& discoG.getX() == (colunainicial.getX()-(colunainicial.LARGURA+15))) {
	    			discoP.setX(colunainicial.getX()-(colunainicial.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunainicial.getX() <= x && x <= colunainicial.getX() + colunainicial.LARGURA
		    			&& colunainicial.getY() <= y && y <= colunainicial.getY() + colunainicial.ALTURA
		    			&& discoM.getX() == (colunainicial.getX()-(colunainicial.LARGURA))) {
	    			discoP.setX(colunainicial.getX()-(colunainicial.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoG.getX() == (colunafinal.getX()-(colunafinal.LARGURA+15))) {
	    			discoP.setX(colunafinal.getX()-(colunafinal.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 2));
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA) {
	    		  
             	   discoP.setX(colunafinal.getX()-(colunafinal.LARGURA / 2));
             	   discoP.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunainicial.getX() <= x && x <= colunainicial.getX() + colunainicial.LARGURA
		    			&& colunainicial.getY() <= y && y <= colunainicial.getY() + colunainicial.ALTURA) {
	    		  
             	   discoP.setX(colunainicial.getX()-(colunainicial.LARGURA / 2));
             	   discoP.setY(barra.getY()-barra.ALTURA);
             	   
             	}
	    		if(colunafinal.getX() <= x && x <= colunafinal.getX() + colunafinal.LARGURA
		    			&& colunafinal.getY() <= y && y <= colunafinal.getY() + colunafinal.ALTURA
		    			&& discoG.getX() == (colunafinal.getX()-(colunafinal.LARGURA+15)) && discoM.getX() == (colunafinal.getX()-(colunafinal.LARGURA))) {
	    			discoP.setX(colunafinal.getX()-(colunafinal.LARGURA / 2));
             	    discoP.setY(barra.getY()-(barra.ALTURA * 3));
             	   
             	}
	    		 gDoBuffer.dispose();
                 updateUI();
             	
	    	}
	    	if(discoG.getX() == (colunafinal.getX()-(colunafinal.LARGURA+15)) && discoM.getX() == (colunafinal.getX()-(colunafinal.LARGURA))
	    			&& discoP.getX() == (colunafinal.getX()-(colunafinal.LARGURA / 2))) {
	    		JOptionPane.showMessageDialog(null, "Parabéns, você completou a torre de hanói!");
	    	}
	    }
	    	
	

	    public void mouseMoved(MouseEvent e) {
	    	
	    }
	}
	
	
	
	public Colunainicial getColuna() {
		return colunainicial;
	}

	public void setColuna(Colunainicial colunainicial) {
		this.colunainicial = colunainicial;
	}


	
	/**
	 * 
	 * 
	 */
	public static void main(String[] args) {
	   
	    JFrame jFrame = new JFrame();
	   
	    
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	  
	    JPanelDesenho desenho = new JPanelDesenho();
	   
	    desenho.setPreferredSize(new Dimension(800, 600));
	    
	    jFrame.getContentPane().add(desenho);
	    
	    jFrame.setResizable(false);
	    jFrame.pack();
	    
	    jFrame.setVisible(true);
	}

	public Colunatrabalho getColunatrabalho() {
		return colunatrabalho;
	}

	public void setColunatrabalho(Colunatrabalho colunatrabalho) {
		this.colunatrabalho = colunatrabalho;
	}

	public Colunafinal getColunafinal() {
		return colunafinal;
	}

	public void setColunafinal(Colunafinal colunafinal) {
		this.colunafinal = colunafinal;
	}

	public Barra getBarra() {
		return barra;
	}

	public void setBarra(Barra barra) {
		this.barra = barra;
	}

	public DiscoG getDiscoG() {
		return discoG;
	}

	public void setDiscoG(DiscoG discoG) {
		this.discoG = discoG;
	}

	public DiscoM getDiscoM() {
		return discoM;
	}

	public void setDiscoM(DiscoM discoM) {
		this.discoM = discoM;
	}

	public DiscoP getDiscoP() {
		return discoP;
	}

	public void setDiscoP(DiscoP discoP) {
		this.discoP = discoP;
	}


}