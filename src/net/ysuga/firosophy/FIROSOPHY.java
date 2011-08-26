package net.ysuga.firosophy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import net.ysuga.firosophy.guard.NotFoundGuardFactory;
import net.ysuga.firosophy.guard.StateEqualsGuardFactory;
import net.ysuga.firosophy.state.RTState;
import net.ysuga.firosophy.state.RTStateFactory;
import net.ysuga.firosophy.state.action.AllRTCsActivateActionFactory;
import net.ysuga.firosophy.state.action.AllRTCsConfigureActionFactory;
import net.ysuga.firosophy.state.action.AllRTCsDeactivateActionFactory;
import net.ysuga.firosophy.state.action.AllRTCsResetActionFactory;
import net.ysuga.firosophy.state.action.BuildConnectionActionFactory;
import net.ysuga.firosophy.state.action.ClearAllConnectionActionFactory;
import net.ysuga.firosophy.util.FileNameUtil;
import net.ysuga.statemachine.StateMachine;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.guard.GuardFactoryManager;
import net.ysuga.statemachine.state.State;
import net.ysuga.statemachine.state.StateFactoryManager;
import net.ysuga.statemachine.state.action.StateActionFactoryManager;

import org.xml.sax.SAXException;

public class FIROSOPHY extends StateMachine {
	
	static private Logger logger = Logger.getLogger(FIROSOPHY.class.getName());
 
	/**
	 * ���̕�����FIROSOPHY�p�ɍ쐬�����K�[�h�̓o�^���s���܂��D
	 * �K�[�h��FactoryManager�ɓo�^����Ă���ƁCXML�t�@�C����ǂ݂��񂾏ꍇ�C
	 * �����I�ɃK�[�h�̃C���X�^���X�𐶐��ł��܂��D
	 * 
	 * �܂��J�X�^�}�C�Y����State�����l�ɓo�^���܂��D
	 */
	static {
		GuardFactoryManager.add(new NotFoundGuardFactory());
		GuardFactoryManager.add(new StateEqualsGuardFactory());
		
		StateFactoryManager.add(new RTStateFactory());
		
		StateActionFactoryManager.add(new AllRTCsActivateActionFactory());
		StateActionFactoryManager.add(new AllRTCsDeactivateActionFactory());		
		StateActionFactoryManager.add(new AllRTCsResetActionFactory());		
		StateActionFactoryManager.add(new AllRTCsConfigureActionFactory());		
		StateActionFactoryManager.add(new ClearAllConnectionActionFactory());		
		StateActionFactoryManager.add(new BuildConnectionActionFactory());		
	}
	
	/**
	 * <div lang="ja">
	 * �R���X�g���N�^
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
		basePath = file.getAbsolutePath().split(file.getName())[0];
		for(State state : getStateCollection()) {
			if(state instanceof RTState) {
				RTState rtState = (RTState)state;
				rtState.setBasePath(basePath);
				if(rtState.isRelativePath()) {
					String fullpath = FileNameUtil.getAbsolutePath(basePath, rtState.getFileName());
					rtState.setFileName(fullpath);
				}
			}
		}
	}

	/**
	 * 
	 * <div lang="ja">
	 * �R���X�g���N�^
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
	 * Kind signature of AllRTCsDeactivateAction
	 */
	public static final String ALLRTCSDEACTIVATEACTION = "AllRTCsDeactivateAction";

	/**
	 * Kind signature of AllRTCsDeactivateAction
	 */
	public static final String ALLRTCSRESETACTION = "AllRTCsResetAction";
	
	/**
	 * Kind signature of BuildConnectionAction
	 */
	public static final String BUILDCONNECTIONACTION = "BuildConnectionAction";

	/**
	 * Kind signature of RemoveAllConnectionAction
	 */
	public static final String CLEARALLCONNECTIONACTION = "ClearAllConnectionAction";

	/**
	 * Kind signature of AllRTCsConfigureAction
	 */
	public static final String ALLRTCSCONFIGUREACTION = "AllRTCsConfigureAction";
	
	/**
	 * Kind signature of RTState
	 */
	public static final String RTSTATE = "RTState";

	public static final String XMLFILEPATH = "XmlFilePath";

	public static final String RELATIVE = "relativePath";
	
	private String basePath;
	
	public void setBasePath(String path) {
		basePath = path;
	}
	
	@Override
	public void save(File file) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException {
		basePath = file.getAbsolutePath().split(file.getName())[0];
		for(State state : getStateCollection()) {
			if(state instanceof RTState) {
				((RTState)state).setBasePath(basePath);
			}
		}
		super.save(file);
	}
	
	@Override
	public void start() throws Exception {
		for(State state : getStateCollection()) {
			if(state instanceof RTState) {
				((RTState)state).buildProfile();
			}
		}
		super.start();
	}
	
}
 
