package partialOrder;

import partialOrder.DagState;

public class DagTransition<T> {
	T label;
	DagState<T> next;
	
	public DagTransition(T l, DagState<T> n){
		this.label = l;
		this.next = n;
	}
}
