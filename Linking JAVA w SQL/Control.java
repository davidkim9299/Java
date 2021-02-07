package StudentManagement;

public class Control {
	public static void main(String[] args) {
		nameDAO n = new nameDAO();
		n.tableInsert(1, "KIM");
		n.tableInsert(2, "PARK");
		n.tableInsert(3, "CHOI");
		n.tableInsert(4, "LEE");
		n.tableInsert(5, "KANG");
		
		n.tableSelect();
	}

}
