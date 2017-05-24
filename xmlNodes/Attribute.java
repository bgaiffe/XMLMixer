package xmlNodes;




	public class Attribute {
		String localName;
		String nameSpace;
		String value;
		String prefix;

		public Attribute(String ln, String ns, String v) {
			this.localName = ln;
			this.nameSpace = ns;
			this.value = v;
			this.prefix = ""; //$NON-NLS-1$
		}

		public Attribute(String ln, String p, String ns, String v) {
			this.localName = ln;
			this.nameSpace = ns;
			this.value = v;
			this.prefix = p;
		}

		public Attribute(javax.xml.stream.events.Attribute at) {
			this.localName = at.getName().getLocalPart();
			this.nameSpace = at.getName().getNamespaceURI();
			this.prefix = at.getName().getPrefix();
			this.value = at.getValue();
		}

		@Override
		public String toString() {
			if (this.prefix.compareTo("") != 0) { //$NON-NLS-1$
				return this.prefix + ":" +  //$NON-NLS-1$
					   this.localName + "='" +  //$NON-NLS-1$
					   this.value + "'"; //$NON-NLS-1$
			} 
			return this.localName + "='" +  //$NON-NLS-1$
				   this.value + "'";  //$NON-NLS-1$
			
		}

		public boolean equals(Attribute other) {
			return this.localName.compareTo(other.localName) == 0
					&& this.nameSpace.compareTo(other.nameSpace) == 0
					&& this.value.compareTo(other.value) == 0;
		}

		public String getLocalName() {
			return this.localName;
		}

		public String getValue() {
			return this.value;
		}
	}

