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
import net.ysuga.statemachine.guard.GuardProfile;
import net.ysuga.statemachine.util.ParameterMap;

/**
 * @author ysuga
 *
 */
public class NotFoundGuardFactory extends AbstractGuardFactory {

	/**
	 * <div lang="ja">
	 * �R���X�g���N�^
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
	public Guard createGuard(String name, ParameterMap parameterMap) {
		return new NotFoundGuard(name, parameterMap.get(NotFoundGuard.PATHURI));
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

}
