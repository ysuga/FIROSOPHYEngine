package net.ysuga.firosophy.state;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.firosophy.state.action.AllRTCsActivateAction;
import net.ysuga.firosophy.state.action.AllRTCsConfigureAction;
import net.ysuga.firosophy.state.action.AllRTCsDeactivateAction;
import net.ysuga.firosophy.state.action.AllRTCsResetAction;
import net.ysuga.firosophy.state.action.BuildConnectionAction;
import net.ysuga.firosophy.state.action.ClearAllConnectionAction;
import net.ysuga.firosophy.util.FileNameUtil;
import net.ysuga.rtsbuilder.RTSystemBuilder;
import net.ysuga.rtsystem.profile.RTSystemProfile;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.state.DefaultState;
import net.ysuga.statemachine.state.action.StateActionList;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * 
 * <div lang="ja"> OpenRTMのRTシステムを有するState． </div> <div lang="en">
 * 
 * </div>
 * 
 * @author ysuga
 * 
 */
public class RTState extends DefaultState {

	private static Logger logger;
	static {
		logger = Logger.getLogger("net.ysuga.firosophy");
	}

	private String basePath;

	final public void setBasePath(String path) {
		this.basePath = path;
	}

	final public String getBasePath() {
		return this.basePath;
	}

	private String filename;

	private boolean relativePath;
	
	public void setRelativePath(boolean flag) {
		relativePath = flag;
	}
	
	public boolean isRelativePath() {
		return relativePath;
	}
	
	private RTSystemProfile rtSystemProfile;

	final public RTSystemProfile getRTSystemProfile() {
		return rtSystemProfile;
	}

	final public void setRTSystemProfile(RTSystemProfile profile) {
		rtSystemProfile = profile;
	}
	
	/**
	 * 
	 * <div lang="ja"> コンストラクタ
	 * 
	 * @param name
	 *            </div> <div lang="en"> Constructor
	 * @param name
	 *            </div>
	 */
	public RTState(String name) {
		super(name);
		try {
			setFileName(null);
			setKind(FIROSOPHY.RTSTATE);
			StateActionList onEntryActionList = getOnEntryActionList();
			onEntryActionList.add(new AllRTCsResetAction());
			onEntryActionList.add(new ClearAllConnectionAction());
			onEntryActionList.add(new AllRTCsConfigureAction());
			onEntryActionList.add(new BuildConnectionAction());
			onEntryActionList.add(new AllRTCsActivateAction());

			StateActionList onExitActionList = getOnExitActionList();
			onExitActionList.add(new AllRTCsDeactivateAction());
			onExitActionList.add(new AllRTCsResetAction());
			onExitActionList.add(new ClearAllConnectionAction());
			
		} catch (Exception ex) {

		}
	}

	public RTState(Node node) throws InvalidFSMFileException {
		super("");
		load(node);
		setKind(FIROSOPHY.RTSTATE);

	}

	/**
	 * Set RTS Profile Filename
	 * 
	 * @param filename
	 *            xml file (RTS profile)
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	final public void setFileName(String filename) {
		this.filename = filename;
		//if (filename != null) {
		//	rtSystemProfile = new RTSystemProfile(new File(getFileName()));
		//}
	}

	/**
	 * Get RTS Profile Filename
	 * 
	 * @return RTC Profile Name
	 */
	final public String getFileName() {
		return filename;
	}

	/**
	 * <div lang="ja">
	 * 
	 * @return </div> <div lang="en">
	 * 
	 * @return </div>
	 */
	final public boolean isRTCsNotFound() {
		if (rtSystemProfile != null) {
			return RTSystemBuilder.searchRTCs(rtSystemProfile);
		} else {
			return false;
		}
	}

	/**
	 * <div lang="ja">
	 * 
	 * @param xmlDocument
	 * @return </div> <div lang="en">
	 * @param xmlDocument
	 * @return </div>
	 */
	@Override
	public Element toElement(Document xmlDocument) {
		Element element = super.toElement(xmlDocument);
		Element filePathElement = xmlDocument
				.createElement(FIROSOPHY.XMLFILEPATH);
		element.appendChild(filePathElement);
		String path = FileNameUtil.getRelativePath(getBasePath(), getFileName());
		filePathElement.setAttribute(FIROSOPHY.RELATIVE, "true");
		if(path != null) {
			filePathElement.setAttribute(FIROSOPHY.RELATIVE, "false");
			path = getFileName();
		}
		Text textElement = xmlDocument.createTextNode(path);
		filePathElement.appendChild(textElement);
		return element;
	}

	/**
	 * <div lang="ja">
	 * 
	 * @param node
	 * @throws InvalidFSMFileException
	 *             </div> <div lang="en">
	 * @param node
	 * @throws InvalidFSMFileException
	 *             </div>
	 */
	@Override
	public void load(Node node) throws InvalidFSMFileException {
		super.load(node);
		NodeList childNodeList = node.getChildNodes();
		for (int i = 0; i < childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeName().equals(FIROSOPHY.XMLFILEPATH)) {
				NamedNodeMap attributeMap = childNode.getAttributes();
				setRelativePath(Boolean.parseBoolean(attributeMap
						.getNamedItem(FIROSOPHY.RELATIVE).getNodeValue()));
				
				NodeList textNodeList = childNode.getChildNodes();
				for(int j = 0;j < textNodeList.getLength();j++) {
					Node textNode = textNodeList.item(j);
					if(textNode.getNodeType() == Node.TEXT_NODE) {
						try {
							setFileName(textNode.getNodeValue());
						} catch (DOMException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						} 
					}
				}
			}
		}

	}

	/**
	 * buildProfile
	 * <div lang="ja">
	 * 
	 * </div>
	 * <div lang="en">
	 *
	 * </div>
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void buildProfile() throws ParserConfigurationException, SAXException, IOException {
		String fullPath = getFileName();
		setRTSystemProfile(new RTSystemProfile(new File(fullPath)));
	}

}
