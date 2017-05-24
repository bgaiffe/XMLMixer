package grammar;

import grammar.GramSymb;
import grammar.Terminal;
import xmlNodes.GenericNode;


	public class Terminal implements GramSymb {
		GenericNode val;

		Terminal(GenericNode v) {
			this.val = v;
		}

		@Override
		public boolean isTerminal() {
			return true;
		}

		@Override
		public String toString() {
			return this.val.toString();
		}

		public GenericNode getVal() {
			return this.val;
		}

		@Override
		public boolean equals(GramSymb other) {
			return other.isTerminal()
					&& (this.val.toString().compareTo(
							((Terminal) other).getVal().toString()) == 0);
		}

		/*
		 * public static void main(String argv[]){ GenericNode ca1 = new
		 * CloseElementNode("a", "0"); GenericNode ca2 = new CloseElementNode("a",
		 * "0");
		 * 
		 * if (ca1.equals(ca2)){ System.out.println("égaux"); } else{
		 * System.out.println("Différents"); } }
		 */
	}


