package market.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import market.ui.FrmLogin;
import market.model.BeanUser;


public class FrmMain extends JFrame implements ActionListener{
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_commodity=new JMenu("��Ʒ");
    private JMenu menu_order=new JMenu("����");
    private JMenu menu_user=new JMenu("��������");
    private JMenu menu_administrator=new JMenu("����Ա");
    
    private JMenuItem  menuItem_limit=new JMenuItem("��ʱ������Ʒ");
    private JMenuItem  menuItem_decrease=new JMenuItem("���۴�����Ʒ");
    private JMenuItem  menuItem_all=new JMenuItem("������Ʒ");
    
    private JMenuItem  menuItem_neworder=new JMenuItem("��ǰ����");
    private JMenuItem  menuItem_oldorder=new JMenuItem("��ʷ����");
    
    private JMenuItem  menuItem_userinformation=new JMenuItem("������Ϣ");
    private JMenuItem  menuItem_discount=new JMenuItem("ӵ�е��Ż�ȯ");
    private JMenuItem  menuItem_address=new JMenuItem("ʹ�ù��ĵ�ַ");
    private JMenuItem  menuItem_changepwd=new JMenuItem("�޸�����");
    
    private JMenuItem  menuItem_administratorinformation=new JMenuItem("������Ϣ");
    private JMenuItem  menuItem_purchase=new JMenuItem("�ɹ���");
    private JMenuItem  menuItem_managementdecrease=new JMenuItem("���۴�������");
    private JMenuItem  menuItem_managementdiscount=new JMenuItem("�Ż�ȯ����");
    
    private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	public FrmMain() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("��������");
		dlgLogin=new FrmLogin(this,"��½",true);
		dlgLogin.setVisible(true);
		if ("����Ա".equals(BeanUser.currentLoginUser.getUsertype())) {
			menubar.add(menu_administrator);
			menu_administrator.add(menuItem_administratorinformation);
			menuItem_administratorinformation.addActionListener(this);
			menu_administrator.add(menuItem_purchase);
			menuItem_purchase.addActionListener(this);
			menu_administrator.add(menuItem_managementdecrease);
			menuItem_managementdecrease.addActionListener(this);
			menu_administrator.add(menuItem_managementdiscount);
			menuItem_managementdiscount.addActionListener(this);
			menu_administrator.add(menuItem_changepwd);
			menuItem_changepwd.addActionListener(this);
		}
		else if ("�û�".equals(BeanUser.currentLoginUser.getUsertype())) {
			menubar.add(menu_user);
			menu_user.add(menuItem_userinformation);
			menuItem_userinformation.addActionListener(this);
			menu_user.add(menuItem_discount);
			menuItem_discount.addActionListener(this);
			menu_user.add(menuItem_address);
			menuItem_address.addActionListener(this);
			menu_user.add(menuItem_changepwd);
			menuItem_changepwd.addActionListener(this);
		}
		menubar.add(menu_commodity);
		menu_commodity.add(menuItem_limit);
		menuItem_limit.addActionListener(this);
		menu_commodity.add(menuItem_decrease);
		menuItem_decrease.addActionListener(this);
		menu_commodity.add(menuItem_all);
		menuItem_all.addActionListener(this);
		
		menubar.add(menu_order);
		menu_order.add(menuItem_neworder);
		menuItem_neworder.addActionListener(this);
		menu_order.add(menuItem_oldorder);
		menuItem_oldorder.addActionListener(this);
		
		this.setJMenuBar(menubar);
		
		statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("����, "+BeanUser.currentLoginUser.getUser_name()+BeanUser.currentLoginUser.getUsertype()+" !");
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == this.menuItem_limit) {
			FrmLimit dlg = new FrmLimit(this,"��ʱ������Ʒ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_decrease) {
			FrmDecrease dlg = new FrmDecrease(this,"���۴�����Ʒ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_all) {
			FrmAll dlg = new FrmAll(this,"������Ʒ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_neworder) {
			FrmNewOrder dlg = new FrmNewOrder(this,"��ǰ����",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_oldorder) {
			FrmOldOrder dlg = new FrmOldOrder(this,"��ʷ����",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_userinformation) {
			FrmUserInformation dlg = new FrmUserInformation(this,"�û�������Ϣ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_discount) {
			FrmDiscount dlg = new FrmDiscount(this,"ӵ�е��Ż�ȯ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_address) {
			FrmAddress dlg = new FrmAddress(this,"ʹ�ù��ĵ�ַ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_changepwd) {
			FrmChangePwd dlg = new FrmChangePwd(this,"�޸�����",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_administratorinformation) {
			FrmAdministratorInformation dlg = new FrmAdministratorInformation(this,"����Ա������Ϣ",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_purchase) {
			FrmPurchase dlg = new FrmPurchase(this,"�ɹ���",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_managementdecrease) {
			FrmManagementDecrease dlg = new FrmManagementDecrease(this,"���۴�������",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_managementdiscount) {
			FrmManagementDiscount dlg = new FrmManagementDiscount(this,"�Ż�ȯ����",true);
			dlg.setVisible(true);
		}
	}

}
