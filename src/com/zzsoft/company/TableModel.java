package com.zzsoft.company;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableModel extends AbstractTableModel {

	private Vector content = null;
	private String[] title_name = { "ID", "姓名", "性别", "年龄" };
	
    public TableModel() {
	    content = new Vector();
	}
    
    public void addRow(String name, boolean sex, String age) {
        Vector v = new Vector();
        v.add(0, new Integer(content.size()));
        v.add(1, name);
        v.add(2, new Boolean(sex));
        v.add(3, age);
        content.add(v);
    }
    
    public void removeRow(int row) {
        content.remove(row);
    }

    public void removeRows(int row, int count) {
        for (int i = 0; i < count; i++) {
           if (content.size() > row) {
               content.remove(row);
           }
        }
    }
    
    public String getColumnName(int col) {
        return title_name[col];
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title_name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//   public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
//       DefaultTableCellRenderer tableRenderer = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
//       // 设置单元格内容居中显示
//       tableRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//注意这个的CENTER这个系统变量
//       return tableRenderer;
//   }

}
