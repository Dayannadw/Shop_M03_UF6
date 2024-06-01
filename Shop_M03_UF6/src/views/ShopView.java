package views;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employee;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import model.*;
import views.*;
import main.*;

public class ShopView extends JFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDialog countMoney;
	JFrame parentFrame;
	JButton contarCaja;
	JLabel lblNewLabel;
	JButton añadirProducto;
	JButton añadirStock;
	JButton eliminarProducto;
	Shop shop = new Shop();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @param frame 
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ShopView() {	
		ShopView(); // 
		shop.loadInventory();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void ShopView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Seleccione una opción");
		lblNewLabel.setBounds(6, 6, 140, 16);
		contentPane.add(lblNewLabel);

		contarCaja = new JButton("1. Contar Caja");
		contarCaja.setBounds(6, 52, 190, 29);
		contarCaja.addActionListener(this);
		contarCaja.addKeyListener(this);
		contarCaja.setFocusable(false); 
		contentPane.add(contarCaja);

		añadirProducto = new JButton("2. Añadir Producto");
		añadirProducto.setBounds(6, 93, 190, 29);
		añadirProducto.addActionListener(this);
		añadirProducto.addKeyListener(this);
		añadirProducto.setFocusable(false); 
		contentPane.add(añadirProducto);

		añadirStock = new JButton("3. Añadir Stock");
		añadirStock.setBounds(6, 134, 190, 29);
		añadirStock.addActionListener(this);
		añadirStock.addKeyListener(this); 
		añadirStock.setFocusable(false);
		contentPane.add(añadirStock);

		eliminarProducto = new JButton("9. Eliminar producto");
		eliminarProducto.setBounds(6, 175, 190, 29);
		eliminarProducto.addActionListener(this);
		eliminarProducto.addKeyListener(this); 
		eliminarProducto.setFocusable(false); 
		contentPane.add(eliminarProducto);

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); 
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == contarCaja) {
			openCashView();
		} else if (e.getSource() == añadirProducto) {
			addProduct();
		} else if (e.getSource() == añadirStock) {
			addStock();
		} else if (e.getSource() == eliminarProducto) {
			deleteProduct();
		}
	}
	
	
	
	
	public void openCashView() {
		CashView cashView = new CashView(shop);
		cashView.setVisible(true);
	}

	public void addProduct() {
		ProductView productView = new ProductView(shop);
		productView.addProduct();
		productView.setVisible(true);
	}

	public void addStock() {
		ProductView productView = new ProductView(shop);
		productView.addStock();
		productView.setVisible(true);
	}

	public void deleteProduct() {
		ProductView productView = new ProductView(shop);
		productView.deleteProduct();
		productView.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_1:
				openCashView();
				break;
			case KeyEvent.VK_2:
				addProduct();
				break;
			case KeyEvent.VK_3:
				addStock();
				break;
			case KeyEvent.VK_9:
				deleteProduct();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
