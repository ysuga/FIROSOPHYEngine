/**
 * AllRTCsActivateAction.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/05
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.state;

import net.ysuga.rtsbuilder.RTSystemBuilder;
import net.ysuga.rtsystem.profile.RTSystemProfile;
import net.ysuga.statemachine.state.State;
import net.ysuga.statemachine.state.StateAction;

/**
 * @author ysuga
 *
 */
public class AllRTCsActivateAction implements StateAction {

	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * </div>
	 */
	public AllRTCsActivateAction() {
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
			RTSystemBuilder.activateRTCs(profile);
		}
	}

}
