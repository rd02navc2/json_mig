package com.example.demo.phase2;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.sun.xml.xsom.parser.AnnotationContext;
import com.sun.xml.xsom.parser.AnnotationParser;

//To parse the annotation block create an AnnotationParser and implement 2 methods: 
//getContentHandler and getResult. 
//The getResult method, based  on your implementation, will return the content of the annotation tag. 
//The content of an annotation tag is being parsed as a plain XML, //
//the following example shows how to extract the documentation content from the annotation tag.

public class XsdAnnotationParser extends AnnotationParser {

	private StringBuilder documentation = new StringBuilder();
	private StringBuffer sb = new StringBuffer();

	AnnotationDAO a = new AnnotationDAO();

	@Override
	public ContentHandler getContentHandler(AnnotationContext context, String parentElementName, ErrorHandler handler,
			EntityResolver resolver) {

		return new ContentHandler() {

			private boolean parsingDocumentation = false;

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (parsingDocumentation) {
					documentation.append(ch, start, length);
					sb.append(ch, start, length);
				}
			}

			@Override
			public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {
				if (localName.equals("documentation")) {
					parsingDocumentation = true;
					a = new AnnotationDAO();
				}
			}

			@Override
			public void endElement(String uri, String localName, String name) throws SAXException {

				if (localName.equals("UniqueID")) {
					a.UniqueID = sb.toString().trim();
				} else if (localName.equals("DictionaryEntryName")) {
					a.DictionaryEntryName = sb.toString().trim();
				} else if (localName.equals("Definition")) {
					a.Definition = sb.toString().trim();
				} else if (localName.equals("Cardinality")) {
					a.Cardinality = sb.toString().trim();
				} else if (localName.equals("ObjectClassTerm")) {
					a.ObjectClassTerm = sb.toString().trim();
				} else if (localName.equals("PropertyTerm")) {
					a.PropertyTerm = sb.toString().trim();
				} else if (localName.equals("RepresentationTerm")) {
					a.RepresentationTerm = sb.toString().trim();
				} else if (localName.equals("ChineseName")) {
					a.chineseName = sb.toString().trim();
				} else if (localName.equals("Remark")) {
					a.remark = sb.toString().trim();
				} else if (localName.equals("Format")) {
					a.format = sb.toString().trim();
					// ---------------------------------------------------------------
				} else if (localName.equals("sn")) {
					a.sn = sb.toString().trim();
				} else if (localName.equals("oldS")) {
					a.oldS = sb.toString().trim();
				} else if (localName.equals("oldG")) {
					a.oldG = sb.toString().trim();
				} else if (localName.equals("oldE")) {
					a.oldE = sb.toString().trim();
				} else if (localName.equals("oldChName")) {
					a.oldChName = sb.toString().trim();
				} else if (localName.equals("oldEnName")) {
					a.oldEnName = sb.toString().trim();
				} else if (localName.equals("oldProp")) {
					a.oldProp = sb.toString().trim();
				} else if (localName.equals("oldMC")) {
					a.oldMC = sb.toString().trim();
				} else if (localName.equals("oldAirSea")) {
					a.oldAirSea = sb.toString().trim();
				} else if (localName.equals("note94")) {
					a.note94 = sb.toString().trim();
					// ----------------------------------------------------------------------

				} else if (localName.equals("changeReason")) {
					a.changeReason = sb.toString().trim();
				} else if (localName.equals("newS")) {
					a.newS = sb.toString().trim();
				} else if (localName.equals("newG")) {
					a.newG = sb.toString().trim();
				} else if (localName.equals("newE")) {
					a.newE = sb.toString().trim();
				} else if (localName.equals("newChName")) {
					a.newChName = sb.toString().trim();

					// } else if (localName.equals("newEnName")) {
					// a.newEnName = sb.toString().trim();
					// } else if (localName.equals("newChDef")) {
					// a.newChDef = sb.toString().trim();
					// } else if (localName.equals("newEnDef")) {
					// a.newEnDef = sb.toString().trim();
					// } else if (localName.equals("newProp")) {
					// a.newProp = sb.toString().trim();

				} else if (localName.equals("M_C")) {
					a.M_C = sb.toString().trim();
				} else if (localName.equals("wcoId")) {
					a.wcoId = sb.toString().trim();
				} else if (localName.equals("wcoName")) {
					a.wcoName = sb.toString().trim();
				} else if (localName.equals("FMOCD")) {
					a.FMOCD = sb.toString().trim();
				}else if (localName.equals("chn")) {
					a.allMsgs = sb.toString().trim();
				}

				
				
				sb.delete(0, documentation.toString().length());

				if (localName.equals("documentation")) {
					parsingDocumentation = false;
				}
			}

			@Override
			public void endDocument() throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void endPrefixMapping(String prefix) throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void processingInstruction(String target, String data) throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void setDocumentLocator(Locator locator) {
				// TODO Auto-generated method stub

			}

			@Override
			public void skippedEntity(String name) throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void startDocument() throws SAXException {
				// TODO Auto-generated method stub

			}

			@Override
			public void startPrefixMapping(String prefix, String uri) throws SAXException {
				// TODO Auto-generated method stub

			}
		};
	}

	@Override
	public Object getResult(Object existing) {
		// return documentation.toString().trim();
		return a;
	}
}