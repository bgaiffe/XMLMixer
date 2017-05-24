package grammar;





	public class NonTerminal implements GramSymb {

		String val;

		public NonTerminal(String v) {
			// System.out.println("On crée le NT : "+v);
			this.val = v.intern();
		}

		@Override
		public boolean isTerminal() {
			return false;
		}

		public String getName() {
			return this.val;
		}

		@Override
		public String toString() {
			return "NT[" + this.val + "]"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		@Override
		public boolean equals(GramSymb other) {
			return !other.isTerminal()
					&& getName().equals(((NonTerminal) other).getName());
		}
	}


