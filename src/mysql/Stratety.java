package mysql;

import com.opensymphony.xwork2.ActionSupport;

public class Stratety extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String editor;
	private int index;
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
