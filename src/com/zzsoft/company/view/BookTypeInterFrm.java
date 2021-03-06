/*
 * BookTypeInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.zzsoft.company.view;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.zzsoft.company.dao.BookTypeDao;
import com.zzsoft.company.model.BookType;
import com.zzsoft.company.util.DbUtil;
import com.zzsoft.company.util.StringUtil;

/**
 *
 * @author  __USER__
 */
public class BookTypeInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil=new DbUtil();
	BookTypeDao bookTypeDao=new BookTypeDao();
	
	/** Creates new form BookTypeInterFrm */
	public BookTypeInterFrm() {
		initComponents();
		this.setLocation(200, 50);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		bookTypeNameTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookTypeDescTxt = new javax.swing.JTextArea();
		jb_Add = new javax.swing.JButton();
		jb_Reset = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u56fe\u4e66\u7c7b\u522b\u6dfb\u52a0");

		jLabel1.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");

		jLabel2.setText("\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0\uff1a");

		bookTypeDescTxt.setColumns(20);
		bookTypeDescTxt.setRows(5);
		jScrollPane1.setViewportView(bookTypeDescTxt);

		jb_Add.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\caofeng\\Desktop\\images\\add.png")); // NOI18N
		jb_Add.setText("\u6dfb\u52a0");
		jb_Add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_AddActionPerformed(evt);
			}
		});

		jb_Reset.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\caofeng\\Desktop\\images\\reset.png")); // NOI18N
		jb_Reset.setText("\u91cd\u7f6e");
		jb_Reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_ResetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(58, 58, 58)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1)
														.addComponent(jLabel2)
														.addComponent(jb_Add))
										.addGap(44, 44, 44)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jb_Reset)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				208,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				285,
																				Short.MAX_VALUE)
																		.addComponent(
																				bookTypeNameTxt,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				285,
																				Short.MAX_VALUE)))
										.addGap(53, 53, 53)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(43, 43, 43)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																bookTypeNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(56, 56, 56)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																121,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												42, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jb_Add)
														.addComponent(jb_Reset))
										.addGap(48, 48, 48)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_AddActionPerformed(java.awt.event.ActionEvent evt) {
		String bookTypName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypName)){
			JOptionPane.showMessageDialog(null, "ͼ�������Ʋ���Ϊ�գ�");
			return;
		}
		BookType bookType=new BookType(bookTypName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=bookTypeDao.bookTypeAdd(con, bookType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "ͼ�������ӳɹ���");
				this.resetValues();
			}else{
				JOptionPane.showMessageDialog(null, "ͼ��������ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ��������ʧ�ܣ�");
		}
	}

	private void jb_ResetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValues();
	}
	
	private void resetValues(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea bookTypeDescTxt;
	private javax.swing.JTextField bookTypeNameTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_Add;
	private javax.swing.JButton jb_Reset;
	// End of variables declaration//GEN-END:variables

}