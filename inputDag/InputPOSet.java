package inputDag;

import java.util.Set;

import partialOrder.POSet;
import xmlNodes.GenericNode;


public class InputPOSet extends POSet<GenericNode>{

	private int tp;
	private int level;
	
	public InputPOSet(Set<GenericNode> s){
		super(s);
	}
	
	public void setTpAndLevel(int t, int l){
		this.tp = t;
		this.level = l;
	}
	
	
	
	/*public InputDagState allTotalOrders(){
		return (InputDagState) super.allTotalOrders();
	}*/
	
	/*public static void main(String argv[]){
		InputDagState id;
		InputPOSet ips;
		CopyOnWriteArraySet<GenericNode> set = new CopyOnWriteArraySet<GenericNode>();
		OpenElementNode odel = new OpenElementNode("<del>");
		CloseElementNode cdel = new CloseElementNode("</del>");
		TextNode c = new TextNode("c");
		TextNode d = new TextNode("d");
		OpenElementNode ode = new OpenElementNode("<de>");
		CloseElementNode ca = new CloseElementNode("</A>");
		OpenElementNode ob = new OpenElementNode("<B>");
		set.add(odel); set.add(cdel); set.add(c); set.add(d); 
		set.add(ode); set.add(ca); set.add(ob);
		ips = new InputPOSet(set);
		ArrayList<GenericNode> ch1 = new ArrayList<GenericNode>();
		ArrayList<GenericNode> ch2 = new ArrayList<GenericNode>();
		ArrayList<GenericNode> ch3 = new ArrayList<GenericNode>();
		ch1.add(odel); ch1.add(c); ch1.add(d); ch1.add(cdel);
		ips.addChain(ch1);
		ch2.add(c); ch2.add(ode); ch2.add(d);
		ips.addChain(ch2);
		ch3.add(ca); ch3.add(ob);
		ips.addChain(ch3);
		ips.simplify();
		id = ips.allTotalOrders();
	}*/
}




