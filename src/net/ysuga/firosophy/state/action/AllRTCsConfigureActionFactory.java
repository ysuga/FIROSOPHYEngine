/**
 * AllRTCsActivateActionFactory.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/06
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.state.action;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.statemachine.state.action.AbstractStateActionFactory;
import net.ysuga.statemachine.state.action.StateAction;
import net.ysuga.statemachine.util.ParameterMap;

/**
 * @author ysuga
 *
 */
public class AllRTCsConfigureActionFactory extends AbstractStateActionFactory {

	/**
	 * <div lang="ja">
	 * �R���X�g���N�^
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * </div>
	 */
	public AllRTCsConfigureActionFactory() {
		super(FIROSOPHY.ALLRTCSCONFIGUREACTION);
	}

	/**
	 * <div lang="ja">
	 * @param parameterMap
	 * @return
	 * </div>
	 * <div lang="en">
	 * @param parameterMap
	 * @return
	 * </div>
	 */
	@Override
	public StateAction buildStateAction(ParameterMap parameterMap) {
		return new AllRTCsConfigureAction();
	}

	
	/**
	 * <div lang="ja">
	 * @return
	 * </div>
	 * <div lang="en">
	 * @return
	 * </div>
	 */
	public StateAction createStateAction() {
		return new AllRTCsConfigureAction();
	}

}
