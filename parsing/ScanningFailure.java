package parsing;

import parsing.ParsingItem;
import inputDag.InputDagTransition;

// a scanning failure is a couple :
//     failed item
//     failed dag State
public class ScanningFailure {
	ParsingItem it;
	InputDagTransition st;
	
	ScanningFailure(ParsingItem pi, InputDagTransition dt){
		this.it = pi;
		this.st = dt;
	}
	public ParsingItem getItem(){
		return it;
	}
	public InputDagTransition getTrans(){
		return st;
	}
}
