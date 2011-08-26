/**
 * AllRTCsActivateAction.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/05
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.state.action;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.firosophy.state.RTState;
import net.ysuga.rtsbuilder.RTSystemBuilder;
import net.ysuga.rtsystem.profile.RTSystemProfile;
import net.ysuga.statemachine.state.State;
import net.ysuga.statemachine.state.action.AbstractStateAction;
import net.ysuga.statemachine.util.ParameterMap;

/**
 * @author ysuga
 *
 */
public class AllRTCsDeactivateAction extends  AbstractStateAction {

	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * </div>
	 */
	public AllRTCsDeactivateAction() {
		super(FIROSOPHY.ALLRTCSDEACTIVATEACTION);
	}

	/**
	 * <div lang="ja">
	 * @param state
	 * @throws Exception
	 * </div>
	 * <div lang="en">
	 * @param state
	 * @throws Exception
	 * </div>
	 */
	@Override
	public void actionPerformed(State state) throws Exception {
		RTState rtState = (RTState)state;
		RTSystemProfile profile = rtState.getRTSystemProfile();
		if(profile != null) {
			RTSystemBuilder.deactivateRTCs(profile);
		}
	}

	/**
	 * <div lang="ja">
	 * @return
	 * </div>
	 * <div lang="en">
	 * @return
	 * </div>
	 */
	@Override
	public ParameterMap getParameterMap() {
		return new ParameterMap();
	}

	/**
	 * <div lang="ja">
	 * @param parameterMap
	 * </div>
	 * <div lang="en">
	 * @param parameterMap
	 * </div>
	 */
	@Override
	public void setParameterMap(ParameterMap parameterMap) {
		
	}

}
