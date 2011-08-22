package net.ysuga.firosophy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import net.ysuga.firosophy.guard.NotFoundGuardFactory;
import net.ysuga.firosophy.guard.StateEqualsGuardFactory;
import net.ysuga.statemachine.StateMachine;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.guard.GuardFactoryManager;

import org.xml.sax.SAXException;

public class FIROSOPHY extends StateMachine {
 
	static {
		GuardFactoryManager.add(new NotFoundGuardFactory());
		GuardFactoryManager.add(new StateEqualsGuardFactory());
	}
	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * @param file
	 * @throws InvalidFSMFileException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * @param file
	 * @throws InvalidFSMFileException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * </div>
	 */
	public FIROSOPHY(File file) throws InvalidFSMFileException,
			ParserConfigurationException, SAXException, IOException {
		super(file);
	}

	/**
	 * 
	 * <div lang="ja">
	 * コンストラクタ
	 * @param name
	 * @throws ParserConfigurationException
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * @param name
	 * @throws ParserConfigurationException
	 * </div>
	 */
	public FIROSOPHY(String name) throws ParserConfigurationException {
		super(name);
	}
	
	public static final String NOTFOUND = "NotFound";
	public static final String STATE_EQUALS = "StateEquals";
	public static final String ALLRTCSACTIVATEACTION = "AllRTCsActivateAction";
	 
}
 
