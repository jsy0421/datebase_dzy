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
    private JMenu menu_commodity=new JMenu("商品");
    private JMenu menu_order=new JMenu("订单");
    private JMenu menu_user=new JMenu("个人中心");
    private JMenu menu_administrator=new JMenu("管理员");
    
    private JMenuItem  menuItem_limit=new JMenuItem("限时促销商品");
    private JMenuItem  menuItem_decrease=new JMenuItem("满折促销商品");
    private JMenuItem  menuItem_all=new JMenuItem("所有商品");
    
    private JMenuItem  menuItem_neworder=new JMenuItem("当前订单");
    private JMenuItem  menuItem_oldorder=new JMenuItem("历史订单");
    
    private JMenuItem  menuItem_userinformation=new JMenuItem("个人信息");
    private JMenuItem  menuItem_discount=new JMenuItem("拥有的优惠券");
    private JMenuItem  menuItem_address=new JMenuItem("使用过的地址");
    private JMenuItem  menuItem_changepwd=new JMenuItem("修改密码");
    
    private JMenuItem  menuItem_administratorinformation=new JMenuItem("个人信息");
    private JMenuItem  menuItem_purchase=new JMenuItem("采购表");
    private JMenuItem  menuItem_managementdecrease=new JMenuItem("满折促销管理");
    private JMenuItem  menuItem_managementdiscount=new JMenuItem("优惠券管理");
    
    private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	public FrmMain() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("生鲜网超");
		dlgLogin=new FrmLogin(this,"登陆",true);
		dlgLogin.setVisible(true);
		if ("管理员".equals(BeanUser.currentLoginUser.getUsertype())) {
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
		else if ("用户".equals(BeanUser.currentLoginUser.getUsertype())) {
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
	    JLabel label=new JLabel("您好, "+BeanUser.currentLoginUser.getUser_name()+BeanUser.currentLoginUser.getUsertype()+" !");
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
		// TODO 自动生成的方法存根
		if (e.getSource() == this.menuItem_limit) {
			FrmLimit dlg = new FrmLimit(this,"限时促销商品",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_decrease) {
			FrmDecrease dlg = new FrmDecrease(this,"满折促销商品",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_all) {
			FrmAll dlg = new FrmAll(this,"所有商品",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_neworder) {
			FrmNewOrder dlg = new FrmNewOrder(this,"当前订单",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_oldorder) {
			FrmOldOrder dlg = new FrmOldOrder(this,"历史订单",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_userinformation) {
			FrmUserInformation dlg = new FrmUserInformation(this,"用户个人信息",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_discount) {
			FrmDiscount dlg = new FrmDiscount(this,"拥有的优惠券",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_address) {
			FrmAddress dlg = new FrmAddress(this,"使用过的地址",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_changepwd) {
			FrmChangePwd dlg = new FrmChangePwd(this,"修改密码",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_administratorinformation) {
			FrmAdministratorInformation dlg = new FrmAdministratorInformation(this,"管理员个人信息",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_purchase) {
			FrmPurchase dlg = new FrmPurchase(this,"采购单",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_managementdecrease) {
			FrmManagementDecrease dlg = new FrmManagementDecrease(this,"满折促销管理",true);
			dlg.setVisible(true);
		}
		else if (e.getSource() == this.menuItem_managementdiscount) {
			FrmManagementDiscount dlg = new FrmManagementDiscount(this,"优惠券管理",true);
			dlg.setVisible(true);
		}
	}

}
