package parsing;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import parsing.ParsingItem;

//The structure in which we keep our items so that we test efficiently wether some item is already there.
public class SortedTableOfItems {

	
	class sttIterator implements Iterator<ParsingItem>{
		Iterator<Integer> k1Iter;
		Iterator<Integer> k2Iter;
		Iterator<ParsingItem> listIter;
		Integer curK1;
		Integer curK2;
		
		sttIterator(SortedTableOfItems t){
			k1Iter = null;
			k2Iter = null;
			listIter = null;
			k1Iter = t.theTable.keySet().iterator();
			if (k1Iter.hasNext()){
				curK1 = k1Iter.next();
				k2Iter = t.theTable.get(curK1).keySet().iterator();
			}
			if ((k2Iter != null) && (k2Iter.hasNext())){
				curK2 = k2Iter.next();
				listIter = t.theTable.get(curK1).get(curK2).iterator();
			}
		}
		
		public boolean hasNext(){
			if ((listIter != null) && (listIter.hasNext())){
				return true;
			}
			if ((k2Iter != null) && (k2Iter.hasNext())){
				curK2 = k2Iter.next();
				listIter = theTable.get(curK1).get(curK2).iterator();
				return this.hasNext();
			}
			if ((k1Iter != null) && (k1Iter.hasNext())){
				curK1 = k1Iter.next();
				k2Iter = theTable.get(curK1).keySet().iterator();
				return this.hasNext();
			}
			return false;
		}
		
		public ParsingItem next(){
			if (this.hasNext()){
				return this.listIter.next();
			}
			else{
				return null;
			}
		}
		public void remove(){};
	}
	
	
	HashMap<Integer, HashMap<Integer, ArrayList<ParsingItem>>> theTable;
	
	SortedTableOfItems(){
		theTable = new HashMap<Integer, HashMap<Integer, ArrayList<ParsingItem>>>();
	}
	
	public boolean isInTable(ParsingItem pi){
		ArrayList<ParsingItem> theArrayList;
		
		HashMap<Integer, ArrayList<ParsingItem>> t1 = theTable.get(new Integer(pi.getI().getId()));
		if (t1 == null){
			return false;
		}
		else{
			theArrayList = t1.get(new Integer(pi.getJ().getId()));
			if (theArrayList == null){
				return false;
			}
			else{
				Iterator<ParsingItem> it = theArrayList.iterator();
				while (it.hasNext()){
					if (it.next().equals(pi)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void add(ParsingItem pi){
		ArrayList<ParsingItem> theArrayList;
		HashMap<Integer, ArrayList<ParsingItem>> t1 = theTable.get(new Integer(pi.getI().getId()));
		
		if (t1 == null){
			t1 = new HashMap<Integer, ArrayList<ParsingItem>>();
			theTable.put(new Integer(pi.getI().getId()), t1);
		}
		theArrayList = t1.get(new Integer(pi.getJ().getId()));
		if (theArrayList == null){
			theArrayList = new ArrayList<ParsingItem>();
			t1.put(new Integer(pi.getJ().getId()), theArrayList);
		}
		theArrayList.add(pi);
	}
	
	public int getTextPos(){
		ArrayList<ParsingItem> theArrayList;
		HashMap<Integer, ArrayList<ParsingItem>> t1;
		
		if (theTable.isEmpty()){
			return 0;
		}
		t1 = theTable.get(theTable.keySet().iterator().next());
		if (t1.isEmpty()){
			return 0;
		}
		theArrayList = t1.get(t1.keySet().iterator().next());
		if (theArrayList.isEmpty()){
			return 0;
		}
		else{
			return theArrayList.iterator().next().getJ().getTextPosition();
		}
	}
	public int size(){
		HashMap<Integer, ArrayList<ParsingItem>> t1;
		ArrayList<ParsingItem> theArrayList;
		Integer k1, k2;
		int s = 0;
		Iterator<Integer> i1, i2;
		i1 = theTable.keySet().iterator();
		while (i1.hasNext()){
			k1 = i1.next();
			t1 = theTable.get(k1);
			i2 = t1.keySet().iterator();
			while (i2.hasNext()){
				k2 = i2.next();
				theArrayList = t1.get(k2);
				s = s + theArrayList.size();
			}
		}
		return s;
	}
	
	Iterator<ParsingItem> iterator(){
		return new sttIterator(this);
	}
	
}
