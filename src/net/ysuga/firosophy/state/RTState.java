package net.ysuga.firosophy.state;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.rtsbuilder.RTSystemBuilder;
import net.ysuga.rtsystem.profile.RTSystemProfile;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.state.DefaultState;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * 
 * <div lang="ja">
 * OpenRTMのRTシステムを有するState．
 * </div>
 * <div lang="en">
 *
 * </div>
 * @author ysuga
 *
 */
public class RTState extends DefaultState {
 
	private static  Logger logger;
	static {
		logger = Logger.getLogger("net.ysuga.firosophy");
	}
	
	
	private String filename;
	
	private RTSystemProfile rtSystemProfile;
	
	final public RTSystemProfile getRTSystemProfile() { return rtSystemProfile; }
	
	
	/**
	 * 
	 * <div lang="ja">
	 * コンストラクタ
	 * @param name
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * @param name
	 * </div>
	 */
	public RTState(String name) {
		super(name);
		try {
			setFileName(null);
			setKind(FIROSOPHY.RTSTATE);
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
	 * @param filename xml file (RTS profile)
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	final public void setFileName(String filename) throws ParserConfigurationException, SAXException, IOException {
		this.filename = filename;
		if(filename != null) {
			rtSystemProfile = new RTSystemProfile(new File(getFileName()));
		}
	}
	
	/**
	 * Get RTS Profile Filename
	 * @return RTC Profile Name
	 */
	final public String getFileName() {
		return filename;
	}

	/**
	 * <div lang="ja">
	 *
	 * @return
	 * </div>
	 * <div lang="en">
	 *
	 * @return
	 * </div>
	 */
	final public boolean isRTCsNotFound() {
		if(rtSystemProfile != null) {
			return RTSystemBuilder.searchRTCs(rtSystemProfile); 
		} else {
			return false;
		}
	}

	

	/**
	 * <div lang="ja">
	 * @param xmlDocument
	 * @return
	 * </div>
	 * <div lang="en">
	 * @param xmlDocument
	 * @return
	 * </div>
	 */
	@Override
	public Element toElement(Document xmlDocument) {
		return super.toElement(xmlDocument);
	}


	/**
	 * <div lang="ja">
	 * @param node
	 * @throws InvalidFSMFileException
	 * </div>
	 * <div lang="en">
	 * @param node
	 * @throws InvalidFSMFileException
	 * </div>
	 */
	@Override
	public void load(Node node) throws InvalidFSMFileException {
		super.load(node);
		
		
	}

	
}
 
