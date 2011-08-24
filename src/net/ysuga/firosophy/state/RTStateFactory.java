/**
 * RTStateFactory.java
 *
 * @author Yuki Suga (ysuga.net)
 * @date 2011/08/23
 * @copyright 2011, ysuga.net allrights reserved.
 *
 */
package net.ysuga.firosophy.state;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.statemachine.exception.InvalidFSMFileException;
import net.ysuga.statemachine.state.State;
import net.ysuga.statemachine.state.StateFactory;

import org.w3c.dom.Node;

/**
 * <div lang="ja">
 *
 * </div>
 * <div lang="en">
 *
 * </div>
 * @author ysuga
 *
 */
public class RTStateFactory implements StateFactory {

	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * </div>
	 */
	public RTStateFactory() {
		super();
	}


	/**
	 * <div lang="ja">
	 * @param node
	 * @return
	 * @throws InvalidFSMFileException
	 * </div>
	 * <div lang="en">
	 * @param node
	 * @return
	 * @throws InvalidFSMFileException
	 * </div>
	 */
	public State loadState(Node node) throws InvalidFSMFileException {
		return new RTState(node);
	}


	/**
	 * <div lang="ja">
	 * @return
	 * </div>
	 * <div lang="en">
	 * @return
	 * </div>
	 */
	public String getKind() {
		return FIROSOPHY.RTSTATE;
	}

}
