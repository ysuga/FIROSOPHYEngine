package net.ysuga.firosophy.guard;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.firosophy.state.RTState;
import net.ysuga.statemachine.guard.AbstractGuard;
import net.ysuga.statemachine.state.State;
import net.ysuga.statemachine.util.ParameterMap;

/**
 * 
 * @author ysuga
 *
 */
public class NotFoundGuard extends AbstractGuard {
 
	static final String PATHURI = "PathUri";
	private String pathUri;
	/**
	 * if state's RTCs are not found, return true (transit)
	 * @return if RTCs (registered in state's rts profile) are not found (even if one RTC), return true;
	 */
	public boolean operate(State state) {
		return ((RTState)state).isRTCsNotFound();
	}
	 
	/**
	 * Constructor
	 * @param name
	 */
	public NotFoundGuard(String name, String pathUri) {
		super(name, FIROSOPHY.NOTFOUND);
		this.pathUri = pathUri;
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
		ParameterMap map = new ParameterMap();
		map.put(PATHURI, pathUri);
		return map;
	}

	/**
	 * <div lang="ja">
	 * @param state
	 * </div>
	 * <div lang="en">
	 * @param state
	 * </div>
	 */
	public void onInitialize(State state) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	/**
	 * <div lang="ja">
	 * @param state
	 * </div>
	 * <div lang="en">
	 * @param state
	 * </div>
	 */
	public void onFinalize(State state) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	 
}
 
