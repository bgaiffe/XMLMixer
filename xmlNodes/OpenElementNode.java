package xmlNodes;

//XMLMixer: a tool for embedding annotations into XML files.

//Copyright (C) 2017  Bertrand Gaiffe
//bertrand.gaiffe@atilf.fr

//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.

//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.

//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.

//XMLMixer: a tool for embedding annotations into XML files.

//Copyright (C) 2017  Bertrand Gaiffe
//bertrand.gaiffe@atilf.fr

//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.


	import java.util.ArrayList;
	import java.util.Iterator;

	//public class OpenElementNode implements GenericNode, javax.xml.stream.events.StartElement {

	public class OpenElementNode implements GenericNode {
		String localName;
		String nameSpace;
		String qName;
		String id;
		boolean autoClose;
		String attributesAsString;

		ArrayList<Attribute> attributes;
		ArrayList<Attribute> nameSpaceNodes;

		public OpenElementNode(String ln, String ns, String i,
				ArrayList<Attribute> atts, boolean isAutoClose) {
			this.localName = ln;
			this.nameSpace = ns;
			this.id = i;
			this.attributes = atts;
			this.autoClose = isAutoClose;
			this.qName = ln;
		}

		public OpenElementNode(String ln, String ns, String i,
				ArrayList<Attribute> atts, ArrayList<Attribute> nsNodes,
				boolean isAutoClose) {
			this.localName = ln;
			this.nameSpace = ns;
			this.id = i;
			this.attributes = atts;
			this.autoClose = isAutoClose;
			this.nameSpaceNodes = nsNodes;
			this.qName = ln;
		}

		@SuppressWarnings("unused")
		public OpenElementNode(String ln) {
			StringBuffer bf = new StringBuffer();
			int i = 1;

			this.attributes = new ArrayList<Attribute>();

			while (!Character.isWhitespace(ln.charAt(i)) & !(ln.charAt(i) == '/')
					& !(ln.charAt(i) == '>')) {
				bf.append(ln.charAt(i));
				i = i + 1;
			}
			this.localName = bf.toString();
			// now for the attributes
			while ((ln.charAt(i) != '/') & (ln.charAt(i) != '>')) {
				while (Character.isWhitespace(ln.charAt(i))) {
					i = i + 1;
				}
				if ((ln.charAt(i) != '/') & (ln.charAt(i) != '>')) {
					StringBuffer attName = new StringBuffer();
					while ((ln.charAt(i) != '=')
							& !Character.isWhitespace(ln.charAt(i))) {
						attName.append(ln.charAt(i));

						i = i + 1;
					}
					// System.out.println("Attname = "+attName.toString());
					while (ln.charAt(i) != '"' & ln.charAt(i) != '\'') {
						i = i + 1;
					}
					char delim = ln.charAt(i);
					i = i + 1;
					StringBuffer value = new StringBuffer();

					if (i == ln.length()) {
						System.err.println("Pb element " + ln); //$NON-NLS-1$
					}

					while (ln.charAt(i) != delim) {
						value.append(ln.charAt(i));

						if (i == ln.length()) {
							System.err.println("Pb element " + ln); //$NON-NLS-1$
						}

						i = i + 1;
					}
					i = i + 1;
					if (attName.toString().compareTo("xmlns") == 0) { //$NON-NLS-1$

						this.nameSpace = value.toString();
						// System.out.println("added ns = "+nameSpace);
					} else {
						// System.out.println("valeur = "+value.toString());
						this.attributes.add(new Attribute(attName.toString(), "", //$NON-NLS-1$
								value.toString()));
					}
				}
			}

			if (ln.charAt(ln.length() - 2) == '/') {
				this.autoClose = true;
			} else {
				this.autoClose = false;
			}
			// nameSpace = "";
			this.id = ""; //$NON-NLS-1$
			this.qName = this.localName;
		}

		public String getQName() {
			return this.qName;
		}

		public String getNsUri() {
			return this.nameSpace;
		}

		public void setId(String idS) {
			this.id = idS;
		}

		public String getId() {
			return this.id;
		}

		@Override
		public String toString() {
			StringBuffer res = new StringBuffer("<" + this.localName); //$NON-NLS-1$
			if (this.autoClose) {
				res.append("/"); //$NON-NLS-1$
			}
			Iterator<Attribute> i = this.attributes.iterator();
			if (i.hasNext()) {
				res.append(" "); //$NON-NLS-1$
			}
			while (i.hasNext()) {
				res.append(i.next().toString());
				if (i.hasNext()) {
					res.append(" "); //$NON-NLS-1$
				}
			}
			if (this.nameSpaceNodes != null) {
				Iterator<Attribute> ins = this.nameSpaceNodes.iterator();
				if (ins.hasNext()) {
					res.append(" "); //$NON-NLS-1$
				}
				while (ins.hasNext()) {
					res.append(ins.next().toString());
					if (ins.hasNext()) {
						res.append(" "); //$NON-NLS-1$
					}
				}
			}
			// res.append(">"+"_"+id);
			res.append(">"); //$NON-NLS-1$
			return res.toString();
		}

		@Override
		public int getType() {
			int res;
			if (this.autoClose) {
				res = GenericNode.AUTO_CLOSE;
			} else {
				res = GenericNode.OPEN_ELEMENT;
			}
			return res;
		}

		public String getLocalName() {
			return this.localName;
		}

		@Override
		public String getStringValue() {
			StringBuffer res = new StringBuffer("<" + this.localName); //$NON-NLS-1$
			if (this.autoClose) {
				res.append("/"); //$NON-NLS-1$
			}
			Iterator<Attribute> i = this.attributes.iterator();
			if (i.hasNext()) {
				res.append(" "); //$NON-NLS-1$
			}
			while (i.hasNext()) {
				res.append(i.next().toString());
			}
			res.append(">"); //$NON-NLS-1$
			return res.toString();
		}

		@Override
		public boolean equals(GenericNode other) {
			Iterator<Attribute> att1 = this.attributes.iterator();
			boolean res = (other.getType() == GenericNode.OPEN_ELEMENT);

			if (res) {
				OpenElementNode otOE = (OpenElementNode) other;
				res = res && this.localName.compareTo(otOE.localName) == 0;
				res = res && this.nameSpace.compareTo(otOE.nameSpace) == 0;
				res = res && this.id.compareTo(otOE.id) == 0;
				res = res && this.attributes.size() == otOE.attributes.size();
				res = res && this.autoClose == otOE.autoClose;
				Iterator<Attribute> att2 = otOE.attributes.iterator();
				while (att1.hasNext()) {
					res = res && att1.next().equals(att2.next());
				}
			}
			return res;
		}

		public void addAttribute(String atName, String ns, String value) {
			this.attributes.add(new Attribute(atName, ns, value));
		}

		public ArrayList<Attribute> getAttributes() {
			return this.attributes;
		}

}
