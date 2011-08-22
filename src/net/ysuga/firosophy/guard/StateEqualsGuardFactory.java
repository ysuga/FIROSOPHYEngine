/**
 * StateEqualsGuardFactory.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/05
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.guard;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.rtsbuilder.RTCCondition;
import net.ysuga.statemachine.guard.AbstractGuardFactory;
import net.ysuga.statemachine.guard.Guard;
import net.ysuga.statemachine.guard.GuardProfile;
import net.ysuga.statemachine.util.ParameterMap;

/**
 * @author ysuga
 *
 */
public class StateEqualsGuardFactory extends AbstractGuardFactory {

	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * @param kind
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * @param kind
	 * </div>
	 */
	public StateEqualsGuardFactory() {
		super(FIROSOPHY.STATE_EQUALS);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * <div lang="ja">
	 * @param name
	 * @param parameterMap
	 * @return
	 * </div>
	 * <div lang="en">
	 * @param name
	 * @param parameterMap
	 * @return
	 * </div>
	 */
	@Override
	public Guard createGuard(String name, ParameterMap parameterMap) {
		
		return new StateEqualsGuard(name, parameterMap.get(StateEqualsGuard.PATHURI), RTCCondition.parseString(parameterMap.get(StateEqualsGuard.RTCCONDITION)));
	}

	/**
	 * <div lang="ja">
	 * @return
	 * </div>
	 * <div lang="en">
	 * @return
	 * </div>
	 */
	public GuardProfile getGuardProfile() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
