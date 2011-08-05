/**
 * NotFoundGuardFactory.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/05
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.guard;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.statemachine.guard.AbstractGuardFactory;
import net.ysuga.statemachine.guard.Guard;
import net.ysuga.statemachine.guard.GuardParameterMap;

/**
 * @author ysuga
 *
 */
public class NotFoundGuardFactory extends AbstractGuardFactory {

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
	public NotFoundGuardFactory() {
		super(FIROSOPHY.NOTFOUND);
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
	public Guard createGuard(String name, GuardParameterMap parameterMap) {
		return new NotFoundGuard(name, parameterMap.get(NotFoundGuard.PATHURI));
	}

}
