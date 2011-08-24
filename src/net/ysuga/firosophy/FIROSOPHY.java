package net.ysuga.firosophy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import net.ysuga.firosophy.guard.NotFoundGuardFactory;
import net.ysuga.firosophy.guard.StateEqualsGuardFactory;
import net.ysuga.firosophy.state.RTStateFactory;
import net.ysuga.firosophy.state.action.AllRTCsActivateActionFactory;
import net.ysuga.statemachine.StateMachine;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.guard.GuardFactoryManager;
import net.ysuga.statemachine.state.StateFactoryManager;
import net.ysuga.statemachine.state.action.StateActionFactoryManager;

import org.xml.sax.SAXException;

public class FIROSOPHY extends StateMachine {
 
	/**
	 * この部分でFIROSOPHY用に作成したガードの登録を行います．
	 * ガードがFactoryManagerに登録されていると，XMLファイルを読みこんだ場合，
	 * 自動的にガードのインスタンスを生成できます．
	 * 
	 * またカスタマイズしたStateも同様に登録します．
	 */
	static {
		GuardFactoryManager.add(new NotFoundGuardFactory());
		GuardFactoryManager.add(new StateEqualsGuardFactory());
		
		StateFactoryManager.add(new RTStateFactory());
		
		StateActionFactoryManager.add(new AllRTCsActivateActionFactory());
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
	
	/**
	 * Kind Signatur of NotFoundGuard
	 */
	public static final String NOTFOUND = "NotFound";
	
	/**
	 * Kind signature of StateEqualsGuard
	 */
	public static final String STATE_EQUALS = "StateEquals";
	
	/**
	 * Kind signature of AllRTCsActivateAction
	 */
	public static final String ALLRTCSACTIVATEACTION = "AllRTCsActivateAction";
	
	/**
	 * Kind signature of RTState
	 */
	public static final String RTSTATE = "RTState";
	 
}
 
